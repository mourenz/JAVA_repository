package club.zqg.dao;

import club.zqg.domain.Student;
import club.zqg.domain.condition.StudentQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {


    void save(Student student);
    void delete(Student student);
    Student queryOne(@Param("sNum") String sNum);
    List<Student> queryAll();
    void batchDelete(@Param("sNum") String[] sNum);
    // 高级查询
    List<Student> findInfoByObjectCondition(StudentQueryObject studentQueryObject);

    // 查询记录个数
    int count();



}
