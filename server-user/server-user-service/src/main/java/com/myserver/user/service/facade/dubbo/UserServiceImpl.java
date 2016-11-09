package com.myserver.user.service.facade.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.myserver.user.constant.UserErrorcode;
import com.server.entity.exception.APIException;
import com.server.entity.model.APIReqEntity;
import com.server.entity.model.APIRespEntity;
import com.server.entity.user.api.dubbo.IUserService;
import com.server.entity.user.api.entity.req.LoginReqEntity;
import com.server.entity.user.dao.UserDaoEntity;
import com.server.entity.user.dao.UserStatusDaoEntity;
import com.server.entity.utils.ObjectUtils;
import com.server.entity.utils.StringUtils;
import com.server.user.dao.hibernate.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 用户service-以duubo协议对外暴露的服务
 */
@Service(protocol = {"dubbo"},validation = "true")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;


    @Transactional(readOnly = true)
    @Override
    public APIRespEntity<UserDaoEntity> getUserByLoginName(APIReqEntity<String> params) throws APIException{
        UserDaoEntity userDaoEntity = userDao.getByLoginName(StringUtils.trimNull(params.getReqParam()));
        if (userDaoEntity == null){
            throw new APIException(UserErrorcode.USER_NOT_EXIST,"用户不存在");
        }
        return new APIRespEntity<UserDaoEntity>(userDaoEntity);
    }

    @Override
    public APIRespEntity<UserDaoEntity> login(APIReqEntity<LoginReqEntity> reqEntity)throws APIException{

        String loginName = StringUtils.trimNull(reqEntity.getReqParam().getLoginName());
        String loginPwd = StringUtils.trimNull(reqEntity.getReqParam().getLoginPwd());

        if (loginName.isEmpty() || loginPwd.isEmpty()){
            throw new APIException(UserErrorcode.PWD_OR_ACCT_NULL,"登录账号或密码为空");
        }

        UserDaoEntity user = userDao.getByLoginName(loginName);

        // 用户不存在
        if (ObjectUtils.isEmpty(user)){
            throw new APIException(UserErrorcode.USER_NOT_EXIST,"用户不存在");
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
            return new APIRespEntity(UserErrorcode.PWD_OR_ACCT_ERROR,"用户账户或密码错误");
        }

        // 校验账户状态，是否可以登录
        if (!checkLoginable(user)){
            throw new APIException(UserErrorcode.LOGIN_STATUS_ABNORMAL,"登录账户状态不正确或该账户不允许登录，请联系管理员。");
        }

        return new APIRespEntity<UserDaoEntity>(user);
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
