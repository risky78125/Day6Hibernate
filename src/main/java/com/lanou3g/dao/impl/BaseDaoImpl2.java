package com.lanou3g.dao.impl;

import com.lanou3g.dao.BaseDao;
import com.lanou3g.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Author: 武奇<p/>
 * Company: lanou3g.com<p/>
 * Date: 2017/10/30
 */
public class BaseDaoImpl2<T> implements BaseDao<T> {
    @Override
    public T save(T bean) {
        HandlerImpl<T> h = new HandlerImpl<T>(bean);
        return HibernateUtil.handle(h);


    }

    @Override
    public T delete(T bean) {
        return HibernateUtil.handle(new HibernateUtil.ResultHandler<T>() {
            @Override
            public T handle(Session sess) {
                sess.delete(bean);
                return bean;
            }
        });
    }

    @Override
    public T update(T bean) {
        return HibernateUtil.handle(new HibernateUtil.ResultHandler<T>() {
            @Override
            public T handle(Session sess) {
                sess.update(bean);
                return bean;
            }
        });
    }

    @Override
    public List<T> findAll(Class<T> clazz) {
        return HibernateUtil.handle(new HibernateUtil.ResultHandler<List<T>>() {
            @Override
            public List<T> handle(Session sess) {
                Query<T> query = sess.createQuery("from " + clazz.getSimpleName(), clazz);
                return query.list();
            }
        });
    }

    public static class HandlerImpl<T> implements HibernateUtil.ResultHandler<T>{

        private T bean;

        public HandlerImpl(T bean) {
            this.bean = bean;
        }

        @Override
        public T handle(Session sess) {
            sess.save(bean);
            return bean;
        }
    }

}
