package com.github.candyacao.blog.service;

import com.github.candyacao.blog.bean.User;

/** 业务逻辑 */
public interface IUserService {
	//注册用户
	boolean registerUser(User user);
	//登陆用户
	User loginUser(User user);
	//修改用户
	void updateUser(User user);
	//注销用户
	void deleteUser(User user);
}
