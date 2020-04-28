package com.youngch.pat.beyond.scheduled;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngch.pat.beyond.hepler.ReqCommonHelper;
import com.youngch.pat.beyond.model.request.hotel.HotelRoomStatusRequestModel;
import com.youngch.pat.beyond.model.request.order.CheckInRequestModel;
import com.youngch.pat.beyond.model.response.ApiRespModel;
import com.youngch.pat.beyond.model.response.CheckInContentResponseModel;
import com.youngch.pat.beyond.model.response.CheckInResponseModel;
import com.youngch.pat.beyond.model.response.HotelRoomStatusResponseModel;
import com.youngch.pat.beyond.service.BeyondService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: yexudong
 * @Date: 2020/4/9 14:24
 */
@Component
public class BeyondScheduled {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeyondScheduled.class);

    @Autowired
    private BeyondService beyondService;


    //    @Scheduled(cron = "0 */1 * * * ?")
    public void pollRoomStatus() {
        HotelRoomStatusRequestModel requestModel = new HotelRoomStatusRequestModel();
        requestModel.setOrgId(1035613440376851L);
        requestModel.setRoomNos(new String[]{"8703", "8705", "8706"});

        ApiRespModel respModel = beyondService.onRoomStatus(requestModel);

        List<HotelRoomStatusResponseModel> responseModels =
                new ObjectMapper().convertValue(respModel.Data, new TypeReference<List<HotelRoomStatusResponseModel>>() {
                });
        for (HotelRoomStatusResponseModel responseModel : responseModels) {
            switch (responseModel.getStatus()) {
                case "VD":
                    LOGGER.info("房间{}状态为空脏", responseModel.getRoomNo());
                    break;
                case "VC":
                    LOGGER.info("房间{}状态为空净", responseModel.getRoomNo());
                    break;
                case "OOO":
                    LOGGER.info("房间{}状态为维修房", responseModel.getRoomNo());
                    break;
                case "OD":
                    LOGGER.info("房间{}状态为住脏", responseModel.getRoomNo());

                    break;
                case "OC":
                    LOGGER.info("房间{}状态为住净", responseModel.getRoomNo());

                    break;
            }
        }

    }


    private static String[] ROOMS = new String[]{"8703", "8705", "8706"};

    private static ConcurrentHashMap<String, CheckInContentResponseModel> checkStatus = new ConcurrentHashMap<>();

    @Scheduled(cron = "0/5 * * * * ?")
    public void pollCheckInStatus() {
        CheckInRequestModel requestModel = new CheckInRequestModel();
        requestModel.setOrgId(1035613440376851L);
        requestModel.setRoomNumbers(ROOMS);
        requestModel.setCheckinStatus(new String[]{"I"});
        requestModel.setPageIndex(1);
        requestModel.setPageSize(100);
        ApiRespModel respModel = beyondService.onCheckInQuery(requestModel);
        //入住房间信息
        CheckInResponseModel responseModel =
                new ObjectMapper().convertValue(respModel.Data, new TypeReference<CheckInResponseModel>() {
                });

        String[] checkInRoomNums = new String[responseModel.getContent().length];


        CheckInContentResponseModel[] contentResponseModels = responseModel.getContent();

        //入住房间状态
        if (contentResponseModels.length > 0) {
            for (int i = 0; i < contentResponseModels.length; i++) {
                checkInRoomNums[i] = contentResponseModels[i].getRoomNumber();
                //查找缓存
                CheckInContentResponseModel contentResponseModel = checkStatus.get(contentResponseModels[i].getRoomNumber());
                if (contentResponseModel != null) {
                    return;
                }
                remote(contentResponseModels[i]);
                checkStatus.put(contentResponseModels[i].getRoomNumber(), contentResponseModels[i]);
            }
        }

        //未入住房间
        String[] su = su(checkInRoomNums);
        if (su.length > 0) {
            for (int i = 0; i < su.length; i++) {
                //查找缓存
                CheckInContentResponseModel contentResponseModel = checkStatus.get(su[i]);
                if (contentResponseModel != null) {
                    contentResponseModel.setCheckinStatus("O");
                    remote(contentResponseModel);
                    checkStatus.remove(su[i]);
                }
            }
        }

    }

//    public static void main(String[] args) {
//        String[] checkInRoomNums = new String[]{"8706", "8703"};
//
//        System.out.println(Arrays.toString(su(checkInRoomNums)));
//    }

    private static String[] su(String[] checkInRoomNums) {
        Set<String> set = new HashSet<String>(Arrays.asList(ROOMS.length > checkInRoomNums.length ? ROOMS : checkInRoomNums));
        // 遍历较短的数组，实现最少循环
        for (String i : ROOMS.length > checkInRoomNums.length ? checkInRoomNums : ROOMS) {
            // 如果集合里有相同的就删掉，如果没有就将值添加到集合
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        String[] arr = {};
        return set.toArray(arr);
    }

    private void remote(CheckInContentResponseModel item) {
        int statusType = "I".equals(item.getCheckinStatus()) ? 1 : 2;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ZhuzherResponseBean responseBean = new ZhuzherResponseBean();
        LOGGER.info("room {} ,status {} ,customer {}", item.getRoomNumber(), item.getCheckinStatus(), item.getCheckinCustomer().getName());
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
        guest.setGender(item.getCheckinCustomer().getGender().equals("0") ? "male" : "female");
        guest.setName(item.getCheckinCustomer().getName());
        guest.setTel(item.getCheckinCustomer().getMobile());
        guests.add(guest);
        zhuzherOrder.setGuest(guests);
        orders.add(zhuzherOrder);
        zhuzherData.setOrder(orders);
        responseBean.setData(zhuzherData);
        ReqCommonHelper.callOnAiPmsServer(responseBean);
    }

}
