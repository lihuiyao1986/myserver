package com.server.entity.utils;

import com.dangdang.config.service.GeneralConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigProfile;

/**
 * 获取zk配置属性
 */
public class ZKConfigUtils {

    /**
     * 获取值
     * @param connectStr
     * @param rootNode
     * @param version
     * @param group
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getValue(final String connectStr, final String rootNode, final String version,final String group,String key,String defaultValue){
        ZookeeperConfigProfile configProfile = new ZookeeperConfigProfile(connectStr, rootNode, version);
        GeneralConfigGroup propertyGroup1 = new ZookeeperConfigGroup(configProfile, group);
        return StringUtils.trimNull(propertyGroup1.get(key),defaultValue);
    }
}
