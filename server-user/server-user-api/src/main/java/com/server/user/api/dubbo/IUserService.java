package com.server.user.api.dubbo;

import com.server.user.api.model.User;

/**
 * Created by jk on 16/11/6.
 */
public interface IUserService {

    public User getUserById(long userId);

}
