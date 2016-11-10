package com.server.config.manger.api.rest;


import com.server.entity.annotation.API;
import com.server.entity.configmanager.web.resp.UseRightRespEntity;

/**
 * IResourceAPI
 */
public interface IResourceAPI {

    /**
     * 查询用户权限
     * @param userId
     * @param ownship
     * @return
     */
    @API
    public UseRightRespEntity queryUserRights(String userId,String ownship);

}
