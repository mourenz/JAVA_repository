package transaction;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *  事务只是在业务代码中 插入  这里的代码就是 advice 增强
 *  业务代码就是 切入点 pointCut
 */
public class Transaction {
    public void before() {
        System.out.println("前置增强");
    }

    public void commit() {
        System.out.println("事务提交");
    }

    public void rollback(Throwable ex){
        System.out.println("回滚操作"+ex.getMessage());
    }
    public void close(){
        System.out.println("关闭 流.......");
    }

    // 环绕增强[可以任意切入]
    public Object aroundTran(ProceedingJoinPoint pjp) {
        Object retValue = null;
        try {
            System.out.println("环绕增强 前置");
            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            retValue = pjp.proceed(args); // 调用具体方法
            System.out.println("环绕增强 后置");
        } catch (Throwable t) {
            System.out.println("环绕增强 异常");
            throw new RuntimeException(t);
        } finally {
            System.out.println("环绕增强 最终");
        }
        return retValue;
    }
}
