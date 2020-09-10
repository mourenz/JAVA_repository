package club.zqg.utils;

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
        System.out.println(factory.openSession());
        // System.out.println(getSqlSession());
    }
}
