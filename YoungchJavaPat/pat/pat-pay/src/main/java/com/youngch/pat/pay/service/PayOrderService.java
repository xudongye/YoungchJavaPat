package com.youngch.pat.pay.service;

import com.youngch.pat.model.PayOrder;

/**
 * @author: yexudong
 * @Date: 2020/6/2 16:57
 */
public interface PayOrderService {

    PayOrder getNotPaidByOrderId(String orderId, int payType, String tradeType);

    PayOrder getByOutTradeNo(String outTradeNo);

    void create(PayOrder payOrder);

    void update(PayOrder payOrder);
}
