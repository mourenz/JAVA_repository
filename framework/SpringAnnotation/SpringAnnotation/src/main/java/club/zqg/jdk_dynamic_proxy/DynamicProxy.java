package club.zqg.jdk_dynamic_proxy;

import club.zqg.service.IUserService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy<UserService> implements InvocationHandler {

    IUserService target = new club.zqg.service.impl.UserService();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("¿ªÆôÊÂÎñ....");
        Object retVal = method.invoke(target, args);
        return retVal;
    }

    public UserService getProxyObject() {
        return (UserService) Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[]{IUserService.class}, this);
    }

}
