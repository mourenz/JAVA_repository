package club.zqg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化 [将内存对象 存入到 文件]   对象 ObjectOutputStream
 * @author admin
 *
 */
public class SerializedDemo {
	
	public static void main(String[] args)throws Exception {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("E:/user.bat"))); 
		objectOutputStream.writeObject(new String("zzzz"));
		objectOutputStream.writeObject(new String("qqqq"));
		objectOutputStream.writeObject(new String("gggg"));
		objectOutputStream.flush();
		objectOutputStream.close();
		System.out.println("---------");
		
		
		/**
		 * ObjectInputStream反序列化先前使用ObjectOutputStream编写的原始数据和对象。
		 */
		System.out.println("----------------------反序列化-----------------------------------");
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("E:/user.bat")));
		while(true){
			try {
				String object = (String)objectInputStream.readObject();
				System.out.println(object);
			} catch (Exception e) {
				objectInputStream.close();
				break; // 跳出循环
			}
			
		}
	}

}
