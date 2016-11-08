package com.myserver.user.rest;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import com.server.entity.constants.Errorcode;
import com.server.entity.user.api.dubbo.IUserService;
import com.server.entity.user.api.rest.IUserAPI;
import com.server.entity.user.dao.UserDaoEntity;
import com.server.entity.user.web.UserRespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * UserAPIImpl
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
    @Transactional(readOnly = true)
    @Override
    public UserRespEntity getUserByLoginName(@PathParam("loginName") String loginName) {
        UserDaoEntity entity = userService.getUserByLoginName(loginName);
        UserRespEntity respEntity = new UserRespEntity();
        if (entity!=null){
            respEntity.setResult(entity);
        }else{
            respEntity.setErrormsg("用户信息不存在");
            respEntity.setErrorcode(Errorcode.FAIL_CODE);
        }
        return respEntity;
    }
}
