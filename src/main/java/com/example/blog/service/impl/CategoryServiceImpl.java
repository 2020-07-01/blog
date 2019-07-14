package com.example.blog.service.impl;

import com.example.blog.dao.CategoryDao;
import com.example.blog.entity.Category;
import com.example.blog.service.CategoryService;
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


    @Autowired
    CategoryDao categoryDao;

    //查询所有的类别信息
    public List<Category> selectAll() {

        return categoryDao.selectAll();
    }
}
