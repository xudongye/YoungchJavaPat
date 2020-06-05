package com.youngch.pat.pay.service.impl;

import com.youngch.pat.common.utils.price.PriceUtils;
import com.youngch.pat.model.PayConfig;
import com.youngch.pat.model.PayOrder;
import com.youngch.pat.model.PmsOrder;
import com.youngch.pat.pay.constant.PayConstant;
import com.youngch.pat.pay.domain.AliPayConfig;
import com.youngch.pat.pay.domain.PayOrderParam;
import com.youngch.pat.pay.domain.WxPayConfig;
import com.youngch.pat.pay.exception.PayOrderNotFoundException;
import com.youngch.pat.pay.exception.PmsOrderNotFoundException;
import com.youngch.pat.pay.exception.UnsetAliPayConfigException;
import com.youngch.pat.pay.service.PayBusinessDelegate;
import com.youngch.pat.pay.service.PayConfigService;
import com.youngch.pat.pay.service.PayOrderService;
import com.youngch.pat.pay.service.PmsOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: yexudong
 * @Date: 2020/6/3 9:37
 */
@Service("BeyondPayBusinessDelegateImpl")
public class BeyondPayBusinessDelegateImpl implements PayBusinessDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeyondPayBusinessDelegateImpl.class);

    @Autowired
    private PayConfigService payConfigService;

    @Autowired
    private PmsOrderService pmsOrderService;

    @Autowired
    private PayOrderService payOrderService;


    @Override
    public boolean isAlreadyPaid(PayOrderParam payOrderParam) {
        return pmsOrderService.isOrderPaid(payOrderParam.getOrderId());
    }

    @Override
    public double getPaidPrice(PayOrderParam payOrderParam) {
        PmsOrder pmsOrder = pmsOrderService.getByOrderId(payOrderParam.getOrderId());
        return PriceUtils.ConvertDecimalPoint(pmsOrder.getTotalFee(), 2);
    }

    @Override
    public AliPayConfig getAliConfig(String orderId) {
        PmsOrder pmsOrder = pmsOrderService.getByOrderId(orderId);
        if (pmsOrder == null) {
            throw new PmsOrderNotFoundException();
        }
        PayConfig payConfig = payConfigService.getByHotelId(pmsOrder.getHotelId(), PayConstant.PayType.AliPay.getCode());
        if (payConfig == null) {
            throw new UnsetAliPayConfigException();
        }
        AliPayConfig config = new AliPayConfig();
        config.setAppId(payConfig.getAppId());
        config.setPrivateKey(payConfig.getPrivateKey());
        config.setPublicKey(payConfig.getPublicKey());
        config.setAlipayPublicKey(payConfig.getAlipayPublicKey());
        config.setGateWayUrl(payConfig.getGateWayUrl());
        config.setHotelId(payConfig.getHotelId());
        config.setBody(payConfig.getBody());
        config.setSubject(payConfig.getSubject());
        config.setNotifyUrl(payConfig.getNotifyUrl());
        return config;
    }

    @Override
    public WxPayConfig getWxConfig(String hotelId) {
        return null;
    }

    @Override
    public void handlePayResult(PayOrderParam payOrderParam) {
        LOGGER.info("order pay result from beyond：order id {} , pay type {}", payOrderParam.getOrderId(), payOrderParam.getPayType().getName());
        if (pmsOrderService.isOrderPaid(payOrderParam.getOrderId())) {
            return;
        }
        pmsOrderService.markOrderPaid(payOrderParam.getOrderId(), payOrderParam.getPayType().getCode());
    }
}
