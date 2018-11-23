package com.jnshu.seviceImpl;

import com.jnshu.entity.User;
import com.jnshu.mapper.UserMapper;
import com.jnshu.service.UserService;
import com.jnshu.tool.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
   @Autowired
    UserMapper userMapper;


    @Override
    public int register(User user) {
        if(userMapper.findUserByName(user.getUsername())!=null){
            return 0;
        }
        //对用户的密码进行MD5加密加盐后，存储到数据库
        String password= Md5Util.generate(user.getPassword());
        user.setPassword(password);
        return userMapper.addUser(user);
    }

    //登陆
    @Override
    public User checkLogin(String username, String password) {
        User user=userMapper.findUserByName(username);
        //进行密码验证
        if(user!=null && Md5Util.verify(password,user.getPassword())){
            return user;
        }
        return  null;
    }

    @Override
    public User findById(int id) {
        return userMapper.findUserById(id);
    }
}
