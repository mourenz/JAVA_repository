package club.zqg.app;

import club.zqg.dao.MapMapper;
import club.zqg.domain.User;
import club.zqg.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 测试Dao 方法参数为 Map
public class AppMap {


    @Before
    public void before(){
        System.out.println("测试方法之前执行方法");
    }

    @Test
    public void testMap(){
        System.out.println("map参数的方法");
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        System.out.println(sqlSession);
        MapMapper mapper = sqlSession.getMapper(MapMapper.class);
        Map<String,String> map = new HashMap<>();
        map.put("name","d");
        List<User> ambiguousStudeng = mapper.getAmbiguousStudeng(map);
        for(User user:ambiguousStudeng){
            System.out.println(user.getUsername());
        }
    }
}
