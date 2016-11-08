package com.myserver.user.model;

import com.server.model.BaseRespEntity;
import com.server.user.api.model.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jk on 16/11/8.
 */
@XmlRootElement(name = "resp")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserRespEntity extends BaseRespEntity {

    @XmlElement(name = "result")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
