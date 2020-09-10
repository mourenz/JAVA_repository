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
	public static List<Connection> list = Collections.synchronizedList(new ArrayList<Connection>());// ArrayList �̲߳���ȫ ����ת��Ϊ�̰߳�ȫ
																									
	static {
		for (int i = 0; i < 50; i++) {
			list.add(JdbcUtil.getConnection());
		}
		System.out.println("connection  pool has been initized");
	}

	// get certain Connection
	public static Connection getConnection() {
		Connection conn = list.remove(0); // �����Ѿ��õ���ʵ����
		// ʵ�ֶ�Connection ����Ĵ��� [���������ִ�� Ҳ���Ǵ���ִ�� ��� ��ʱ �Ѿ�ʵ���˶�Connection ���д���]
		Connection proxyConnection = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), // ��ȡ��ʵ����������� [��Ϊ�õ���ʵ����],// ʵ�ֶ���ʵ�����еķ������д���,
				new Class[]{Connection.class},// �ӿ�����
				new InvocationHandler() { // ����Է�������ǿ
					@Override  // [�˷�����ʱ�ᱻ����  ����ʱ������ִ��Connection ������ �������õ��÷���ʱ �ᱻ����ִ�� ]
					public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
						Object retVal = null;
						if ("close".equals(arg1.getName())) {
							 list.add(conn); // add �������� boolean ��ʱִֻ�� add()���� ԭ����close()����ִ��    ����Ҫ����ֵ ��Ϊclose() ����ֵΪvoid
						} else {
							retVal = arg1.invoke(conn, arg2);// ���������÷���ʲô�ͷ���ʲô
						}
						return retVal; // ��������� ������ʵ����ķ��� ��ȡ���ķ�������ֵ [ֻ�д������ ���÷���  �Ż��з���ֵ]
					}
				});
		return proxyConnection; // ���Ǹ÷��� ��ΪgetConnection() ����ֵ [���ø÷����ķ���ֵ]
	}
}
