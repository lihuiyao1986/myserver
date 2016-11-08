package com.server.entity.channel.dao;

import com.server.entity.model.BaseDicEntity;
import com.server.entity.utils.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 服务状态：开通、暂停、无效
 * @author JOHN
 * 2015.01.13
 */
@Entity
@Table(name="DIC_ServiceStatus")
public class ServiceStatus extends BaseDicEntity {
    private static final long serialVersionUID = -1989745318221092760L;
    public final static String ACTIVE = "ACTIVE";		//服务室活跃的
    public final static String RUNNING = "RUNNING";		//服务正在运行中...
    public final static String INACTIVE = "INACTIVE";	//服务不活跃，或者说是失效的

    public static ServiceStatus getServiceStatus(String code){
        ServiceStatus serviceStatus = new ServiceStatus();
        if (ACTIVE.equals(StringUtils.trimNull(code))){
            serviceStatus.setId(1);
            serviceStatus.setCode(ACTIVE);
        }else if (RUNNING.equals(StringUtils.trimNull(code))){
            serviceStatus.setId(2);
            serviceStatus.setCode(RUNNING);
        }else if(INACTIVE.equals(StringUtils.trimNull(code))){
            serviceStatus.setId(3);
            serviceStatus.setCode(INACTIVE);
        }
        return serviceStatus;
    }
}
