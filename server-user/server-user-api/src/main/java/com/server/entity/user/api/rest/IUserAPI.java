package com.server.entity.user.api.rest;

import com.server.entity.exception.APIException;
import com.server.entity.user.web.UserRespEntity;

/**
 * Created by jk on 16/11/6.
 */
public interface IUserAPI {

    /**
     * 根据 登录名查询用户
     * @param loginName
     * @return
     */
    public UserRespEntity getUserByLoginName(String loginName)throws APIException ;


    /**
     * 用户登录
     * @param loginName
     * @param loginPwd
     * @return
     */
    public UserRespEntity login(String loginName,String loginPwd)throws APIException;
}
