package com.example.blog.support;

import java.util.UUID;

/**
 * @author :qiang
 * @date :2019/7/20 上午10:37
 * @description :获取随机UUID
 * @other :
 */
public class UUIDSupport {

    //获取id
    public static String getUUID() {

        String string = UUID.randomUUID().toString();
        String newString = "";
        char[] c = string.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 45) {
                continue;
            } else {
                newString = newString + c[i];
            }
        }

        newString = newString.substring(0, 3);
        return newString;

    }
}
