<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<h2>用户信息</h2>
<%
    String user = (String) request.getAttribute("loginUser");
%>
欢迎你：<%= user %>
<%@ include file="footer.jsp" %>