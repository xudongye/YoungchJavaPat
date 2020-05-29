package com.youngch.pat.cloudwalk.service;

import com.youngch.pat.cloudwalk.constant.CloudWalkConstant;
import lombok.Data;


/**
 * @author: yexudong
 * @Date: 2020/5/26 10:35
 */
@Data
public class HotelRoomQueryCondition {
    private String hotelId;
    private String arriveTime;
    private String departureTime;
    private String[] roomTypeIds;
    private CloudWalkConstant.CheckInType checkInType;
}
