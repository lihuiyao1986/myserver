package com.server.entity.user.dao;

import com.server.entity.channel.dao.ChannelAffiliateAccountAppQueue;
import com.server.entity.channel.dao.ChannelAffiliateSubAccount;
import com.server.entity.channel.dao.ChannelUserDaoEntity;
import com.server.entity.channel.dao.OrgDaoEntity;
import com.server.entity.model.BaseBizEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jk on 16/11/8.
 */
@Entity
@Table(name="SYS_User")
public class UserDaoEntity extends BaseBizEntity{

    @Column(length=20,nullable=false)
    private String name;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private GenderDaoEntity gender;

    @Column
    private Date birthday;

    @Column(length=20)
    private String jobTitle;

    @Column(length=20)
    private String jobNumber;//工号

    @Column(length=20)
    private String workPhone;

    @Column(length=15)
    private String mobilePhone;

    @Column(length=30)
    private String csremail;

    @Column
    private boolean seatOrno;

    @Column
    private boolean doOutsideOrno;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private UserStatusDaoEntity status;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private OrgDaoEntity orgnization;

    @Column(length=50,unique=true,nullable=true)
    private String loginName;

    @Column(length=20)
    private String loginPwd;

    @Column(columnDefinition="int default 0")
    private int loginRetryTimes;

    @Column
    private Date lastloginRetryDate;

    @Column
    private Date accountLockedTime;

    @Column
    private boolean loginOrNot;//是否可登陆

    @Column(length = 20) // 系统内部编码
    private String systemCode;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=true,fetch = FetchType.EAGER)
    @JoinColumn(nullable=true)
    private ChannelAffiliateSubAccount affiliateSubAccount;// 附属子账户(云通讯)

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=true,fetch = FetchType.EAGER)
    @JoinColumn(nullable=true)
    private ChannelAffiliateAccountAppQueue affiliateAccountAppQueue; // 附属账户应用队列
    /**
     * 微信用户
     */
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=true,fetch = FetchType.EAGER)
    @JoinColumn(nullable=true,unique=true)
    private ChannelUserDaoEntity channelUser;

    @Transient
    //服务状态  ready 就绪  leave 离开
    private String serviceStatus;

    public static final String  serviceStatus_READY = "ready";
    public static final String  serviceStatus_LEAVE = "leave";

    @Transient
    //通话服务状态
    private String callStatus;

    @Transient
    //自动接入数量，default 0
    private int autoAccpetCount = 0;
    public boolean isLoginOrNot() {
        return loginOrNot;
    }
    public void setLoginOrNot(boolean loginOrNot) {
        this.loginOrNot = loginOrNot;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public GenderDaoEntity getGender() {
        return gender;
    }
    public void setGender(GenderDaoEntity gender) {
        this.gender = gender;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getWorkPhone() {
        return workPhone;
    }
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getCsremail() {
        return csremail;
    }
    public void setCsremail(String csremail) {
        this.csremail = csremail;
    }
    public UserStatusDaoEntity getStatus() {
        return status;
    }
    public void setStatus(UserStatusDaoEntity status) {
        this.status = status;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getLoginPwd() {
        return loginPwd;
    }
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
    public int getLoginRetryTimes() {
        return loginRetryTimes;
    }
    public void setLoginRetryTimes(int loginRetryTimes) {
        this.loginRetryTimes = loginRetryTimes;
    }
    public Date getAccountLockedTime() {
        return accountLockedTime;
    }
    public void setAccountLockedTime(Date accountLockedTime) {
        this.accountLockedTime = accountLockedTime;
    }

    public boolean isDoOutsideOrno() {
        return doOutsideOrno;
    }
    public void setDoOutsideOrno(boolean doOutsideOrno) {
        this.doOutsideOrno = doOutsideOrno;
    }
    public String getServiceStatus() {
        return serviceStatus;
    }
    public boolean isSeatOrno() {
        return seatOrno;
    }
    public void setSeatOrno(boolean seatOrno) {
        this.seatOrno = seatOrno;
    }
    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
    public int getAutoAccpetCount() {
        return autoAccpetCount;
    }
    public void setAutoAccpetCount(int autoAccpetCount) {
        this.autoAccpetCount = autoAccpetCount;
    }
    public ChannelUserDaoEntity getChannelUser() {
        return channelUser;
    }
    public void setChannelUser(ChannelUserDaoEntity channelUser) {
        this.channelUser = channelUser;
    }
    public Date getLastloginRetryDate() {
        return lastloginRetryDate;
    }
    public void setLastloginRetryDate(Date lastloginRetryDate) {
        this.lastloginRetryDate = lastloginRetryDate;
    }
    public String getSystemCode() {
        return systemCode;
    }
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
    public String getCallStatus() {
        return callStatus;
    }
    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }
    public ChannelAffiliateSubAccount getAffiliateSubAccount() {
        return affiliateSubAccount;
    }
    public void setAffiliateSubAccount(ChannelAffiliateSubAccount affiliateSubAccount) {
        this.affiliateSubAccount = affiliateSubAccount;
    }
    public OrgDaoEntity getOrgnization() {
        return orgnization;
    }
    public void setOrgnization(OrgDaoEntity orgnization) {
        this.orgnization = orgnization;
    }
    public ChannelAffiliateAccountAppQueue getAffiliateAccountAppQueue() {
        return affiliateAccountAppQueue;
    }
    public void setAffiliateAccountAppQueue(ChannelAffiliateAccountAppQueue affiliateAccountAppQueue) {
        this.affiliateAccountAppQueue = affiliateAccountAppQueue;
    }
    public String getJobNumber() {
        return jobNumber;
    }
    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }
}
