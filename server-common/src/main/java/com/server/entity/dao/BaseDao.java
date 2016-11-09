package com.server.entity.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * BaseDao
 */
@Repository
@Transactional
public class BaseDao<T,PK extends Serializable> {

    @Autowired
    protected SessionFactory sessionFactory;

    // entityClass
    private Class<T> entityClass;

    /**
     * 构造方法
     */
    public BaseDao(){
        Class c = this.getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }


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
    public void save(T t) {
        getSession().save(t);
    }

    /**
     * 删除实体
     *
     * @param t
     */
    public void delete(T t) {
        getSession().delete(t);
    }

    /**
     * 通过主键删除实体
     *
     * @param id
     */
    public void delete(PK id) {
        getSession().delete(this.get(id));
    }


    /**
     * 获取
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public T get(PK id) {
        return (T) getSession().get(entityClass, id);
    }

    /**
     * 更新实体
     *
     * @param t
     */
    public void update(T t) {
        getSession().update(t);
    }


    /**
     * 保存或更新实体
     *
     * @param t
     */
    public void saveOrUpdate(T t) {
        getSession().saveOrUpdate(t);
    }

    /**
     * 获取全部实体
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> getAll(Class<T> tClass) {
        return getSession().createCriteria(tClass).list();
    }

    /**
     * QBC查询
     *
     * @param criteria
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> findByCriteria(Criteria criteria) {
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
    public List<T> findByHql(final String hql, final Object... params) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return query.list();
    }

    /**
     * 获取Criteria
     *
     * @return
     */
    public Criteria getCriteria() {
        return getSession().createCriteria(this.entityClass);
    }

    /**
     * 执行HQL
     * @param hql
     * @param params
     * @return
     */
    public boolean executeHql(String hql, Object... params) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return query.executeUpdate()>0 ? true : false;
    }

    /**
     * QBE查询
     *
     * @param t
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> findByExample(T t) {
        Example example = Example.create(t);
        Criteria criteria = getSession().createCriteria(this.entityClass);
        criteria.add(example);
        return criteria.list();
    }

    /**
     * 批量插入对象
     * @param objs
     */
    public void batchInsertObjects(List<T> objs) {
        Session session = getSession();
        for (int i = 0; i < objs.size(); i++) {
            Object obj = objs.get(i);
            if (obj != null)
                session.save(obj);
            if ((i + 1) % 20 == 0) {
                session.flush();
                session.clear();
            }
        }
        session.flush();
        session.clear();
    }

    /**
     * 批量更新对象
     * @param objs
     */
    public void batchUpdateObjects(List<T> objs) {
        Session session = getSession();
        for (int i = 0; i < objs.size(); i++) {
            Object obj = objs.get(i);
            session.update(obj);
            if ((i + 1) % 20 == 0) {
                session.flush();
                session.clear();
            }
        }
        session.flush();
        session.clear();
    }

    /**
     * 批量新增、更新对象
     * @param objs
     */
    public void batchInsertOrUpdateObjects(List<T> objs) {
        Session session = getSession();
        for (int i = 0; i < objs.size(); i++) {
            Object obj = objs.get(i);
            if (obj != null)
                session.saveOrUpdate(obj);
            if ((i + 1) % 20 == 0) {
                session.flush();
                session.clear();
            }
        }
        session.flush();
        session.clear();
    }

    /**
     * 批量执行hql语句
     * @param hqls
     */
    public void batchUpdateHql(List<String> hqls) {
        Session session = getSession();
        for (int i = 0; i < hqls.size(); i++) {
            String aHql = hqls.get(i);
            session.createQuery(aHql).executeUpdate();
            if ((i + 1) % 20 == 0) {
                session.flush();
                session.clear();
            }
        }
        session.flush();
        session.clear();
    }

    /**
     * 批量删除对象
     * @param objs
     */
    public void batchDeleteObjects(List<T> objs) {
        Session session = getSession();
        for (int i = 0; i < objs.size(); i++) {
            Object obj = objs.get(i);
            session.delete(obj);
            if ((i + 1) % 20 == 0) {
                session.flush();
                session.clear();
            }
        }
        session.flush();
        session.clear();
    }

    /**
     * 获得数据库时间
     * @return
     */
    public Date getSystemTime() {
        return (Date)getSession().createSQLQuery("select current_timestamp() from dual").uniqueResult();
    }
}
