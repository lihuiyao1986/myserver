package com.server.user.dao.hibernate;

import com.server.entity.dao.BaseDao;
import com.server.entity.user.dao.UserDaoEntity;
import com.server.entity.utils.Collections3;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jk on 16/11/7.
 */
@Transactional
@Repository
public class UserDao extends BaseDao<UserDaoEntity,Long> {

    /**
     * 根据loginName查询用户信息
     * @param loginName
     * @return
     */
    @Transactional(readOnly = true)
    public UserDaoEntity getByLoginName(String loginName){
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("loginName",loginName));
        List<UserDaoEntity> list = criteria.list();
        return Collections3.isEmpty(list) ? null : list.get(0);
    }

}
