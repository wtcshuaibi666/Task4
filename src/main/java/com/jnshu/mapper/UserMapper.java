package com.jnshu.mapper;

import com.jnshu.entity.User;


public interface UserMapper {
    //注册
   int addUser(User user);
    //登陆
    User findUserByName(String username);
    User findUserById(int id);
}
