package club.zqg.app;

import club.zqg.config.AopConfig;
import club.zqg.service.impl.MathServiceOfAop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        MathServiceOfAop mathService = annotationConfigApplicationContext.getBean(MathServiceOfAop.class);
        mathService.div(1,1);
    }
}
