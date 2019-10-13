package com.cyan.test;

import com.cyan.mapper.UserMapper1;
import com.cyan.mapper.UserMapper2;
import com.cyan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class UserTest {

    private SqlSessionFactory sessionFactory1;
    private SqlSession session1;

    @Before
    public void init()throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sessionFactory1 = new SqlSessionFactoryBuilder().build(inputStream);
        session1 = sessionFactory1.openSession(true);
    }

    @Test//不同session同一mapper同一方法相同的sql语句以及参数,pojo必须序列化
    public void test01() throws IOException {
        UserMapper1 $proxy = session1.getMapper(UserMapper1.class);
        User user1 = $proxy.selectUserById(1);
        session1.close();//会话关闭之后才放入二级缓存中
        SqlSession session2 = sessionFactory1.openSession(true);
        User user2 = session2.getMapper(UserMapper1.class).selectUserById(1);
        System.out.println(user1 == user2);//false深拷贝
    }

    @Test//不同session不同mapper同一方法相同的sql语句以及参数,pojo必须序列化
    public void test02() throws IOException {
        UserMapper1 $proxy = session1.getMapper(UserMapper1.class);
        User user1 = $proxy.selectUserById(1);
        session1.close();
        SqlSession session2 = sessionFactory1.openSession(true);
        User user2 = session2.getMapper(UserMapper2.class).selectUserById(1);
        System.out.println(user1 == user2);
    }

    @Test//不同session同一mapper不同方法相同的sql语句以及参数,pojo必须序列化
    public void test03() throws IOException {
        UserMapper1 $proxy = session1.getMapper(UserMapper1.class);
        User user1 = $proxy.selectUserById(1);
        session1.close();
        SqlSession session2 = sessionFactory1.openSession(true);
        User user2 = session2.getMapper(UserMapper1.class).getUserById(1);
        System.out.println(user1 == user2);
    }

    @Test
    public void test04() throws IOException {
        UserMapper1 $proxy = session1.getMapper(UserMapper1.class);
        User user1 = $proxy.selectUserById(1);
        session1.close();

        User user = new User();
        user.setId(2);
        user.setName("灵棋");
        user.setUpdateTime(new Date());
        SqlSession session2 = sessionFactory1.openSession(true);
        session2.getMapper(UserMapper1.class).updateUserById(user);
        session2.close();

        SqlSession session3 = sessionFactory1.openSession(true);
        User user2 = session3.getMapper(UserMapper1.class).selectUserById(1);
        System.out.println(user1 == user2);
    }

    @Test
    public void test05() throws IOException {
        UserMapper1 $proxy = session1.getMapper(UserMapper1.class);
        User user1 = $proxy.selectUserById(1);
        session1.close();

        User user = new User();
        user.setId(2);
        user.setName("灵棋");
        user.setUpdateTime(new Date());
        SqlSession session2 = sessionFactory1.openSession(true);
        session2.getMapper(UserMapper1.class).modifyUserById(user);
        session2.close();

        SqlSession session3 = sessionFactory1.openSession(true);
        User user2 = session3.getMapper(UserMapper1.class).selectUserById(1);
        System.out.println(user1 == user2);
    }
}
