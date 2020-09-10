package club.zqg.app;

import club.zqg.jdk_dynamic_proxy.DynamicProxy;
import club.zqg.service.IUserService;
import club.zqg.service.impl.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import club.zqg.config.MainConfig;

import java.lang.reflect.InvocationHandler;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}

		DynamicProxy<UserService> userServiceDynamicProxy = new DynamicProxy<>();
		UserService proxyObject = userServiceDynamicProxy.getProxyObject();
		proxyObject.save();

		/*System.out.printf("--------------------jdk¶¯Ì¬´úÀí-------------------");
		DynamicProxy dynamicProxy = annotationConfigApplicationContext.getBean(DynamicProxy.class);
		IUserService iuserService = (UserService)dynamicProxy.getProxyObject();
		iuserService.save();*/


	}
}
