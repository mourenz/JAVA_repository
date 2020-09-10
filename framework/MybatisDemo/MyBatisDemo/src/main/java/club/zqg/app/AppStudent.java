package club.zqg.app;

import club.zqg.dao.StudentMapper;
import club.zqg.domain.Student;
import club.zqg.domain.condition.StudentQueryObject;
import club.zqg.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class AppStudent {
    public static void main(String[] args){
        AppStudent appStudent = new AppStudent();
        appStudent.queryOne();
        //appStudent.advanceQuery();
        appStudent.quertCount();

    }

    void queryOne(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);


        Student student = mapper.queryOne("110");
        System.out.println(student.getsName()+"---"+student.getSex());
    }

    void queryList(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.queryAll();
        for(Student student:students){
            System.out.println(student.getsName());
        }
    }

    // 批量删除
    void batchDelete(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.batchDelete(new String[]{"120","130"});
        sqlSession.commit();
        sqlSession.close();
    }

    // 高级查询
    void advanceQuery(){
        StudentQueryObject studentQueryObject = new StudentQueryObject();
        studentQueryObject.setKeyword("朱启刚");
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> infoByObjectCondition = mapper.findInfoByObjectCondition(studentQueryObject);
        for (Student stu:infoByObjectCondition){
            System.out.println(stu.getsNum());
        }
    }

    // 查询记录个数
    void quertCount(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int count = mapper.count();
        System.out.println(count);
    }

}
