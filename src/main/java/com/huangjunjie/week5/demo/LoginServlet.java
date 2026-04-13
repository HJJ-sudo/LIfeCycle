package com.huangjunjie.week5.demo;


import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // 模拟验证：账号 admin 密码 123
            if ("admin".equals(username) && "123".equals(password)) {
                // 存到request属性
                request.setAttribute("loginUser", username);
                // 转发到用户页
                RequestDispatcher rd = request.getRequestDispatcher("userInfo.jsp");
                rd.forward(request, response);
            } else {
                // 错误信息
                request.setAttribute("error", "用户名或密码错误");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
