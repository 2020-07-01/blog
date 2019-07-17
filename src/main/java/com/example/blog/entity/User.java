package com.example.blog.entity;

/**
 * @author :qiang
 * @date :2019/7/11 下午8:49
 * @description :用户实体类
 * @other :
 */

public class User {

    /* @FileNote：用来描述字段
     * desc：字段描述
     * length：字段长度
     * notNull：是否可以为空
     * dataType：数据类型
     * valueSet：取值范围
     * validator：检验函数
     * 对于进行查询的字段要创建检验函数在进行查询之前对字段进行检验，
     * 如果符合要求则进行
     */

    /*
     * desc：用户名
     * length：24
     * notNull：false
     * dataType:String
     */
    private String userName;

    /*
     * desc：用户密码
     * length：24
     * notNull：false
     * dataType:String
     *
     */
    private String userPassword;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
