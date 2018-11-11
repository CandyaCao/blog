package com.github.candyacao.blog.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.github.candyacao.blog.bean.Post;
import com.github.candyacao.blog.bean.User;
import com.github.candyacao.blog.service.IPostService;
import com.github.candyacao.blog.service.impl.PostServiceImpl;

@WebServlet("/post")
public class PostServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		Post post = new Post();
		post.setTitle(title);
		post.setContent(content);
		User user = (User) session.getAttribute("user");
		post.setAuthor_id(user.getId());
		IPostService postServiceImpl = new PostServiceImpl();
		boolean flag = postServiceImpl.addPost(post);
		
		if (flag) {
			// 发表成功
			post.getAuthor_id();
			
			response.sendRedirect("author/post");
		}else {
			// 发表失败
			response.sendRedirect("");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
