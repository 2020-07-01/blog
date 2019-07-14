package com.example.blog.service;

import com.example.blog.entity.Category;

import java.util.List;

public interface CategoryService {

    //查询所有的类别信息
    List<Category> selectAll();
}
