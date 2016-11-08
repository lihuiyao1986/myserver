package com.server.entity.exception;

/**
 * 业务层异常
 */
public class ServiceException extends BaseException {
    public ServiceException() {
        super ();
    }

    public ServiceException(String errorCode) {
        this (errorCode, "");
    }

    public ServiceException(String errorCode, String defaultMessage) {
        super (errorCode, defaultMessage);
    }

    public ServiceException(String errorCode, String internalCode, String defaultMessage) {
        super (errorCode, internalCode, defaultMessage);
    }

    public ServiceException(Throwable cause, String errorCode, String defaultMessage) {
        super (cause, errorCode, defaultMessage);
    }

    public ServiceException(Throwable cause, String errorCode) {
        super (cause, errorCode);
    }

    public ServiceException(String errorCode, String[] args) {
        super (errorCode, args);
    }

    @Override
    public String getMessage(){
        return this.defaultMessage;
    }
}
