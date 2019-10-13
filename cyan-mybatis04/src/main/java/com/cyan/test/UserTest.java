package com.cyan.test;

import com.cyan.mapper.UserMapper;
import com.cyan.pojo.User;
import com.cyan.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UserTest {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        User user = userMapper.selectUserById1(1);
        System.out.println(user);
    }

    @Test
    public void test02(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean(UserService.class);
        User user = userService.selectUserById1(1);
        System.out.println(user);
    }

    @Test
    public void test03(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean(UserService.class);
        User user = userService.selectUserById2(1);
        System.out.println(user);
    }

    @Test
    public void test04(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setId(23);
        user.setName("青子");
        List<User> userList = userService.selectByUser(user);
        userList.stream().forEach(System.out::println);
    }

    @Test
    public void test05(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean(UserService.class);
        List<User> userList = userService.selectUserListByIds(Arrays.asList(1, 2, 3));
        userList.stream().forEach(System.out::println);
    }

    @Test
    public void test06(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setId(27);
        user.setName("青子");
        user.setUpdateTime(new Date());
        Integer row= userService.updateUserById(user);
        System.out.println(row);
    }

    @Test
    public void test07(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setName("青子");
        user.setId(2);
        List<User> userList= userService.selectUserByNameOrId(user);
        userList.forEach(System.out::println);
    }
}
