package com.cyan.test;

import com.cyan.mapper.AccountMapper;
import com.cyan.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class AccountTest {
    private SqlSession session;

    @Before
    public void init()throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession(true);
    }

    @Test
    public void test01() throws IOException {
        AccountMapper $proxy = session.getMapper(AccountMapper.class);
        Account account = $proxy.selectAccountById(1);
        System.out.println(account.toString());
    }

    @Test
    public void test02() throws IOException {
        AccountMapper $proxy = session.getMapper(AccountMapper.class);
        $proxy.getAccountList().forEach(System.out::println);
    }

    @Test
    public void test03() throws IOException {
        AccountMapper $proxy = session.getMapper(AccountMapper.class);
        $proxy.selectAccountList().forEach(System.out::println);
    }

}
