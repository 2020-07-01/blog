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
     * 验证用户信息
     *
     * @param userName
     * @param userPassword
     * @return 验证成功返回true，失败返回false
     */
    @Override
    public boolean getUser(String userName, String userPassword) {

        User user = userDao.selectUserByNP(userName, userPassword);

        //判断是否可以查询到用户
        if (user == null) {
            log.error("用户不存在");
            return false;
        } else {
            log.info("用户存在");
            return true;
        }
    }

    /**
     * 注册信息用户
     *
     * @param user
     * @return 注册成功返回true，失败返回false
     */
    @Override
    public boolean registerUser(User user) {
        Integer row = userDao.insertUser(user);
        if (row == 1) {
            log.info("用户注册成功");
            return true;
        } else {
            log.info("用户注册失败");
            return false;
        }
    }

}
