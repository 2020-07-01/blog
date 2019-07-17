package com.example.blog.service.impl;

import com.example.blog.dao.UserDao;
import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :qiang
 * @date :2019/7/11 下午9:29
 * @description :用户信息service层实现类
 * @other :
 */
@Service
public class UserServiceImpl implements UserService {


    protected static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class.getName());

    @Autowired
    UserDao userDao;


    /**
     * 根据用户名和密码查询用户信息
     *
     * @param userName
     * @param userPassword
     * @return
     */
    public boolean getUser(String userName, String userPassword) {

        User user = userDao.selectUserByNP(userName, userPassword);

        //判断是否可以查询到用户
        if (user == null) {
            log.error("用户不存在");
            return false;
        } else {
            log.info("查询用户");
            return true;
        }
    }
}
