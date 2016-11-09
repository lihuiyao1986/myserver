package com.server.entity.user.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户状态
 * @author JOHN
 * 2015.01.13
 */
@Entity
@Table(name="DIC_UserStatus")
public class UserStatusDaoEntity implements Serializable {

    public static final String STANDBY = "STANDBY";			//待用（暂停）
    public static final String ACTIVE = "ACTIVE";			//正常状态
    public static final String LOCKED = "LOCKED";			//被锁定，无法登陆
    public static final String SUSPENDED = "SUSPENDED";		//暂停
    public static final String QUITED = "QUITED";		//离职
    private static final long serialVersionUID = 6895115621732748939L;

    @Id
    @Column(length=1)
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;	//id
    @Column(length=20,unique=true,nullable=false)
    private String code;//代码
    @Column(length=50)
    private String description;//描述
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
