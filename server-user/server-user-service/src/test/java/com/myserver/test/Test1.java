package com.myserver.test;

import com.server.user.api.model.User;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jk on 16/11/6.
 */
public class Test1 {

    Logger logger = Logger.getLogger(Test1.class.getName());

    private Client client;

    @Before
    public void setup(){
        client = ClientBuilder.newClient();
    }

    /**
     *
     */
    @Test
    public void testRegister(){
        User user = new User();
        user.setNickname("liyannn");
        User respUser = client.target("http://127.0.0.1:8888/services/user/register.json")
                .request().post(Entity.entity(user,MediaType.APPLICATION_JSON_TYPE),User.class);
        logger.log(Level.ALL,respUser.toString());
    }


}
