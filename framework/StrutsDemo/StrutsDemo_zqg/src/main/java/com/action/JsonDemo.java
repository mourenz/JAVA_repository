package com.action;

import com.enity.UserStruts;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;
import com.service.impl.UserServiceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//多例
public class JsonDemo extends ActionSupport implements ModelDriven<Map<String, Object>> {

    private List<UserStruts> userList;//对象驱动

    public List<UserStruts> getUserList() {
        System.out.println("getUserList方法执行了......");
        return userList;
    }

    private Map<String, Object> map = new HashMap();

    @Override
    public Map<String, Object> getModel() {
        return map;
    }


    private int count;

    private static int static_count;

    private UserService userService = new UserServiceImp();


    public JsonDemo() {
        System.out.println("构造器执行了.......");
        System.out.println("count:" + count);
        System.out.println("staticCount:" + static_count);
        count++;
        static_count++;
    }


    public String list() {
        System.out.println("list方法执行了......");
        userList = userService.findAllUser();
        return "jsonList";
    }

    public String map() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UserStruts(UserStruts.test_name, UserStruts.test_pwd));
        map.put("mapResult", arrayList);
        return "jsonList";
    }

    public String testNoResult() {
        return "jsonList";
    }


    public String sayHello(String hello, int i) {
        return hello + i;
    }


}
