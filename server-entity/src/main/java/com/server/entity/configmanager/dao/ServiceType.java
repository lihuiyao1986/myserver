package com.server.entity.configmanager.dao;

import com.server.entity.model.BaseDicEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 服务类型：欠费查询、欠费缴纳、用户信息查询等
 * @author JOHN
 * 2015.01.13
 */
@Entity
@Table(name="DIC_ServiceType")
public class ServiceType extends BaseDicEntity {
    private static final long serialVersionUID = -100574093807837674L;

    @Column(length=100)
    private String uri;

    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }
}
