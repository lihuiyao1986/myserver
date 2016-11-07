package com.server.user.dao.hibernate.impl;

import com.server.user.dao.base.BaseDao;
import com.server.user.dao.hibernate.IUserDao;
import com.server.user.dao.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jk on 16/11/7.
 */
@Repository
@Transactional
public class UserDaoImpl implements IUserDao{

    @Autowired
    private BaseDao baseDao;

    @Transactional(readOnly = true)
    public UserInfo getUser(@Param("userId") long userId) {
        return baseDao.get(UserInfo.class,userId);
    }
}
