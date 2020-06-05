package com.youngch.pat.pay.exception;

import com.youngch.pat.common.exception.BusinessException;

/**
 * @author: yexudong
 * @Date: 2020/6/4 15:49
 */
public class PayMethodNotSupportException extends BusinessException {
    private String payMethod;

    private String payType;

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public PayMethodNotSupportException(String payMethod, String payType){
        this.payMethod = payMethod;
        this.payType = payType;
    }

    @Override
    public String getErrorCode() {
        return "21504";
    }

    @Override
    public String getErrorMsg() {
        return "pay method not support, method: " + this.payMethod + " type : " + this.payType;
    }
}
