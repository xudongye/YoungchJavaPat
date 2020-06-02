package com.youngch.pat.cloudwalk.service;

import com.youngch.pat.cloudwalk.vo.*;

import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/5/26 10:08
 */
public interface CloudWalkService {

    MemberInfo getMember(MemberQueryCondition condition);

    Hotel getHotelInfo(String hotelId);

    List<Room> getRoomByRoomType(HotelRoomQueryCondition condition);

    List<RoomTypeInfo> getHotelRoomTypeCountAndPriceList(HotelRoomQueryCondition condition);

    List<PreOrderInfo> getOrderByLiaison(String hotelId, String keyword);

    PreOrderInfo getSingleOrder(String orderId, String hotelId);

//    PreOrderInfo addOrder(String checkInType, String hotelId);

    boolean checkIn(CheckInParam checkInParam);
}
