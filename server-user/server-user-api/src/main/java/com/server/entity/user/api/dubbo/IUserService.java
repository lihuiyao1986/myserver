package com.server.entity.user.api.dubbo;


import com.server.entity.annotation.API;
import com.server.entity.exception.APIException;
import com.server.entity.model.APIReqEntity;
import com.server.entity.model.APIRespEntity;
import com.server.entity.user.dao.UserDaoEntity;
import com.server.entity.user.web.req.LoginReqEntity;

/**
 * 用户服务
 */
public interface IUserService {

    /**
     * 根据 登录名查询用户
     * @param loginName
     * @return
     */
    @API
    public APIRespEntity<UserDaoEntity> getUserByLoginName(APIReqEntity<String> loginName)throws APIException;


    /**
     * 用户登录
     * @return
     */
    @API
    public APIRespEntity<UserDaoEntity> login(APIReqEntity<LoginReqEntity> reqEntity)throws APIException;


}
