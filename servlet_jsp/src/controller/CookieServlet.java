package controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("cookie__--我被触发了么");
        PrintWriter writer = response.getWriter();
        Cookie[] cookies = request.getCookies();
        System.out.println(Arrays.toString(cookies));
        Cookie cookie = null;
        if(cookies == null ){
           cookie = new Cookie("last", new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss").format(new Date()));
            response.addCookie(cookie);
            System.out.println("第一次访问");
            writer.write("欢迎你，你是第一次登陆");
        }else{
            System.out.println("不是第一次访问");
            for(Cookie cookIe:cookies){
               if(cookIe.getName().equals("last")){
                   writer.write("你上次访问的时间为"+cookIe.getValue());
                   cookIe = new Cookie("last",new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss").format(new Date()));
                   response.addCookie(cookIe);
               }
            }
        }
        writer.close();
    }
}
