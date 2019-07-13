package com.example.blog.service;

import com.example.blog.entity.Article;

import java.util.List;

public interface ArticleService {


    //查询所有的博客
    List<Article> selectAll();

    //根据id删除博客
    int deleteBlog(String id);

    //修改博客
    int updateBlog(Article article);

    //根据id查询博客
    Article selectById(String id);
}
