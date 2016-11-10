package com.server.config.manager.service.facade.rest;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.server.config.manger.api.dubbo.IResourceService;
import com.server.config.manger.api.rest.IResourceAPI;
import com.server.entity.configmanager.web.req.UserRightGetReqEntity;
import com.server.entity.configmanager.web.resp.UseRightRespEntity;
import com.server.entity.configmanager.web.resp.UserRight;
import com.server.entity.model.APIReqEntity;
import com.server.entity.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 资源API
 */
@Service(protocol = {"dubbo","rest"},validation = "true")
@Path("/config")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Transactional
public class ResourceAPIImpl implements IResourceAPI {

    @Autowired
    private IResourceService resourceService;

    /**
     *
     * @param userId
     * @param ownship
     * @return
     */
    @Path("/user/right/get/{userId}/{ownship}")
    @Override
    @GET
    @Transactional(readOnly = true)
    public UseRightRespEntity queryUserRights(@PathParam("userId") String userId, @PathParam("ownship")String ownship) {
        userId = StringUtils.trimNull(userId,"0");
        APIReqEntity<UserRightGetReqEntity> reqParam = new APIReqEntity<UserRightGetReqEntity>(new UserRightGetReqEntity(Long.parseLong(userId),ownship) );
        List<UserRight> userRightList = resourceService.queryUserRights(reqParam).getRespResult();
        UseRightRespEntity respEntity = new UseRightRespEntity();
        respEntity.setResults(userRightList);
        return respEntity;
    }
}
