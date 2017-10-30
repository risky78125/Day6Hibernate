package com.lanou3g.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Author: 武奇<p/>
 * Company: lanou3g.com<p/>
 * Date: 2017/10/30
 */
public class HibernateUtil {

    // SessionFactory只能由一个
    private static final SessionFactory SF;

    static {
        Configuration cfg = new Configuration()
                .configure();
        SF = cfg.buildSessionFactory();
    }

    public static Session openSession(){
        return SF.openSession();
    }

    public static <T> T handle(ResultHandler<T> handler){
        Session sess = openSession();
        Transaction tr = sess.beginTransaction();
        // 不知道干啥
        T result = handler.handle(sess);
        tr.commit();
        sess.close();
        return result;
    }

//    public static Transaction begin(){
//        return openSession().beginTransaction();
//    }


    public interface ResultHandler<T>{
        T handle(Session sess);
    }
}
