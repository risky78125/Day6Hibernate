package com.lanou3g.dao.impl;

import com.lanou3g.dao.BaseDao;
import com.lanou3g.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Author: 武奇<p/>
 * Company: lanou3g.com<p/>
 * Date: 2017/10/30
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    @Override
    public T save(T bean) {
        Session sess = HibernateUtil.openSession();
        Transaction tr = sess.beginTransaction();
//        sess.save(bean);
        sess.saveOrUpdate(bean);
        tr.commit();
        sess.close();
        return bean;
    }

    @Override
    public T delete(T bean) {
        Session sess = HibernateUtil.openSession();
        Transaction tr = sess.beginTransaction();
        sess.delete(bean);
        tr.commit();
        sess.close();
        return bean;
    }

    @Override
    public T update(T bean) {
        Session sess = HibernateUtil.openSession();
        Transaction tr = sess.beginTransaction();
        sess.update(bean);
        tr.commit();
        sess.close();
        return bean;
    }

    @Override
    public List<T> findAll(Class<T> clazz) {
        Session sess = HibernateUtil.openSession();
        Transaction tr = sess.beginTransaction();
        Query<T> query;
        try {
            query = sess.createQuery("from " + clazz.getSimpleName(), clazz);
            tr.commit();
            return query.list();
        } finally {
            sess.close();
        }
    }
}
