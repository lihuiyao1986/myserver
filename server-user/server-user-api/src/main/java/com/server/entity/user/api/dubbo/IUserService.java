package com.server.entity.user.api.dubbo;


import com.server.entity.user.dao.UserDaoEntity;

/**
 * Created by jk on 16/11/6.
 */
public interface IUserService {

    /**
     * 根据 登录名查询用户
     * @param loginName
     * @return
     */
    public UserDaoEntity getUserByLoginName(String loginName);


}
