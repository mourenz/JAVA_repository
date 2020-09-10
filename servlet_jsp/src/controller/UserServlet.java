package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import poji.Msg;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("这是userServlet");
        System.out.println(request.getParameter("username"));
        Msg msg = new Msg("success",200);
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = response.getWriter();
        mapper.writeValue(writer,msg); // 流的方式输出到浏览器
        writer.close();
    }
}
