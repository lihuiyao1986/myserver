package com.server.user.api.rest;

import com.server.exception.APIException;
import com.server.user.api.model.User;

/**
 * Created by jk on 16/11/6.
 */
public interface IGetUserAPI {

    public User getUserByID(String userName, long userId)throws APIException;

    public User registerUser(User user);

}
