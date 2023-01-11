package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCHelper {
	public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String url = "jdbc:sqlserver://DESKTOP-2UOQ2VS:1433;databaseName=PRODUCTMANAGEMENTSYSTEM;encrypt=false";
	public static String username = "sa";
	public static String password = "123456";
	public static java.sql.Connection connection;
	
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Connection()throws Exception{
		connection = DriverManager.getConnection(url, username, password);
	}
	
	public static PreparedStatement preparedStatement(String sql, Object...args) {
		PreparedStatement pstmt =null;
		try {
			Connection();
			if(sql.startsWith("{")) {
				pstmt = connection.prepareCall(sql);
			}else {
				pstmt = connection.prepareStatement(sql);
			}
			
			for (int i = 0; i < args.length; i++) {
				pstmt.setObject(i +1, args[i]);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		return pstmt;
	}
	
	public static int executeUpdate(String sql,Object...args) {
		try {
			PreparedStatement pstmt = preparedStatement(sql, args);
			try {
				return pstmt.executeUpdate();
			} catch (Exception e) {
				pstmt.getConnection().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public static ResultSet executeQuery(String sql, Object...args) {
		try {
			PreparedStatement pstmt = preparedStatement(sql, args);
			return pstmt.executeQuery();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static Object value(String sql, Object...args) {
		try {
			ResultSet rs = executeQuery(sql, args);
			if(rs.next()) {
				return rs.getObject(0);
			}
			rs.getStatement().getConnection().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
