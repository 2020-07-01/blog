package com.example.blog.dao;

import com.example.blog.eneity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    //根据用户名和密码查询用户
    User selectUserByNP(@Param("userName") String userName,@Param("userPassword") String userPassword );
}
