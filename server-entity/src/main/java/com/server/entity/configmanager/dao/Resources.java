package com.server.entity.configmanager.dao;

import com.server.entity.model.BaseBizEntity;

import javax.persistence.*;

/**
 * 资源
 * @author JOHN
 * 20150212
 */
@Entity
@Table(name="SYS_Resource")
public class Resources extends BaseBizEntity {
    private static final long serialVersionUID = -7784401866490437381L;

    @Column(length=20)
    private String name;	//名称
    @Column(length=20,nullable=false,unique=true)
    private String code;	//编号

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private ResourceType type;//类型

    @Column(length=50, nullable=false, unique=true)
    private String uri;
    @Column(length=50)
    private String iconCls;

    @Column(columnDefinition="int default 0")
    private int group;
    @Column(columnDefinition="int default 0")
    private int sort;

    @Column
    private boolean navigable;

    @Column
    private boolean valid;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public ResourceType getType() {
        return type;
    }
    public void setType(ResourceType type) {
        this.type = type;
    }
    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }
    public int getGroup() {
        return group;
    }
    public void setGroup(int group) {
        this.group = group;
    }
    public int getSort() {
        return sort;
    }
    public void setSort(int sort) {
        this.sort = sort;
    }
    public boolean isNavigable() {
        return navigable;
    }
    public void setNavigable(boolean navigable) {
        this.navigable = navigable;
    }
    public boolean isValid() {
        return valid;
    }
    public void setValid(boolean valid) {
        this.valid = valid;
    }
    public String getIconCls() {
        return iconCls;
    }
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
}
