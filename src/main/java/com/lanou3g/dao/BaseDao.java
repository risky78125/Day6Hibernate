package com.lanou3g.dao;

import java.util.List;

/**
 * Author: 武奇<p/>
 * Company: lanou3g.com<p/>
 * Date: 2017/10/30
 */
public interface BaseDao<T> {

    T save(T bean);
    T delete(T bean);
    T update(T bean);
    List<T> findAll(Class<T> clazz);

}
