package com.jnshu.service;

import com.jnshu.entity.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student) throws Exception;
    boolean updateStudent(int id,Student student) throws Exception;
    Student findStudentById(int id) throws Exception;
    boolean deleteStudent(int id) throws Exception;
    List<Student> findAll() throws Exception;
}
