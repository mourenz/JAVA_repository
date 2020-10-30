package com.pqd.curd.bean;

public class Admin {
    public Admin() {
    }

    public Admin(Integer id, String adminName, String adminPwd, Integer instituteID) {
        this.id = id;
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.instituteID = instituteID;
    }

    private Integer id;
    private String adminName;
    private String adminPwd;
    private Integer instituteID;

    public Integer getId() {
        return id;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public Integer getInstituteID() {
        return instituteID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public void setInstituteID(Integer instituteID) {
        this.instituteID = instituteID;
    }
}
