<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.github.candyacao.blog.bean.Post" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>all posts</title>
</head>
<body>
    <%
        List<Post>posts = (List<Post>)(List)request.getAttribute("posts");
    %>
    <ul>
        <% for (Post post: posts) {  %>
            <li><a href="/blog/postview?postid=<%= post.getId()%>"><%=post.getTitle() %></a></li>
        <%} %>
    </ul>
</body>
</html>