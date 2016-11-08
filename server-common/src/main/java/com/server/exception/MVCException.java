package com.server.exception;

/**
 * 控制层异常
 */
public class MVCException extends BaseException {

    public MVCException() {
        super ();
    }

    public MVCException(String errorCode) {
        this (errorCode, "");
    }

    public MVCException(String errorCode, String defaultMessage) {
        super (errorCode, defaultMessage);
    }

    public MVCException(String errorCode, String internalCode, String defaultMessage) {
        super (errorCode, internalCode, defaultMessage);
    }

    public MVCException(Throwable cause, String errorCode, String defaultMessage) {
        super (cause, errorCode, defaultMessage);
    }

    public MVCException(Throwable cause, String errorCode) {
        super (cause, errorCode);
    }

    public MVCException(String errorCode, String[] args) {
        super (errorCode, args);
    }

    @Override
    public String getMessage(){
        return this.defaultMessage;
    }
}
