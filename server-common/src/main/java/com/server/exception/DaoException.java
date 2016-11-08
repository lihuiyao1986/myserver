package com.server.exception;

/**
 * 数据访问层异常
 */
public class DaoException extends BaseException{

    public DaoException() {
        super ();
    }

    public DaoException(String errorCode) {
        this (errorCode, "");
    }

    public DaoException(String errorCode, String defaultMessage) {
        super (errorCode, defaultMessage);
    }

    public DaoException(String errorCode, String internalCode, String defaultMessage) {
        super (errorCode, internalCode, defaultMessage);
    }

    public DaoException(Throwable cause, String errorCode, String defaultMessage) {
        super (cause, errorCode, defaultMessage);
    }

    public DaoException(Throwable cause, String errorCode) {
        super (cause, errorCode);
    }

    public DaoException(String errorCode, String[] args) {
        super (errorCode, args);
    }

    @Override
    public String getMessage(){
        return this.defaultMessage;
    }
}
