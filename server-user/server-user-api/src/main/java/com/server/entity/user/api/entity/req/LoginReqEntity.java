package com.server.entity.user.api.entity.req;

import com.server.entity.model.BaseModel;

/**
 * Created by jk on 16/11/9.
 */
public class LoginReqEntity extends BaseModel{

    private String loginName;

    private String loginPwd;

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
