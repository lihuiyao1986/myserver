package com.server.entity.exception;

import com.server.entity.utils.StringUtils;

/**
 *
 */
public class APIException extends Exception {

    // 错误编码
    private String errorCode;

    // 默认错误信息
    protected String errorMsg;

    /**
     * 构造函数
     * @param throwable
     * @param errorCode
     * @param errorMsg
     */
    public APIException(Throwable throwable,String errorCode,String errorMsg) {
        super(throwable);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     *
     * @param errorCode
     * @param errorMsg
     */
    public APIException(String errorCode,String errorMsg){
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return StringUtils.trimNull(errorMsg + "[" + getErrorCode() + "]", getMessage());
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
