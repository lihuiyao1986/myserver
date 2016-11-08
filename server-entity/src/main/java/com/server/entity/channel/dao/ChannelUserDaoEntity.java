package com.server.entity.channel.dao;

import com.server.entity.model.BaseBizEntity;
import com.server.entity.user.dao.GenderDaoEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 平台的所有参与者
 * @author JOHN
 * 2015.01.13
 */
@Entity
@Table(name="BIZ_ChannelUser")
public class ChannelUserDaoEntity extends BaseBizEntity {
    private static final long serialVersionUID = -3788689445158785988L;

    //加密后的微信号，每个用户对每个公众号的OpenID是唯一的。对于不同公众号，同一用户的openid不同
    //摘自《微信公众平台开发者文档》
    @Column(length=50, unique=true)
    private String accountNo;
    @Column(length=50)
    private String name;
    //备注名称,坐席设置或绑定用户时自动设置，同步第三方用户信息时不需更新此字段
    @Column(length=50)
    private String remarkName;
    //联系地址
    @Column(length=100)
    private String address;
    //证件号码
    @Column(length=30)
    private String idNumber;
    //邮箱
    @Column(length=40)
    private String email;
    //电话
    @Column(length=20)
    private String telPhone;
    //备注-其他信息
    @Column(length=200)
    private String remark;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=true,fetch = FetchType.EAGER)
    @JoinColumn
    private GenderDaoEntity gender;


    @Column(length=200)
    private String headImgUrl;
    //国家
    @Column(length=20)
    private String country;
    //身份
    @Column(length=20)
    private String province;
    //城市
    @Column(length=20)
    private String city;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn
    private ChannelServiceAccount serviceAccount;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=true,fetch = FetchType.EAGER)
    @JoinColumn
    private ChannelUserGroup group;
    @Column
    private boolean canceled;
    @Column
    private Date concernTime;//关注时间
    @Column
    private Date cancelTime;//取消时间
    @Column
    private String callId;// 通话的唯一标识(云通讯)

    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ChannelUserGroup getGroup() {
        return group;
    }
    public void setGroup(ChannelUserGroup group) {
        this.group = group;
    }
    public GenderDaoEntity getGender() {
        return gender;
    }
    public void setGender(GenderDaoEntity gender) {
        this.gender = gender;
    }
    public boolean isCanceled() {
        return canceled;
    }
    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
    public Date getConcernTime() {
        return concernTime;
    }
    public void setConcernTime(Date concernTime) {
        this.concernTime = concernTime;
    }
    public Date getCancelTime() {
        return cancelTime;
    }
    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }
    public String getRemarkName() {
        return remarkName;
    }
    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }
    public String getHeadImgUrl() {
        return headImgUrl;
    }
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public ChannelServiceAccount getServiceAccount() {
        return serviceAccount;
    }
    public void setServiceAccount(ChannelServiceAccount serviceAccount) {
        this.serviceAccount = serviceAccount;
    }
    public String getAddress() {
        return address;
    }
    public String getIdNumber() {
        return idNumber;
    }
    public String getEmail() {
        return email;
    }
    public String getTelPhone() {
        return telPhone;
    }
    public String getRemark() {
        return remark;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getCallId() {
        return callId;
    }
    public void setCallId(String callId) {
        this.callId = callId;
    }
}
