package com.jnshu.mapper;

import com.jnshu.entity.Student;

import java.util.List;

public interface StudentMapper {
    int addStudent(Student student);
    boolean updateStudent(Student student);
    Student findStudentById(int id);
    boolean deleteStudent(int id);
    List<Student> findAll();
}
