package com.jnshu.controller;

import com.jnshu.entity.Job;
import com.jnshu.entity.Person;
import com.jnshu.service.JobService;
import com.jnshu.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TilesContro {
    @Autowired
    JobService jobService;
    @Autowired
    PersonService personService;
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String getGood(Model model){
        List<Person>personList=personService.getGood();
        Integer count=personService.findByLearn();
        Integer number=personService.findByWork();

        model.addAttribute("personList",personList);
        model.addAttribute("count",count);
        model.addAttribute("number",number);
        return "home";
    }
    @RequestMapping(value = "job",method = RequestMethod.GET)
    public String find(Model model){
        List<Job>jobList=jobService.getListJob();
        model.addAttribute("job",jobList);
        return "job";
    }



}
