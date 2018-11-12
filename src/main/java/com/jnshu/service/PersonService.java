package com.jnshu.service;

import com.jnshu.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getGood();
    //优秀学员
    Integer findByWork();
    //找到工作的人
    Integer findByLearn();
    //正在学习的人
    Integer getType(String type);
//查询职业相关数量
}
