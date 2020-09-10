package club.zqg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import club.zqg.pojo.Color;
import club.zqg.pojo.Person;
import org.springframework.stereotype.Service;

@Configuration  // ��֪ Spring ����һ��������
@ComponentScan(value = "club.zqg",// ���ð��� ���� @Controller ��@Service ��@Repository @Compent ע�����������
includeFilters = {@Filter(type = FilterType.ANNOTATION,classes = {Service.class})}// ֻɨ�� ����@Controllerע�����
,useDefaultFilters = false// �ر��Զ�ɨ����� ��Ϊ�ر� ���� @Controller ��@Service ��@Repository @Compent����  ֻ�� @Controller ע�����
//excludeFilters = {@Filter(type = )}  �����ų� ��Ϊ ��ɨ��  ����  xxx����
)
@Import({Color.class,MySelectBean.class,MyBeanRegisty.class})  // ������Ҫע��IOC���� ���Զ��嵼��Bean[MySelectBean.class]
public class MainConfig {
	@Bean// ����ע��һ������ ������ ��  ���� ���ӳ� DruidData
	public Person person() {
		return new Person(); // ����
	}
	
	@Bean(initMethod ="init")
	public Color Color() {
		return new Color();
	}
	
	
	@Bean
	public BlackFactory blackFactory() {
		return new BlackFactory();
	}
}
