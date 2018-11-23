package com.jnshu.controller;

import com.jnshu.entity.Job;
import com.jnshu.entity.Person;
import com.jnshu.entity.User;
import com.jnshu.service.JobService;
import com.jnshu.service.PersonService;
import com.jnshu.service.UserService;

import com.jnshu.tool.DesUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TilesContro {
    @Autowired
    JobService jobService;
    @Autowired
    PersonService personService;
    @Autowired
    UserService userService;
    @Autowired
    DesUtil desUtil;

    public final static Logger logger= LogManager.getLogger(TilesContro.class);

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
    @RequestMapping(value = "/u/job",method = RequestMethod.GET)
    public String find(Model model){
        List<Job>jobList=jobService.getListJob();
        model.addAttribute("job",jobList);
        return "job";
    }
    //访问时，跳转登陆页面
    @RequestMapping(value = "/login/0")
    public String login(){
        return "login";
    }
    //访问时，跳转注册页面
    @RequestMapping(value = "/login/1")
    public String register(){
        return "register";
    }


    //登陆
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String checkLogin(Model model, @Param("username")String username, @Param("password")String password,
                             HttpServletRequest request, HttpServletResponse response){
        User user = userService.checkLogin(username,password);
        if(user!=null){
            logger.info(username,password);
            logger.info("登陆成功");
            //使用DES对用户ID和登录时间加密，生成Token，放入Cookie中
            int id=user.getId();
            String token=id+"/"+System.currentTimeMillis();
            try {
                token = desUtil.encrypt(token);
                Cookie cookie=new Cookie("token",token);
                //设置cookie的有效期，以秒为单位
                cookie.setMaxAge(60*3);
                //设置cookie的有效路径，比如把cookie的有效路径设为"/xdp"，那么浏览器访问"xdp"目录下的web资源时，都会带上cookie
                cookie.setPath("/");
                logger.debug("cookie有效路径为"+cookie.getMaxAge()+"cookie的有效期为"+cookie.getMaxAge()+"cookie生成的名字为"+cookie.getName());
                //将生成的cookie发送给浏览器客户端
                response.addCookie(cookie);
            } catch (Exception e) {
                e.printStackTrace();

            }

            return "redirect:/u/job" ;
        }else {
            logger.debug("用户不存在，请重新登录");
            return "redirect:/login/0";
        }
    }
    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user) {
        if (userService.register(user) != 0) {
            logger.info("注册成功，返回登陆页面");
            return "ok";
        } else {
            logger.debug("注册失败，用户名已存在");
            return "redirect:/login/1";
        }
    }

    //注销
    @RequestMapping(value = "/loginOut",method=RequestMethod.GET)
    public String loginOut(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies){
            if("token".equals(cookie.getName())){
                cookie = new Cookie("token", null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
                return "redirect:/login/0";
            }
        }
        return "redirect:/login/0";
    }
}








