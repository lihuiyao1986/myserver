package com.server.entity.user.dao;

import com.server.entity.model.BaseDicEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户状态
 * @author JOHN
 * 2015.01.13
 */
@Entity
@Table(name="DIC_UserStatus")
public class UserStatusDaoEntity extends BaseDicEntity {

    public static final String STANDBY = "STANDBY";			//待用（暂停）
    public static final String ACTIVE = "ACTIVE";			//正常状态
    public static final String LOCKED = "LOCKED";			//被锁定，无法登陆
    public static final String SUSPENDED = "SUSPENDED";		//暂停
    public static final String QUITED = "QUITED";		//离职

}
