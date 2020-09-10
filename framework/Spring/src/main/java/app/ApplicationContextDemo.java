package app;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;
import service.impl.UserServiceImp;

public class ApplicationContextDemo {
    //@Autowired 注入机制  优先按照类型注入 如果存在多个类型 则按照变量名匹配




    public static void main(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        IUserService userService = ac.getBean("userService", UserServiceImp.class);
        userService.add(new User());
    }

}
