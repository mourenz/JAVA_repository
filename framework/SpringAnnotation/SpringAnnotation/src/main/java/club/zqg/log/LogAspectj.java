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
    public void logStart(JoinPoint joinPoint){ //JoinPoint ������� ��һλ
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("��־����...��ǰ��ǿ�ķ���Ϊ"+signature.getName()+"����Ϊ"+args.toString());
    }

    @AfterReturning(value = "pointCut()",returning = "result") // ���ܱ�����ķ�������ֵ
    public void logAfter(Object result){
        System.out.println("�����������أ�����ֵΪ"+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "bad")
    public void logException(Throwable bad){
        System.out.println("���������쳣 �쳣��ϢΪ"+bad.toString());
    }

}
