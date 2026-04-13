<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<h2>用户注册</h2>
<form action="register" method="post">
    用户名：<input name="username"><br>
    密码：<input name="password" type="password"><br>
    <button>注册</button>
</form>
<%@ include file="footer.jsp" %>