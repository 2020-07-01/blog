package com.example.blog.entity;

/**
 * @author :qiang
 * @date :2019/7/12 下午10:38
 * @description :博客实体类
 * @other :
 */
public class Article {

    /*
     * 博客编号
     */
    private String id;

    /*
     * 博客标题
     */
    private String title;

    /*
     * 博客内容
     */
    private String content;

    /*
     * 博客类别
     */
    private Category category;

    /*
     * 博客摘要:默认取前40个字
     */
    private String summary;

    /*
     * 创建时间：由系统生成
     */
    private String createDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", summary='" + summary + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
