package com.example.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @author :qiang
 * @date :2019/8/16 下午10:09
 * @description :SpringSecurity安全框架的配置类
 * @other : 创建配置文件类继承自
 */
@EnableWebSecurity//器用web的安全功能
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        /**
         *此方法定义那些路径应该被保护，那些可以随意访问
         *
         *
         * 退出登陆之后进入的登陆页面
         *
         */
        http.authorizeRequests()

                .antMatchers("/adminUser/register", "/admin/login").permitAll()
                .anyRequest().authenticated().and()
                .formLogin()
                .loginPage("/admin/login")
                .permitAll()

                .and()
                .logout()
                .logoutUrl("/logout").logoutSuccessUrl("/admin/login");

    }


    /**
     * 基于内存设置用户信息
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("yq").password("310").roles("admin").and().
                withUser("1").password("1").roles("USER");

    }
}
