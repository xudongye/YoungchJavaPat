package com.youngch.pat.pay.exception;

import com.youngch.pat.common.exception.BusinessException;

/**
 * @author: yexudong
 * @Date: 2020/6/2 16:50
 */
public class BusinessTypeNotSupportException extends BusinessException {
    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getErrorMsg() {
        return "business type not support";
    }
}
