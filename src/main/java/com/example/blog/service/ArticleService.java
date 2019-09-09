package com.example.blog.service;

import com.example.blog.entity.Article;
import com.example.blog.errorCode.ErrorCode;

import java.util.List;

public interface ArticleService {


    //查询所有的博客
    List<Article> selectAll();

    //根据id删除博客
    int deleteBlog(String aId);

    //修改博客
    int updateBlog(Article article);

    //根据id查询博客
    Article selectById(String aId);

    //保存博客信息
    ErrorCode saveBlog(String articleMessage);

    //根据key进行搜索
    List<Article> search(String key);

    //修改博客信息
    int update(Article article);

    //根据category查询所有的博客
    List<Article> selectAllByCategory(String category);


}
