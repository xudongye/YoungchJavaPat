package com.youngch.pat.common.exception;

import org.springframework.http.HttpStatus;

public abstract class ObjectNotFoundException extends BusinessException {
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
