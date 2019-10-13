package com.cyan.test;

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
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class UserTest {

    private SqlSession session;

    @Before
    public void init()throws IOException{
        String resource = "mybatis-config.xml";
        //Reader reader = Resources.getResourceAsReader(resource);
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sqlSessionFactory.openSession(true);
    }

    @Test
    public void test01() throws IOException {
        User result = session.selectOne("com.cyan.mapper.UserMapper.selectUserById", 1);
        System.out.println(result.toString());
    }

    @Test
    public void test02() throws IOException {
        UserMapper $proxy = session.getMapper(UserMapper.class);
        User user = $proxy.selectUserById(2);
        System.out.println(user.toString());
    }

    @Test
    public void test03() throws IOException {
        UserMapper $proxy = session.getMapper(UserMapper.class);
        Integer row = $proxy.insertUser("灵棋",new Date(),new Date());
        System.out.println(row);
    }

    @Test
    public void test04() throws IOException {
        UserMapper $proxy = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("糖糖");
        Date now = new Date();
        user.setCreateTime(now);
        user.setUpdateTime(now.getTime());
        Integer row = $proxy.saveUser(user);
        System.out.println(user);
        System.out.println(row);
    }

    @Test
    public void test05() throws IOException {
        UserMapper $proxy = session.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("id",23);
        map.put("name","青子");
        map.put("createTime",new Date());
        map.put("updateTime",new Date());
        Integer row = $proxy.updateUserById(map);
        System.out.println(row);
    }

    @Test
    public void test06() throws IOException {
        UserMapper $proxy = session.getMapper(UserMapper.class);
        Integer row = $proxy.modifyUserById(24,"灵棋",new Date());
        System.out.println(row);
    }

}
