package com.tokenRedis.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class LoginController {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("getCurrentUser")
    public Integer getCurrentUser(HttpServletRequest request){
        String token = request.getHeader("token");
        Object user = redisTemplate.opsForValue().get(token);
        if(user!=null){
            return 200;
        }
        return 404;
    }


    @PostMapping("/login")
    public Map<String,Object> login(String username,String password){
        HashMap<String, Object> msgMap = new HashMap<>();
        if(!StringUtils.isEmpty(username)){
            if("admin".equals(username)&&"admin".equals(password)) {
                // 设置 token
                String token = UUID.randomUUID().toString().replace("-", "");
                //将 token 塞入redis 中设置 过期时间 30min
                redisTemplate.opsForValue().set(token,username, Duration.ofMinutes(30L));
                msgMap.put("code",200);
                msgMap.put("token",token);
                return msgMap;
            }
        }
        msgMap.put("fail",2);
        return msgMap;
    }
}
