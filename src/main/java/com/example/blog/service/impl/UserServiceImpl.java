package com.example.blog.service.impl;

import com.example.blog.dao.UserDao;
import com.example.blog.eneity.User;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

/**
 * @author :qiang
 * @date :2019/7/11 下午9:29
 * @description :用户信息service层实现类
 * @other :
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;


    /**
     * 根据用户名和密码查询用户信息
     *
     * @param userName
     * @param userPassword
     * @return
     */
    public boolean getUSer(String userName, String userPassword) {
        User user = userDao.selectUserByNP(userName, userPassword);
        //判断是否可以查询到用户
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }
}
