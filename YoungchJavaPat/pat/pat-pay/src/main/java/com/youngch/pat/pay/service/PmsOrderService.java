package com.youngch.pat.pay.service;

import com.youngch.pat.model.PmsOrder;
import com.youngch.pat.pay.constant.PayConstant;
import com.youngch.pat.pay.domain.PmsOrderParam;

/**
 * @author: yexudong
 * @Date: 2020/6/2 16:20
 */
public interface PmsOrderService {

    PmsOrder create(PmsOrderParam pmsOrderParam);

    PmsOrder getByOrderId(String orderId);

    PmsOrder getPaidByOrderId(String orderId);

    boolean isOrderPaid(String orderId);

    void markOrderPaid(String orderId, int payType);

}
