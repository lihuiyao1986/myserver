package com.server.config.manger.dao.hibernate;

import com.server.entity.channel.dao.ServiceStatus;
import com.server.entity.configmanager.dao.ServiceType;
import com.server.entity.dao.BaseDao;
import com.server.entity.utils.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 获取服务类型
 */
@Transactional
@Repository
public class ServiceTypeDao extends BaseDao<ServiceType,Integer> {

    /**
     * 根据渠道id查询服务类型
     * @param channelAccountId
     * @return
     */
    @Transactional(readOnly = true)
    public List<ServiceType> getSerTypeByChAcctId(String channelAccountId){
        String hql = "from ServiceType s";
        if(!StringUtils.isEmpty(channelAccountId)){
            hql += " where s.id in (select ser.servType.id from Service ser,ChannelServiceAccount acc "
                    + " where ser.sp.id = acc.sp.id and ser.status.code = '"+ ServiceStatus.ACTIVE+"'"
                    + " and acc.id = '"+channelAccountId+"') ";
        }
        hql += " order by s.code";
        return this.findByHql(hql);
    }
}
