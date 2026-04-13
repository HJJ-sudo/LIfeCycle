package com.huangjunjie.week3.demo;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 获取搜索关键词
        String keyword = request.getParameter("keyword");

        out.println("<html>");
        out.println("<head><title>搜索结果</title></head>");
        out.println("<body>");
        out.println("<h2>你搜索的内容：" + keyword + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}