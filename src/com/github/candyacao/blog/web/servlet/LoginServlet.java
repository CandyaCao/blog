package com.github.candyacao.blog.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.github.candyacao.blog.bean.User;
import com.github.candyacao.blog.service.IUserService;
import com.github.candyacao.blog.service.impl.UserServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		System.out.println("data from form "+user);
		IUserService userServiceImpl = new UserServiceImpl();
		User user2 = userServiceImpl.loginUser(user);
		System.out.println("will login user " + user2);
		if (user2!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user2);			
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
