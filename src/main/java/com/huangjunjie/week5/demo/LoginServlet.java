package com.huangjunjie.week5.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login") // 对应form的action
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 1. 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2. 验证（作业要求：固定账号 DaBing / 123）
        if("DaBing".equals(username) && "123".equals(password)) {
            out.println("Login Success!!!");
            out.println("Welcome " + username);
        } else {
            out.println("Username or Password Error!!!");
        }
    }
}
