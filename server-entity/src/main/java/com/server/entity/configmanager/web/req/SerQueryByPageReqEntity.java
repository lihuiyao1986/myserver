package com.server.entity.configmanager.web.req;

import com.server.entity.base.dao.BasePageModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 分页查询服务
 */
@XmlRootElement(name = "resp")
@XmlAccessorType(XmlAccessType.FIELD)
public class SerQueryByPageReqEntity extends BasePageModel {

    // serviceId
    private int serviceId;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
