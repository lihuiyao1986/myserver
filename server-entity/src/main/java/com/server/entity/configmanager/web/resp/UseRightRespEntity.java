package com.server.entity.configmanager.web.resp;

import com.server.entity.model.BaseRespEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by jk on 16/11/10.
 */
@XmlRootElement(name = "resp")
@XmlAccessorType(XmlAccessType.FIELD)
public class UseRightRespEntity extends BaseRespEntity {

    private List<UserRight> results;

    public List<UserRight> getResults() {
        return results;
    }

    public void setResults(List<UserRight> results) {
        this.results = results;
    }
}
