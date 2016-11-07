package com.server.utils;

/**
 * Created by jk on 16/11/7.
 */
public class StringUtils {

    /**
     * trimNull
     * @param str
     * @param defaultStr
     * @return
     */
    public static String trimNull(String str,String defaultStr){
        if (isEmpty(str)){
            return defaultStr;
        }else{
            return str.trim();
        }
    }


    /**
     * 是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || str.trim().isEmpty();
    }
}
