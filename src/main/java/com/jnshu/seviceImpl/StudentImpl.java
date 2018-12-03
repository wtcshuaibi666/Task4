package com.jnshu.seviceImpl;

import com.jnshu.entity.Student;
import com.jnshu.mapper.StudentMapper;
import com.jnshu.service.StudentService;
import com.jnshu.tool.MemcachedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public int addStudent(Student student)throws Exception {
//     插入成功后的值存入student的id中
    studentMapper.addStudent(student);
    MemcachedUtils.add("student"+student.getId(),student);
//    返回student的id值
    return student.getId();
    }

    @Override
    public boolean updateStudent(int id,Student student)throws Exception {
        student.setId(id);
        MemcachedUtils.replace("student"+id,student);
        return studentMapper.updateStudent(student);
    }

    @Override
    public Student findStudentById(int id) throws Exception{
//   查找缓存
        Object object = MemcachedUtils.get("student"+id);
//        当存在缓存时，返回缓存数据
    if (object!=null){
        return (Student) object;
    }
    Student student = studentMapper.findStudentById(id);
//    缓存为空 添加缓存
    MemcachedUtils.set("student"+id,student);
    return student;
    }

    @Override
    public boolean deleteStudent(int id) throws Exception{
//       删除缓存
    MemcachedUtils.delete(String.valueOf(id));
    return studentMapper.deleteStudent(id);
    }

    @Override
    public List<Student> findAll()throws Exception {
        return studentMapper.findAll();
    }
}
