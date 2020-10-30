package club.zqg.enter.controller;

import club.zqg.enter.domain.User;
import club.zqg.enter.service.IUserService;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

//ALT+7 查看结构
// ctrl+shift+r 查找和定位文件[只能为文件，文件内容无法定位]
// shift+shift-->查找内容
@RestController
@RequestMapping("user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @RequestMapping("testDate")
    public User getUser(User user){
        return user;
    }

    @RequestMapping("getDate")
    public User getUser02(){
        LOGGER.info("---getUser02()");
       return null;//new User(new Integer(1),"zqg","zqg",new Date());
    }


    @RequestMapping("userList")
    public List<User> getUserList(){
        LOGGER.info("---userList()");
        return userService.getAllUser();//new User(new Integer(1),"zqg","zqg",new Date());
    }
}
