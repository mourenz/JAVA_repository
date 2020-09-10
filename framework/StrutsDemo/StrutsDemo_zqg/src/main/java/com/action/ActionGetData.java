package com.action;

import com.enity.UserStruts;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ActionGetData extends ActionSupport {
    // 封装list[必须提供 get set方法]
    private List<UserStruts> users;

    //封装Map[必须提供 get set方法]
    private Map<String, UserStruts> userMap;

    public Map<String, UserStruts> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, UserStruts> userMap) {
        this.userMap = userMap;
    }

    public void setUsers(List<UserStruts> users) {
        this.users = users;
    }

     //必须提供get方法    否则不能注入
    public List<UserStruts> getUsers() {
        return users;
    }

    public String listData(){
        System.out.println(Arrays.toString(users.toArray()));
        return NONE;
    }

    public String mapData(){
        Set<String> keySet = userMap.keySet();
        for (String key:keySet){
            System.out.println(userMap.get(key));
        }
        return NONE;
    }


    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}
