package transaction;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Aop 注解
 */
@Component
@Aspect
public class AnnonationAop {
//    切入点表达式
    @Pointcut("execution(* service..*.*(..))")
    public void service(){  // 指定 pointCut id
    }


    @Before("service()")
    public void before(){
        System.out.println("前置增强");
    }
}
