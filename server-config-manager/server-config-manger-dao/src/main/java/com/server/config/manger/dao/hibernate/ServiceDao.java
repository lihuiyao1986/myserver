package com.server.config.manger.dao.hibernate;

import com.server.entity.channel.dao.ServicePoint;
import com.server.entity.configmanager.dao.Service;
import com.server.entity.dao.BaseDao;
import com.server.entity.dao.Page;
import com.server.entity.utils.Collections3;
import com.server.entity.utils.ObjectUtils;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ServiceDao
 */
@Transactional
@Repository
public class ServiceDao extends BaseDao<Service,Integer> {

    @Autowired
    private ServicePointDao servicePointDao;

    /**
     * queryByPage
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Transactional(readOnly = true)
    public Page<Service> queryServiceByPage(int pageNo,int pageSize,Integer serviceId){
        String hql = "from Service where 1 = 1 ";
        if (!ObjectUtils.isEmpty(serviceId) && serviceId > 0){
            hql += " and id = ? ";
        }
        hql += " order by sp.owner asc, servType.code desc ";
        Query query = null;
        if (!ObjectUtils.isEmpty(serviceId) && serviceId > 0){
            query = createHqlQuery(hql,serviceId);
        }else{
            query = createHqlQuery(hql);
        }
        return new Page<Service>(pageNo,pageSize,query);
    }

    /**
     * 根据spID和服务类型ID查询服务
     * @param spid
     * @param serTypId
     * @return
     */
    @Transactional(readOnly = true)
    public Service getSerBySerTypeAndSPId(int serTypId,int spid){
        String hql = "from Service s where s.servType.id =? and s.sp.id = ? ";
        List<Service> list = findByHql(hql,serTypId,spid);
        return Collections3.isEmpty(list) ? null : list.get(0);
    }


    /**
     * 根据ID查询服务
     * @param serId
     * @return
     */
    public Service getSerById(int serId){
       return this.get(serId);
    }

    /**
     * 保存service
     * @param service
     * @return
     */
    public Service saveService(Service service){
        ServicePoint servicePoint = servicePointDao.get(service.getSp().getId());
        if (ObjectUtils.isEmpty(servicePoint)){
            return null;
        }
        service.setOwnership(servicePoint.getOwnership());
        service.setCreateDate(getSystemTime());
        service.setLastUpdateDate(getSystemTime());
        save(service);
        return service;
    }

    /**
     * 更新
     * @param service
     */
    public void update(Service service){
        Service serviceNew = copyProperties(Service.class,service,service.getId());
        update(serviceNew);
    }





}
