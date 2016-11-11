package com.server.entity.configmanager.web.resp;

import com.server.entity.configmanager.dao.Service;
import com.server.entity.dao.Page;
import com.server.entity.model.BaseRespEntity;

/**
 * Created by jk on 16/11/11.
 */
public class SerPageQueryRespEntity extends BaseRespEntity {

    private Page<Service> results;

    public Page<Service> getResults() {
        return results;
    }

    public void setResults(Page<Service> results) {
        this.results = results;
    }

    public SerPageQueryRespEntity(Page<Service> results) {
        this.results = results;
    }

    public SerPageQueryRespEntity() {
    }
}
