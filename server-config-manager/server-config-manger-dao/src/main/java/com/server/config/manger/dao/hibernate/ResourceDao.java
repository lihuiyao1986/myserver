package com.server.config.manger.dao.hibernate;

import com.server.entity.configmanager.dao.Resources;
import com.server.entity.dao.BaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 权限DAO
 */
@Repository
@Transactional
public class ResourceDao extends BaseDao<Resources,Integer> {

    /**
     * 根据code获取资源
     * @param code
     * @param length
     * @return
     */
    public List<Resources> getResourcesByCode(String code,Integer length){

        String hql = "from Resources s where  s.code like ? ";

        if(length != null && length > 0){
            hql += " and length(s.code) = " + length;
        }

        hql += " order by s.group,s.sort";

        return this.findByHql(hql,code);
    }

    /**
     * 根据userId,代码和长度查询用户权限信息
     * @param userId
     * @param code
     * @param length
     * @return
     */
    public List<Resources> getResources(Long userId,String code,int length) {
        String hql = "select r from Resources r where length(r.code) = ? and r.code in ("
                + " select distinct substring(p.resource.code,1,?) "
                + " from UserRole ur,Permission p where ur.role = p.role "
                + " and ur.user.id = ? and p.resource.code like ?) "
                + " order by r.group,r.sort ";
        return this.findByHql(hql,length,length,userId,code);
    }
}
