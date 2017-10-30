package com.lanou3g.dao.impl;

import com.lanou3g.dao.BaseDao;
import com.lanou3g.domain.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: 武奇<p/>
 * Company: lanou3g.com<p/>
 * Date: 2017/10/30
 */
public class BaseDaoImplTest {

    private BaseDao<Student> dao;

    @Before
    public void init(){
//        dao = new BaseDaoImpl<Student>();
        dao = new BaseDaoImpl2<>();
    }

    @Test
    public void test(){
        Student s1 = new Student("BC", "男", 15);
        dao.save(s1);
//        Student s2 = new Student(1, "", "", 19);
//        dao.delete(s2);
//        Student s3 = new Student(3, "QC", "女", 14);
//        dao.update(s3);

        dao.findAll(Student.class)
                .forEach(System.out::println);
    }

}