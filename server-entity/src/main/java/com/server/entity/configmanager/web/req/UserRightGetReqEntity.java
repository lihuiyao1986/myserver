package com.server.entity.configmanager.web.req;

import com.server.entity.model.BaseModel;

/**
 * LoginReqEntity登录请求参数
 */
public class UserRightGetReqEntity extends BaseModel{

    // 用户ID
    private long userId;

    // 会员
    private String ownShip;

    public UserRightGetReqEntity(long userId, String ownShip) {
        this.userId = userId;
        this.ownShip = ownShip;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOwnShip() {
        return ownShip;
    }

    public void setOwnShip(String ownShip) {
        this.ownShip = ownShip;
    }

    @Override
    public String toString() {
        return "UserResGetReqEntity{" +
                "userId=" + userId +
                ", ownShip='" + ownShip + '\'' +
                '}';
    }
}
