package club.zqg.app;

import club.zqg.dao.UserMapper;
import club.zqg.domain.User;
import club.zqg.utils.MyBatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import java.util.Map;
import java.sql.Connection;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class App {
    public static void main(String[] args) {
        System.out.println("------");
        new App().useringMappCompent();
    }

    @Test
    public void test() {
        /*
        InputStream rin = Resources.getResourceAsStream("MyBatis-config.xml");
//        InputStream in = new FileInputStream("D:\\MyBaitsDemo\\MyBaitsDemo\\resouce\\MyBatis-config.xml");
        System.out.println(rin);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(rin);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        */
        //使用工具类
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//        获取单条记录 有漏洞，字符串写错 检查不出
        User user = sqlSession.selectOne("domain.User.get", "zqg");
        //获取所有数据
        List<User> users = sqlSession.selectList("domain.User.listAll");
        sqlSession.close();
        System.out.println(user.getUsername());
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void updateData() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User();
        user.setUsername("zqg");
        user.setPassword("zqg");
        int update = sqlSession.update("domain.User.update", user);
        sqlSession.commit();// 手动提交
        sqlSession.close();
        System.out.println(update);
    }

    @Test
    public void insertData() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User();
        user.setId(1111);
        user.setUsername("zqg2");
        user.setPassword("zqg2");
        int insert = sqlSession.insert("domain.User.insert", user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(insert);
    }

    //map封装
    @Test
    public void mapResult() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Map<String, String>> list = sqlSession.selectList("club.zqg.domain.User.querySomeCol");
        for (Map<String, String> map : list) {
            System.out.println(map);
        }
    }

    //使用mapper组件
    @Test
    public void useringMappCompent() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //使用mapper组件 mapper组件==接口+映射配置文件
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //User zqg = mapper.get("zqg"); // get方法 写
        //System.out.println(user.getUsername());
        PageHelper.startPage(1, 2); // 设置分页
        List<User> users = mapper.listAll();
        for (User u : users) {
            System.out.println(u);
        }
        PageInfo<User> userPageInfo = new PageInfo<>(users,2); // 对结果集进行封装
        System.out.println("总的集合"+userPageInfo.getList());
        System.out.println("下一页"+userPageInfo.getNextPage());
        System.out.println("当前页数"+userPageInfo.getPageNum());
        System.out.println("总页数"+userPageInfo.getPages());
        System.out.println("尾行"+userPageInfo.getEndRow());
        System.out.println("下一页"+userPageInfo.getNextPage());
        System.out.println("上一页"+userPageInfo.getPrePage());

        //Page<User> page = new Page<User>();  不用

      /*  // insert
        User user1 = new User();
        user1.setId("mapper3");
        user1.setUsername("mapper");
        user1.setPassword("maper Compent");
        mapper.insert(user1);
        //update
        user1.setId("uuuuuu-9");
        user1.setUsername("new_name");
        user1.setPassword("new_pwd");
        mapper.update(user1);

        //delete
        mapper.delete(user1);*/
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testQueryWithWhere(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //使用mapper组件 mapper组件==接口+映射配置文件
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,null,"zqg");
        User user1 = mapper.get(user);
        System.out.println(user1);

        //
        mapper.updateInfo(new User(6,"zqg","zqg"));

        sqlSession.commit();
        sqlSession.close();
    }


    //单个参数
    @Test
    public void testOneParamter(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Connection connection = sqlSession.getConnection();
        System.out.println(connection);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer id = mapper.getIdByUname("zqg");
        System.out.println(id);
        sqlSession.close();
    }
    
    
    //多个参数
    @Test
    public void testManyParamters() {
    	 SqlSession sqlSession = MyBatisUtil.getSqlSession();
    	 UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    	 mapper.updateUser("zqg_update", 5);
    	 sqlSession.close();
    }
    
    // 参数为数组 数组迭代
    @Test
    public void testArrayParamter() {
    	 SqlSession sqlSession = MyBatisUtil.getSqlSession();
    	 UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    	 List<String> nameList = mapper.getNameListById(new int[] {5,6,7,8,9});
    	 for(String name:nameList) {
    		 System.out.println(name);
    	 }
    	
    }


}
