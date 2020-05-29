package com.youngch.pat.cloudwalk.vo;

import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/5/29 14:18
 */
@Data
public class PreOrderInfo {
    private String hotelId;
    private String orderId;
    private String orderNo;
    private long billId;
    private String checkInType;
    private String orderStatus;
    private String estimatedArriveTime;
    private String estimatedDepartureTime;
    private String memo;
    private String orderSource;
    private Liaison[] liaisons;
}
