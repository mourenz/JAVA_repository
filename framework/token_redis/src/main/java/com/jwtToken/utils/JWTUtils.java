package com.jwtToken.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    public static String sign = "!HA#@aaa!";

    /**
     * 生成token
     *
     * @return
     */
    public static String getToken(Map<String, String> clamiMaps) {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());//获取当前时间
        instance.add(Calendar.DATE, 7); // 过期时间 设置为7天后
        JWTCreator.Builder builder = JWT.create();
        clamiMaps.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        return builder
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(sign));
    }

    /**
     * 验证token
     *
     * @param token
     */
    public static DecodedJWT verfyToken(String token) {
        JWTVerifier tokenDecodeVerfy = JWT.require(Algorithm.HMAC256(sign)).build();
        DecodedJWT verify = tokenDecodeVerfy.verify(token);
        return verify;
    }


}
