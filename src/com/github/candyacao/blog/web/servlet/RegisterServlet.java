package com.github.candyacao.blog.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.candyacao.blog.bean.User;
import com.github.candyacao.blog.service.impl.UserServiceImpl;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 接收数据
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		System.out.println("name"+name+" password:"+password+" password2"+password2);
		if (!password.equals(password2)) {
			response.sendRedirect("register.jsp");
			System.out.println("两次密码输入不一致！");
			return;
		}
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setPassword2(request.getParameter("password2"));
		user.setGender(request.getParameter("gender"));
		System.out.println("user from  form"  +user);
		//2. 调用service层方法
		System.out.println("调用service层方法");
		UserServiceImpl serviceImpl = new UserServiceImpl();
		boolean flag = serviceImpl.registerUser(user);
		System.out.println(flag);
		//3.做出响应
		if (flag) {
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("register.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
