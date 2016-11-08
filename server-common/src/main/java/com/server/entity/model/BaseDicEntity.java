package com.server.entity.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by jk on 16/11/8.
 */
@MappedSuperclass
public class BaseDicEntity extends BaseDaoEntity {
    private static final long serialVersionUID = 1836626495567726657L;
    @Column(length=20,unique=true,nullable=false)
    protected String code;//代码
    @Column(length=50)
    protected String description;//描述
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
