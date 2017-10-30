package com.lanou3g.dao.difficult;

import java.util.List;

/**
 * Author: 武奇<p/>
 * Company: lanou3g.com<p/>
 * Date: 2017/10/30
 */
public interface BaseDaoDifficult<T> {

    Operator<T> save(T bean);

    Operator<List<T>> findAll(Class<T> clazz);

}
