package com.example.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :qiang
 * @date :2019/9/10 下午8:51
 * @description :登录页面
 * @other :
 */
@Controller
public class LoginController {

    //创建日志实例
    private static final Logger log = LoggerFactory.getLogger(UserController.class.getName());

    /**
     * 进入登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/blog")
    public String login() {
        log.info("进入登陆页面");
        return "admin/login";
    }

}
