package com.cyan.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Classes implements Serializable {

    private static final long serialVersionUID = -4349649620776973480L;

    private Integer id;
    private String name;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();

    public Classes(){}

    public Classes(Integer id, String name, Teacher teacher, List<Student> students) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}
