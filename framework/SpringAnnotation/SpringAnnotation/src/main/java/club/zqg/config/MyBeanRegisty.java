package club.zqg.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanRegisty implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		//BeanDefinitionRegistry  registry 可以获取  IOC容器的 的信息
		int beanDefinitionCount = registry.getBeanDefinitionCount(); // 当前ioc容器的Bean个数
		System.out.println("当前ioc容器的Bean个数"+beanDefinitionCount);
		//boolean containsBeanDefinition = registry.containsBeanDefinition("xxx.xxx.xx");  IOC中是否包含某个bean
		// 手动注册
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(club.zqg.pojo.RainBow.class);
		registry.registerBeanDefinition("rainBow",rootBeanDefinition);
		

	}

}
