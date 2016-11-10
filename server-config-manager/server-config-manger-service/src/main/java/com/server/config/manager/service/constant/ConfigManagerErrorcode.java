package com.server.config.manager.service.constant;

/**
 * 错误码
 */
public class ConfigManagerErrorcode {

    // 前缀
    private final static String PREFIX = "CONFIG_MANAGER_";


    /**
     * 获取code
     * @param code
     * @return
     */
    private final static String getCode(String code){
        return PREFIX + code;
    }

}
