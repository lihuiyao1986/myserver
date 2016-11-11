package com.server.config.manger.api.rest;

import com.server.entity.configmanager.web.resp.SerPageQueryRespEntity;

/**
 * 服务api
 */
public interface IServiceAPI {

    /**
     * 分页查询服务
     * @param pageNo
     * @param pageSize
     * @param serviceId
     * @return
     */
    public SerPageQueryRespEntity querySerByPage(int pageNo,int pageSize,int serviceId);
}
