package com.example.blog.dao;

import com.example.blog.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    // 根据用户名和密码查询用户
    User selectUserByNP(@Param("userName") String userName, @Param("password") String password);

    // 注册用户
    Integer insertUser(User user);

}
