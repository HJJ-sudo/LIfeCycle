package com.huangjunjie.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LifeCycleServlet extends HttpServlet {

    // 用一个列表来记录生命周期方法的执行日志
    private List<String> lifecycleLogs = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        String log = "=== 【init()】 Servlet 初始化完成 ===";
        lifecycleLogs.add(log);
        System.out.println(log); // 同时输出到控制台
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String log = "=== 【doGet()】 收到客户端 GET 请求 ===";
        lifecycleLogs.add(log);
        System.out.println(log);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        writer.println("<h1>Servlet生命周期验证页面</h1>");
        writer.println("<p>以下是生命周期方法执行记录：</p>");
        writer.println("<ul style='font-size:18px; color: #2c3e50;'>");
        // 把所有日志输出到页面
        for (String logMsg : lifecycleLogs) {
            writer.println("<li>" + logMsg + "</li>");
        }
        writer.println("</ul>");
        writer.println("<p>刷新页面可观察 doGet() 重复执行</p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
        String log = "=== 【destroy()】 Servlet 被销毁 ===";
        lifecycleLogs.add(log);
        System.out.println(log);
    }
}