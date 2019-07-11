package com.example.blog.controller;

import com.example.blog.eneity.User;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author :qiang
 * @date :2019/7/11 下午9:28
 * @description :用户信息控制类
 * @other :
 */
@RequestMapping(value = "/admin")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 后台主页
     *
     * @return
     */
    @RequestMapping(value = "")
    public String admin() {
        return "admin/index";
    }

    /**
     * 登陆模块
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public String login() {
        return "admin/login";
    }


    /**
     * 登陆验证模块，验证成功后跳转至后台主页,否则跳转到登陆界面
     *
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/doLogin")
    public String doLogin(User user, Model model) {
        //如果可以获取到用户名和密码则成功否则失败
        if (userService.getUSer(user.getUserName(), user.getUserPassword())) {

            return "redirect:/admin";
        } else {
            return "admin/login";
        }

    }


}
