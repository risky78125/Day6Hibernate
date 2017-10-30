package com.lanou3g.dao.difficult.impl;

import com.lanou3g.dao.difficult.BaseDaoDifficult;
import com.lanou3g.dao.difficult.ResultHandler;
import com.lanou3g.domain.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Author: 武奇<p/>
 * Company: lanou3g.com<p/>
 * Date: 2017/10/30
 */
public class DifficultDaoTest {

    private BaseDaoDifficult<Student> dao;

    @Before
    public void init(){
        dao = new DifficultDao<>();
    }

    @Test
    public void test(){
        Student s = new Student("Jack", "male", 28);
        // 插入数据
        dao.save(s).operate(new ResultHandler<Student>() {
            @Override
            public void handle(Student result) {
                // 插入的数据为:
                System.out.println(result);
            }
        });

        // 查询数据
        dao.findAll(Student.class).operate(new ResultHandler<List<Student>>() {
            @Override
            public void handle(List<Student> result) {
                // 查询的数据为:
                result.forEach(System.out::println);
            }
        });
    }


}