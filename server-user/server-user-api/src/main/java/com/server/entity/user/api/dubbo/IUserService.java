package com.server.entity.user.api.dubbo;


import com.server.entity.exception.APIException;
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


    /**
     * 用户登录
     * @param loginName
     * @param loginPwd
     * @return
     */
    public UserDaoEntity login(String loginName,String loginPwd)throws APIException;


}
