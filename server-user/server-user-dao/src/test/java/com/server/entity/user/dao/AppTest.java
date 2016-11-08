package com.server.entity.user.dao;

import com.server.user.dao.hibernate.UserDao;
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
    private UserDao userDao;

    @Test
    public void testQueryUserByLoginName(){
        UserDaoEntity userDaoEntity = userDao.getByLoginName("eslink");
        System.out.println(" user = " + userDaoEntity);
    }

}
