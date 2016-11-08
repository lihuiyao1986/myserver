package com.server.entity.channel.dao;

import com.server.entity.model.BaseBizEntity;

import javax.persistence.*;

/**
 * 云通讯附属主账户
 * @author ly
 *
 */
@Entity
@Table(name="BIZ_ChannelAffiliateSubAccount")
public class ChannelAffiliateSubAccount extends BaseBizEntity {
    /***/
    private static final long serialVersionUID = -6240009995710642153L;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn
    private  ChannelServiceAccount channelServiceAccount;// 渠道服务账户

    @Column
    private String subAccountSid;// 子账户Id

    @Column
    private String subToken;// 子账户的授权令牌

    @Column
    private String voipAccount;// VoIP 号码

    @Column
    private String voipPwd;// VoIP 密码

    @Column
    private String voipToken;// VoIP 授权令牌

    @Column
    private String agentNo;// 坐席编号(存储规则: 渠道服务账号(Ownership) + 自增的坐席编号)

    @Column(columnDefinition = "bit default 0")
    private boolean priority;// 是否优先接听客户电话。false：顺序接听，true：优先接听。默认值为false

    public String getSubAccountSid() {
        return subAccountSid;
    }
    public void setSubAccountSid(String subAccountSid) {
        this.subAccountSid = subAccountSid;
    }
    public String getSubToken() {
        return subToken;
    }
    public void setSubToken(String subToken) {
        this.subToken = subToken;
    }
    public String getVoipAccount() {
        return voipAccount;
    }
    public void setVoipAccount(String voipAccount) {
        this.voipAccount = voipAccount;
    }
    public String getVoipPwd() {
        return voipPwd;
    }
    public void setVoipPwd(String voipPwd) {
        this.voipPwd = voipPwd;
    }
    public String getVoipToken() {
        return voipToken;
    }
    public void setVoipToken(String voipToken) {
        this.voipToken = voipToken;
    }
    public String getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo;
    }
    public ChannelServiceAccount getChannelServiceAccount() {
        return channelServiceAccount;
    }
    public void setChannelServiceAccount(ChannelServiceAccount channelServiceAccount) {
        this.channelServiceAccount = channelServiceAccount;
    }
    public boolean isPriority() {
        return priority;
    }
    public void setPriority(boolean priority) {
        this.priority = priority;
    }
    public ChannelAffiliateSubAccount(ChannelServiceAccount channelServiceAccount, String subAccountSid,
                                      String subToken, String voipAccount, String voipPwd, String voipToken, String agentNo,String ownership,boolean priority) {
        super();
        this.channelServiceAccount = channelServiceAccount;
        this.subAccountSid = subAccountSid;
        this.subToken = subToken;
        this.voipAccount = voipAccount;
        this.voipPwd = voipPwd;
        this.voipToken = voipToken;
        this.agentNo = agentNo;
        super.ownership = ownership;
        this.priority = priority;
    }
    public ChannelAffiliateSubAccount() {
        super();
    }
}
