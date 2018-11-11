package com.github.candyacao.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.candyacao.blog.bean.Post;
import com.github.candyacao.blog.dao.IPostDao;
import com.github.candyacao.blog.utils.ConnectionFactory;

public class PostDaoImpl implements IPostDao {

	@Override
	public boolean savePost(Post post) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "insert into b_post(id,title,author_id,content) values(b_post_seq.nextval,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, post.getTitle());
			pstmt.setLong(2, post.getAuthor_id());
			pstmt.setString(3, post.getContent());
			int count = pstmt.executeUpdate();
			flag = count>0;
			System.out.println(flag+"是否插入成功，成功为true");
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
		return flag;
	}

	@Override
	public boolean deletePost(long id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "delete from b_post where id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, id);
			flag = pstmt.execute();
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
		return flag;
	}

	@Override
	public Post selectByID(long id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from b_post where id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet set = pstmt.executeQuery();
			while (set.next()) {
				Post post = new Post(set.getLong(1), set.getString(2), set.getLong(3), set.getString(4));
				return post;
			}
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
		return null;
	}

	@Override
	public List<Post> selectByAuthotID(long user_id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		List<Post> posts = new ArrayList<Post>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from b_post where author_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, user_id);
			ResultSet set = pstmt.executeQuery();
			while (set.next()) {
				Post post = new Post(set.getLong(1), set.getString(2), set.getLong(3), set.getString(4));
				posts.add(post);
			}
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
		return posts;
	}
}
