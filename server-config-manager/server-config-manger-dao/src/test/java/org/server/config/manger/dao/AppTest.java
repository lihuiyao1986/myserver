package org.server.config.manger.dao;

import com.server.config.manger.dao.hibernate.ResourceDao;
import com.server.config.manger.dao.hibernate.ServiceDao;
import com.server.config.manger.dao.hibernate.ServiceTypeDao;
import com.server.entity.configmanager.dao.Resources;
import com.server.entity.configmanager.dao.Service;
import com.server.entity.configmanager.dao.ServiceType;
import com.server.entity.dao.Page;
import com.server.entity.utils.ObjectUtils;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/config-manager-database.xml")
public class AppTest extends TestCase {

    private Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private ServiceDao serviceDao;

    @Autowired
    private ServiceTypeDao serviceTypeDao;

    @Test
    public void testGetResourcesByCode(){
        List<Resources> list = resourceDao.getResourcesByCode("%", 4);
        logger.debug(list.toString());
    }

    @Test
    public void testQueryServiceByPage(){
        Page<Service> list = serviceDao.queryServiceByPage(1,10,null);
        logger.debug(list.toString());
    }

    @Test
    public void testQueryServiceTypeByChannelAcctId(){
        List<ServiceType> list = serviceTypeDao.getSerTypeByChAcctId("12");
        logger.debug(list.toString());
    }

    @Test
    public void testQueryServiceBySerTypeAndSPID(){
        Service service = serviceDao.getSerBySerTypeAndSPId(63, 4);
        logger.debug(ObjectUtils.isEmpty(service) ? "null" : service.toString());
    }

}
