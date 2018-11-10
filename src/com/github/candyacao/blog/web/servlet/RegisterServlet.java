package com.github.candyacao.blog.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.candyacao.blog.bean.User;
import com.github.candyacao.blog.service.impl.UserServiceImpl;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 接收数据
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		//2. 调用service层方法
		UserServiceImpl serviceImpl = new UserServiceImpl();
		boolean flag = serviceImpl.registerUser(user);
		//3.做出响应
		if (flag) {
			response.sendRedirect("login.html");
		}else {
			response.sendRedirect("register.html");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
