package com.action;


import com.opensymphony.xwork2.ActionSupport;

public class ActionDemo extends ActionSupport {

    public String reviewJQueryUI() {
        return "reviewJQueryUI";
    }


    public String test() {
        this.addActionError("addActionError()添加的错误信息");
        return "test";
    }

}
