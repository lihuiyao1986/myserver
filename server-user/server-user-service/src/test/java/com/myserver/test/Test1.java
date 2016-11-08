package com.myserver.test;

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



}
