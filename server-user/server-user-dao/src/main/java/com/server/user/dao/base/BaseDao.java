package com.server.user.dao.base;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * BaseDao
 */
@Repository
@Transactional
public class BaseDao {

    @Autowired
    protected SessionFactory sessionFactory;


    /**
     * 获取session
     * @return
     */
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }


    /**
     * 保存实体
     *
     * @param t
     */
    public <T> void save(T t) {
        getSession().save(t);
    }

    /**
     * 删除实体
     *
     * @param t
     */
    public <T> void delete(T t) {
        getSession().delete(t);
    }

    /**
     * 通过主键删除实体
     *
     * @param id
     */
    public <T,PK extends Serializable>void delete(Class<T> tClass,PK id) {
        getSession().delete(this.get(tClass,id));
    }


    /**
     * 获取
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public <T,PK extends Serializable> T get(Class<T> tClass,PK id) {
        return (T) getSession().get(tClass, id);
    }

    /**
     * 更新实体
     *
     * @param t
     */
    public <T> void update(T t) {
        getSession().update(t);
    }


    /**
     * 保存或更新实体
     *
     * @param t
     */
    public <T> void saveOrUpdate(T t) {
        getSession().saveOrUpdate(t);
    }

    /**
     * 获取全部实体
     *
     * @return
     */
    @Transactional(readOnly = true)
    public <T> List<T> getAll(Class<T> tClass) {
        return getSession().createCriteria(tClass).list();
    }

    /**
     * QBC查询
     *
     * @param criteria
     * @return
     */
    @Transactional(readOnly = true)
    public <T> List<T> findByCriteria(Criteria criteria) {
        return criteria.list();
    }

    /**
     * HQL查询
     *
     * @param hql
     * @param params
     * @return
     */
    @Transactional(readOnly = true)
    public <T> List<T> findByHql(final String hql, final Object... params) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return query.list();
    }
}
