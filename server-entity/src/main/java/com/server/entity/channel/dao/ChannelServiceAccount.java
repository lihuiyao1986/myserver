package com.server.entity.channel.dao;

import com.server.entity.model.BaseBizEntity;
import com.server.entity.user.dao.Participant;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="BIZ_ChannelServiceAccount")
public class ChannelServiceAccount extends BaseBizEntity {
    private static final long serialVersionUID = -2694464112107091709L;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn
    private Participant accountOwner;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn
    private ServicePoint sp;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn
    private Participant channelProvider;
    @Column(length=20,nullable = false)
    private String name;//服务号名称

    @Column(length=50, unique=true)
    private String accountNo;
    @Column(length=50, unique=true)
    private String appId;//如果为邮箱 此为邮箱账号
    @Column(length=50)
    private String secret;//如果为邮箱 此为邮箱密码
    @Column(length=50)
    private String token;//如果为邮箱 此为收件服务器
    @Column(length=50)
    private String aesKey;//1.如果为邮箱 此为发件服务器  2.如果为云通讯 此为VoIP接入号
    @Column(length=50)
    private String accessCode;//云通讯接入号
    //根据规则生成出的访问令牌(1.如果为云通讯 此为接入号)
    @Column(length=100, unique=true ,nullable = true)
    private String accessToken;
    //根据规则生成出的访问令牌  新令牌生成出的之前令牌
    @Column(length=100, unique=true ,nullable = true)
    private String accessTokenOld;

    //令牌有效截止日期 yyyy-MM-dd hh24:mi:ss
    private Date expiresTime;
    //旧令牌有效截止日期 yyyy-MM-dd hh24:mi:ss
    private Date expiresTimeOld;

    //渠道回调地址
    @Column(length=100)
    private String callBackUrl;
    //微信类型区分 授权还是商户号
    @Column(length=50)
    private String wxType;
    //刷新令牌
    @Column(length=200)
    private String refreshToken;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Participant getAccountOwner() {
        return accountOwner;
    }
    public void setAccountOwner(Participant accountOwner) {
        this.accountOwner = accountOwner;
    }
    public Participant getChannelProvider() {
        return channelProvider;
    }
    public void setChannelProvider(Participant channelProvider) {
        this.channelProvider = channelProvider;
    }
    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    public String getAppId() {
        return appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }
    public String getSecret() {
        return secret;
    }
    public void setSecret(String secret) {
        this.secret = secret;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getAesKey() {
        return aesKey;
    }
    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }
    public ServicePoint getSp() {
        return sp;
    }
    public void setSp(ServicePoint sp) {
        this.sp = sp;
    }

    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getAccessTokenOld() {
        return accessTokenOld;
    }
    public void setAccessTokenOld(String accessTokenOld) {
        this.accessTokenOld = accessTokenOld;
    }
    public Date getExpiresTime() {
        return expiresTime;
    }
    public void setExpiresTime(Date expiresTime) {
        this.expiresTime = expiresTime;
    }
    public Date getExpiresTimeOld() {
        return expiresTimeOld;
    }
    public void setExpiresTimeOld(Date expiresTimeOld) {
        this.expiresTimeOld = expiresTimeOld;
    }
    public String getAccessCode() {
        return accessCode;
    }
    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }
    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }
    public String getWxType() {
        return wxType;
    }
    public void setWxType(String wxType) {
        this.wxType = wxType;
    }
    public String getRefreshToken() {
        return refreshToken;
    }
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}