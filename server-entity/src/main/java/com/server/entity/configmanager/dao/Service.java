package com.server.entity.configmanager.dao;


import com.server.entity.channel.dao.ServicePoint;
import com.server.entity.channel.dao.ServiceStatus;
import com.server.entity.model.BaseBizEntity;

import javax.persistence.*;

/**
 * 一个具体的服务
 * @author JOHN
 * 2015.01.14
 */
@Entity
@Table(name="BIZ_Service")
public class Service extends BaseBizEntity {
    private static final long serialVersionUID = 364297383356473089L;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private ServicePoint sp;						//服务点id，外键关联ServicePoint

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private ServiceType servType;				//服务类型
    @Transient
    private String name;    //服务名称


    public String getName() {
        return sp.getName()+"-"+servType.getDescription();
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(length=10)
    private String localServCode;					//服务编码

    @Column(length=10)
    private String remoteServCode;					//服务编码

    @Column
    private String servBgnTime;					//服务开放开始时间,hh24mmss
    @Column
    private String servEndTime;					//服务开放截止时间，hh24mmss
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private ServiceStatus status;				//服务状态

    @Column(length=50)
    private String servConstraints;				//服务约束，拟采用drools表示，引入规则引擎驱动

//	@OneToMany(cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE},
//    		fetch=FetchType.EAGER,mappedBy="service")
//    private Set<ServicePermission> serviceLimits = new HashSet<ServicePermission>();

    public ServicePoint getSp() {
        return sp;
    }
    public void setSp(ServicePoint sp) {
        this.sp = sp;
    }
    public ServiceType getServType() {
        return servType;
    }
    public void setServType(ServiceType servType) {
        this.servType = servType;
    }
    public ServiceStatus getStatus() {
        return status;
    }
    public void setStatus(ServiceStatus status) {
        this.status = status;
    }
    public String getServConstraints() {
        return servConstraints;
    }
    public void setServConstraints(String servConstraints) {
        this.servConstraints = servConstraints;
    }

    public String getServBgnTime() {
        return servBgnTime;
    }
    public void setServBgnTime(String servBgnTime) {
        this.servBgnTime = servBgnTime;
    }
    public String getServEndTime() {
        return servEndTime;
    }
    public void setServEndTime(String servEndTime) {
        this.servEndTime = servEndTime;
    }
    //	public Set<ServicePermission> getServiceLimits() {
//		return serviceLimits;
//	}
//	public void setServiceLimits(Set<ServicePermission> serviceLimits) {
//		this.serviceLimits = serviceLimits;
//	}
    public String getLocalServCode() {
        return localServCode;
    }
    public void setLocalServCode(String localServCode) {
        this.localServCode = localServCode;
    }
    public String getRemoteServCode() {
        return remoteServCode;
    }
    public void setRemoteServCode(String remoteServCode) {
        this.remoteServCode = remoteServCode;
    }

}

