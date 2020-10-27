package com;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
public class JwtTokenTest {

    @Test
    public void test(){
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());//获取当前时间
        instance.add(Calendar.SECOND,200); // 当前时间 +200秒
        Date time = instance.getTime();
        System.out.println(time);
    }

    @Test
    public void testJwt(){
        System.out.println();
    }

}
