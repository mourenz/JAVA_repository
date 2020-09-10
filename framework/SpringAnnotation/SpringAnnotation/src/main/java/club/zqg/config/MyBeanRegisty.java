package club.zqg.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanRegisty implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		//BeanDefinitionRegistry  registry ���Ի�ȡ  IOC������ ����Ϣ
		int beanDefinitionCount = registry.getBeanDefinitionCount(); // ��ǰioc������Bean����
		System.out.println("��ǰioc������Bean����"+beanDefinitionCount);
		//boolean containsBeanDefinition = registry.containsBeanDefinition("xxx.xxx.xx");  IOC���Ƿ����ĳ��bean
		// �ֶ�ע��
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(club.zqg.pojo.RainBow.class);
		registry.registerBeanDefinition("rainBow",rootBeanDefinition);
		

	}

}
