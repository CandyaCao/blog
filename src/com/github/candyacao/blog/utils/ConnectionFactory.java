package com.github.candyacao.blog.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 封装JDBC 1 2 6
 */
public class ConnectionFactory {

//	private static String driverName="oracle.jdbc.OracleDriver";
//	private static String url="jdbc:oracle:thin:@172.16.6.144:1521:xe";
//	private static String user="boss";
//	private static String password="boss";
	private static String driverName;
	private static String url;
	private static String user;
	private static String password;

	static {
		try {
			Properties properties = new Properties();
			// Reader reader=new FileReader("src/com/base/utils/db.properties");
			InputStream reader = ConnectionFactory.class.getResourceAsStream("db.properties");
			// 读取这个文件中的配置信息
			properties.load(reader);

			driverName = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");

			Class.forName(driverName);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// ResultSet Statement Connection
	public static void close(Connection conn, Statement stmt, ResultSet... rs) {
		try {
			if (rs != null) {
				if (rs != null) {
					if (rs.length != 0) {
						// 说明传参数
						ResultSet resultSet = rs[0];
						if (resultSet != null) {
							resultSet.close();
						}
					}
				}
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	public void close(Connection conn,Statement stmt) {
//		
//	}

	public static void main(String[] args) {
		Connection connection = ConnectionFactory.getConnection();
		System.out.println(connection);
	}

}
