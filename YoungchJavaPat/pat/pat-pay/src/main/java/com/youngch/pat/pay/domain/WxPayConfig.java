package com.youngch.pat.pay.domain;

import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/6/2 15:44
 */
@Data
public class WxPayConfig {
    private Long id;
    private String appId;
    private String wxpayAppKey;
    private String wxpayMchId;
    private String certLocalPath;
    private String hotelId;

    private String body;
    private String notifyUrl;
}
