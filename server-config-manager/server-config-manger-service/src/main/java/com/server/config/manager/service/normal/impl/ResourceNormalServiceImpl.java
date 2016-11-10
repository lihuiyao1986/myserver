package com.server.config.manager.service.normal.impl;

import com.server.config.manager.service.normal.IResourceNormalService;
import com.server.config.manger.dao.hibernate.ResourceDao;
import com.server.entity.configmanager.dao.Resources;
import com.server.entity.configmanager.web.resp.UserRight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限相关
 */
@Service
public class ResourceNormalServiceImpl implements IResourceNormalService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<UserRight> queryUserRights(String code, int length, Long userId, boolean eslinkAdmin) {
        code = code == null ? "%" : code + "%";
        List<Resources> resList;
        if(eslinkAdmin){
            resList = resourceDao.getResourcesByCode(code,length);
        }else{
            resList = resourceDao.getResources(userId,code,length);
        }
        List<UserRight> treeList = new ArrayList<UserRight>();
        for(Resources res : resList){
            UserRight right = new UserRight();
            right.setCode(res.getCode());
            right.setRightName(res.getName());
            right.setUrl(res.getUri());
            right.setChildren(this.queryUserRights(res.getCode(), length + 2, userId, eslinkAdmin));
            treeList.add(right);
        }
        return treeList;
    }
}
