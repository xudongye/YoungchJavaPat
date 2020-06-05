package com.youngch.pat.pay.business;

import com.youngch.pat.pay.config.PaymentConfig;
import com.youngch.pat.pay.domain.AliPayConfig;
import com.youngch.pat.pay.service.NotifyBusinessBoFactory;
import com.youngch.pat.pay.service.OutTradeNoGenerator;
import com.youngch.pat.pay.service.PayBusinessDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author: yexudong
 * @Date: 2020/6/4 14:41
 */
public class AliPayResultBusinessRecorder implements HandleAliPayResultBusiness.ResultListener, NotifyBusinessBoFactory {
    private static Logger logger = LoggerFactory.getLogger(AliPayResultBusinessRecorder.class);

    private boolean isSuccess = false;

    private String outTradeNo;

    private String tradeType;

    /**
     * 订单金额
     */
    private int totalFee;

    /**
     * 微信支付订单号
     */
    private String transactionId;

    private Date timeEnd;

    private String buyerId;

    private String buyerLogonId;


    @Override
    public void onFailBySignInvalid(NotifyResData notifyResData) {
        logger.error("【支付结果失败】请求API返回的数据签名验证失败，有可能数据被篡改了, {}", notifyResData);
    }

    @Override
    public void onSuccess(NotifyResData notifyResData) {
        logger.info("alipay enter【支付结果成功】, {}", notifyResData);
        this.isSuccess = true;
        this.outTradeNo = notifyResData.getOut_trade_no();
        this.totalFee = (int) Math.round(new Double(notifyResData.getBuyer_pay_amount()) * 100);
        this.transactionId = notifyResData.getTrade_no();
        this.buyerId = notifyResData.getBuyer_id();
        this.buyerLogonId = notifyResData.getBuyer_logon_id();
        try {
            this.timeEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(notifyResData.getGmt_payment());
        } catch (ParseException e) {
            logger.warn("alipay end time string parse error, outTradeNo:{}, msg:{} ", getOutTradeNo(), e);
        }
        logger.info("alipay exist【支付结果成功】, {}", notifyResData);
    }

    @Override
    public NotifyBusinessBo getNotifyBusinessBo() {
        return new NotifyBusinessBo()
                .setOutTradeNo(getOutTradeNo())
                .setTotalFee(getTotalFee())
                .setTradeType(getTradeType())
                .setSettlementTotalFee(getTotalFee())
                .setTransactionId(getTransactionId())
                .setTimeEnd(getTimeEnd())
                .setBuyerId(getBuyerId())
                .setBuyerLogonId(getBuyerLogonId());
    }

    @Override
    public void onUnknownFail(NotifyResData notifyResData) {
        logger.error("【支付结果失败】未知错误, {}", notifyResData);
    }

    @Override
    public AliPayConfig onConfig(String outTradeNo) {
        int businessType = OutTradeNoGenerator.getBusinessTypeByOutTradePrefixTag(outTradeNo);
        PayBusinessDelegate payBusinessDelegate = PaymentConfig.getBusinessDelegate(null, businessType);
        AliPayConfig aliPayConfig = payBusinessDelegate.getAliConfig(outTradeNo);
        logger.info("get config by out_trade_no, appId {} from hotel {}", aliPayConfig.getAppId(), aliPayConfig.getHotelId());
        return aliPayConfig;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public String getTradeType() {
        return tradeType;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getBuyerLogonId() {
        return buyerLogonId;
    }
}
