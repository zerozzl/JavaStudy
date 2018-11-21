package com.zerozzl.study.lang.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/test";
	private static String user = "root";
	private static String password = "root";
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;

	// 初始化
	public static Connection init() {
		try {
			// 加载驱动
			Class.forName(driverName);
			// 设置 配置数据
			// 1.url(数据看服务器的ip地址 数据库服务端口号 数据库实例)
			// 2.user
			// 3.password
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			// 开始连接数据库
			System.out.println("数据库连接成功..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 插入
	public static void execUpdate(String sql,
			Object[] params) {
		try {
			pstmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					// 因为问号参数的索引是从1开始，所以是i+1，将所有值都转为字符串形式，好让setObject成功运行
					pstmt.setObject(i + 1, params[i]);
				}
			}
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	// 查询
	public static ResultSet execSelect(String sql,
			Object[] params) {
		ResultSet res = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					// 因为问号参数的索引是从1开始，所以是i+1，将所有值都转为字符串形式，好让setObject成功运行
					pstmt.setObject(i + 1, params[i]);
				}
			}
			res = pstmt.executeQuery();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return res;
	}

	public static void close() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		init();

		// test insert
		String insertSql = "insert into user values(?, ?, ?)";
		Object[] insertParam = new Object[] { 3, "user3", 12 };
		execUpdate(insertSql, insertParam);
		System.out.println("插入数据成功");

		// test update
		String updateSql = "update user set age = ? where id = ?";
		Object[] updateParam = new Object[] { 15, 3 };
		execUpdate(updateSql, updateParam);
		System.out.println("修改数据成功");

		// test delete
		String deleteSql = "delete from user where id = ?";
		Object[] deleteParam = new Object[] { 3 };
		execUpdate(deleteSql, deleteParam);
		System.out.println("删除数据成功");

		// test select();
		String selectSql = "select * from user where age = ?";
		Object[] selectParam = new Object[] { 12 };
		ResultSet res = execSelect(selectSql, selectParam);
		// 遍历结果
		while (res.next()) {
			System.out.print(res.getInt(1) + "\t");
			System.out.print(res.getString(2) + "\t");
			System.out.print(res.getInt(3) + "\t");
			System.out.print("\n");
		}
		res.close();

		close();
	}

}
