package com.cyan.mapper;

import com.cyan.common.Page;
import com.cyan.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    User selectUserById(Integer id);

    @Select("select * from user")
    List<User> selectUserListByPage(Page page);
}
