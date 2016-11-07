package com.server.user.dao;

import com.server.user.dao.base.BaseDao;
import com.server.user.dao.hibernate.IUserDao;
import com.server.user.dao.model.AddressInfo;
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
    private IUserDao userDao;

    @Autowired
    private BaseDao baseDao;


    @Test
    public void testQueryUser(){
        UserInfo user = userDao.getUser(1L);
        logger.info(user);
    }

    @Test
    public void testSaveUser(){
        UserInfo user = new UserInfo();
        user.setAge(454);
        user.setName("liewg");
        user.setNickName("ssss");
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAddressName("浙江杭州西湖三段");
        addressInfo.setCityCode("0571");
        addressInfo.setCityName("杭州市");
        user.setAddressInfo(addressInfo);
        baseDao.save(user);
    }

    @Test
    public void testSaveAddress(){
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAddressName("浙江杭州西湖三段");
        addressInfo.setCityCode("0571");
        addressInfo.setCityName("杭州市");
        baseDao.save(addressInfo);
    }
}
