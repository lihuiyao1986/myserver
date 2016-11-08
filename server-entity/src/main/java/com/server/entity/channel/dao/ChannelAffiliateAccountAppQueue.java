package com.server.entity.channel.dao;

import com.server.entity.model.BaseBizEntity;

import javax.persistence.*;

/**
 *
 * 渠道附属账户应用队列
 * @author ly
 *
 */
@Entity
@Table(name="BIZ_ChannelAffiliateAccountAppQueue")
public class ChannelAffiliateAccountAppQueue extends BaseBizEntity {

    /**
     *
     */
    private static final long serialVersionUID = -4961479463989814564L;

    @Column(length=50, unique=true)
    private String queueNo;//(必填)队列类型，定义为正整数，具体属性类型的含义由应用侧维护，例如：1英语技能组，2足球技能组，3法语技能组。队列类型与座席类型相一致。

    @Column(length=200)
    private String typeDes;//(必填)队列类型描述

    @Column(length=50)
    private String workTime;//(必填)队列工作时间，格式：hh:mi-hh:mi。非工作时间不接听电话，为用户播放提示音后挂机

    @Column(length=50)
    private String offWorkPrompt;//(可选)非工作时间队列提示，填写语音库中上传的语音文件名

    @Column(length=50)
    private String offWorkDate;//(可选)非工作日期，默认值为空，格式为 yyyy-mm-dd:yyyy-mm-dd，开始及结束日期以英文冒号隔开。相同时表示为一天。

    @Column(length=50)
    private String  nonWorkDatePrompt;//(可选)非工作日期的提示音

    @Column(length=50)
    private String offWorkWeekDay;//(可选)每周的非工作时间，默认值为空。若是多天以#分隔，输入值为每日英文缩写，如：Mon、Tue、Wed、Thu、Fri、Sat、Sun

    @Column(length=50)
    private String  aWeekofNonWorkTimePrompt;//(可选)每周非工作的时间的提示音

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn
    private ChannelServiceAccount serviceAccount;

    public String getTypeDes() {
        return typeDes;
    }

    public void setTypeDes(String typeDes) {
        this.typeDes = typeDes;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getOffWorkPrompt() {
        return offWorkPrompt;
    }

    public void setOffWorkPrompt(String offWorkPrompt) {
        this.offWorkPrompt = offWorkPrompt;
    }

    public String getOffWorkDate() {
        return offWorkDate;
    }

    public void setOffWorkDate(String offWorkDate) {
        this.offWorkDate = offWorkDate;
    }

    public String getOffWorkWeekDay() {
        return offWorkWeekDay;
    }

    public void setOffWorkWeekDay(String offWorkWeekDay) {
        this.offWorkWeekDay = offWorkWeekDay;
    }

    public ChannelServiceAccount getServiceAccount() {
        return serviceAccount;
    }

    public void setServiceAccount(ChannelServiceAccount serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    public String getQueueNo() {
        return queueNo;
    }

    public void setQueueNo(String queueNo) {
        this.queueNo = queueNo;
    }

    public String getNonWorkDatePrompt() {
        return nonWorkDatePrompt;
    }

    public void setNonWorkDatePrompt(String nonWorkDatePrompt) {
        this.nonWorkDatePrompt = nonWorkDatePrompt;
    }

    public String getaWeekofNonWorkTimePrompt() {
        return aWeekofNonWorkTimePrompt;
    }

    public void setaWeekofNonWorkTimePrompt(String aWeekofNonWorkTimePrompt) {
        this.aWeekofNonWorkTimePrompt = aWeekofNonWorkTimePrompt;
    }

}