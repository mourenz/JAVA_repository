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

@Configuration  // 告知 Spring 这是一个配置类
@ComponentScan(value = "club.zqg",// 将该包下 贴有 @Controller 、@Service 、@Repository @Compent 注解加入容器中
includeFilters = {@Filter(type = FilterType.ANNOTATION,classes = {Service.class})}// 只扫描 贴有@Controller注解的类
,useDefaultFilters = false// 关闭自动扫描规则 即为关闭 贴有 @Controller 、@Service 、@Repository @Compent的类  只有 @Controller 注解的类
//excludeFilters = {@Filter(type = )}  则是排除 即为 不扫描  贴有  xxx的类
)
@Import({Color.class,MySelectBean.class,MyBeanRegisty.class})  // 导入需要注入IOC的类 和自定义导入Bean[MySelectBean.class]
public class MainConfig {
	@Bean// 贴此注解一般用于 第三方 类  比如 连接池 DruidData
	public Person person() {
		return new Person(); // 返回
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
