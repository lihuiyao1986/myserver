package com.server.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by jk on 16/11/10.
 */
@Component
public class TopicMessageListener implements MessageListener {

    static final Logger logger = LoggerFactory.getLogger(TopicMessageListener.class);

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();//请使用valueSerializer
        byte[] channel = message.getChannel();
        String itemValue = (String)redisTemplate.getValueSerializer().deserialize(body);
        String topic = (String)redisTemplate.getStringSerializer().deserialize(channel);
        logger.debug(" message = " + itemValue + " -  topic = " + topic);
    }
}
