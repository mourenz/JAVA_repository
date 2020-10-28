package com.jwtToken.controller;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jwtToken.utils.JWTUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class JWTLoginController {

    @GetMapping("getJwtCurrentUser")
    public Map<String,Object> getJwtCurrentUser(HttpServletRequest request){
        String token = request.getHeader("token");
        HashMap<String, Object> userMap = new HashMap<>();
        DecodedJWT decodedJWT = JWTUtils.verfyToken(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        claims.forEach((k,v)->{
            if ("username".equals(k)){
                userMap.put("username",v.asString());
            }else if("role".equals(k)){
                userMap.put("role",v.asString());
            }
        });
        return userMap;
    }


    @PostMapping("/jwtlogin")
    public Map<String,Object> login(String username){
        HashMap<String, Object> map = new HashMap<>();
        if("admin".equals(username)){
            HashMap<String, String> playLoad = new HashMap<>();
            // 封装用户信息 用于生成 token
            playLoad.put("username",username);
            playLoad.put("role","admin");
            String token = JWTUtils.getToken(playLoad);
            map.put("code",200);
            map.put("msg","操作成功");
            map.put("token",token);
            return map;
        }
        map.put("code",500);
        map.put("msg","登录失败");
        return map;
    }
}
