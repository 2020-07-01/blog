package com.example.blog.controller;

import com.example.blog.entity.Article;
import com.example.blog.entity.Category;
import com.example.blog.errorCode.ErrorCode;
import com.example.blog.errorCode.ErrorCodes;
import com.example.blog.service.ArticleService;
import com.example.blog.service.CategoryService;
import com.example.blog.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :qiang
 * @date :2019/7/11 下午9:28
 * @description :用户主要操作类
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
     * 进入登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public String login() {
        log.info("进入登陆页面");
        return "admin/login";
    }

    /**
     * 默认进入后台主页
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public String admin(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum
            , @RequestParam(defaultValue = "9", value = "pageSize") Integer pageSize, HttpServletResponse response, HttpServletRequest request) {

        //如果cookie不为空则继续执
        if (request.getCookies() != null) {
            PageHelper.startPage(pageNum, pageSize);
            try {
                List<Article> articleList1 = articleService.selectAll();

                List<Article>  articleList = articleList(articleList1);

                PageInfo<Article> pageInfo = new PageInfo<>(articleList);

                model.addAttribute("pageInfo", pageInfo);
            } catch (Exception e) {
                log.info(e.toString());
            }

            log.info("分页成功");
            return "admin/index";
        } else
            return "admin/login";
    }

    private List<Article> articleList(List<Article> list) {

        //创建新的list存储title
        List<String> list1 = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {

            list1.add(list.get(i).getTitle());
        }

        //遍历标题list
        for (int i = 0; i < list1.size(); i++)//遍历标题
        {
            String newString = list1.get(i).substring(0, 33);

            list1.set(i, newString);
        }

        //替换title
        for (int i = 0; i < list.size(); i++) {

            list.get(i).setTitle(list1.get(i));
        }

        return list;
    }


    /**
     * 进入写博客界面
     *
     * @return
     */
    @RequestMapping(value = "/write")
    public String write(Model model, HttpServletRequest request, HttpServletResponse response) {
        //获取请求中的cookie数组
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            //查询所有的类别信息传送到前端
            List<Category> categories = categoryService.selectAll();
            model.addAttribute("categories", categories);
            model.addAttribute("article1", new Article());//传入一个空对象
            return "admin/write";

        } else {
            return "admin/login";
        }

    }

    /**
     * 删除博客模块
     * 删除博客时要根据cookie判断用户是否有权限
     *
     * @param articleMessage：接受前端返回的博客id
     * @return ：重定向到index页面
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public ErrorCode deleteBlog(@RequestBody String articleMessage
            , HttpServletResponse response
            , HttpServletRequest request) {

        //获取cookie
        Cookie[] cookies = request.getCookies();
        //将string转换为静态的JSONObject
        JSONObject object = JSONObject.fromObject(articleMessage);
        //获取与键关联的值
        String aId = object.getString("aId");

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("yq")) {
                articleService.deleteBlog(aId);
                return ErrorCodes.CODE_005;
            }
        }
        return ErrorCodes.CODE_004;

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

        articleService.updateBlog(article);
        return "redirect:/admin/index";
    }

    /**
     * 保存博客模块
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public ErrorCode save(@RequestBody String articleMessage, HttpServletRequest request, HttpServletResponse response) {


        //保存博客信息
        ErrorCode errorCode = articleService.saveBlog(articleMessage);
        return errorCode;

    }


}

