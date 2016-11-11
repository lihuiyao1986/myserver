package com.server.config.manager.service.facade.dubbo;

import com.server.config.manger.api.dubbo.IServiceService;
import com.server.config.manger.dao.hibernate.ServiceDao;
import com.server.entity.configmanager.dao.Service;
import com.server.entity.configmanager.web.req.SerQueryByPageReqEntity;
import com.server.entity.dao.Page;
import com.server.entity.model.APIReqEntity;
import com.server.entity.model.APIRespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * 查询服务
 */
@com.alibaba.dubbo.config.annotation.Service(protocol = {"dubbo"},validation = "true")
@Transactional
public class SerServiceImpl implements IServiceService {

    @Autowired
    private ServiceDao serviceDao;

    @Transactional(readOnly = true)
    @Override
    public APIRespEntity<Page<Service>> queryServiceByPage(APIReqEntity<SerQueryByPageReqEntity> params) {
        Page<Service> pageList = serviceDao.queryServiceByPage(params.getReqParam().getPageNo(),params.getReqParam().getPageSize(),params.getReqParam().getServiceId());
        return new APIRespEntity<Page<Service>>(pageList);
    }
}
