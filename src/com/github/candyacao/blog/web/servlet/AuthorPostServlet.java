package com.github.candyacao.blog.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.candyacao.blog.bean.Post;
import com.github.candyacao.blog.bean.User;
import com.github.candyacao.blog.service.IPostService;
import com.github.candyacao.blog.service.impl.PostServiceImpl;

@WebServlet("/author/post")
public class AuthorPostServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		IPostService postServiceImpl = new PostServiceImpl();
		
		List<Post> posts = postServiceImpl.getPostsByUser(user);
		System.out.println(posts.size());
		request.setAttribute("posts", posts);
		ServletContext application = this.getServletContext(); 
		RequestDispatcher rd = application.getRequestDispatcher("/posts.jsp"); 
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
