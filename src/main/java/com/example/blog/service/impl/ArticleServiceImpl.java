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
        List<Article> list = articleDao.selectAll();
        return list;
    }
}
