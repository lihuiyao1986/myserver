package com.server.user.dao.hibernate;

import com.server.entity.dao.BaseDao;
import com.server.entity.user.dao.LoginLog;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 登录日志
 */
@Transactional
@Repository
public class LoginLogDao extends BaseDao<LoginLog,Long> {

}
