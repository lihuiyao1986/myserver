package com.myserver.user.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.server.entity.user.api.dubbo.IUserService;
import com.server.entity.user.dao.UserDaoEntity;
import com.server.user.dao.hibernate.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户service
 */
@Service(protocol = {"dubbo"},validation = "true")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDaoEntity getUserByLoginName(String loginName) {
        return userDao.getByLoginName(loginName);
    }
}
