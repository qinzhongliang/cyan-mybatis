package com.cyan.mapper;

import com.cyan.pojo.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> getStudentById(Integer id);

}
