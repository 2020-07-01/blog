package com.example.blog.dao;

import com.example.blog.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {

    //查询所有的博客
    List<Article> selectAll();
}
