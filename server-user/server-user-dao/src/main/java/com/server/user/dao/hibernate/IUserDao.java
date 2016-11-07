package com.server.user.dao.hibernate;

import com.server.user.dao.model.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 用户dao
 */
public interface IUserDao {

    public UserInfo getUser(@Param("userId") long userId);

}
