package com.github.candyacao.blog.service;

import java.util.List;

import com.github.candyacao.blog.bean.Post;
import com.github.candyacao.blog.bean.User;

public interface IPostService {
	// 增加文章
	boolean addPost(Post post);
	//删除文章
	boolean delectPost(Post post);
	// 根据用户获得所有的post
	List<Post> getPostsByUser(User user);
	Post getPostByID(long id);
}
