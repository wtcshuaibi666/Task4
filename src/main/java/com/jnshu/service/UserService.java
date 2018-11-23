package com.jnshu.service;

import com.jnshu.entity.User;


public interface UserService  {
    int register(User user) ;
    User checkLogin(String username,String password);
    User findById(int id);

}
