package com.lanou3g.domain;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Author: 武奇<p/>
 * Company: lanou3g.com<p/>
 * Date: 2017/10/30
 */
public class StudentTest {

    private Session sess;
    private Transaction trans;

    @Before// 该注解标记的方法会在测试方法之前执行
    public void init(){
        System.out.println("----init----");
        // 1. 加载配置文件
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        // 2. 通过Configuration对象创建SessionFactory对象
        SessionFactory sf = cfg.buildSessionFactory();
        // 3. 打开会话
        sess = sf.openSession();
        // 4. 通过Session对象开启事务
        trans = sess.beginTransaction();

    }

    @Test// 标记某个方法为测试方法
    public void save(){
        System.out.println("----save----");
        Student zw = new Student(1, "ZW123", "男", 78);
        // 将实体类对象传入方法的参数中
        // 插入方法
        sess.save(zw);
        // 会根据id自行选择是插入还是更新
//        sess.saveOrUpdate(zw);
    }

    @Test
    public void delete(){
        System.out.println("----删除----");
        Student s = new Student(2, "ab", "a", 25);
        // 删除的时候只看id, 与其他属性无关
        sess.delete(s);

//        sess.update();
    }

    @Test
    public void query(){
        System.out.println("----查询----");
        Query<Student> query = sess.createQuery("from Student", Student.class);
        // 查询出所有的数据
        List<Student> list = query.list();
        List<Student> students = query.getResultList();
        System.out.println(list);

        students.forEach(System.out::println);

        // 查询出一条数据
//        Student stu = query.getSingleResult();
    }

    @Test
    public void status(){
        Student s = sess.get(Student.class, 1);
        // 就把数据变成了游离状态
        // 此时改变实体类对象的属性, 不会对表产生影响
        sess.evict(s);
//        sess.lock(s, LockMode.UPGRADE_NOWAIT);
        s.setName("QC123");
        s.setGender("female123");
        sess.update(s);
    }

    @After// 标记的方法会在测试方法之后执行
    public void destroy(){
        System.out.println("----destroy----");
        // 提交事务
        trans.commit();
        // 关闭会话
        sess.close();
    }
}