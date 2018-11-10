package com.github.candyacao.blog.dao;

import java.util.List;

import com.github.candyacao.blog.bean.User;

/**
 * I代表接口，User代表操作User类，dao代表dao层的代码
 * @author candyacao
 * @created 2018年11月3日 下午7:17:49
 */
public interface IUserDao {
	//1. 保存
	void saveUser(User user);
	//2. 更新
	int updateUser(User user);
	//3. 删除
	void deleteUser(Long id);
	//4. 查询  find select
	User selectUserById(Long id);
	User selectUserByName(String name);
	User selectUserByNameAndPassword(String name, String password);
	List<User> selectAllUser();
}
