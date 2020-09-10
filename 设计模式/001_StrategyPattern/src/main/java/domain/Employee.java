package domain;

public class Employee {
    private String ename;
    private String eid;

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "ename='" + ename + '\'' +
                ", eid='" + eid + '\'' +
                '}';
    }

    public Employee(String ename, String eid) {
        this.ename = ename;
        this.eid = eid;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public String getEid() {
        return eid;
    }
}
