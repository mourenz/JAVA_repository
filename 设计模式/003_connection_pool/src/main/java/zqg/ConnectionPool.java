package zqg;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * connection pool
 * 
 * @author admin
 *
 */
//
public class ConnectionPool {
	public static List<Connection> list = Collections.synchronizedList(new ArrayList<Connection>());// ArrayList 线程不安全 将其转换为线程安全
																									
	static {
		for (int i = 0; i < 50; i++) {
			list.add(JdbcUtil.getConnection());
		}
		System.out.println("connection  pool has been initized");
	}

	// get certain Connection
	public static Connection getConnection() {
		Connection conn = list.remove(0); // 这里已经拿到真实对象
		// 实现对Connection 对象的代理 [当这个函数执行 也就是代码执行 完毕 此时 已经实现了对Connection 进行代理]
		Connection proxyConnection = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), // 获取真实对象类加载器 [即为拿到真实对象],// 实现对真实对象中的方法进行代理,
				new Class[]{Connection.class},// 接口数组
				new InvocationHandler() { // 具体对方法的增强
					@Override  // [此方法何时会被调用  调用时机：当执行Connection 创建的 对象引用调用方法时 会被触发执行 ]
					public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
						Object retVal = null;
						if ("close".equals(arg1.getName())) {
							 list.add(conn); // add 方法返回 boolean 此时只执行 add()方法 原本的close()不会执行    不需要返回值 因为close() 返回值为void
						} else {
							retVal = arg1.invoke(conn, arg2);// 其他方法该返回什么就返回什么
						}
						return retVal; // 当代理对象 调用真实对象的方法 获取到的方法返回值 [只有代理对象 调用方法  才会有返回值]
					}
				});
		return proxyConnection; // 这是该方法 即为getConnection() 返回值 [调用该方法的返回值]
	}
}
