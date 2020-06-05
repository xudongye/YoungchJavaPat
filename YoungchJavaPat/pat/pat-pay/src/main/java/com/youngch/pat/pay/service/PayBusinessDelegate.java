package com.youngch.pat.pay.service;

import com.youngch.pat.pay.domain.AliPayConfig;
import com.youngch.pat.pay.domain.PayOrderParam;
import com.youngch.pat.pay.domain.WxPayConfig;


/**
 * @author: yexudong
 * @Date: 2020/6/3 9:33
 */
public interface PayBusinessDelegate {

    boolean isAlreadyPaid(PayOrderParam payOrderParam);

    double getPaidPrice(PayOrderParam payOrderParam);

    AliPayConfig getAliConfig(String orderId);

    WxPayConfig getWxConfig(String orderId);

    void handlePayResult(PayOrderParam payOrderParam);
}
