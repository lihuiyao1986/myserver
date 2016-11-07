package com.server.model;

import java.io.Serializable;

/**
 * Created by jk on 16/11/7.
 */
public class APIResp implements Serializable{

    private static final long serialVersionUID = -5053094488261580073L;

    private String message = "";

    private String code = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "APIResp{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
