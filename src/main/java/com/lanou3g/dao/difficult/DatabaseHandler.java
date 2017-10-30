package com.lanou3g.dao.difficult;

import org.hibernate.Session;

/**
 * Author: 武奇<p/>
 * Company: lanou3g.com<p/>
 * Date: 2017/10/30
 */
public interface DatabaseHandler<T> {
    T doHandle(Session session);
}
