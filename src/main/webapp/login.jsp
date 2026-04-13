<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<h2>用户登录</h2>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
        out.println("<p style='color:red'>" + error + "</p>");
    }
%>
<form action="login" method="post">
    用户名：<input name="username"><br>
    密码：<input name="password" type="password"><br>
    <button>登录</button>
</form>
<%@ include file="footer.jsp" %>