package com.github.candyacao.blog.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.candyacao.blog.bean.Post;
import com.github.candyacao.blog.service.IPostService;
import com.github.candyacao.blog.service.impl.PostServiceImpl;

/**
 * Servlet implementation class PostViewServlet
 */
@WebServlet("/postview")
public class PostViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long postID = Integer.parseInt(request.getParameter("postid"));
		IPostService postService = new PostServiceImpl();
		Post post = postService.getPostByID(postID);
		request.setAttribute("post", post);
		this.getServletContext().getRequestDispatcher("/showPost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
