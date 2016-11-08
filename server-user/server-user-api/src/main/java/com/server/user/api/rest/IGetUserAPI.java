package com.server.user.api.rest;

import com.server.exception.APIException;
import com.server.model.BaseRespEntity;
import com.server.user.api.model.User;

/**
 * Created by jk on 16/11/6.
 */
public interface IGetUserAPI {

    public BaseRespEntity getUserByID(String userName, long userId)throws APIException;

    public BaseRespEntity registerUser(User user);

}
