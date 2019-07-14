package com.example.blog.dao;

import com.example.blog.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {

    //查询所有的博客
    List<Article> selectAll();

    //删除博客
    int deleteBlog(String id);

    //修改博客
    int updateBlog(Article article);

    //根基id查询博客
    Article selectById(String id);

    //保存博客信息
    int saveBlog(Article article);
}
