<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎注册</title>
</head>
<body>
    <form action="register" method="POST">
        用户名：<input type="text" name="username"><br><br>
        密码：<input type="password" name="password"><br><br>
        再次确认：<input type="password" name="password2"><br><br>
        性别：<input type="radio" name="gender" value="male">男
                 <input type="radio" name="gender" value="female">女<br><br>
                 <input type="submit" value="提交">
    </form>
</body>
</html>