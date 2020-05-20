package com.youngch.pat.beyond.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngch.pat.beyond.domain.Hotel;
import com.youngch.pat.beyond.domain.RoomKeyParameter;
import com.youngch.pat.beyond.dto.ZhuzherData;
import com.youngch.pat.beyond.dto.ZhuzherGuest;
import com.youngch.pat.beyond.dto.ZhuzherOrder;
import com.youngch.pat.beyond.dto.ZhuzherResponseBean;
import com.youngch.pat.beyond.hepler.ReqCommonHelper;
import com.youngch.pat.beyond.model.request.hotel.HotelRoomStatusRequestModel;
import com.youngch.pat.beyond.model.request.order.CheckInRequestModel;
import com.youngch.pat.beyond.model.response.ApiRespModel;
import com.youngch.pat.beyond.model.response.CheckInContentResponseModel;
import com.youngch.pat.beyond.model.response.CheckInResponseModel;
import com.youngch.pat.beyond.model.response.HotelRoomStatusResponseModel;
import com.youngch.pat.beyond.repository.RoomCheckStatusRefreshLockDao;
import com.youngch.pat.beyond.service.BeyondService;
import com.youngch.pat.beyond.service.HotelService;
import com.youngch.pat.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 关于房态查询优化：
 * 1.调用别样红roomStatus函数查询所有酒店房间的空住的状态
 * 2.再通过管道过滤订单设置为对应的I（入住）或O（退房）状态
 * 3.是否远程发送订单：首先获取是否有入住锁定isLocked,
 * 在isLocked=true状态下，一旦发现订单为O（退房状态），则发送退房订单
 * 在isLocked=false状态下，一旦发现订单为I（入住状态），则发送入住订单
 *
 * @author: yexudong
 * @Date: 2020/5/20 9:34
 */
@Component
public class RoomCheckInTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomCheckInTask.class);

    @Autowired
    private BeyondService beyondService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomCheckStatusRefreshLockDao refreshLockDao;

    @Scheduled(cron = "0/5 * * * * ?")
    public void pollRoomStatus() {
        List<Hotel> hotels = hotelService.getAll();
        if (hotels.isEmpty()) {
            return;
        }
        for (Hotel hotel : hotels) {
            for (String s : hotel.getRoomNoList()) {
                HotelRoomStatusRequestModel requestModel = new HotelRoomStatusRequestModel();
                requestModel.setOrgId(Long.valueOf(hotel.getHotelId()));
                requestModel.setRoomNos(new String[]{s});
                onRoomStatus(requestModel);
            }
        }
    }

    private void onRoomStatus(HotelRoomStatusRequestModel requestModel) {
        ApiRespModel respModel = beyondService.onRoomStatus(requestModel);
        if (respModel.Code == 10000) {
            List<HotelRoomStatusResponseModel> responseModels =
                    new ObjectMapper().convertValue(respModel.Data, new TypeReference<List<HotelRoomStatusResponseModel>>() {
                    });
            for (HotelRoomStatusResponseModel responseModel : responseModels) {

                CheckInRequestModel checkInRequestModel = new CheckInRequestModel();
                checkInRequestModel.setOrgId(requestModel.getOrgId());
                checkInRequestModel.setRoomNumbers(new String[]{responseModel.getRoomNo()});
                checkInRequestModel.setPageIndex(1);
                checkInRequestModel.setPageSize(100);

                switch (responseModel.getStatus()) {
                    case "VD":
                        LOGGER.info("【房间{}】状态为空脏", responseModel.getRoomNo());
                        checkInRequestModel.setCheckinStatus(new String[]{"O"});
                        break;
                    case "VC":
                        LOGGER.info("【房间{}】状态为空净", responseModel.getRoomNo());
                        checkInRequestModel.setCheckinStatus(new String[]{"O"});
                        break;
                    case "OOO":
                        LOGGER.info("【房间{}】状态为维修房", responseModel.getRoomNo());
                        break;
                    case "OD":
                        LOGGER.info("【房间{}】状态为住脏", responseModel.getRoomNo());
                        checkInRequestModel.setCheckinStatus(new String[]{"I"});
                        break;
                    case "OC":
                        LOGGER.info("【房间{}】状态为住净", responseModel.getRoomNo());
                        checkInRequestModel.setCheckinStatus(new String[]{"I"});
                        break;
                }
                onCheckStatus(checkInRequestModel);
            }
        }
        LOGGER.debug(respModel.Message);
    }

    private void onCheckStatus(CheckInRequestModel requestModel) {
        ApiRespModel respModel = beyondService.onCheckInQuery(requestModel);
        if (respModel.Code == 10000) {
            //入住房间信息
            CheckInResponseModel responseModel = new ObjectMapper().convertValue(respModel.Data, new TypeReference<CheckInResponseModel>() {
            });
            CheckInContentResponseModel[] contentResponseModels = responseModel.getContent();
            CheckInContentResponseModel contentResponseModel = contentResponseModels[0];
            LOGGER.info("【订单数据】：{}", contentResponseModel.toString());
            RoomKeyParameter roomKeyParameter = new RoomKeyParameter(requestModel.getOrgId() + "", contentResponseModel.getRoomNumber());
            //锁定入住
            boolean isLocked = refreshLockDao.isLocked(roomKeyParameter);

            //入住有锁定，无入住信息
            if ("O".equals(contentResponseModel.getCheckinStatus()) && isLocked) {
                remote(contentResponseModel);
                refreshLockDao.unlock(roomKeyParameter);
            }
            //入住无锁定，有入住信息
            if ("I".equals(contentResponseModel.getCheckinStatus()) && !isLocked) {
                remote(contentResponseModel);
                refreshLockDao.lock(roomKeyParameter, 7, TimeUnit.DAYS);
            }

        }
        LOGGER.debug(respModel.Message);
    }

    private void remote(CheckInContentResponseModel item) {
        LOGGER.info("【订单推送】：房间号 {} ,状态 {} ,入住人 {}", item.getRoomNumber(), item.getCheckinStatus(), item.getCheckinCustomer().getName());
        int statusType = "I".equals(item.getCheckinStatus()) ? 1 : 2;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ZhuzherResponseBean responseBean = new ZhuzherResponseBean();
        responseBean.setType(statusType);
        ZhuzherData zhuzherData = new ZhuzherData();
        zhuzherData.setHotel_id(item.getOrgId() + "");
        zhuzherData.setOrder_id(item.getOrderId() + "");
        List<ZhuzherOrder> orders = new ArrayList<>();
        ZhuzherOrder zhuzherOrder = new ZhuzherOrder();
        zhuzherOrder.setCheck_in_date(format.format(item.getActualArriveTime()));
        zhuzherOrder.setReserve_order_id(item.getOrderId());
        zhuzherOrder.setCheck_out_date(format.format(item.getBenefitDepartureTime()));
        zhuzherOrder.setRoom_no(item.getRoomNumber());
        zhuzherOrder.setCheck_in_id(item.getCheckinId());
        zhuzherOrder.setStatus(statusType);
        orders.add(zhuzherOrder);
        List<ZhuzherGuest> guests = new ArrayList<>();
        ZhuzherGuest guest = new ZhuzherGuest();
        int gender = item.getCheckinCustomer().getGender();
        String genderString = gender == 2 ? "male" : gender == 1 ? "female" : "unknown";
        guest.setGender(genderString);
        guest.setName(item.getCheckinCustomer().getName());
        guest.setTel(item.getCheckinCustomer().getMobile());
        guests.add(guest);
        zhuzherOrder.setGuest(guests);
        orders.add(zhuzherOrder);
        zhuzherData.setOrder(orders);
        responseBean.setData(zhuzherData);
        String result = ReqCommonHelper.callOnAiPmsServer(responseBean);
        LOGGER.info("【订单推送成功】：result {}", result);
    }
}
