package com.jwtToken.interceptor;

import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwtToken.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class JWTInteceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HashMap<String, String> msgMap = new HashMap<>();
        String token = request.getHeader("token")==null?" ":request.getHeader("token");
        try {
            JWTUtils.verfyToken(token);
            return true;
        }catch (AlgorithmMismatchException algorithmMismatchException){
            msgMap.put("msg","加密算法不匹配！");
        }catch (SignatureVerificationException signatureVerificationException){
            msgMap.put("msg","签名无效!");
        }catch (TokenExpiredException tokenexpiredexception ){
            msgMap.put("msg","token已经过期！");
        }
        catch (Exception e){
            e.printStackTrace();
            msgMap.put("msg","系统错误");
        }
        // @ResponseBody 借助于jackson
        String msg = new ObjectMapper().writeValueAsString(msgMap);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(msg);
        return false;
    }
}
