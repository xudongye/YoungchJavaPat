package com.youngch.pat.pay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.youngch.pat.common.utils.enums.EnumUtil;
import com.youngch.pat.model.PayOrder;
import com.youngch.pat.pay.business.AliPayResultBusinessRecorder;
import com.youngch.pat.pay.business.NotifyBusinessBo;
import com.youngch.pat.pay.config.PaymentConfig;
import com.youngch.pat.pay.constant.PayConstant;
import com.youngch.pat.pay.domain.AliPayConfig;
import com.youngch.pat.pay.domain.PayOrderParam;
import com.youngch.pat.pay.domain.PayTradePreCreateModel;
import com.youngch.pat.pay.exception.AliPayCallFailException;
import com.youngch.pat.pay.exception.BusinessAlreadyPaidException;
import com.youngch.pat.pay.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

import static com.youngch.pat.pay.config.PaymentConfig.doHandlePayResultBusiness;
import static com.youngch.pat.pay.config.PaymentConfig.getBusinessDelegate;

/**
 * @author: yexudong
 * @Date: 2020/6/2 16:05
 */
@Service
public class PayServiceImpl implements PayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayServiceImpl.class);

    @Autowired
    private PayConfigService payConfigService;

    @Autowired
    private PmsOrderService pmsOrderService;

    @Autowired
    private PayOrderService payOrderService;

    @Autowired
    private Map<String, PayBusinessDelegate> payBusinessDelegateMap;

    @Override
    public PayTradePreCreateModel aliPayPreCreate(PayOrderParam orderParam) {
        int businessType = orderParam.getBusinessType().getCode();
        PayBusinessDelegate payBusinessDelegate = getBusinessDelegate(payBusinessDelegateMap, businessType);
        if (payBusinessDelegate.isAlreadyPaid(orderParam)) {
            throw new BusinessAlreadyPaidException();
        }
        double realPay = payBusinessDelegate.getPaidPrice(orderParam);
        int totalFee = getTotalFee(realPay);
        PayOrder accountPayOrder = payOrderService.getNotPaidByOrderId(orderParam.getOrderId(),
                orderParam.getPayType().getCode(), orderParam.getTradeType().getName());
        boolean needUpdate = false;
        String codeUrl = "";
        String outTradeNo = "";
        if (accountPayOrder != null) {
            //NATIVE 支付 对应codeUrl不为空
            boolean createdOnce = StringUtils.isNotEmpty(accountPayOrder.getCodeUrl());
            Date lastModifiedTime = accountPayOrder.getModifyTime() == null ?
                    accountPayOrder.getCreateTime() : accountPayOrder.getModifyTime();
            boolean expired = hasPrepayIdExpired(orderParam.getTradeType().getCode(), lastModifiedTime);
            //有订单但已超时
            if (!createdOnce || expired) {
                needUpdate = true;
            } else {
                codeUrl = accountPayOrder.getCodeUrl();
                outTradeNo = accountPayOrder.getOutTradeNo();
            }
        }
        //订单未创建，或已存在但需要更新
        if (accountPayOrder == null || needUpdate) {
            outTradeNo = accountPayOrder == null ? OutTradeNoGenerator.generate(businessType) : outTradeNo;
            AliPayConfig aliPayBean = payBusinessDelegate.getAliConfig(orderParam.getOrderId());
            AlipayTradePrecreateResponse precreateResponse = doAliPayPrecreate(aliPayBean, outTradeNo, realPay);
            codeUrl = precreateResponse.getQrCode();
            if (accountPayOrder == null) {
                createPayOrder(orderParam, outTradeNo, "", totalFee, codeUrl);
            }
            if (needUpdate) {
                accountPayOrder.setCodeUrl(codeUrl);
                accountPayOrder.setOutTradeNo(outTradeNo);
                accountPayOrder.setModifyTime(new Date());
                payOrderService.update(accountPayOrder);
                LOGGER.info("alipay prepay updated, outTradeNo: {} businessId: {}, codeUrl: {}",
                        accountPayOrder.getOutTradeNo(), accountPayOrder.getPmsOrderId(), codeUrl);
            }
        }
        return new PayTradePreCreateModel(codeUrl, outTradeNo);

    }

    @Override
    public boolean aliPayCallBack(HttpServletRequest request) {
        LOGGER.info("Receive alipay handleAliPayNotify request parameters : {}", request.getParameterMap());
        AliPayResultBusinessRecorder aliPayResultBusinessRecorder = new AliPayResultBusinessRecorder();
        try {
            doHandlePayResultBusiness(request, aliPayResultBusinessRecorder);
            if (aliPayResultBusinessRecorder.isSuccess()) {
                handleNotify(aliPayResultBusinessRecorder.getNotifyBusinessBo());
            }
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("handle alipay notify error:", e);
        }
        return aliPayResultBusinessRecorder.isSuccess();
    }

    private void handleNotify(NotifyBusinessBo notifyBusiness) {
        LOGGER.info("handleNotify outTradeNo: ({})", notifyBusiness.getOutTradeNo());
        int businessType = OutTradeNoGenerator.getBusinessTypeByOutTradePrefixTag(notifyBusiness.getOutTradeNo());
        PayOrder payOrder = payOrderService.getByOutTradeNo(notifyBusiness.getOutTradeNo());
        if (payOrder.getPaid()) {
            // the order has been handled already.
            LOGGER.warn("handleNotify outTradeNo: ({}) is already paid.", notifyBusiness.getOutTradeNo());
            return;
        }
        // check money equals
        int needPayPrice = payOrder.getTotalFee();
        if (needPayPrice > payOrder.getTotalFee()) {
            LOGGER.warn("handleNotify outTradeNo: ({}), pay price ({}) less than order ({}), quit marking order to paid.",
                    notifyBusiness.getOutTradeNo(), notifyBusiness.getTotalFee(), needPayPrice);
            // 2017/6/9 just warn, do not return, since alipay might give substract automatically
            // mostly between 0 ~ 2 RMB
            //return;
        }
        // update pay order data
        payOrder.setPaid(true);
        payOrder.setTradeType(notifyBusiness.getTradeType());
        payOrder.setTotalFee(notifyBusiness.getTotalFee());
        payOrder.setSettlementTotalFee(notifyBusiness.getSettlementTotalFee());
        payOrder.setTransactionId(notifyBusiness.getTransactionId());
        payOrder.setTimeEnd(notifyBusiness.getTimeEnd());
        payOrder.setBuyerId(notifyBusiness.getBuyerId());
        payOrder.setBuyerLogonId(notifyBusiness.getBuyerLogonId());
        payOrder.setModifyTime(new Date());
        payOrderService.update(payOrder);

        // delegate to business service
        PayBusinessDelegate payBusinessDelegate = getBusinessDelegate(payBusinessDelegateMap, businessType);
        PayOrderParam payBusinessBo = new PayOrderParam();
        payBusinessBo.setOrderId(payOrder.getPmsOrderId());
        payBusinessBo.setPayType(EnumUtil.getEnumObject(payOrder.getPayType(), PayConstant.PayType.class));
        payBusinessDelegate.handlePayResult(payBusinessBo);
    }

    @Override
    public PayTradePreCreateModel wxPayPreCreate(HttpServletRequest request, PayOrderParam orderParam) {
        return null;
    }

    @Override
    public String wxPayCallBack(HttpServletRequest request) {
        return null;
    }

    @Override
    public boolean unifiedRefund(String orderId) {
        return false;
    }

    private PayOrder createPayOrder(PayOrderParam payOrderBean, String outTradeNo, String prepayId, int totalFee, String codeUrl) {
        PayOrder accountPayOrder = new PayOrder();
        accountPayOrder.setPaid(false);
        accountPayOrder.setPmsOrderId(payOrderBean.getOrderId());
        accountPayOrder.setPayType(payOrderBean.getPayType().getCode());
        accountPayOrder.setTradeType(payOrderBean.getTradeType().getName());
        accountPayOrder.setTotalFee(totalFee);
        accountPayOrder.setOutTradeNo(outTradeNo);
        accountPayOrder.setPrepayId(prepayId);
        accountPayOrder.setCodeUrl(codeUrl);
        accountPayOrder.setCreateTime(new Date());
        payOrderService.create(accountPayOrder);
        LOGGER.info("create PayOrder.outTradeNo = {} for business: {} ",
                outTradeNo, payOrderBean.getOrderId());
        return accountPayOrder;
    }

    //发起支付宝扫码支付
    private AlipayTradePrecreateResponse doAliPayPrecreate(AliPayConfig aliPayBean, String outTradeNo, double realPay) {

        AlipayClient alipayClient = new DefaultAlipayClient(aliPayBean.getGateWayUrl(), aliPayBean.getAppId(),
                aliPayBean.getPrivateKey(), "json", "utf-8", aliPayBean.getAlipayPublicKey(), "RSA2");

        AlipayTradePrecreateModel precreateModel = new AlipayTradePrecreateModel();
        precreateModel.setOutTradeNo(outTradeNo);
        precreateModel.setBody(aliPayBean.getBody());
        precreateModel.setSubject(aliPayBean.getSubject());
        precreateModel.setTimeoutExpress("30m");
        precreateModel.setTotalAmount(String.valueOf(realPay));

        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setBizModel(precreateModel);
        request.setNotifyUrl(aliPayBean.getNotifyUrl());
        try {
            AlipayTradePrecreateResponse precreateResponse = alipayClient.execute(request);
            if (precreateResponse.isSuccess()) {
                LOGGER.info("酒店 {} 设备 成功发起 aliPay 支付", aliPayBean.getHotelId());
                return precreateResponse;
            }
            LOGGER.error("支付宝支付错误结果：{}", precreateResponse.getMsg());
        } catch (AlipayApiException e) {
            e.printStackTrace();
            LOGGER.error("aliPay 支付发起失败：{}", e.getErrMsg());
        }

        throw new AliPayCallFailException();
    }

    private int getTotalFee(double realPay) {
        return (int) (realPay * 100);
    }

    private boolean hasPrepayIdExpired(int tradeType, Date lastModifiedTime) {
        Calendar c1 = Calendar.getInstance();// 获取当前时间
        Calendar c2 = Calendar.getInstance();
        c2.setTime(lastModifiedTime);
        long currentTime = c1.getTimeInMillis();
        long createTime = c2.getTimeInMillis();
        long difference = currentTime - createTime;
        //long surviveTime = difference / (3600 * 1000);
        /**微信h5支付有效期为5分钟*/
        if (tradeType == PayConstant.TradeType.MWEB.getCode()) {
            return difference >= 5 * 60 * 1000;
        } else {
            /**二维码有效期为2小时*/
            return difference >= 2 * 3600 * 1000;
        }
    }
}
