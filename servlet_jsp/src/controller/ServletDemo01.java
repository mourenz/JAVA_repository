package controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo01 extends HttpServlet {

    public ServletDemo01() {
        System.out.println("ServletDemo01 已经被创建"); // 第一次访问才创建  由服务器创建
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("flag").equals("showSomething")){
            showSomething(request,response);
        }
        if(request.getParameter("flag").equals("manyParamter")){
            manyParamter(request,response);
        }

    }

    public void manyParamter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String[] types = request.getParameterValues("type");
        response.setContentType("text/html charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(types!=null){
            for(String type:types){
                System.out.println("type--"+type);
            }
            writer.close();
        }
        System.out.println("执行完毕");
    }

    public void showSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("当前 this为"+this);
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8"); // 告知浏览器返回的是 html内容 用编码为utf-8
        System.out.println("获取请求方法"+request.getMethod()+"请求协议"+request.getProtocol()+"获取用户代理"+request.getHeader("User-Agent"));
        System.out.println("获取请求对象"+request);
        ServletContext servletContext = this.getServletContext(); // 项目上下文 整个项目只有一个
        System.out.println(servletContext.getRealPath("/index.jsp")); // 获取部署路径
    }
}
