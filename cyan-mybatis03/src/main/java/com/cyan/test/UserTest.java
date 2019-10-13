package com.cyan.test;

import com.cyan.common.Page;
import com.cyan.mapper.UserMapper;
import com.cyan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {

    private SqlSessionFactory sessionFactory;
    private SqlSession session;

    @Before
    public void init()throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sessionFactory.openSession(true);
    }

    @Test
    public void test01(){
        UserMapper $proxy = session.getMapper(UserMapper.class);
        User user = $proxy.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void test02(){
        UserMapper $proxy = session.getMapper(UserMapper.class);
        List<User> userList = $proxy.selectUserListByPage(new Page(5,2));
        userList.stream().forEach(System.out::println);
    }

}
