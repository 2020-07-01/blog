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
    private String catagoryName;

    private String displayName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
