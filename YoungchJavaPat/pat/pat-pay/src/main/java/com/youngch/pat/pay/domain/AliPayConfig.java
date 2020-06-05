package com.youngch.pat.pay.domain;

import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/6/2 15:45
 */
@Data
public class AliPayConfig {
    private String appId;
    private String privateKey;
    private String publicKey;
    private String alipayPublicKey;
    private String gateWayUrl;

    private String hotelId;
    private String body;
    private String subject;
    private String notifyUrl;
}
