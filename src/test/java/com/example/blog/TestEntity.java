package com.example.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :qiang
 * @date :2019/7/11 下午9:00
 * @description :测试实体类
 * @other :
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEntity {


    @Test
    public void getUUid() {

        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format1.format(new Date()));
    }


}
