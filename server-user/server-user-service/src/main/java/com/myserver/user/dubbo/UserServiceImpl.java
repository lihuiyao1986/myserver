package com.myserver.user.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.server.entity.constants.Errorcode;
import com.server.entity.exception.APIException;
import com.server.entity.user.api.dubbo.IUserService;
import com.server.entity.user.dao.UserDaoEntity;
import com.server.entity.user.dao.UserStatusDaoEntity;
import com.server.entity.utils.ObjectUtils;
import com.server.entity.utils.StringUtils;
import com.server.user.dao.hibernate.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 用户service
 */
@Service(protocol = {"dubbo"},validation = "true")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDaoEntity getUserByLoginName(String loginName) {
        return userDao.getByLoginName(loginName);
    }

    @Override
    public UserDaoEntity login(String loginName, String loginPwd)throws APIException{

        if (StringUtils.trimNull(loginName).isEmpty() || StringUtils.trimNull(loginPwd).isEmpty()){
            throw new APIException(Errorcode.FAIL_CODE,"登录账号或密码为空");
        }

        UserDaoEntity user = userDao.getByLoginName(loginName);

        // 用户不存在
        if (ObjectUtils.isEmpty(user)){
            throw new APIException(Errorcode.FAIL_CODE,"用户不存在");
        }

        //用户因登录密码不对，限制锁定。
        //如果当前时间大于锁定时间，且大于锁定超时时间，则解锁
        long accountLockedInterval = 100000;
        Date now = new Date();
        if(user.getLastloginRetryDate() != null && now.getTime() - user.getLastloginRetryDate().getTime() >= accountLockedInterval * 1000){
            //解锁用户
            //userService.unlockUser(user);
        }

        // 密码错误
        if (!checkPwd(loginPwd,user.getLoginPwd())){
            throw new APIException(Errorcode.FAIL_CODE,"用户账户或密码错误");
        }

        // 校验账户状态，是否可以登录
        if (!checkLoginable(user)){
            throw new APIException(Errorcode.FAIL_CODE,"登录账户状态不正确或该账户不允许登录，请联系管理员。");
        }
        return user;
    }

    /**
     * 校验用户是否可以登录
     * @param user
     * @return
     */
    private boolean checkLoginable(UserDaoEntity user){
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
    private boolean checkPwd(String newPwd,String orignalPwd){
        return newPwd.equals(orignalPwd);
    }
}
