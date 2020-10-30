package club.zqg.domain;

public class Student {
    private String sNum;
    private String sName;
    private String sex;
    private Integer age;
    private Integer cid;
    private Integer majorId;
    private Integer depId;
    private Integer yearId;
    private Integer iid;

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setsNum(String sNum) {
        this.sNum = sNum;
    }

    public void setDepId(Integer deptId) {
        this.depId = deptId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getCid() {
        return cid;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public String getsName() {
        return sName;
    }

    public Integer getDepId() {
        return depId;
    }

    public String getsNum() {
        return sNum;
    }

    public Integer getIid() {
        return iid;
    }

    public Integer getYearId() {
        return yearId;
    }

}
