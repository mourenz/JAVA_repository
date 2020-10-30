package club.zqg.dao;

import club.zqg.domain.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    void updateInfo(User user);
    void deleteUser(User user);
    void save(User user);
    User get(User user);
    List<User> listAll();

    // 参数为 普通数据类型 [String]
    Integer getIdByUname(String uname);
    
    
    // 多个参数
    void updateUser(@Param("uname")String uname,@Param("uid")Integer uid);
    
    
    // 参数为数组 时的 遍历
    List<String> getNameListById(@Param("idArray")int[] idArray);

}
