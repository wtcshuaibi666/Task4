package com.jnshu.seviceImpl;

import com.jnshu.entity.Student;
import com.jnshu.mapper.StudentMapper;
import com.jnshu.service.StudentService;
import com.jnshu.tool.JedisCache;
import org.slf4j.LoggerFactory;

import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisImpl implements StudentService{
    private static Logger logger = LoggerFactory.getLogger(RedisImpl.class);
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    JedisCache jedisCache;
    @Override
    public int addStudent(Student student) throws Exception {
        studentMapper.addStudent(student);
    Boolean exist = jedisCache.setStudent("student"+student.getId(),student);
    return student.getId();
    }

    @Override
    public boolean updateStudent(int id, Student student) throws Exception {
      Boolean msg = studentMapper.updateStudent(student);
      String key = "student"+student.getId();
      Object haskey = jedisCache.get(key);
    if (haskey!=null){
        jedisCache.delete(key);
        logger.info("delete cache");
    }
    return msg;
    }

    @Override
    public Student findStudentById(int id) throws Exception {
        //find cche
        Object object = jedisCache.get("student"+id);
        if (object!=null){
            return (Student)object;
        }
        Student student = studentMapper.findStudentById(id);
        jedisCache.set("student"+id,student);
        return student;
    }

    @Override
    public boolean deleteStudent(int id) throws Exception {
        jedisCache.delete("student"+id);
        logger.info("delete cache");
    return studentMapper.deleteStudent(id);
    }

    @Override
    public List<Student> findAll() throws Exception {
        return studentMapper.findAll();
    }
}
