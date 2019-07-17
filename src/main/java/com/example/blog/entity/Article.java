package com.example.blog.entity;

/**
 * @author :qiang
 * @date :2019/7/12 下午10:38
 * @description :博客实体类
 * @other :
 */
public class Article {

    /*
     * desc:博客编号
     * length:24
     * notNull:false
     * dateType:String
     */
    private String aId;

    /*
     * desc:博客标题
     * length:24
     * notNull:false
     * dateType:String
     */
    private String title;

    /*
     * desc:博客内容
     * length:65535/3=21480
     * notNull:false
     * dateType:String
     */
    private String content;

    /*
     * desc:博客类别
     * length:24
     * notNull:false
     * dateType:String
     */
    private Category category;

    /*
     * desc:博客摘要
     * length:40
     * notNull:false
     * dateType:String
     */
    private String summary;

    /*
     * desc:创建时间
     * length:24
     * notNull:false
     * dateType:String
     */
    private String createDate;


    /*
     * desc:修改时间
     * length:24
     * notNull:false
     * dateType:String
     */
    private String editDate;

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
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

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aId='" + aId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", summary='" + summary + '\'' +
                ", createDate='" + createDate + '\'' +
                ", editDate='" + editDate + '\'' +
                '}';
    }
}
