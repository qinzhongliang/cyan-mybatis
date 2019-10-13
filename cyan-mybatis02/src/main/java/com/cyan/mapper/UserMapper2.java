package com.cyan.mapper;

import com.cyan.pojo.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

@CacheNamespace
public interface UserMapper2 {

    @Select("select * from t_user where id = #{id}")
    User selectUserById(Integer id);

}
