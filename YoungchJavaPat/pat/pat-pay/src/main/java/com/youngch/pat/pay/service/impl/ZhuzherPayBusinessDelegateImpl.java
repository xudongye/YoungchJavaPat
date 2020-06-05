package com.youngch.pat.pay.service.impl;

import com.youngch.pat.pay.domain.AliPayConfig;
import com.youngch.pat.pay.domain.PayOrderParam;
import com.youngch.pat.pay.domain.WxPayConfig;
import com.youngch.pat.pay.service.PayBusinessDelegate;
import org.springframework.stereotype.Service;

/**
 * @author: yexudong
 * @Date: 2020/6/5 10:06
 */
@Service("ZhuzherPayBusinessDelegateImpl")
public class ZhuzherPayBusinessDelegateImpl implements PayBusinessDelegate {
    @Override
    public boolean isAlreadyPaid(PayOrderParam payOrderParam) {
        return false;
    }

    @Override
    public double getPaidPrice(PayOrderParam payOrderParam) {
        return 0;
    }

    @Override
    public AliPayConfig getAliConfig(String orderId) {
        return null;
    }

    @Override
    public WxPayConfig getWxConfig(String orderId) {
        return null;
    }

    @Override
    public void handlePayResult(PayOrderParam payOrderParam) {

    }
}
