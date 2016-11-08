package com.myserver.user.rest;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.server.exception.APIException;
import com.server.user.api.model.User;
import com.server.user.api.rest.IGetUserAPI;
import com.server.user.dao.hibernate.UserDao;
import com.server.user.dao.mapper.UserMapper;
import com.server.user.dao.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by jk on 16/11/6.
 */
@Service(protocol = {"rest","dubbo"},validation = "true")
@Path("/user")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Transactional
public class GetUserAPIImpl implements IGetUserAPI {

    @Autowired
    private UserDao userDao;

    @GET
    @Path("/get/{userName}")
    @Override
    @Transactional(readOnly = true)
    public User getUserByID(@PathParam("userName")String userName,@QueryParam("userId")long userId) throws APIException{
        UserInfo userInfo = userDao.get(userId);
        User user = null;
        if (userInfo !=null){
            user = new User();
            user.setAge(userInfo.getAge());
            user.setName(userInfo.getName());
            user.setNickname(userInfo.getNickName());
            user.setAddressInfos(userInfo.getAddressInfos());
            return user;
        }else {
            throw new APIException("1009","用户不存在");
        }
    }

    @POST
    @Path("/register")
    @Override
    public User registerUser(User user) {
        User user1 = new User();
        user1.setAge(12);
        user1.setName("李焱生");
        user1.setNickname("smile~");
        return user1;
    }
}
