package com.server.user.dao;

import com.server.user.dao.hibernate.AddressDao;
import com.server.user.dao.hibernate.UserDao;
import com.server.user.dao.model.AddressInfo;
import com.server.user.dao.model.UserInfo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

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
    private AddressDao addressDao;

    @Test
    public void testQueryUser(){
        UserInfo user = userDao.get(1L);
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
        addressInfo.setUserInfo(user);

        AddressInfo addressInfo1 = new AddressInfo();
        addressInfo1.setAddressName("江西省九江市东风大道");
        addressInfo1.setCityCode("0792");
        addressInfo1.setCityName("九江市");
        addressInfo1.setUserInfo(user);

        List<AddressInfo> addrs = new ArrayList<AddressInfo>();
        addrs.add(addressInfo);
        addrs.add(addressInfo1);
        user.setAddressInfos(addrs);
        userDao.save(user);
    }

    @Test
    public void testSaveAddress(){
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAddressName("浙江杭州西湖三段");
        addressInfo.setCityCode("0571");
        addressInfo.setCityName("杭州市");
        addressDao.save(addressInfo);
    }
}
