package com.github.candyacao.blog.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.github.candyacao.blog.bean.User;
import com.github.candyacao.blog.dao.IUserDao;
import com.github.candyacao.blog.dao.impl.UserDaoImpl;
import com.github.candyacao.blog.service.IUserService;

public class UserServiceImpl implements IUserService{

	@Override
	public boolean registerUser(User user) {
	    //业务逻辑  注册用户
		//判断用户名是否被占用  需要借助于dao层
		//构建一个dao层实例
		IUserDao daoImpl = new UserDaoImpl();
		//调用对应方法
		User user2 = daoImpl.selectUserByName(user.getName());
		System.out.println("aaaaaaaaaaaaaaaaa");
		System.out.println("USER FROM DB" + user2);
		if (user2 == null) {
			System.out.println("该用户名没有被占用");
			//该用户名没有被占用
			//直接注册
			daoImpl.saveUser(user);
			return true;
		}else {
			//该用户被占用
			System.out.println("该用户被占用");
			//响应一个错误   error.html  register.html
			return false;
			
		}
	
	}

	@Override
	public User loginUser(User user) {
		IUserDao userDaoImpl = new UserDaoImpl();
		User user1 = userDaoImpl.selectUserByNameAndPassword(user.getName(), user.getPassword());
		return user1;
	}

	@Override
	public void updateUser(User user) {
				
	}

	@Override
	public void deleteUser(User user) {
		
	}

}
