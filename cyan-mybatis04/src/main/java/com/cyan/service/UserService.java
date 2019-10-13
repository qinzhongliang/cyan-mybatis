package com.cyan.service;

import com.cyan.pojo.User;

import java.util.List;

/**
 * Created by cyan
 * Date:2019/9/29 0:12
 */
public interface UserService {

    User selectUserById1(Integer id);

    User selectUserById2(Integer id);

    List<User> selectByUser(User user);

    List<User> selectUserListByIds(List<Integer> ids);

    Integer updateUserById(User user);

    List<User> selectUserByNameOrId(User user);
}
