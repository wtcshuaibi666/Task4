package com.jnshu.controller;

import com.jnshu.entity.Student;
import com.jnshu.tool.JedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("/redis")
public class RedisController {
@Autowired
JedisCache jedisCache;
private static Logger logger = LoggerFactory.getLogger(RedisController.class);

@RequestMapping(value = "gety",method = RequestMethod.GET)
    @ResponseBody
    public String getyRedis()throws Exception{
    Jedis jedis = new Jedis("localhost");
    return jedis.get("user1");
}

@RequestMapping(value = "/api/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object findByKey(@RequestBody @PathVariable("id") String key){
    if (StringUtils.isEmpty(key)){
return "key must not be empty or null";
    }
    return jedisCache.get("student"+key);
}
@RequestMapping(value = "/api/{id}",method = RequestMethod.PUT,produces = "application/json; charset=utf-8")
    @ResponseBody
    public Boolean insert(@PathVariable("id") String key, @RequestBody Student student){
    student.setId(Integer.valueOf(key));
if (StringUtils.isEmpty(key)){
    return false;
}
return jedisCache.set("student"+key,student);
}
@RequestMapping(value = "/api/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean deleteByKey(@PathVariable("id")String key){
    if (StringUtils.isEmpty(key)){
        return false;
    }
    return jedisCache.delete("student"+key);
}
}
