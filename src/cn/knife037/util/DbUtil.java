package cn.knife037.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/platform?"
					+ "useUnicode=true&characterEncoding=utf-8&useSSL=false&user=root&password=root";
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static PreparedStatement preparedStatement(Connection conn, String sql) {
		PreparedStatement  pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return pstmt;
	}
	
	public static ResultSet getResult(PreparedStatement pstmt) {
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static void update(PreparedStatement pstmt) {
		try {
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(AutoCloseable closeable) {
		try {
			if(closeable != null) {
				closeable.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
