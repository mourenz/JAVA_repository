package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class TokenRedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;


    @Test
    void contextLoads() {
        Integer append = redisTemplate.opsForValue().append("user", "user");
        System.out.println(append);
        System.out.println(redisTemplate);
    }



}
