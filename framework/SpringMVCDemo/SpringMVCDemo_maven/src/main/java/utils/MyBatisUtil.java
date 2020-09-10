package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
    private static SqlSessionFactory factory = null;

    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("MyBatis-config.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static SqlSession getSqlSession() {
        return factory.openSession();
    }


    public static void main(String[] args) {
        // System.out.println(factory.openSession());
        // System.out.println(getSqlSession());
        int[] arr = {0, 5, 1, 2, -1, 88, 55, 22};
        insertSort(arr);
        for (int v : arr) {
            System.out.println(v);
        }


    }

    // ≤Â»Î≈≈–Ú
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                //swap(arr,j,j-1);
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }
}


