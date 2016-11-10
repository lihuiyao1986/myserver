package com.myserver.user.service.normal.impl;

import com.myserver.user.service.normal.IUserNormalService;
import com.server.entity.user.dao.LoginLog;
import com.server.entity.user.dao.UserDaoEntity;
import com.server.entity.user.dao.UserStatusDaoEntity;
import com.server.entity.user.web.req.LoginReqEntity;
import com.server.entity.utils.StringUtils;
import com.server.user.dao.hibernate.LoginLogDao;
import com.server.user.dao.hibernate.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 不对外暴露的服务
 */
@Service
public class UserNormalServiceImpl implements IUserNormalService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    // 登录失败最大重试次数
    @Value("${login.maxLoginRetryTimes}")
    private int maxLoginRetryTimes;

    // 登录失败导致账户锁定的时间间隔
    @Value("${login.accountLockedInterval}")
    private int accountLockedInterval;

    /**
     * 校验用户是否可以登录
     * @param user
     * @return
     */
    public boolean checkLoginable(UserDaoEntity user){
        String userstate = StringUtils.trimNull(user.getStatus().getCode());
        if (!UserStatusDaoEntity.ACTIVE.equals(userstate) || !user.isLoginOrNot()) {
            return false;
        }else{
            return true;
        }
    }

    /**
     * 校验密码
     * @param newPwd
     * @param orignalPwd
     * @return
     */
    public boolean checkPwd(String newPwd,String orignalPwd){
        return newPwd.equals(orignalPwd);
    }

    /**
     * 解锁用户
     * @param user
     * @return
     */
    @Override
    public UserDaoEntity unlockUser(UserDaoEntity user) {
        user.setAccountLockedTime(null);
        user.setLoginRetryTimes(0);
        user.setLastloginRetryDate(null);
        userDao.update(user);
        return user;
    }

    /**
     * 锁住用户
     * @param user
     * @return
     */
    @Override
    public UserDaoEntity lockUser(UserDaoEntity user) {
        Date now = userDao.getSystemTime();
        //判断上次密码不符和本次是否为同一天
        if(user.getLastloginRetryDate() != null && now.getTime() - user.getLastloginRetryDate().getTime() < accountLockedInterval * 1000){
            //如果为同一天，则累加重试次数
            user.setLoginRetryTimes(user.getLoginRetryTimes() + 1);
            user.setLastloginRetryDate(now);
        }else{
            //不为同一天，则从1开始
            user.setLoginRetryTimes(1);
            user.setLastloginRetryDate(now);
        }
        if(user.getLoginRetryTimes() >= maxLoginRetryTimes) {
            user.setAccountLockedTime(now);
        }
        user.setLastUpdateDate(now);
        userDao.update(user);
        return user;
    }

    /**
     * 记录登录日志
     * @param loginParam
     * @param asyn
     */
    @Override
    public void logLogin(LoginReqEntity loginParam, boolean asyn,UserDaoEntity user) {
        final LoginLog loginLog = new LoginLog();
        loginLog.setLocalIP(StringUtils.trimNull(loginParam.getLocalIP()));
        loginLog.setRemoteIP(StringUtils.trimNull(loginParam.getRemoteIP()));
        loginLog.setOwnership(user.getOwnership());
        loginLog.setSessionID(StringUtils.trimNull(loginParam.getSessionId()));
        loginLog.setUser(user);
        if (asyn){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    loginLogDao.save(loginLog);
                }
            }).start();
        }else{
            loginLogDao.save(loginLog);
        }
    }
}
