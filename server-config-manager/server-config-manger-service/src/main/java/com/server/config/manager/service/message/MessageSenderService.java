package com.server.config.manager.service.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * Created by jk on 16/11/14.
 */
@Service
public class MessageSenderService {

    @Autowired
    private JmsTemplate jmsTemplate;

    //@Autowired
    //private Destination responseDestination;

    public void sendMessage( Destination destination,final String message){
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                //textMessage.setJMSReplyTo(responseDestination);
                return textMessage;
            }
        });
    }


}
