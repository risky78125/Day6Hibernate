package com.lanou3g.dao.difficult.utils;

import com.lanou3g.dao.difficult.DatabaseHandler;
import com.lanou3g.dao.difficult.Operator;
import com.lanou3g.dao.difficult.ResultHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Author: 武奇<p/>
 * Company: lanou3g.com<p/>
 * Date: 2017/10/30
 */
public class DatabaseTool {
    private static final SessionFactory SF;

    static {
        Configuration cfg = new Configuration();
        cfg.configure();
        SF = cfg.buildSessionFactory();
    }

    private static Session getSession() {
        return SF.openSession();
    }


    public static <T> Operator<T> handle(DatabaseHandler<T> handler){
        Session session = getSession();
        Transaction trans = session.beginTransaction();
        T result = handler.doHandle(session);
        trans.commit();
        session.close();
        return new Operator<T>() {
            @Override
            public void operate(ResultHandler<T> handler) {
                handler.handle(result);
            }
        };
    }



}
