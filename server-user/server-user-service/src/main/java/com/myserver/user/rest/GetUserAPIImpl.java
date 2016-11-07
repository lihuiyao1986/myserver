package com.myserver.user.rest;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.server.exception.APIException;
import com.server.user.api.model.User;
import com.server.user.api.rest.IGetUserAPI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by jk on 16/11/6.
 */
@Path("/user")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class GetUserAPIImpl implements IGetUserAPI {


    @GET
    @Path("/get/{userName}")
    @Override
    public User getUserByID(@PathParam("userName")String userName,@QueryParam("userId")long userId) throws APIException{
        User user = new User();
        user.setAge(12);
        user.setName("李焱生");
        user.setNickname("smile~");
        throw new APIException("1808","系统出错啦");
        //return user;
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
