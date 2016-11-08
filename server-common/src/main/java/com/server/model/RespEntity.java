package com.server.model;

import com.server.constants.Errorcode;
import com.server.utils.StringUtils;

/**
 * 响应bean
 */
public class RespEntity <T extends Object> {

    private T result;

    private String errormsg = Errorcode.SUCC_CODE;

    private String errorcode = Errorcode.SUCC_MSG;

    private boolean successfull = true;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public boolean isSuccessfull() {
        return Errorcode.SUCC_CODE.equals(StringUtils.trimNull(errorcode));
    }
}
