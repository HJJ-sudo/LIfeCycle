<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<html>
<head>
    <title>JavaWeb 首页</title>
    <style>
        ul li {
            list-style: none;
            margin: 10px 0;
        }
        a {
            font-size: 18px;
            color: #2c3e50;
            text-decoration: none;
        }
        a:hover {
            color: #3498db;
            text-decoration: underline;
        }
        .search-box {
            margin: 20px 0;
            padding: 15px;
            border: 1px solid #eee;
            border-radius: 4px;
            width: 400px;
        }
        .search-box input {
            width: 250px;
            padding: 5px;
            margin-right: 10px;
        }
        .search-box button {
            padding: 5px 15px;
            background: #2c3e50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>✅ JavaWeb 项目启动成功！</h1>
<p>你可以访问：</p>

<!-- 搜索功能：action="search" 对应 web.xml /search -->
<div class="search-box">
    <h3>Exercise2 搜索功能</h3>
    <form action="search" method="get">
        搜索内容：<input type="text" name="keyword" placeholder="请输入关键词">
        <button type="submit">提交搜索</button>
    </form>
</div>

<ul>
    <li><a href="lifeCycle">Servlet生命周期验证</a></li>
    <li><a href="registerServlet">register表单参数获取</a></li>
    <li><a href="login.jsp">点击登录</a></li>
    <li><a href="register.jsp">点击注册</a></li>
    <li><a href="MyJsp.jsp">include指令复用页面示例</a></li>
</ul>

</body>
</html>

<%@ include file="footer.jsp" %>