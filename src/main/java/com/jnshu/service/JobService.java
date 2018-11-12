package com.jnshu.service;

import com.jnshu.entity.Job;

import java.util.List;

public interface JobService {
    //查询所有职业
    List<Job> getListJob();
//    查询某个职业
    Job getJobById(int id);
}
