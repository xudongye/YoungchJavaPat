package com.youngch.pat.pay.business;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by Christopher.Wang on 2016/7/21.
 */
public class NotifyResData {
    // 基本参数
    /**
     * 通知的发送时间。
     格式为yyyy-MM-dd HH:mm:ss。
     */
    private String notify_time;
    private String notify_type;
    private String notify_id;
    private String sign_type;
    private String sign;

    // 业务数据
    private String out_trade_no;
    private String subject;
    private String payment_type;
    /**
     * 该交易在支付宝系统中的交易流水号。最长64位。
     */
    private String trade_no;
    private String trade_status;
    /**
     * 该笔交易创建的时间。
     格式为yyyy-MM-dd
     HH:mm:ss。
     */
    private String gmt_create;
    /**
     * 该笔交易的买家付款时间。
     */
    private String gmt_payment;
    private String gmt_close;
    private String seller_email;
    private String buyer_logon_id;
    private String seller_id;
    private String buyer_id;
    private String buyer_pay_amount;
    private String body;
    /**
     * 卖家退款的时间，退款通知时会发送。
     格式为yyyy-MM-dd HH:mm:ss。
     */
    private String gmt_refund;

    public NotifyResData(){}

    public NotifyResData(Map<String, String> fromMap){
        this();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (fromMap.containsKey(fieldName)){
                try {
                    field.set(this, fromMap.get(fieldName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getNotify_time() {
        return notify_time;
    }

    public void setNotify_time(String notify_time) {
        this.notify_time = notify_time;
    }

    public String getNotify_type() {
        return notify_type;
    }

    public void setNotify_type(String notify_type) {
        this.notify_type = notify_type;
    }

    public String getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getGmt_payment() {
        return gmt_payment;
    }

    public void setGmt_payment(String gmt_payment) {
        this.gmt_payment = gmt_payment;
    }

    public String getGmt_close() {
        return gmt_close;
    }

    public void setGmt_close(String gmt_close) {
        this.gmt_close = gmt_close;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public String getBuyer_logon_id() {
        return buyer_logon_id;
    }

    public void setBuyer_logon_id(String buyer_logon_id) {
        this.buyer_logon_id = buyer_logon_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }


    public String getBuyer_pay_amount() {
        return buyer_pay_amount;
    }

    public void setBuyer_pay_amount(String buyer_pay_amount) {
        this.buyer_pay_amount = buyer_pay_amount;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGmt_refund() {
        return gmt_refund;
    }

    public void setGmt_refund(String gmt_refund) {
        this.gmt_refund = gmt_refund;
    }

    @Override
    public String toString() {
        return "NotifyResData{" +
                "notify_time='" + notify_time + '\'' +
                ", notify_type='" + notify_type + '\'' +
                ", notify_id='" + notify_id + '\'' +
                ", sign_type='" + sign_type + '\'' +
                ", sign='" + sign + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", subject='" + subject + '\'' +
                ", payment_type='" + payment_type + '\'' +
                ", trade_no='" + trade_no + '\'' +
                ", trade_status='" + trade_status + '\'' +
                ", gmt_create='" + gmt_create + '\'' +
                ", gmt_payment='" + gmt_payment + '\'' +
                ", gmt_close='" + gmt_close + '\'' +
                ", seller_email='" + seller_email + '\'' +
                ", seller_id='" + seller_id + '\'' +
                ", buyer_id='" + buyer_id + '\'' +
                ", buyer_logon_id='" + buyer_logon_id + '\'' +
                ", buyer_pay_amount='" + buyer_pay_amount + '\'' +
                ", body='" + body + '\'' +
                ", gmt_refund='" + gmt_refund + '\'' +
                '}';
    }
}
