package com.jnshu.controller;

import com.jnshu.entity.Student;
import com.jnshu.service.StudentService;
import com.jnshu.tool.MemcachedUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mem")
public class MemcacheController {
    @Qualifier("redisImpl")
    @Autowired
   StudentService studentService;
    private static Logger logger = LoggerFactory.getLogger(MemcacheController.class);

    @RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object findByKey(@RequestBody @PathVariable("id") String key) {
        if (StringUtils.isEmpty(key)) {
            return "there is no data,please check your id!!";
        }
        return MemcachedUtils.get("student" + key);
    }
    @RequestMapping(value = "/api/{id}", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Boolean insert(@PathVariable("id") String key, @RequestBody Student student){
        System.out.println(student.toString());
        student.setId(Integer.valueOf(key));
        if(StringUtils.isEmpty(key)){
            return false;
        }
        return MemcachedUtils.add("student" + key, student);
    }
}
