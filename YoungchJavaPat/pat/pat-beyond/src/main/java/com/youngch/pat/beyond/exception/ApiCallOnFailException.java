package com.youngch.pat.beyond.exception;

import com.youngch.pat.common.exception.BusinessException;

/**
 * @author: yexudong
 * @Date: 2020/4/8 14:18
 */
public class ApiCallOnFailException extends BusinessException {
    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getErrorMsg() {
        return "接口远程调用失败！";
    }
}
