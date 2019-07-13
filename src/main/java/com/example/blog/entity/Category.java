package com.example.blog.entity;

/**
 * @author :qiang
 * @date :2019/7/12 下午10:44
 * @description :博客类别
 * @other :
 */
public class Category {
    /*
     * 博客类别编号
     */
    private String id;

    /*
     * 类别名称
     */
    private String categoryName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
