package com.example.blog.controller;

import com.example.blog.entity.Article;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tautua.markdownpapers.Markdown;
import org.tautua.markdownpapers.parser.ParseException;

import java.io.StringReader;
import java.io.StringWriter;
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

    @RequestMapping(value = "/get")
    public String get() {
        return "front/index";
    }


    //根据id查询内容，然后将内容进行显示
    @RequestMapping(value = "/detail")
    public String showDetail(@RequestParam("aId") String aId, Model model) {

        Article article = articleService.selectById(aId);
        Markdown markdown = new Markdown();
        try {
            StringWriter out = new StringWriter();
            StringReader in = new StringReader(article.getContent());
            markdown.transform(new StringReader(article.getContent()), out);
            out.flush();
            article.setContent(out.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("article", article);

        return "front/detail";

    }

    // /article/column/Java专栏/javaPage}>Java专栏</a></li>
    //安类型显示博客
    @RequestMapping(value = "/column/{displayName}/{categoryName}")
    public String column(@PathVariable String displayName, @PathVariable String categoryName, Model model) {

        //通过id查询所有的博客
        return "ere";


    }


    //头部的查寻功能
    //传递过来的key进行全文搜索,存在key关键字的博客全部进行先死
    @RequestMapping(value = "/search")
    public String search(@RequestParam("key") String key, Model model) {
        //应该在查询之前进行分页
        List<Article> articleList = articleService.search(key);
        model.addAttribute("articleList", articleList);

        return "front/columnPage";
    }


}
