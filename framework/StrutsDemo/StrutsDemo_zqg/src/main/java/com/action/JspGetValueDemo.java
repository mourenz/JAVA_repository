package com.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.enity.UserStruts;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.service.impl.UserServiceImp;
import org.apache.struts2.ServletActionContext;

import java.util.Arrays;
import java.util.List;

public class JspGetValueDemo extends ActionSupport {



    //jsp获取字符串
    private String jspString;

    public String getJspString() {
        return jspString;
    }


    private List<UserStruts> userList;

    //此方法调用只是在页面渲染时调用
    public List<UserStruts> getUserList() {
        System.out.println("getMethod执行了......");
        System.out.println("getMethod执行了" + userList);
        return userList;
    }

    //业务对象
    private UserService userService = new UserServiceImp();

    public String stringValue() {
        jspString = "StringValue";
        return "ajaxOrPush";
    }

    //jsp获取List集合
    public String listValue() {
        userList = userService.findAllUser();
        System.out.println("listValue" + Arrays.toString(userList.toArray()));
        return "ajaxOrPush";
    }

    //jsp获取值栈list  set方式存入值栈
    public String valueStackGet() {
        ActionContext.getContext().getValueStack().set("userlist", userService.findAllUser());
        return "ajaxOrPush";
    }

    //jsp获取值栈list push方式存入值栈
    public String  valueStackGetOfPush(){
        //push存入的数据是存入root区域，jsp 在获取的时候，是直接获取
        ActionContext.getContext().getValueStack().push(userService.findUsersWithPage());

        //通过域存入的数据  jsp在获取的时候，只能通过  #域.键值.xx
        ServletActionContext.getRequest().setAttribute("user_request",new UserStruts(UserStruts.test_name+"_request_scope", UserStruts.test_pwd));
        ServletActionContext.getServletContext().setAttribute("user_application",new UserStruts(UserStruts.test_name+"_application_scope", UserStruts.test_pwd));
        return "ajaxOrPush";
    }


    //ajax获取集合
    public String ajaxGetList()throws Exception {
        String userListString = JSON.toJSONString(userService.findAllUser());
        JSONArray jsonArray = JSONArray.parseArray(userListString);
        ServletActionContext.getResponse().getWriter().print(jsonArray);
        return NONE;
    }
}
