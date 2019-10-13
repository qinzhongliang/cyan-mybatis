package com.cyan.mapper;

import com.cyan.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by cyan
 * Date:2019/9/29 0:07
 */
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    User selectUserById1(Integer id);

    User selectUserById2(Integer id);

    List<User> selectByUser(User user);

    List<User> selectUserListByIds(@Param("ids") List<Integer> ids);

    Integer updateUserById(User user);

    List<User> selectUserByNameOrId(User user);
}
