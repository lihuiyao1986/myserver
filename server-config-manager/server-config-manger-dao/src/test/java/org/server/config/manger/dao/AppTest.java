package org.server.config.manger.dao;

import com.server.config.manger.dao.hibernate.ResourceDao;
import com.server.entity.configmanager.dao.Resources;
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

    @Test
    public void testGetResourcesByCode(){
        List<Resources> list = resourceDao.getResourcesByCode("%", 4);
        logger.debug(list.toString());
    }

}
