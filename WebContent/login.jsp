<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
</head>
<body>
    <form action="login" method="POST">
        <label for="username">用户名：</label><input type="text" name="username" ><br><br>
        <label for="password">密&nbsp;&nbsp;&nbsp;码：</label><input type="password" name="password" ><br><br>
        <input type="submit" value="提交"> 
        <input type="reset" value="重置">
    </form>
</body>
</html>