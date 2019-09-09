package com.example.blog.service.impl;

import com.example.blog.dao.UserDao;
import com.example.blog.entity.User;
import com.example.blog.errorCode.ErrorCode;
import com.example.blog.errorCode.ErrorCodes;
import com.example.blog.service.UserService;
import com.example.blog.support.DateSupport;
import com.example.blog.support.UUIDSupport;
import com.example.blog.support.Validate;
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
     * @param password
     * @return 验证成功返回true，失败返回false
     */
    @Override
    public boolean getUser(String userName, String password) {

        User user = userDao.selectUserByNP(userName, password);

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
    public ErrorCode registerUser(User user) {

        //判断用户名是否已经存在
        if (userDao.selectUserByUN(user.getUserName()) != null) {
            return ErrorCodes.CODE_002;
        }

        //首先对用户名和用户密码进行验证
        ErrorCode errorCode1 = Validate.userNameValidate(user.getUserName());
        if (errorCode1.getCode().equals("006")) {
            return ErrorCodes.CODE_006;
        }

        ErrorCode errorCode = Validate.passwordValidate(user.getUserPassword());

        if (errorCode.getCode().equals("008")) {
            return ErrorCodes.CODE_008;
        }
        if (errorCode.getCode().equals("007")) {
            return ErrorCodes.CODE_007;
        }
        if (errorCode.getCode().equals("009")) {
            return ErrorCodes.CODE_009;
        }
        if (errorCode.getCode().equals("010")) {
            return ErrorCodes.CODE_010;
        }

        //添加id,注册时间和修改时间
        user.setUuid(UUIDSupport.getUUID());
        user.setRegisterDate(DateSupport.getDate());
        user.setEditDate(DateSupport.getDate());

        //注册用户
        int cow = userDao.insertUser(user);
        if (cow == 1) {
            log.info("用户：" + user.getUserName() + "注册成功");
            return ErrorCodes.CODE_001;
        } else {
            return ErrorCodes.CODE_003;
        }


    }

}
