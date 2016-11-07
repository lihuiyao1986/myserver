package com.myserver.user.dubbo;

import com.server.user.api.dubbo.IUserService;
import com.server.user.api.model.User;

/**
 * Created by jk on 16/11/6.
 */
public class UserServiceImpl implements IUserService {

    @Override
    public User getUserById(long userId) {
        User user = new User();
        user.setAge(12);
        user.setName("李焱生");
        user.setNickname("smile~");
        return user;
    }
}
