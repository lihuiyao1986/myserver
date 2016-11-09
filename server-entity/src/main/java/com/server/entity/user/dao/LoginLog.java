package com.server.entity.user.dao;


import com.server.entity.base.dao.WebBaseLogEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 登录日志
 * @author JOHN
 * 20150212
 */
@Entity
@Table(name="SYS_LoginLog")
public class LoginLog extends WebBaseLogEntity {

    @Column
    private Date logoutTime;

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

}