package com.jwtToken.config;

import com.jwtToken.interceptor.JWTInteceptor;
import com.tokenRedis.project.filter.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JWTwebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInteceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/jwtlogin","/login");
    }
}
