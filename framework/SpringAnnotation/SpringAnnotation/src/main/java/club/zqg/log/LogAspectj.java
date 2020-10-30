package club.zqg.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspectj {

    @Pointcut("execution(public int club.zqg.service.impl.MathServiceOfAop.*(..))")
    public void pointCut(){

    }

   // @Before("public int club.zqg.service.impl.MathServiceOfAop.div(int,int)")
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){ //JoinPoint 必须放置 第一位
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("日志开启...当前增强的方法为"+signature.getName()+"参数为"+args.toString());
    }

    @AfterReturning(value = "pointCut()",returning = "result") // 接受被代理的方法返回值
    public void logAfter(Object result){
        System.out.println("方法正常返回：返回值为"+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "bad")
    public void logException(Throwable bad){
        System.out.println("方法出现异常 异常信息为"+bad.toString());
    }

}
