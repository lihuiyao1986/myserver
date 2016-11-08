package com.server.model;

import com.server.constants.Errorcode;
import com.server.utils.StringUtils;

import javax.xml.bind.annotation.*;

/**
 * 响应bean
 */
@XmlRootElement(name = "resp")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseRespEntity extends BaseModel{

    private String errormsg = Errorcode.SUCC_CODE;

    private String errorcode = Errorcode.SUCC_MSG;

    private boolean successfull = true;

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
