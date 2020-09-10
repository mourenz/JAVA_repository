package zqg;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import service.ICoustomerService;
import service.impl.CoustomerService;

/**
 * bean 工厂
 * @author admin
 */
@SuppressWarnings("all")
public class BeanFactory {


	// bean单例对象
	private static Map<String, Object> beans = new HashMap<String,Object>();
	public static ResourceBundle resourceBundle = ResourceBundle.getBundle("bean");// 读取 bean.xml 文件
	static{
		try {
			Enumeration<String> keys = resourceBundle.getKeys(); // 遍历
			while(keys.hasMoreElements()){
				String key = keys.nextElement();
				String beanPath = resourceBundle.getString(key);
				Object value = Class.forName(beanPath).newInstance();
				beans.put(key, value);  //存入容器
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("beans 容器创建失败");
		}
	}
	// getBean() 容器维护 bean
	public static Object getBean3(String beanName){
		return beans.get(beanName);
	}
	
	// 配置文件加载
/*	public static Properties properties = new Properties(); // 读取配置文件对象
	static {
		try {
			InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"); // 类路径下
			System.out.println("static" + in);
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ExceptionInInitializerError(e.getMessage());
		}
	}

	// 实现getBean() 原理[方式1]
	public static Object getBean1() {
		try {
			return Class.forName((String) properties.get("customerService")).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}*/

	// 实现2
	/*
	 * ResourceBundle.getBundle("bean"); 不需要带后缀 只能用于读取.properties 文件 不能写入 只能读取
	 * properties 文件只能在类路径下 不允许在包中
	 */
	

	// getBean() 实现2
	public static Object getBean2(String beanName) {
		try {
			return Class.forName(resourceBundle.getString(beanName)).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	// 强耦合
	public static ICoustomerService getCustomerService() {
		try {
			return (ICoustomerService) Class.forName("service.impl.CoustomerService").newInstance();
		} catch (Exception e) {
			throw new RuntimeException("出错");
		}
	}

	// 强耦合
	public static ICoustomerService getCustomerService02() {
		try {
			return (CoustomerService) Class.forName("service.impl.CoustomerService").newInstance();
		} catch (Exception e) {
			throw new RuntimeException("出错");
		}
	}

	
	public static void main(String[] args) {
		/*
		 * System.out.println(BeanFactory.getCustomerService());
		 * ICoustomerService customerService02 =
		 * BeanFactory.getCustomerService02();
		 * System.out.println(customerService02);
		 */
		//System.out.println(properties);
		System.out.println("获取的值---" + resourceBundle.getString("customerService"));
		ICoustomerService bean2 = (CoustomerService) BeanFactory.getBean2("customerService");
		System.out.println(bean2.getClass());
		/**
		 * BeanFactory.getBean()方法未能实现单例 也就是每次获取都是一个新的对象 这样加大内存消耗
		 */
		for (int i = 0; i < 5; i++) {
			System.out.println(BeanFactory.getBean2("customerService"));
		}
		System.out.println("----------------------------------------------");
		// 单列Bean 维护
		for(int i=0;i<5;i++){
			System.out.println(BeanFactory.getBean3("customerService"));
		}
	}
}
