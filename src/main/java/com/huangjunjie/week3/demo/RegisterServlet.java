package com.huangjunjie.week3.demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 必须加这个注解！映射路径 /register

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 1. 处理中文乱码
            request.setCharacterEncoding("UTF-8");

            // 2. 作业要求：注册完成 → 重定向到登录页面
            response.sendRedirect("login.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}