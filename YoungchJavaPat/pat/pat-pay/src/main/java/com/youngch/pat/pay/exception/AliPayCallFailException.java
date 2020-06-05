package com.youngch.pat.pay.exception;

import com.youngch.pat.common.exception.BusinessException;

/**
 * @author: yexudong
 * @Date: 2020/6/3 11:23
 */
public class AliPayCallFailException extends BusinessException {
    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getErrorMsg() {
        return "alipay call on fail!";
    }
}
