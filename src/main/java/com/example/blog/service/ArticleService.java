package com.example.blog.service;

import com.example.blog.entity.Article;

import java.util.List;

public interface ArticleService {


    //查询所有的博客
    List<Article> selectAll();
}
