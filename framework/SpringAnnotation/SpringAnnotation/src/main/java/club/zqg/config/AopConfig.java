package club.zqg.config;

import club.zqg.log.LogAspectj;
import club.zqg.service.impl.MathServiceOfAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy  // �����Զ�����  ���뿪�� �����޷���ǿ
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
