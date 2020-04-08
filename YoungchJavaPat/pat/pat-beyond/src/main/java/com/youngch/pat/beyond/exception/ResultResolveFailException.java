package com.youngch.pat.beyond.exception;

import com.youngch.pat.common.exception.BusinessException;

public class ResultResolveFailException extends BusinessException {

    private String message;

    public ResultResolveFailException(String message) {
        this.message = message;
    }

    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getErrorMsg() {
        return "解析请求结果失败: " + message;
    }
}
