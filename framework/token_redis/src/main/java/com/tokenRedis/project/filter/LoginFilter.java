package com.tokenRedis.project.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginFilter implements Filter {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletRequest;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
        token = token == null ? " " : token;
        redisTemplate.opsForValue().get(token);
        Long expire = redisTemplate.getExpire(token);
        if (expire > 0) {
            // 重新设置过期时间
            redisTemplate.expire(token,30L, TimeUnit.MINUTES);
            //放行
            filterChain.doFilter(request, response);
        } else {
            //设置 返回
        }


    }

    @Override
    public void destroy() {

    }
}
