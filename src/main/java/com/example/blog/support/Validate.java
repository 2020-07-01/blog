package com.example.blog.support;

import com.example.blog.errorCode.ErrorCode;
import com.example.blog.errorCode.ErrorCodes;

/**
 * @author :qiang
 * @date :2019/9/9 上午11:01
 * @description : 验证机制
 * @other :
 */
public class Validate {

    /**
     * 用户名验证
     * 用户名最多为20个中文或英文字母,可包含特殊字符!
     *
     * @param userName
     * @return
     */
    public static ErrorCode userNameValidate(String userName) {

        if (userName.length() > 20) {
            return ErrorCodes.CODE_006;
        } else {
            return ErrorCodes.CODE_000;//验证通过
        }
    }

    /**
     * 用户密码验证
     * 密码为6-20位,只能且必须包含数字和字母,不能以数字开头!
     *
     * @param password
     * @return
     */
    public static ErrorCode passwordValidate(String password) {
        char[] s = {};
        char first = password.charAt(0);//获取第一个字符
        int length = password.length();//获取密码长度
        char[] password_char = password.toCharArray();//获取字符数组

        boolean containNumber = false;//包含数字的标志
        boolean containLetter = false;//包含字母标志
        boolean legalLength = false;//长度是否合法
        boolean legalFirst = true;//首字母是否合法
        boolean containSpechars = true;//是否包含特殊字符
        //验证密码长度
        if (length >= 6 && length <= 20) {
            legalLength = true;
        }
        //验证首字母
        if (first >= 48 && first <= 57) {
            legalFirst = false;//首字母不合法
        }

        //验证组成
        for (int i = 0; i < password_char.length; i++) {
            //验证是否包含字母
            if (!containLetter) {
                if (password_char[i] >= 65 && password_char[i] <= 90) {
                    containLetter = true;
                }
                if (password_char[i] >= 97 && password_char[i] <= 122) {
                    containLetter = true;
                }
            }
            //验证是否包含数字
            if (!containNumber) {
                if (password_char[i] >= 48 && password_char[i] <= 57) {
                    containNumber = true;
                }
            }
            //验证是否包含特殊字符
            if (!containSpechars) {
                if (password_char[i] < 48 || password_char[i] > 122) {
                    containSpechars = false;
                }
                if (password_char[i] > 57 & password_char[i] < 65) {
                    containSpechars = false;
                }
                if (password_char[i] > 90 & password_char[i] < 97) {
                    containSpechars = false;
                }
            }
        }

        //验证通过
        if (containLetter && containNumber && legalFirst && legalLength && !containSpechars) {
            return ErrorCodes.CODE_000;
        } else if (!legalFirst) {
            return ErrorCodes.CODE_008;
        } else if (!legalLength) {
            return ErrorCodes.CODE_007;
        } else if (!containNumber || !containLetter) {
            return ErrorCodes.CODE_009;
        } else {
            return ErrorCodes.CODE_010;
        }
    }


}
