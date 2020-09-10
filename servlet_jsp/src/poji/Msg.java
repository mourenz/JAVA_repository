package poji;

public class Msg {

    public Msg() {
    }

    public Msg(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    private String msg; // 信息
    private Integer code; // 状态码

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
