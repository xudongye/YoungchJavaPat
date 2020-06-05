package com.youngch.pat.pay.service;

import com.youngch.pat.pay.domain.PayOrderParam;
import com.youngch.pat.pay.domain.PayTradePreCreateModel;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: yexudong
 * @Date: 2020/6/2 15:36
 */
public interface PayService {

    PayTradePreCreateModel aliPayPreCreate(PayOrderParam orderParam);

    boolean aliPayCallBack(HttpServletRequest request);

    PayTradePreCreateModel wxPayPreCreate(HttpServletRequest request, PayOrderParam orderParam);

    String wxPayCallBack(HttpServletRequest request);

    boolean unifiedRefund(String orderId);

}
