/*
package app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

import zqg.ConnectionPool;
import zqg.Msg;

@SuppressWarnings("all")
public class App implements Runnable {
	// shift + ctrl + 左右 快速选中
	// shift + 上下 快速选中行
	// shift + alt + f 万能匹配
	// alt + 上下 快速移动当前行
	// shift + enter 向下新建一行
	// ctrl + d 删除当前行
	// 注意搜狗输入法的 ctrl + shift + f 简繁切换 冲突
	// 快速复制当前行 ctrl + shift + 上下 [注意显示快捷键 [右键 图形属性 ---快捷键 ---禁用]]
	// alt + -> /<-     手动追踪源码 [来回]
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionPool.getConnection();
		System.out.println(connection);
		connection.close(); // 调用 close()方法 其实质就是 在调用 add()方法[因为实现代理了] 
		ConnectionPool.getConnection().close();// 50
		System.out.println("current size of connection pool:" + ConnectionPool.list.size());

		//
		System.out.println(Msg.setMsgObject("200", "success").addMap("info", "处理成功"));
		*/
/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("请输入字符串"); scanner.next(); // 接受字符串
		 * System.out.println("请输入int"); scanner.nextInt();// 接受int float money
		 * = 1000; double salary = 10000.0d; System.out.println(Byte.MAX_VALUE);
		 *//*
 }

	static int titckTotal = 500;

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (App.titckTotal > 0) {
				System.out.println(Thread.currentThread().getName() + "还剩___" + titckTotal--);
			} else {
				System.out.println(Thread.currentThread().getName() + "titckTotal 为0了！！！！");
				break;
			}
		}
		System.out.println("结束循环了");
	}

	@Test
	public void test1() {
		App app = new App();
		Thread t1 = new Thread(app);
		Thread t2 = new Thread(app);
		t1.start();
		t2.start();
	}

	// map的迭代
	@Test
	public void test02() {
		Map<String, String> getenv = System.getenv();
		for (Map.Entry<String, String> entry : getenv.entrySet()) {
			System.out.println("----" + entry.getKey() + "----" + entry.getValue());
		}
		System.out.println();
	}

}
*/
