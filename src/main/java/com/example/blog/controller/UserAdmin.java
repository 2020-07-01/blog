package com.example.blog.controller;

import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author :qiang
 * @date :2019/8/4 下午7:25
 * @description :用户管理控制类
 * @other :
 */
@Controller
@RequestMapping(value = "/adminUser")
public class UserAdmin {

    // 创建日志实例
    private final static Logger log = LoggerFactory.getLogger(UserAdmin.class.getName());

    @Autowired
    private UserService userService;

    /**
     * 进入注册页面
     *
     * @return
     */
    @RequestMapping(value = "/register")
    public String register() {
        log.info("进入注册页面");
        return "register";
    }

    /**
     * 注册新用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/toregister")
    public String toRegister(User user) {
        boolean result = userService.registerUser(user);
        if (result) {
            return "redirect:/admin/login";
        } else {
            return "redirect:/adminUser/register";
        }
    }


    /**
     * 登陆验证模块，验证成功后跳转至后台主页,否则跳转到登陆界面
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String doLogin(User user) {
        log.info("接受用户输入的用户名和密码：" + user.toString());
        //如果可以获取到用户名和密码则成功否则失败
        if (userService.getUser(user.getUserName(), user.getUserPassword())) {
            log.info("用户验证成功");
            return "redirect:/admin/index";
        } else {
            log.info("用户验证失败");
            return "admin/login";
        }
    }


}
