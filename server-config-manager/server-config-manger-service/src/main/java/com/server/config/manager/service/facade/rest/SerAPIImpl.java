package com.server.config.manager.service.facade.rest;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.server.config.manger.api.dubbo.IServiceService;
import com.server.config.manger.api.rest.IServiceAPI;
import com.server.entity.configmanager.web.req.SerQueryByPageReqEntity;
import com.server.entity.configmanager.web.resp.SerPageQueryRespEntity;
import com.server.entity.dao.Page;
import com.server.entity.model.APIReqEntity;
import com.server.entity.model.APIRespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 服务api
 */
@Path("/service")
@Service(protocol = {"dubbo","rest"},validation = "true")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Transactional
public class SerAPIImpl implements IServiceAPI {

    @Autowired
    private IServiceService serviceService;

    /**
     *
     * @param pageNo
     * @param pageSize
     * @param serviceId
     * @return
     */
    @Path("/query/{pageNo}/{pageSize}")
    @GET
    @Transactional(readOnly = true)
    @Override
    public SerPageQueryRespEntity querySerByPage(@PathParam("pageNo")int pageNo,@PathParam("pageSize") int pageSize, @QueryParam("serviceId")int serviceId) {
        SerQueryByPageReqEntity reqParam = new SerQueryByPageReqEntity();
        reqParam.setServiceId(serviceId);
        reqParam.setPageNo(pageNo);
        reqParam.setPageSize(pageSize);
        APIRespEntity<Page<com.server.entity.configmanager.dao.Service>> respEntity = serviceService.queryServiceByPage(new APIReqEntity<SerQueryByPageReqEntity>(reqParam));
        SerPageQueryRespEntity resp = new SerPageQueryRespEntity(respEntity.getRespResult());
        resp.setErrorcode(respEntity.getCode());
        resp.setErrormsg(respEntity.getMessage());
        if (respEntity.isSucc()){
            resp.setResults(resp.getResults());
        }
        return resp;
    }
}
