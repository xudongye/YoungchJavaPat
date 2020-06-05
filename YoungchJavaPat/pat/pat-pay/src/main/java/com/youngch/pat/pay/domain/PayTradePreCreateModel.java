package com.youngch.pat.pay.domain;

/**
 * @author: yexudong
 * @Date: 2020/6/2 15:43
 */
public class PayTradePreCreateModel {
    private String codeUrl;
    private String outTradeNo;

    public PayTradePreCreateModel() {
    }

    public PayTradePreCreateModel(String codeUrl, String outTradeNo) {
        this.codeUrl = codeUrl;
        this.outTradeNo = outTradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }
}
