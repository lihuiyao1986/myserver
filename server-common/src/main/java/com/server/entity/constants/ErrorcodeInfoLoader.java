package com.server.entity.constants;

import com.server.entity.utils.PropertiesLoader;

import java.io.Serializable;

/**
 * 错误码加载
 */
public class ErrorcodeInfoLoader implements Serializable {

    private volatile static ErrorcodeInfoLoader singleton;

    private PropertiesLoader propertiesLoader;

    private ErrorcodeInfoLoader() {
        propertiesLoader = new PropertiesLoader("errorcode.properties");
    }

    public static ErrorcodeInfoLoader getInstance() {
        if (singleton == null) {
            synchronized (ErrorcodeInfoLoader.class) {
                if (singleton == null) {
                    singleton = new ErrorcodeInfoLoader();
                }
            }
        }
        return singleton;
    }

    /**
     * 根据code获取message
     * @param code
     * @param defaultMsg
     * @return
     */
    public String getMessage(String code,String defaultMsg){
       return propertiesLoader.getProperty(code,defaultMsg);
    }



}
