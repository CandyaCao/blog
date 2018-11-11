<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发表文章</title>
</head>
<body>
    <form action="post" method="POST">
        请输入文章标题：<input type="text" name="title" ><br><br>
        正文<br>
        <textarea rows="15" cols="25" name="content"></textarea><br><br>
       <input type="submit" value="提交">
    </form>
</body>
</html>