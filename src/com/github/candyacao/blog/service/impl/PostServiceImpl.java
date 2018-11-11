package com.github.candyacao.blog.service.impl;

import java.util.List;

import com.github.candyacao.blog.bean.Post;
import com.github.candyacao.blog.bean.User;
import com.github.candyacao.blog.dao.IPostDao;
import com.github.candyacao.blog.dao.impl.PostDaoImpl;
import com.github.candyacao.blog.service.IPostService;

public class PostServiceImpl implements IPostService{

	@Override
	public boolean addPost(Post post) {
		IPostDao postImpl = new PostDaoImpl();
		boolean flag = postImpl.savePost(post);
		return flag;
	}

	@Override
	public boolean delectPost(Post post) {
		IPostDao postImpl = new PostDaoImpl();
		boolean flag = postImpl.deletePost(post.getId());
		return flag;
	}

	@Override
	public List<Post> getPostsByUser(User user) {
		IPostDao postDao = new PostDaoImpl();
		List<Post> posts = postDao.selectByAuthotID(user.getId());
		return posts;
	}

	@Override
	public Post getPostByID(long id) {
		IPostDao postDao = new PostDaoImpl();
		Post post = postDao.selectByID(id);
		return post;
	}

}
