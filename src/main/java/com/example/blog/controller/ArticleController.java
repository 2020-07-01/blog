package com.example.blog.controller;

import com.example.blog.entity.Article;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author :qiang
 * @date :2019/7/12 下午10:26
 * @description :博客控制层
 * @other :
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {


    @Autowired
    ArticleService articleService;

    //根据id查询内容，然后将内容进行显示
    @RequestMapping(value = "/detail/{aId}")
    public String showDetail(@PathVariable String aId, Model model) {

        Article article = articleService.selectById(aId);
        model.addAttribute("article", article);

        return "front/detail";
    }


    /**
     * 按类型显示博客
     *
     * @param displayName
     * @param category_cId
     * @param model
     * @return
     */
    @RequestMapping(value = "/column/{displayName}/{category_cId}")
    public String column(@PathVariable String displayName, @PathVariable String category_cId, Model model) {
        //根据category——cId查询所有的博客
        List<Article> articleList = articleService.selectAllByCategory(category_cId);

        model.addAttribute("articleList", articleList);

        return "front/columnPage";
    }

    //头部的查寻功能
    @RequestMapping(value = "/search")
    public String search(@RequestParam("key") String key, Model model) {
        System.out.println(key);
        List<Article> articleList = articleService.search(key);

        for (Article article : articleList) {
            System.out.println(article.toString());
        }
        model.addAttribute("articleList", articleList);

        return "front/columnPage";
    }


}
