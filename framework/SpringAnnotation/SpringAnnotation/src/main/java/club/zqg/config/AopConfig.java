package club.zqg.config;

import club.zqg.log.LogAspectj;
import club.zqg.service.impl.MathServiceOfAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy  // 切面自动代理  必须开启 否则无法增强
@Configuration
public class AopConfig {

    @Bean
    public MathServiceOfAop mathServiceOfAop(){
        return new MathServiceOfAop();
    }
    @Bean
    public LogAspectj logAspectj(){
        return new LogAspectj();
    }

}
