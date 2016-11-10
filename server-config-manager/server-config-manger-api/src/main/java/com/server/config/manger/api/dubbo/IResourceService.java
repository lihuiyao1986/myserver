package com.server.config.manger.api.dubbo;


import com.server.entity.annotation.API;
import com.server.entity.configmanager.web.req.UserRightGetReqEntity;
import com.server.entity.configmanager.web.resp.UserRight;
import com.server.entity.model.APIReqEntity;
import com.server.entity.model.APIRespEntity;

import java.util.List;

/**
 * 用户服务
 */
public interface IResourceService {


    /**
     * 查询用户的权限信息
     * @param params
     * @return
     */
    @API
    public APIRespEntity<List<UserRight>> queryUserRights(APIReqEntity<UserRightGetReqEntity> params);

}
