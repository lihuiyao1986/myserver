package com.server.entity.user.dao;

import com.server.user.dao.hibernate.LoginLogDao;
import com.server.user.dao.hibernate.UserDao;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/user-database.xml")
public class AppTest {

    private Logger logger = Logger.getLogger(AppTest.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    @Test
    public void testQueryUserByLoginName(){
        UserDaoEntity userDaoEntity = userDao.getByLoginName("eslink");
        System.out.println(" user = " + userDaoEntity);
    }

    @Test
    public void testQuerySystemTime(){
        Date date = userDao.getSystemTime();
        System.out.println(" systemTime = " + date);
    }

    @Test
    public void testLogLogin(){
        LoginLog loginLog = new LoginLog();
        UserDaoEntity userDaoEntity = userDao.getByLoginName("eslink");
        loginLog.setOwnership(userDaoEntity.getOwnership());
        loginLog.setUser(userDaoEntity);
        loginLogDao.save(loginLog);
    }

}
