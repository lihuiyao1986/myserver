package com.server.user.dao;

import com.server.user.dao.mapper.UserMapper;
import com.server.user.dao.model.UserInfo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/user-database.xml")
public class AppTest {

    private Logger logger = Logger.getLogger(AppTest.class);

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testInsert(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(13);
        userInfo.setName("李焱生");
        userInfo.setNickName("smile");
        int count = userMapper.insert(userInfo);
        System.out.print(" count = " + count);
    }

    @Test
    public void testQueryUser(){
        UserInfo user = userMapper.getUser(1L);
        logger.info(user);
    }
}
