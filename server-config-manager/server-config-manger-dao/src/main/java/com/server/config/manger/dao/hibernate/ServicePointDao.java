package com.server.config.manger.dao.hibernate;

import com.server.entity.channel.dao.ServicePoint;
import com.server.entity.dao.BaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * ServicePointDao
 */
@Transactional
@Repository
public class ServicePointDao extends BaseDao<ServicePoint,Integer> {
}
