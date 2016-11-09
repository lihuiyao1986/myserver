package com.server.entity.user.api.dubbo;


import com.server.entity.exception.APIException;
import com.server.entity.model.APIReqEntity;
import com.server.entity.model.APIRespEntity;
import com.server.entity.user.api.entity.req.LoginReqEntity;
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
    public APIRespEntity<UserDaoEntity> getUserByLoginName(APIReqEntity<String> loginName)throws APIException;


    /**
     * 用户登录
     * @return
     */
    public APIRespEntity<UserDaoEntity> login(APIReqEntity<LoginReqEntity> reqEntity)throws APIException;


}
