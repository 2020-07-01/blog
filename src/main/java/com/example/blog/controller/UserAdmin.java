package com.example.blog.controller;

import com.example.blog.entity.User;
import com.example.blog.errorCode.ErrorCode;
import com.example.blog.service.UserService;
import com.example.blog.errorCode.ErrorCodes;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

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
    //创建cookie
    Cookie cookie;

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
        return "admin/register";
    }

    /**
     * 注册新用户
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/toregister")
    @ResponseBody
    public ErrorCode toRegister(@RequestBody String userMessage) {
        log.info("用户名和密码为：" + userMessage);
        //将string转换为静态的JSONObject
        JSONObject object = JSONObject.fromObject(userMessage);
        //获取与键关联的值
        String userName = object.getString("userName");
        String password = object.getString("password");

        User user = new User(userName, password);
        //注册用户
        ErrorCode result = userService.registerUser(user);

        return result;
    }

    /**
     * 登陆验证模块，验证成功后跳转至后台主页,否则跳转到登陆界面
     *
     * @param userMessage
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public ErrorCode doLogin(@RequestBody String userMessage, HttpServletResponse response, HttpServletRequest request) {
        log.info("接受用户输入的用户名和密码：" + userMessage);

        //将string转换为静态的JSONObject
        JSONObject object = JSONObject.fromObject(userMessage);
        //获取与键关联的值
        String userName = object.getString("userName");
        String password = object.getString("password");

        User user = new User(userName, password);

        //如果可以获取到用户名和密码则成功否则失败
        if (userService.getUser(user.getUserName(), user.getUserPassword())) {
            log.info("用户验证成功");
            try {
                cookie = new Cookie(URLEncoder.encode(user.getUserName(), "UTF-8"), user.getUserPassword());
            } catch (Exception e) {

            }
            //在所有路径上都绑定cookie
            cookie.setPath("/");

            //设置cookie的有效时间
            //该值大与0表示将cookie存放到客户端的硬盘
            //该值小于0与不设置相同表示将cookie存放到客户端浏览器的缓存中
            //该值等于0表示cookie一生成马上失效
            cookie.setMaxAge(-1);//浏览器关闭时清除cookie
            //加入cookie
            response.addCookie(cookie);

            return ErrorCodes.CODE_000;
        } else {
            log.info("用户验证失败");
            return ErrorCodes.CODE_011;
        }
    }

    //退出登陆操作
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        return "admin/login";
    }


}
