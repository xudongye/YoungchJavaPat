package com.youngch.pat.pay.domain;

import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/6/3 9:55
 */
@Data
public class PmsOrderParam {
    private String orderId;
    private String hotelId;
    private String occupationId;
    private double totalFee;
}
