package com.server.user.dao.mapper;

import com.server.user.dao.base.CrudMapper;
import com.server.user.dao.base.MyBatisMapper;
import com.server.user.dao.model.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * UserMapper
 */
@MyBatisMapper
public interface UserMapper extends CrudMapper<UserInfo>{

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    public UserInfo getUser(@Param("userId") long userId);
}
