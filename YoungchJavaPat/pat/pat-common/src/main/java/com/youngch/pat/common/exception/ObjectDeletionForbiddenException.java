package com.youngch.pat.common.exception;

import org.springframework.http.HttpStatus;


public abstract class ObjectDeletionForbiddenException extends BusinessException {
    public HttpStatus getHttpStatus() {
        return HttpStatus.FORBIDDEN;
    }
}
