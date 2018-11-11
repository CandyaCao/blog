package com.github.candyacao.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.github.candyacao.blog.bean.User;
import com.github.candyacao.blog.dao.IUserDao;
import com.github.candyacao.blog.utils.ConnectionFactory;

public class UserDaoImpl implements IUserDao{

	@Override
	public void saveUser(User user) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "insert into b_user(id,username,password,gender) values(b_user_seq.nextval,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getGender());
			pstmt.execute();
//			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User selectUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectUserByName(String name) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			 connection = ConnectionFactory.getConnection();
			String sql = "select * from b_user where username=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				User user = new User(resultSet.getLong(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));	
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectUserByNameAndPassword(String name, String password) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from b_user where username=? and password=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				User user = new User(resultSet.getLong(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
				System.out.println(resultSet.wasNull());
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
