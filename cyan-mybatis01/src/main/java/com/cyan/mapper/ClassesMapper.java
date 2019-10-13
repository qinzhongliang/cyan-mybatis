package com.cyan.mapper;

import com.cyan.pojo.Classes;

public interface ClassesMapper {

    Classes getClassesById(Integer id);

    Classes findClassesById(Integer id);
}
