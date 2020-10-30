package club.zqg.enter.mapper;

import club.zqg.enter.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<User> selectAllUser();

    List<User> selectAllUserOfMap(Map<String,Object> paramter);
}
