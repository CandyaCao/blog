<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.github.candyacao.blog.bean.Post" %>
    
    <% Post post = (Post)(request.getAttribute("post")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=post.getTitle() %></title>
</head>
<body>
    <h1><%= post.getTitle() %></h1>
    <p><%=post.getAuthor_id() %></p>
    <p><%=post.getContent() %>></p>
</body>
</html>