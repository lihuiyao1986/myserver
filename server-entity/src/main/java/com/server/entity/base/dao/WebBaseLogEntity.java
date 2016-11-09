package com.server.entity.base.dao;

import com.server.entity.model.BaseDaoEntity;
import com.server.entity.user.dao.UserDaoEntity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class WebBaseLogEntity extends BaseDaoEntity {

    @Column
    protected Date createTime;			//log创建时间
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=true,fetch = FetchType.EAGER)
    @JoinColumn(nullable=true)
    protected UserDaoEntity user;				//log创建人

    @Column(length=50)
    protected String localIP;	//远端IP地址
    @Column(length=50)
    protected String remoteIP;	//远端IP地址
    @Column(length=80)
    protected String sessionID;	//http会话id

    @Column(length=20)
    protected String ownership;			//所属组织的code

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UserDaoEntity getUser() {
        return user;
    }

    public void setUser(UserDaoEntity user) {
        this.user = user;
    }

    public String getLocalIP() {
        return localIP;
    }

    public void setLocalIP(String localIP) {
        this.localIP = localIP;
    }

    public String getRemoteIP() {
        return remoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        this.remoteIP = remoteIP;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

}