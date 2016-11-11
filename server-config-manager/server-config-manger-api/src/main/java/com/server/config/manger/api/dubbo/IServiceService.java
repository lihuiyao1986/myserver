package com.server.config.manger.api.dubbo;

import com.server.entity.annotation.API;
import com.server.entity.configmanager.dao.Service;
import com.server.entity.configmanager.web.req.SerQueryByPageReqEntity;
import com.server.entity.dao.Page;
import com.server.entity.model.APIReqEntity;
import com.server.entity.model.APIRespEntity;


/**
 * 服务
 */
public interface IServiceService {

    @API
    public APIRespEntity<Page<Service>> queryServiceByPage(APIReqEntity<SerQueryByPageReqEntity> params);
}
