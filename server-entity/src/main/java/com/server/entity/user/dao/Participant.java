package com.server.entity.user.dao;

import com.server.entity.channel.dao.ServiceStatus;
import com.server.entity.model.BaseBizEntity;

import javax.persistence.*;

/**
 * 平台的所有参与者
 * @author JOHN
 * 2015.01.13
 */
@Entity
@Table(name="BIZ_Participant")
public class Participant extends BaseBizEntity {
    private static final long serialVersionUID = -3666191939222717193L;

    @Column(length=50,unique=true)
    private String tId;             //租户ID
    @Column(length=50)
    private String code;			//组织机构代码
    @Column(length=20)
    private String acctOrgNo;		//清算单位，与机构打款账号对应，判断用户打款号正确性的标志。
    @Column(length=50)
    private String name; 			//组织机构名
    @Column(length=100)
    private String description; 			//组织机构简介
    @Column(length=10)
    private String contact;			//组织联系人
    @Column(length=20)
    private String officePhone;		//办公室电话
    @Column(length=11)
    private String mobilePhone;		//移动电话

    @Column(length=20)
    private String bankName;		//开户行
    @Column(length=20)
    private String bankAcount;		//开航账号
    @Column(length=10)
    private String bankAccountName;	//开户名

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private ServiceStatus status;	//参与者状态：有效、无效



    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getAcctOrgNo() {
        return acctOrgNo;
    }
    public void setAcctOrgNo(String acctOrgNo) {
        this.acctOrgNo = acctOrgNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getOfficePhone() {
        return officePhone;
    }
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankAcount() {
        return bankAcount;
    }
    public void setBankAcount(String bankAcount) {
        this.bankAcount = bankAcount;
    }
    public String getBankAccountName() {
        return bankAccountName;
    }
    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }
    public ServiceStatus getStatus() {
        return status;
    }
    public void setStatus(ServiceStatus status) {
        this.status = status;
    }
    public String gettId() {
        return tId;
    }
    public void settId(String tId) {
        this.tId = tId;
    }

}