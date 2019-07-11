package com.example.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.unit.DataUnit;

import java.util.UUID;

/**
 * @author :qiang
 * @date :2019/7/11 下午9:00
 * @description :测试实体类
 * @other :
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEntity {


    @Test
    public void getUUid(){

        String string = UUID.randomUUID().toString();
        System.out.println("UUID："+string);

    }


}
