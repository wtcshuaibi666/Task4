package com.jnshu.mapper;

import com.jnshu.entity.Person;

import java.util.List;

public interface PersonMapper {
    List<Person> getGood();
    //优秀学员
    Integer findByWork();
    //找到工作的人
    Integer findByLearn();
    Integer getType(String type);

}
