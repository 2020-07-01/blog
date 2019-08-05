package com.example.blog.entity;

import javax.validation.constraints.NotNull;

/**
 * @author :qiang
 * @date :2019/7/11 下午8:49
 * @description :用户实体类
 * @other :
 */

public class User {

    private String userId;

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
    private String password;


    private String registerDate;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", registerDate='" + registerDate + '\'' +
                '}';
    }
}




