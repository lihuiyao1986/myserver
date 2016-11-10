package com.server.config.manager.service.normal;


import com.server.entity.configmanager.web.resp.UserRight;

import java.util.List;

/**
 * 权限相关
 */
public interface IResourceNormalService {

    /**
     * 查询用户的权限
     * @param code
     * @param length
     * @param userId
     * @param eslinkAdmin
     * @return
     */
    public List<UserRight> queryUserRights(String code,int length,Long userId,boolean eslinkAdmin);
}
