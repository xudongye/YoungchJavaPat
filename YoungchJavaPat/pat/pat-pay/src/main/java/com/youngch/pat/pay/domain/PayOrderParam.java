package com.youngch.pat.pay.domain;

import com.youngch.pat.pay.constant.PayConstant;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/6/2 15:52
 */
@Data
public class PayOrderParam {

    private PayConstant.BusinessType businessType;

    private PayConstant.PayType payType;

    private PayConstant.TradeType tradeType;

    private String orderId;

}
