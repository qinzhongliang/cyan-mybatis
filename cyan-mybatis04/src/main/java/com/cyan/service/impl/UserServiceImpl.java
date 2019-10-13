package com.cyan.service.impl;

import com.cyan.mapper.UserMapper;
import com.cyan.pojo.User;
import com.cyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cyan
 * Date:2019/9/29 0:12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserById1(Integer id) {
        userMapper.selectUserById1(id);
        return userMapper.selectUserById1(id);
    }

    @Override
    @Transactional
    public User selectUserById2(Integer id) {
        userMapper.selectUserById2(id);
        return userMapper.selectUserById2(id);
    }

    @Override
    public List<User> selectByUser(User user) {
        return userMapper.selectByUser(user);
    }

    @Override
    public List<User> selectUserListByIds(List<Integer> ids) {
        return userMapper.selectUserListByIds(ids);
    }

    @Override
    public Integer updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public List<User> selectUserByNameOrId(User user){
        return userMapper.selectUserByNameOrId(user);
    }
}
