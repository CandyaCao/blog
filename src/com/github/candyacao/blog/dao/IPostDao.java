package com.github.candyacao.blog.dao;

import java.util.List;

import com.github.candyacao.blog.bean.Post;

public interface IPostDao {
	boolean savePost(Post post);
	boolean deletePost(long id);
	Post selectByID(long id);
	List<Post> selectByAuthotID(long user_id);
}
