package com.youngch.pat.beyond.exception;

import com.youngch.pat.common.base.exception.BusinessException;

public class BeyondCallOnFailException extends BusinessException {
    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getErrorMsg() {
        return "别样红接口访问失败！";
    }
}
