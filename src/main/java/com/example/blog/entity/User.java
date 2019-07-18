package com.example.blog.entity;

import javax.validation.constraints.NotNull;

/**
 * @author :qiang
 * @date :2019/7/11 下午8:49
 * @description :用户实体类
 * @other :
 */

public class User {


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
