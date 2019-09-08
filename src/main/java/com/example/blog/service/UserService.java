package com.example.blog.service;

import com.example.blog.entity.User;

public interface UserService {

    // 根据用户名和密码查询用户信息
    boolean getUser(String userName, String password);

    // 注册用户信息
    boolean registerUser(User user);

    //根据用户名查询用户信息
    boolean selectUser(String userName);


}
