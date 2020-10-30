package com;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
public class JwtTokenTest {

    Calendar instance;

    public void expireTime() {
        instance = Calendar.getInstance();
        System.out.println(instance.getTime());//获取当前时间
        instance.add(Calendar.SECOND, 200); // 当前时间 +200秒
        Date time = instance.getTime();
        System.out.println(time);
    }

    @Test
    public void testJwt() {
        expireTime();
        String tokenJWT = JWT.create()
                .withClaim("userID", 1)
                .withClaim("role", "admin")
                .withExpiresAt(instance.getTime())  // 设置过期时间
                .sign(Algorithm.HMAC256("!z#qws")); // 设置签名
        System.out.println("tokenJwt:\n"+tokenJWT);

        System.out.println("============解码============");

        //获取 token的信息
        JWTVerifier tokenDecodeVerfy = JWT.require(Algorithm.HMAC256("!z#qws")).build();
        DecodedJWT verify = tokenDecodeVerfy.verify(tokenJWT);
        Integer userID = verify.getClaim("userID").asInt();
        String role = verify.getClaim("role").asString();
        System.out.println("userID->"+userID);
        System.out.println("role->"+role);
    }

}
