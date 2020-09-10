package zqg;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

public class JdbcUtil {
	private static Connection connection;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://182.254.244.35:3306/zqg_shop","root","19950117zqg..");
			return connection;			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("get connection exception");
		}
	}
	@Test
	public void test01(){
		System.out.println(JdbcUtil.getConnection());
		System.out.println(JdbcUtil.getConnection());
	}
}
