package jdbc;

import java.awt.image.ColorConvertOp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class JDBCHelper {
	
	public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String url = "jdbc:sqlserver://DESKTOP-2UOQ2VS:1433;databaseName=DUANMAUSOF203;encrypt=false";
	public static String use = "sa";
	public static String password = "123456";
	public static java.sql.Connection connection;
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static int executeUpdate(String sql, Object... args) {
		try {
			PreparedStatement stmt = preparedStatement(sql, args);
			try {
				return stmt.executeUpdate();
			} catch (Exception e) {
				stmt.getConnection().close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return -1;
	}
	
	public static void Connection() throws Exception{
		connection = DriverManager.getConnection(url, use, password);
	}
	
	public static PreparedStatement preparedStatement(String sql, Object... args) throws Exception {
		Connection();
		PreparedStatement pstmt = null;
		
		if(sql.trim().endsWith("{")) {
			pstmt = connection.prepareCall(sql);
		}else {
			pstmt = connection.prepareStatement(sql);
		}
		
		for (int i = 0; i < args.length; i++) {
			pstmt.setObject(i + 1, args[i]);
		}
		
		return pstmt;
	}
	
	public static ResultSet executeQuery(String sql, Object...args) {
		try {
			PreparedStatement pstmt = preparedStatement(sql, args);
			return pstmt.executeQuery();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static Object value(String sql, Object... args) {
		try {
			ResultSet rs = executeQuery(sql, args);
			if(rs.next()) {
				return rs.getObject(0);
			}
			
			rs.getStatement().getConnection().close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	
}
