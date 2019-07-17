package com.example.blog.service.impl;

import com.example.blog.dao.ArticleDao;
import com.example.blog.entity.Article;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author :qiang
 * @date :2019/7/12 下午10:49
 * @description :
 * @other :
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    //查询所有的博客信息
    public List<Article> selectAll() {
        List<Article> articleList = articleDao.selectAll();
        return articleList;
    }


    //根据id删除博客
    public int deleteBlog(String id) {
        return articleDao.deleteBlog(id);
    }

    //修改博客
    public int updateBlog(Article article) {
        return articleDao.updateBlog(article);
    }

    //根据id查询博客
    public Article selectById(String id) {
        return articleDao.selectById(id);
    }

    //保存博客信息
    public int saveBlog(Article article) {
        //设置aId
        article.setaId("123");
        //取前40个字符为摘要,否则整个文章为摘要
        if (article.getContent().length() > 40) {
            article.setSummary(article.getContent().substring(0, 40));
        } else {
            article.setSummary(article.getContent());
        }
        //设置时间


        return articleDao.saveBlog(article);
    }
}
