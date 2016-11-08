package com.server.entity.channel.dao;

import com.server.entity.model.BaseBizEntity;

import javax.persistence.*;

/**
 * 组织
 * @author JOHN
 * 20150212
 */
@Entity
@Table(name="SYS_Orgnization")
public class OrgDaoEntity extends BaseBizEntity {

    @Column(length=20,nullable=false)
    private String name;	//组织名称
    @Column(length=20)
    private String no;		//组织编号（内部编号,租户自行填写）

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private OrgTypeDaoEntity type;	//组织类型

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=true,fetch = FetchType.EAGER)
    @JoinColumn(nullable=true)
    private OrgDaoEntity parentOrg;   //从属部门

    @Column(length=50)
    private String address;	//地址
    @Column(length=50)
    private String addressCoordinate;	//地址坐标

    @Column(length=20)
    private String leader;	//负责人
    @Column(length=25)
    private String phone;	//电话

    @Column(length=100)
    private String remark;	//备注

    @Column(length=20) //系统内部编码(第三方系统编码)
    private String systemCode;

    @Column(length=20,nullable=false)
    private String dataPermission;//数据权限控制

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public OrgDaoEntity getParentOrg() {
        return parentOrg;
    }
    public void setParentOrg(OrgDaoEntity parentOrg) {
        this.parentOrg = parentOrg;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddressCoordinate() {
        return addressCoordinate;
    }
    public void setAddressCoordinate(String addressCoordinate) {
        this.addressCoordinate = addressCoordinate;
    }
    public String getLeader() {
        return leader;
    }
    public void setLeader(String leader) {
        this.leader = leader;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public OrgTypeDaoEntity getType() {
        return type;
    }
    public void setType(OrgTypeDaoEntity type) {
        this.type = type;
    }
    public String getSystemCode() {
        return systemCode;
    }
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
    public String getDataPermission() {
        return dataPermission;
    }
    public void setDataPermission(String dataPermission) {
        this.dataPermission = dataPermission;
    }


}
