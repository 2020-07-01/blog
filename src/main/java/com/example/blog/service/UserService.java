package com.example.blog.service;

import com.example.blog.entity.User;
import com.example.blog.errorCode.ErrorCode;

public interface UserService {

    // 根据用户名和密码查询用户信息
    boolean getUser(String userName, String password);

    // 注册用户信息
    ErrorCode registerUser(User user);


}
