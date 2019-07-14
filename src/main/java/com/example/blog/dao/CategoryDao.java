package com.example.blog.dao;

import com.example.blog.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {

    //查询所有的类别信息
    List<Category> selectAll();
}
