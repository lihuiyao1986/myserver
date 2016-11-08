package com.server.entity.exception;

/**
 * 业务异常
 */
public class BusinessException extends BaseException {

    public BusinessException() {
        super ();
    }

    public BusinessException(String errorCode) {
        this (errorCode, "");
    }

    public BusinessException(String errorCode, String defaultMessage) {
        super (errorCode, defaultMessage);
    }

    public BusinessException(String errorCode, String internalCode, String defaultMessage) {
        super (errorCode, internalCode, defaultMessage);
    }

    public BusinessException(Throwable cause, String errorCode, String defaultMessage) {
        super (cause, errorCode, defaultMessage);
    }

    public BusinessException(Throwable cause, String errorCode) {
        super (cause, errorCode);
    }

    public BusinessException(String errorCode, String[] args) {
        super (errorCode, args);
    }

    @Override
    public String getMessage(){
        return this.defaultMessage;
    }
}
