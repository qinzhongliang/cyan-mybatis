package com.cyan.test;

import com.cyan.mapper.ClassesMapper;
import com.cyan.pojo.Classes;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ClassesTest {

    private SqlSessionFactory sessionFactory;
    private SqlSession session;

    @Before
    public void init()throws IOException {
        String resource = "mybatis-config.xml";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sessionFactory.openSession(true);
    }

    @Test
    public void getClassesById()throws IOException {
        ClassesMapper classesMapper = session.getMapper(ClassesMapper.class);
        Classes classes = classesMapper.getClassesById(1);
        System.out.println(classes);
    }

    @Test
    public void findClassesById()throws IOException {
        ClassesMapper classesMapper = session.getMapper(ClassesMapper.class);
        Classes classes = classesMapper.findClassesById(2);
        System.out.println(classes);
    }

}
