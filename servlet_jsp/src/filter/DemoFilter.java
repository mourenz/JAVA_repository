package filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DemoFilter implements Filter {
    public DemoFilter() {
        System.out.println("过滤器构造方法");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化方法");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行过滤器");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8"); // 服务器返回的是字符 告诉浏览器需要用什么字符集去解析
        response.setContentType("text/html charset=utf-8");  // 这个是告诉浏览器服务器返回的是什么类型的数据，必须指定 ，负责就是乱码
        filterChain.doFilter(request,response);
        System.out.println("返回经过过滤器");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁方法");
    }
}
