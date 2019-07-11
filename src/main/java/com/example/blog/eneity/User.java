package com.example.blog.eneity;

/**
 * @author :qiang
 * @date :2019/7/11 下午8:49
 * @description :用户实体类
 * @other :
 */

public class User {

    /*
     * 用户id，由uuid生长，长度为36位
     * 自己编写算法，去掉其中的-，成为32位
     */
    private String id;

    /*
     * 用户姓名userName
     * 长度为32位
     */
    private String userName;

    /*
     * 用户密码userPassWord
     * 长度为32位
     */
    private String userPassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}
