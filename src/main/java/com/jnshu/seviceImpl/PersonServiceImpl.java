package com.jnshu.seviceImpl;

import com.jnshu.entity.Person;
import com.jnshu.mapper.PersonMapper;
import com.jnshu.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> getGood() {
        return personMapper.getGood();
    }

    @Override
    public Integer findByWork() {
        return personMapper.findByWork();
    }

    @Override
    public Integer findByLearn() {
        return personMapper.findByLearn();
    }

    @Override
    public Integer getType(String type) {
        return personMapper.getType(type);
    }


}

