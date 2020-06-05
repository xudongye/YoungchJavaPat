package com.youngch.pat.pay.exception;

import com.youngch.pat.common.exception.BusinessException;

/**
 * @author: yexudong
 * @Date: 2020/6/4 14:09
 */
public class PayOrderNotFoundException extends BusinessException {
    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getErrorMsg() {
        return "pay order not found.";
    }
}
