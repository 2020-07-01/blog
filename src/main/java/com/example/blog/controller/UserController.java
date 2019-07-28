package com.example.blog.controller;

import com.example.blog.entity.Article;
import com.example.blog.entity.Category;
import com.example.blog.entity.User;
import com.example.blog.service.ArticleService;
import com.example.blog.service.CategoryService;
import com.example.blog.service.UserService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author :qiang
 * @date :2019/7/11 下午9:28
 * @description :用户信息控制类
 * @other :
 */

@RequestMapping(value = "/admin")
@Controller
public class UserController {

    //创建日志实例
    private static final Logger log = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;


    /**
     * 默认进入后台主页
     *
     * @return
     */
    @RequestMapping(value = "")
    public String admin(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum
            , @RequestParam(defaultValue = "9", value = "pageSize") Integer pageSize) {


        PageHelper.startPage(pageNum, pageSize);
        try {
            List<Article> articleList = articleService.selectAll();
            PageInfo<Article> pageInfo = new PageInfo<Article>(articleList);
            model.addAttribute("pageInfo", pageInfo);
        } catch (Exception e) {
            System.out.println(e);
        }

        log.info("分页成功");
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
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String doLogin(User user) {

        //如果可以获取到用户名和密码则成功否则失败
        if (userService.getUser(user.getUserName(), user.getUserPassword())) {
            return "redirect:/admin";
        } else {
            return "admin/login";
        }
    }


    /**
     * 进入写博客界面
     *
     * @return
     */
    @RequestMapping(value = "/write")
    public String write(Model model) {

        //查询所有的类别信息传送到前端
        List<Category> categories = categoryService.selectAll();
        model.addAttribute("categories", categories);
        model.addAttribute("article1", new Article());//传入一个空对象

        return "admin/write";
    }


    /**
     * 删除博客模块
     *
     * @param aId：接受前端返回的博客id
     * @return ：重定向到index页面
     */

    @RequestMapping(value = "/delete")
    public String deleteBlog(@RequestParam("aId") String aId) {

        articleService.deleteBlog(aId);
        return "redirect:/admin";
    }


    /**
     * 进入更新博客页面
     *
     * @param aId
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateBlog")
    public String updateBlog(@RequestParam("aId") String aId, Model model) {
        //根据id查询要修改的博客
        Article article = articleService.selectById(aId);
        log.info("article数据：" + article.toString());
        //查询所有的类别
        List<Category> categoryList = categoryService.selectAll();

        model.addAttribute("displayName", article.getCategory().getDisplayName());
        model.addAttribute("article", article);
        model.addAttribute("category", categoryList);

        return "admin/update";
    }

    /**
     * 更新博客
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "/update")
    public String update(Article article) {
        System.out.println(article.toString());

        articleService.updateBlog(article);
        return "redirect:";
    }

    /* *
     * 保存博客模块
     *
     * @param article
     * @return*/

    @RequestMapping(value = "/save")
    public String save(Article article) {
        System.out.println(article.toString());

        //保存博客信息
        articleService.saveBlog(article);
        return "redirect:";
    }


}

