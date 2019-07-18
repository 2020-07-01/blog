package com.example.blog.service.impl;

import com.example.blog.dao.CategoryDao;
import com.example.blog.entity.Category;
import com.example.blog.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :qiang
 * @date :2019/7/14 上午11:21
 * @description :
 * @other :
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    protected static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class.getName());

    @Autowired
    CategoryDao categoryDao;

    //查询所有的类别信息
    public List<Category> selectAll() {

        List<Category> categoryList = categoryDao.selectAll();
        log.info("查询成功");
        return categoryList;
    }
}
