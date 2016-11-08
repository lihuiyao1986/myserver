package com.server.user.dao.hibernate;

import com.server.user.dao.base.BaseDao;
import com.server.user.dao.model.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jk on 16/11/7.
 */
@Transactional
@Repository
public class UserDao extends BaseDao<UserInfo,Long> {
}