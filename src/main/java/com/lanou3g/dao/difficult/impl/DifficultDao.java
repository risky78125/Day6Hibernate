package com.lanou3g.dao.difficult.impl;

import com.lanou3g.dao.difficult.BaseDaoDifficult;
import com.lanou3g.dao.difficult.DatabaseHandler;
import com.lanou3g.dao.difficult.Operator;
import com.lanou3g.dao.difficult.utils.DatabaseTool;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Author: 武奇<p/>
 * Company: lanou3g.com<p/>
 * Date: 2017/10/30
 */
public class DifficultDao<T> implements BaseDaoDifficult<T> {
    @Override
    public Operator<T> save(T bean) {
        return DatabaseTool.handle(new DatabaseHandler<T>() {
            @Override
            public T doHandle(Session session) {
                session.save(bean);
                return bean;
            }
        });
    }

    @Override
    public Operator<List<T>> findAll(Class<T> clazz) {
        return DatabaseTool.handle(new DatabaseHandler<List<T>>() {
            @Override
            public List<T> doHandle(Session session) {
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery<T> query = builder.createQuery(clazz);
                Root<T> from = query.from(clazz);
                query.select(from);
                return session.createQuery(query).list();
            }
        });
    }
}
