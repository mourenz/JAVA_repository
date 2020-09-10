package zqg.club.chain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// 实体类
class Msg {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "message='" + message + '\'' +
                '}';
    }
}

//过滤器接口
interface Filter {
    void doFilter(Msg msg);
}

// 脚本语言过滤器
class ScriptFilter implements Filter {
    @Override
    public void doFilter(Msg msg) {
        String message = msg.getMessage();
        String newString1 = message.replace('<', '[');
        String replace = newString1.replace('>', ']');
        msg.setMessage(replace);
    }
}

// 敏感信息过滤器
class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Msg msg) {
        String message = msg.getMessage();
        String newString = message.replace('草', '*');
        msg.setMessage(newString);
    }
}

//笑脸过滤器
class FaceFilte implements Filter {
    @Override
    public void doFilter(Msg msg) {
        String message = msg.getMessage();
        String replace = message.replace(":)", "^V^");
        msg.setMessage(replace);
    }
}


// 多版本过滤器
public class FilterChain implements Filter {
    private List<Filter> chainList = new ArrayList<>();

    public FilterChain add(Filter filter) {
        chainList.add(filter);
        return this; // this 当前 new 的对象
    }
    // 处理过滤

    @Override
    public void doFilter(Msg msg) {
        for (Filter filter : chainList) {
            filter.doFilter(msg);
        }
    }

    @Test
    public void testFilter() {
        Msg msg = new Msg();
        msg.setMessage("<script>:)我草");
        System.out.println("未替换的" + msg);
        FilterChain filterChain = new FilterChain();// 此时的 this 就指向他
        filterChain.add(new SensitiveFilter()).add(new ScriptFilter());


        FilterChain filterChain2 = new FilterChain();
        filterChain2.add(new FaceFilte());


        filterChain.add(filterChain2);

        filterChain.doFilter(msg);


        System.out.println("替换后的" + msg);

        System.out.println("当前链条为\n"+filterChain);
        // FilterChain{
        //  chainList=
        //   [
        //   zqg.club.chain.SensitiveFilter@579bb367,
        //   zqg.club.chain.ScriptFilter@1de0aca6,
        //   FilterChain
        //    {chainList=
        //     [zqg.club.chain.FaceFilte@255316f2]
        //   }
        // ]
        // }

        String m = "cccc";
        String c = m.replace('c', '*');
        System.out.println(c);

    }

    @Override
    public String toString() {
        return "FilterChain{" +
                "chainList=" + chainList +
                '}';
    }
}


