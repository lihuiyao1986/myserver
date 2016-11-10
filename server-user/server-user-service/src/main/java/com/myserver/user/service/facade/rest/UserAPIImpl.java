package com.myserver.user.service.facade.rest;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import com.server.entity.constants.GlobalErrorcode;
import com.server.entity.exception.APIException;
import com.server.entity.model.APIReqEntity;
import com.server.entity.model.APIRespEntity;
import com.server.entity.user.api.dubbo.IUserService;
import com.server.entity.user.api.entity.req.LoginReqEntity;
import com.server.entity.user.api.rest.IUserAPI;
import com.server.entity.user.dao.UserDaoEntity;
import com.server.entity.user.web.UserRespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * UserAPIImpl-以rest风格对外暴露的服务
 */
@Service(protocol = {"rest","dubbo"},validation = "true")
@Path("/user")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Transactional
public class UserAPIImpl implements IUserAPI {

    @Autowired
    private IUserService userService;

    @GET
    @Path("/getByLoginName/{loginName}")
    @Override
    public UserRespEntity getUserByLoginName(@PathParam("loginName") String loginName) throws APIException {
        APIRespEntity<UserDaoEntity> entity = userService.getUserByLoginName(new APIReqEntity<String>(loginName));
        UserRespEntity respEntity = new UserRespEntity();
        if (entity.isSucc()){
            respEntity.setResult(entity.getRespResult());
        }else{
            respEntity.setErrormsg(entity.getMessage());
            respEntity.setErrorcode(entity.getCode());
        }
        return respEntity;
    }

    @GET
    @Path("/login/{loginName}/{loginPwd}")
    @Override
    public UserRespEntity login(@PathParam("loginName")String loginName, @PathParam("loginPwd")String loginPwd) throws APIException {
        LoginReqEntity reqParam = new LoginReqEntity();
        reqParam.setLoginName(loginName);
        reqParam.setLoginPwd(loginPwd);
        APIRespEntity<UserDaoEntity> entity = userService.login(new APIReqEntity<LoginReqEntity>(reqParam));
        UserRespEntity respEntity = new UserRespEntity();
        if (entity.isSucc()){
            respEntity.setResult(entity.getRespResult());
        }else{
            respEntity.setErrormsg(entity.getCode());
            respEntity.setErrorcode(entity.getMessage());
        }
        return respEntity;
    }
}
