package com.myserver.user.service.normal;

import com.server.entity.user.api.entity.req.LoginReqEntity;
import com.server.entity.user.dao.UserDaoEntity;

/**
 * 不对外暴露的服务
 */
public interface IUserNormalService {

    /**
     * 校验用户是否可以登录
     * @param user
     * @return
     */
    public boolean checkLoginable(UserDaoEntity user);

    /**
     * 校验密码
     * @param newPwd
     * @param orignalPwd
     * @return
     */
    public boolean checkPwd(String newPwd,String orignalPwd);


    /**
     * 解锁用户
     * @param user
     * @return
     */
    public UserDaoEntity unlockUser(UserDaoEntity user);

    /**
     * 锁住用户
     * @param user
     * @return
     */
    public UserDaoEntity lockUser(UserDaoEntity user);


    /**
     * 记录登录日志
     * @param loginParam
     * @param asyn
     */
    public void logLogin(LoginReqEntity loginParam,boolean asyn,UserDaoEntity user);

}
