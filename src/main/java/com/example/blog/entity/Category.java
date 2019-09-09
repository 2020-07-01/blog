package com.example.blog.entity;

/**
 * @author :qiang
 * @date :2019/7/12 下午10:44
 * @description :博客类别
 * @other :
 */
public class Category {
    /*
     * desc:博客类别id
     * length:24
     * notNull:false
     * dateType:String
     */
    private String cId;

    /*
     * desc:类别名称
     * length:24
     * notNull:false
     * dateType:String
     */
    private String categoryName;


    /*
     * desc:类别名称
     * length:24
     * notNull:false
     * dateType:String
     */
    private String displayName;


    public Category() {

    }

    public Category(String cId, String categoryName, String displayName) {
        this.cId = cId;
        this.categoryName = categoryName;
        this.displayName = displayName;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cId='" + cId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
