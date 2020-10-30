package com.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.enity.UserStruts;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.Arrays;
import java.util.List;

public class FastJsonDemo extends ActionSupport {

    public String fastJsonReturn() throws Exception{
        List<UserStruts> users = Arrays.asList(new UserStruts("zzz", "zzz"), new UserStruts("qqq", "qqq"));
        String listString = JSON.toJSONString(users);
        System.out.println("listString"+listString);
        JSONArray jsonArray = JSONArray.parseArray(listString);
        System.out.println("jsonArray"+jsonArray);
        ServletActionContext.getResponse().getWriter().print(jsonArray);
        return NONE;
    }
}
