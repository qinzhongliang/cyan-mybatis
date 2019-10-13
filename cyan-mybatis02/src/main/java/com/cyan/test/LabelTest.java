package com.cyan.test;

import com.cyan.mapper.LabelMapper1;
import com.cyan.mapper.LabelMapper2;
import com.cyan.pojo.Label;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class LabelTest {

    private SqlSessionFactory sessionFactory1;
    private SqlSession session1;

    @Before
    public void init()throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sessionFactory1 = new SqlSessionFactoryBuilder().build(inputStream);
        session1 = sessionFactory1.openSession(true);
    }

    @Test//同一session同一mapper同一方法相同的sql语句以及参数
    public void test01() throws IOException {
        LabelMapper1 $proxy = session1.getMapper(LabelMapper1.class);
        Label label1 = $proxy.selectLabelById(1);
        Label label2 = $proxy.selectLabelById(1);
        System.out.println(label1 == label2);
    }

    @Test//不同session同一mapper同一方法相同的sql语句以及参数
    public void test02() throws IOException {
        LabelMapper1 $proxy = session1.getMapper(LabelMapper1.class);
        Label label1 = $proxy.selectLabelById(1);
        SqlSession session2 = sessionFactory1.openSession(true);
        Label label2 = session2.getMapper(LabelMapper1.class).selectLabelById(1);
        System.out.println(label1 == label2);
    }

    @Test//同一session不同mapper同一方法相同的sql语句以及相同的参数
    public void test03() throws IOException {
        LabelMapper1 $proxy = session1.getMapper(LabelMapper1.class);
        Label label1 = $proxy.selectLabelById(1);
        Label label2 = session1.getMapper(LabelMapper2.class).selectLabelById(1);
        System.out.println(label1 == label2);
    }

    @Test//同一session同一mapper不同方法相同的sql语句以及相同的参数
    public void test04() throws IOException {
        LabelMapper1 $proxy = session1.getMapper(LabelMapper1.class);
        Label label1 = $proxy.selectLabelById(1);
        Label label2 = $proxy.getLabelById(1);
        System.out.println(label1 == label2);
    }

    @Test
    public void test05() throws IOException {
        LabelMapper1 $proxy = session1.getMapper(LabelMapper1.class);
        Label label1 = $proxy.selectLabelById(1);
        session1.clearCache();//清空以及缓存
        Label label2 = $proxy.selectLabelById(1);
        System.out.println(label1 == label2);
    }

    @Test
    public void test06() throws IOException {
        LabelMapper1 $proxy = session1.getMapper(LabelMapper1.class);
        Label label1 = $proxy.selectLabelById(1);
        Label label = new Label();
        label.setId(20);
        label.setName("灵棋");
        Integer row = $proxy.updateLabelById(label);
        Label label2 = $proxy.selectLabelById(1);
        System.out.println(label1 == label2);
    }
}
