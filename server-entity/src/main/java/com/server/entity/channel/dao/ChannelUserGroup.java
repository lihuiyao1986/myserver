package com.server.entity.channel.dao;

import com.server.entity.model.BaseBizEntity;

import javax.persistence.*;

/**
 * 用户分组
 * @author JOHN
 * 2015.01.13
 */
@Entity
@Table(name="BIZ_ChannelUserGroup")
public class ChannelUserGroup extends BaseBizEntity {
    private static final long serialVersionUID = -3788689445158785988L;
    // 服务号
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private ChannelServiceAccount serviceAccount;
    @Column(length=20)
    private String name;
    public ChannelServiceAccount getServiceAccount() {
        return serviceAccount;
    }
    public void setServiceAccount(ChannelServiceAccount serviceAccount) {
        this.serviceAccount = serviceAccount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}