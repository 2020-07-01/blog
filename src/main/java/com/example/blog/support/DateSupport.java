package com.example.blog.support;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :qiang
 * @date :2019/7/14 下午10:36
 * @description :获取当前时间
 * @other :
 */
public class DateSupport {

    //获取当前时间
    public String getDate() {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format1.format(new Date());
    }

}
