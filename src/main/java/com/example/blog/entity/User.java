package com.example.blog.entity;


/**
 * @author :qiang
 * @date :2019/7/11 下午8:49
 * @description :用户实体类
 * @other :
 */

public class User {

    private String uuid;
    private String userName;
    private String userPassword;
    private String registerDate;
    private String editDate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", editDate='" + editDate + '\'' +
                '}';
    }
}




