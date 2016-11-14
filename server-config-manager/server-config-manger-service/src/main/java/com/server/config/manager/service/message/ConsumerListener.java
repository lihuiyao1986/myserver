package com.server.config.manager.service.message;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jk on 16/11/14.
 */
public class ConsumerListener implements Serializable {

    public Map<String,String> receiveMessage(String message){
        System.out.println("ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
        Map<String,String> map = new ConcurrentHashMap<String, String>();
        map.put("name","liyansheng");
        map.put("value","liyansheng");
        map.put("1222","liya1nsheng");
        map.put("222","liyanshen33g");
        return map;
    }

    public void receiveRespMessage(Map message){
        System.out.println("ConsumerListener通过receiveRespMessage接收到一个纯文本消息，消息内容是：" + message);
    }
}
