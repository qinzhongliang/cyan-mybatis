package com.cyan.mapper;

import com.cyan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;

public interface UserMapper {
    User selectUserById(Integer id);

    Integer insertUser(String name, Date createTime, Date updateTime);

    Integer saveUser(User user);

    Integer updateUserById(Map<String, Object> map);

    Integer modifyUserById(@Param("id") Integer id, @Param("name") String name, @Param("updateTime") Date updateTime);

    //2018_user、2019_user
    //@Select("select * from ${year}_user where id = #{id}")
    //User selectUserTableByYear(String year, Integer id);
}
