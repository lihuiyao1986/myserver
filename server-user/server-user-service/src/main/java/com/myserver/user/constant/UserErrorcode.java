package com.myserver.user.constant;

/**
 * 错误码
 */
public class UserErrorcode {

    // 前缀
    private final static String PREFIX = "USER_";

    // 密码或账户为空
    public static final String PWD_OR_ACCT_NULL = getCode("0000001") ;

    // 用户不存在
    public static final String USER_NOT_EXIST = getCode("0000002");

    // 密码或账户错误
    public static final String PWD_OR_ACCT_ERROR = getCode("0000003");

    // 登录状态异常
    public static final String LOGIN_STATUS_ABNORMAL =  getCode("0000004");


    /**
     * 获取code
     * @param code
     * @return
     */
    private final static String getCode(String code){
        return PREFIX + code;
    }

}
