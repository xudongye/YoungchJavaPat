package com.youngch.pat.pay.exception;

import com.youngch.pat.common.exception.BusinessException;

/**
 * @author: yexudong
 * @Date: 2020/6/3 10:54
 */
public class BusinessAlreadyPaidException extends BusinessException {
    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getErrorMsg() {
        return "order already paid";
    }
}
