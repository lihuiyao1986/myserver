package com.server.entity.model;

import com.server.entity.constants.GlobalErrorcode;
import com.server.entity.utils.StringUtils;

import java.io.Serializable;

/**
 * 请求响应结果
 */
public class APIRespEntity<T> implements Serializable {

    private static final long serialVersionUID = -6693512467274575699L;

    public String code = GlobalErrorcode.SUCC_CODE;

    public String message = GlobalErrorcode.SUCC_MSG;

    public boolean isSucc(){
        return StringUtils.trimNull(code).endsWith(GlobalErrorcode.SUCC_CODE);
    }

    public APIRespEntity() {

    }

    public APIRespEntity(String code, T respResult) {
        this.code = code;
        this.respResult = respResult;
    }

    public APIRespEntity(String code, String message, T respResult) {
        this.code = code;
        this.message = message;
        this.respResult = respResult;
    }

    public APIRespEntity(T respResult) {
        this.respResult = respResult;
    }

    public T respResult;

    public T getRespResult() {
        return respResult;
    }

    public void setRespResult(T respResult) {
        this.respResult = respResult;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "APIRespEntity{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", respResult=" + respResult +
                '}';
    }
}
