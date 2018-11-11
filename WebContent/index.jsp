<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.github.candyacao.blog.bean.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome</title>
</head>
<body>
    欢迎<%=((User)session.getAttribute("user")).getName()%>登录
</body>
</html>