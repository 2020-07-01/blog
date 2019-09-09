package com.example.blog.errorCode;

import javax.lang.model.type.ErrorType;

/**
 * @author :qiang
 * @date :2019/9/8 下午9:18
 * @description :错误代码包装类
 * @other :
 */
public class ErrorCodes {

    public static final ErrorCode CODE_000 = new ErrorCode("000", "验证通过!");
    public static final ErrorCode CODE_001 = new ErrorCode("001", "用户注册成功!");
    public static final ErrorCode CODE_002 = new ErrorCode("002", "用户名已存在!");
    public static final ErrorCode CODE_003 = new ErrorCode("003", "由于未知bug导致注册失败,请重新注册!");
    public static final ErrorCode CODE_004 = new ErrorCode("004", "您没有删除权限!");
    public static final ErrorCode CODE_005 = new ErrorCode("005", "博客已经成功删除!");
    public static final ErrorCode CODE_006 = new ErrorCode("006", "用户名最多为20个字符,可包含特殊字符!");
    public static final ErrorCode CODE_007 = new ErrorCode("007", "用户密码必须位6到20位!");
    public static final ErrorCode CODE_008 = new ErrorCode("008", "用户密码首字母不能为数字!");
    public static final ErrorCode CODE_009 = new ErrorCode("009", "用户密码必须同时包含字母和数字!");
    public static final ErrorCode CODE_010 = new ErrorCode("010", "用户密码不能包含特殊字符!");
    public static final ErrorCode CODE_011 = new ErrorCode("011", "用户名或秘密错误!");
    public static final ErrorCode CODE_012 = new ErrorCode("012", "请选择类别!");
    public static final ErrorCode CODE_013 = new ErrorCode("013","博客内容不能为空!");
    public static final ErrorCode CODE_014 = new ErrorCode("014","博客标题不能为空!");
    public static final ErrorCode CODE_111 = new ErrorCode("111","");

 }
