package com.server.entity.model;

import java.io.Serializable;

/**
 * 请求参数
 */
public class APIReqEntity <T> implements Serializable {

    private static final long serialVersionUID = 4625851219663000912L;

    public T reqParam;

    public T getReqParam() {
        return reqParam;
    }

    public void setReqParam(T reqParam) {
        this.reqParam = reqParam;
    }

    public APIReqEntity(T reqParam) {
        this.reqParam = reqParam;
    }
}
