package com.huangjunjie.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 注册表单参数获取Servlet
 * 核心功能：用3种方法获取表单提交的参数并展示
 */
public class RegisterServlet extends HttpServlet {

    // 处理POST请求（表单默认提交方式）
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 解决中文乱码（关键！否则获取的中文参数会是问号）
        request.setCharacterEncoding("UTF-8"); // 请求编码（表单提交的参数编码）
        response.setContentType("text/html;charset=UTF-8"); // 响应编码（页面展示编码）

        // 获取页面输出流（用于在页面显示参数）
        PrintWriter out = response.getWriter();

        // 2. 方法1：getParameter() —— 获取单个参数值（最常用）
        out.println("<h2>=== 方法1：getParameter() 获取单个参数 ==</h2>");
        String username = request.getParameter("username"); // 对应表单name="username"
        String password = request.getParameter("password"); // 对应表单name="password"
        String email = request.getParameter("email");       // 对应表单name="email"
        String gender = request.getParameter("gender");     // 对应表单name="gender"
        String birthdate = request.getParameter("birthdate");// 对应表单name="birthdate"

        // 输出单个参数结果
        out.println("用户名：" + username + "<br>");
        out.println("密码：" + password + "<br>");
        out.println("邮箱：" + email + "<br>");
        out.println("性别：" + (gender.equals("male") ? "男" : "女") + "<br>");
        out.println("出生日期：" + birthdate + "<hr>");

        // 3. 方法2：getParameterNames() —— 获取所有参数名（遍历所有表单字段）
        out.println("<h2>=== 方法2：getParameterNames() 获取所有参数名 ==</h2>");
        Enumeration<String> paramNames = request.getParameterNames(); // 枚举所有参数名
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement(); // 逐个获取参数名
            String paramValue = request.getParameter(paramName); // 根据参数名获取值
            out.println("参数名：" + paramName + " → 参数值：" + paramValue + "<br>");
        }
        out.println("<hr>");

        // 4. 方法3：getParameterValues() —— 获取同名参数的所有值（适合复选框等多值场景）
        out.println("<h2>=== 方法3：getParameterValues() 获取多值参数 ==</h2>");
        // 性别是单选框，只有一个值；如果是复选框（比如爱好），会返回多个值
        String[] genderValues = request.getParameterValues("gender");
        if (genderValues != null) {
            out.println("gender参数的所有值：<br>");
            for (String value : genderValues) {
                out.println("→ " + value + "<br>");
            }
        }

        // 关闭输出流
        out.close();
    }

    // 兼容GET请求（方便直接通过URL访问测试）
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response); // 调用POST处理逻辑，GET/POST请求都能处理
    }
}
