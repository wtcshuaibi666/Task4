package com.jnshu.seviceImpl;

import com.jnshu.entity.Job;
import com.jnshu.mapper.JobMapper;
import com.jnshu.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{
    @Autowired
    private JobMapper jobMapper;


    @Override
    public List<Job> getListJob() {
        return jobMapper.getListJob();
    }

}
