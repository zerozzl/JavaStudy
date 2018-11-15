package com.zerozzl.study.lang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zerozzl.study.model.User;

public class JdbcUtils {

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/test";
	private static String user = "root";
	private static String password = "root";
	private static Connection conn = null;
	private static PreparedStatement preparedStatement = null;

	// 初始化
	public static void init() {
		try {
			// 加载驱动
			Class.forName(driverName);
			// 设置 配置数据
			// 1.url(数据看服务器的ip地址 数据库服务端口号 数据库实例)
			// 2.user
			// 3.password
			conn = DriverManager.getConnection(url, user, password);
			// 开始连接数据库
			System.out.println("数据库连接成功..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 插入
	public static void insert() throws SQLException {
		String sql = "insert into user values(?, ?, ?)";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, 3);
		preparedStatement.setString(2, "user3");
		preparedStatement.setInt(3, 12);
		preparedStatement.executeUpdate();
		System.out.println("插入数据成功");
	}

	// 修改
	public static void update() throws SQLException {
		String sql = "update user set age = ? where id = ?";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, 15);
		preparedStatement.setInt(2, 1);
		preparedStatement.executeUpdate();
		System.out.println("修改数据成功");
	}

	// 删除
	public static void delete() throws SQLException {
		String sql = "delete from user where id = ?";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, 3);
		preparedStatement.executeUpdate();
		System.out.println("删除数据成功");
	}

	// 查询
	public static void select() throws SQLException {
		String sqlString = "select * from user where age = ?";
		// 编译sql语句
		// 执行查询
		preparedStatement = conn.prepareStatement(sqlString);
		preparedStatement.setInt(1, 12);
		ResultSet res = preparedStatement.executeQuery();
		// 遍历结果
		while (res.next()) {
			System.out.print(res.getInt(1) + "\t");
			System.out.print(res.getString(2) + "\t");
			System.out.print(res.getInt(3) + "\t");
			System.out.print("\n");
		}
	}

	public static void transaction() {
		String sql = "update user set age = ? where id = ?";
		try {
			conn.setAutoCommit(false);
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, 15);
			preparedStatement.setInt(2, 1);
			preparedStatement.executeUpdate();
			conn.commit();
			System.out.println("修改数据成功");
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		init();
		// insert();
		update();
		delete();
		select();
		transaction();
	}

	// 查询
	public static List<User> selectUser() throws SQLException {
		List<User> users = new ArrayList<User>();
		preparedStatement = conn.prepareStatement("select * from user");
		ResultSet res = preparedStatement.executeQuery();
		// 遍历结果
		while (res.next()) {
			users.add(new User(res.getInt(1), res.getString(2), res.getInt(3)));
		}
		return users;
	}

}
