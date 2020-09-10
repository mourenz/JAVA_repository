package club.zqg;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtilsThreadLocal {
	public static Connection connection;

	/**
	 * ThreadLocal 是 JDK底层提供的一个解决多线程并发问题的工具类,
	 * 它为每个线程提供了一个本地的副本变量机制，实现了和其它线程隔离，
	 * 并且这种变量只在本线程的生命周期内起作用，
	 */

	// 保证连接是一个对象  即为 事务即为同一个 Connection
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

	static {
		//类加载完成，只执行一次
		System.out.println("静态代码 执行了...........................");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("获取连接异常............");
			e.printStackTrace();
		}
	}
	// 通过 threadLocal 获取连接 Connection
	public static Connection getConnectionFromThradLocal() {
		if(threadLocal.get()==null) {
			threadLocal.set(getConnection());
		}
		//打印当前线程
		System.out.println("currentThread__"+Thread.currentThread());
		System.out.println("currentClass"+threadLocal.get());
		return threadLocal.get();
	}

	// 开启事务
	public static void startTransation() {
		if(threadLocal.get()==null) {
			threadLocal.set(getConnection());
		}
		try {
			threadLocal.get().setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 关闭
	public static void close() {
		try {
			threadLocal.get().commit();
			threadLocal.get().close();
			threadLocal.remove();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//获取Connection链接对象
	private static Connection getConnection() {
		if(connection==null) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://182.254.244.35","root","xxxx");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return connection;
	}

}
