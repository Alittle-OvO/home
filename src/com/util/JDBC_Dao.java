package com.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class JDBC_Dao {
	private static final String DRIVERNAME="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/dormitory?useUnicode=true&characterEncoding=utf8";
	private static final String USER="root";
	private static final String PWD="780218";
	
	/* 加载驱动 */
	static {
		try {
			Class.forName(DRIVERNAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 连接数据库 */
	public static Connection getConnection() {
		Connection cnt = null;
		try {
			return cnt = DriverManager.getConnection(URL, USER, PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	/* 关闭连接 */
	public static void close(Connection cnt,PreparedStatement ps,ResultSet rs) {	
		try {
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (cnt!=null) {
				cnt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());

	}
}
