package com.server.exception;

/**
 * 应用异常
 * @author william
 *
 */
public class ApplicationException extends BaseException {

	private static final long serialVersionUID = 6915817144165235682L;

	public ApplicationException() {
        super ();
    }

    public ApplicationException(String errorCode) {
        this (errorCode, "");
    }

    public ApplicationException(String errorCode, String defaultMessage) {
        super (errorCode, defaultMessage);
    }

    public ApplicationException(String errorCode, String internalCode, String defaultMessage) {
        super (errorCode, internalCode, defaultMessage);
    }

    public ApplicationException(Throwable cause, String errorCode, String defaultMessage) {
        super (cause, errorCode, defaultMessage);
    }

    public ApplicationException(Throwable cause, String errorCode) {
        super (cause, errorCode);
    }

    public ApplicationException(String errorCode, String[] args) {
        super (errorCode, args);
    }

    @Override
    public String getMessage(){
        return this.defaultMessage;
    }
}
