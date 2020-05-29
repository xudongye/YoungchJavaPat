package com.youngch.pat.cloudwalk.service.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngch.pat.cloudwalk.service.CloudWalkService;
import com.youngch.pat.cloudwalk.service.HotelRoomQueryCondition;
import com.youngch.pat.cloudwalk.service.MemberQueryCondition;
import com.youngch.pat.cloudwalk.vo.*;
import com.youngch.pat.common.beyond.model.request.*;
import com.youngch.pat.common.beyond.model.response.*;
import com.youngch.pat.common.beyond.service.BeyondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/5/26 10:54
 */
@Service
public class CloudWalkServiceImpl implements CloudWalkService {

    @Autowired
    private BeyondService beyondService;

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public MemberInfo getMember(MemberQueryCondition condition) {
        SearchMembersRequestModel requestModel = new SearchMembersRequestModel();
        requestModel.setIdNo(condition.getIdCardNo());
        requestModel.setMobile(condition.getMobile());
        ApiRespModel apiRespModel = beyondService.onSearchMembers(requestModel);
        MemberInfo memberInfo = new MemberInfo();
        JSONObject data = new JSONObject(apiRespModel.Data);
        memberInfo.setMemberId(data.getStr("MemberId"));
        memberInfo.setName(data.getStr("Name"));
        return memberInfo;
    }

    @Override
    public Hotel getHotelInfo(String hotelId) {
        HotelInfoRequestModel requestModel = new HotelInfoRequestModel();
        requestModel.setOrgId(Long.valueOf(hotelId));
        ApiRespModel responseModel = beyondService.onHotelInfo(requestModel);
        HotelInfoResponseModel infoResponseModel = mapper.convertValue(responseModel.Data, new TypeReference<HotelInfoResponseModel>() {
        });
        if (infoResponseModel == null) {
            return null;
        }
        Hotel hotel = new Hotel();
        hotel.setHotelId(infoResponseModel.getOrgId());
        hotel.setHotelName(infoResponseModel.getOrgName());
        hotel.setCityName(infoResponseModel.getCityName());
        hotel.setHotelBrand(infoResponseModel.getBrand());
        hotel.setHotelAddress(infoResponseModel.getAddress());
        hotel.setHotelPhone(infoResponseModel.getPhone());
        hotel.setHotelStar(infoResponseModel.getStar());
        hotel.setHotelDesc(infoResponseModel.getDescription());
        hotel.setLongitude(infoResponseModel.getLatitude());
        hotel.setLatitude(infoResponseModel.getLatitude());
        hotel.setServiceTags(infoResponseModel.getServiceTags());
        hotel.setPanoramicPics(
                infoResponseModel.getPanoramicSite() != null ? infoResponseModel.getPanoramicSite().split("\\|") : null);
        hotel.setImageUris(
                infoResponseModel.getImageUris() != null ? infoResponseModel.getImageUris().split("\\|") : null);

        return hotel;
    }

    @Override
    public List<Room> getRoomByRoomType(HotelRoomQueryCondition condition) {
        GetAvailableRoomsRequestModel requestModel = new GetAvailableRoomsRequestModel();
        requestModel.setOrgId(Long.valueOf(condition.getHotelId()));
        requestModel.setRoomTypeIds(condition.getRoomTypeIds());
        requestModel.setArriveTime(condition.getArriveTime());
        requestModel.setDepartureTime(condition.getDepartureTime());
        requestModel.setCheckinType(condition.getCheckInType().getName());
        ApiRespModel responseModel = beyondService.onGetAvailableRooms(requestModel);

        List<GetAvailableRoomsResponseModel> roomsResponseModels = mapper.convertValue(responseModel.Data, new TypeReference<List<GetAvailableRoomsResponseModel>>() {
        });

        if (roomsResponseModels.isEmpty()) {
            return null;
        }
        List<Room> rooms = new ArrayList<>();
        Room room = null;
        for (GetAvailableRoomsResponseModel roomsResponseModel : roomsResponseModels) {
            room = new Room();
            room.setRoomTypeId(roomsResponseModel.getRoomTypeId());
            room.setFloorNo(roomsResponseModel.getFloorName());
            room.setIsActive(roomsResponseModel.getIsActive());
            room.setRoomNo(roomsResponseModel.getRoomNumber());
            room.setStatus(roomsResponseModel.getStatus());
            room.setImageUris(roomsResponseModel.getImageUris() != null ? roomsResponseModel.getImageUris().split("\\|") : null);
            room.setPanoramicPics(roomsResponseModel.getPanoramicSite() != null ? roomsResponseModel.getPanoramicSite().split("\\|") : null);
            rooms.add(room);
        }
        return rooms;
    }

    @Override
    public List<RoomTypeInfo> getHotelRoomTypeCountAndPriceList(HotelRoomQueryCondition condition) {
        SearchOrgWithRoomPriceAndRoomCountRequestModel requestModel = new SearchOrgWithRoomPriceAndRoomCountRequestModel();
        requestModel.setOrgIds(new Long[]{Long.valueOf(condition.getHotelId())});
        requestModel.setArriveTime(condition.getArriveTime());
        requestModel.setDepartureTime(condition.getDepartureTime());
        requestModel.setCheckinType(condition.getCheckInType().getName());
        ApiRespModel apiRespModel = beyondService.onSearchOrgWithRoomPriceAndRoomCount(requestModel);
        List<SearchOrgWithRoomPriceAndRoomCountResponseModel> responseModels = mapper.convertValue(apiRespModel.Data, new TypeReference<List<SearchOrgWithRoomPriceAndRoomCountResponseModel>>() {
        });
        if (responseModels.isEmpty()) {
            return null;
        }
        List<RoomTypeInfo> roomTypeInfos = new ArrayList<>();
        SearchOrgWithRoomPriceAndRoomCountResponseModel roomCountResponseModel = responseModels.get(0);
        RoomTypeInfo roomTypeInfo = null;
        for (RoomCountModel roomCount : roomCountResponseModel.getRoomCounts()) {
            roomTypeInfo = new RoomTypeInfo();
            roomTypeInfo.setRoomTypeId(roomCount.RoomTypeId);
            roomTypeInfo.setBedAmount(roomCount.RoomType.BedAmount);
            roomTypeInfo.setAbbreviation(roomCount.RoomType.Abbreviation);
            roomTypeInfo.setRoomTypeName(roomCount.RoomType.RoomTypeName);
            roomTypeInfo.setResidueCount(roomCount.Count);
            roomTypeInfo.setImageUris(roomCount.RoomType.ImageUris != null ? roomCount.RoomType.ImageUris.split("\\|") : null);

            //获取价格
            for (RoomPriceModel price : roomCountResponseModel.getPrices()) {
                if (roomTypeInfo.getRoomTypeId().equals(price.RoomTypeId)) {
                    roomTypeInfo.setOriginPrice(price.OrignPrice);
                    roomTypeInfo.setActualPrice(price.ActualPrice);
                }
            }

            roomTypeInfos.add(roomTypeInfo);
        }
        return roomTypeInfos;
    }

    @Override
    public List<PreOrderInfo> getOrderByLiaison(String hotelId, String keyword) {
        QueryOrdersRequestModel requestModel = new QueryOrdersRequestModel();
        requestModel.setOrgId(Long.valueOf(hotelId));
        requestModel.setKeywords(keyword);
        requestModel.setOrderStatusIds(new String[]{"InProgress"});
        ApiRespModel apiRespModel = beyondService.onQueryOrders(requestModel);
        JSONObject data = new JSONObject(apiRespModel.Data);

        List<PreOrderInfo> orderInfos = new ArrayList<>();
        PreOrderInfo orderInfo = null;
        Liaison[] liaisons = null;
        Liaison liaisonInfo = new Liaison();
        JSONArray content = data.getJSONArray("Content");
        for (Object o : content) {
            JSONObject order = new JSONObject(o);
            orderInfo = new PreOrderInfo();
            orderInfo.setHotelId(order.getStr("OrgId"));
            orderInfo.setBillId(order.getLong("BillId"));
            orderInfo.setEstimatedArriveTime(order.getStr("EstimatedArriveTime"));
            orderInfo.setEstimatedDepartureTime(order.getStr("EstimatedDepartureTime"));
            orderInfo.setCheckInType(order.getStr("CheckinType"));
            orderInfo.setMemo(order.getStr("Memo"));
            orderInfo.setOrderId(order.getStr("OrderId"));
            orderInfo.setOrderNo(order.getStr("OrderNo"));
            orderInfo.setOrderSource(order.getStr("OrderSource"));
            orderInfo.setOrderStatus(order.getStr("OrderStatus"));

            JSONArray orderLiaisons = order.getJSONArray("Liaisons");
            liaisons = new Liaison[orderLiaisons.size()];

            for (int i = 0; i < orderLiaisons.size(); i++) {
                JSONObject liaison = new JSONObject(orderLiaisons.get(i));
                liaisonInfo = new Liaison();
                liaisonInfo.setName(liaison.getStr("Name"));
                liaisonInfo.setMobile(liaison.getStr("Mobile"));
                liaisons[i] = liaisonInfo;
            }

            orderInfo.setLiaisons(liaisons);
            orderInfos.add(orderInfo);
        }
        return orderInfos;
    }
}
