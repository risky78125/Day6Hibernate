package com.lanou3g.dao.difficult;

/**
 * Author: 武奇<p/>
 * Company: lanou3g.com<p/>
 * Date: 2017/10/30
 */
public interface Operator<T> {
    void operate(ResultHandler<T> handler);
}
