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
	// shift + ctrl + ���� ����ѡ��
	// shift + ���� ����ѡ����
	// shift + alt + f ����ƥ��
	// alt + ���� �����ƶ���ǰ��
	// shift + enter �����½�һ��
	// ctrl + d ɾ����ǰ��
	// ע���ѹ����뷨�� ctrl + shift + f ���л� ��ͻ
	// ���ٸ��Ƶ�ǰ�� ctrl + shift + ���� [ע����ʾ��ݼ� [�Ҽ� ͼ������ ---��ݼ� ---����]]
	// alt + -> /<-     �ֶ�׷��Դ�� [����]
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionPool.getConnection();
		System.out.println(connection);
		connection.close(); // ���� close()���� ��ʵ�ʾ��� �ڵ��� add()����[��Ϊʵ�ִ�����] 
		ConnectionPool.getConnection().close();// 50
		System.out.println("current size of connection pool:" + ConnectionPool.list.size());

		//
		System.out.println(Msg.setMsgObject("200", "success").addMap("info", "����ɹ�"));
		*/
/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("�������ַ���"); scanner.next(); // �����ַ���
		 * System.out.println("������int"); scanner.nextInt();// ����int float money
		 * = 1000; double salary = 10000.0d; System.out.println(Byte.MAX_VALUE);
		 *//*
 }

	static int titckTotal = 500;

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (App.titckTotal > 0) {
				System.out.println(Thread.currentThread().getName() + "��ʣ___" + titckTotal--);
			} else {
				System.out.println(Thread.currentThread().getName() + "titckTotal Ϊ0�ˣ�������");
				break;
			}
		}
		System.out.println("����ѭ����");
	}

	@Test
	public void test1() {
		App app = new App();
		Thread t1 = new Thread(app);
		Thread t2 = new Thread(app);
		t1.start();
		t2.start();
	}

	// map�ĵ���
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
