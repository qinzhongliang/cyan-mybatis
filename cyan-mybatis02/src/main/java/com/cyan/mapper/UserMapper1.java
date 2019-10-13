package com.cyan.mapper;

import com.cyan.pojo.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@CacheNamespace
public interface UserMapper1 {

    @Select("select * from t_user where id = #{id}")
    User selectUserById(Integer id);

    @Select("select * from t_user where id = #{id}")
    User getUserById(Integer id);

    @Update("update t_user set name = #{name},update_time = #{updateTime} where id = #{id}")
    Integer updateUserById(User user);

    Integer modifyUserById(User user);
}
