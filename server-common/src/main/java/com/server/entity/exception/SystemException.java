package com.server.entity.exception;

/**
 * 系统异常
 */
public class SystemException extends BaseException {
    public SystemException() {
        super ();
    }

    public SystemException(String errorCode) {
        this (errorCode, "");
    }

    public SystemException(String errorCode, String defaultMessage) {
        super (errorCode, defaultMessage);
    }

    public SystemException(String errorCode, String internalCode, String defaultMessage) {
        super (errorCode, internalCode, defaultMessage);
    }

    public SystemException(Throwable cause, String errorCode, String defaultMessage) {
        super (cause, errorCode, defaultMessage);
    }

    public SystemException(Throwable cause, String errorCode) {
        super (cause, errorCode);
    }

    public SystemException(String errorCode, String[] args) {
        super (errorCode, args);
    }

    @Override
    public String getMessage(){
        return this.defaultMessage;
    }
}
