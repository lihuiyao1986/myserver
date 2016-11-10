package com.server.entity.user.web.resp;

import com.server.entity.model.BaseRespEntity;
import com.server.entity.user.dao.UserDaoEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * UserRespEntity
 */
@XmlRootElement(name = "resp")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserRespEntity extends BaseRespEntity {

    @XmlElement(name = "result")
    private UserDaoEntity result;

    public UserDaoEntity getResult() {
        return result;
    }

    public void setResult(UserDaoEntity result) {
        this.result = result;
    }
}
