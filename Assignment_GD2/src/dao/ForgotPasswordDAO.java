package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ForgotPasswordDAO {
private java.sql.Connection connection = null;
	
	public void Connection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-2UOQ2VS:1433;databaseName=USERPASSWORD;encrypt=false";
			String userId = "sa";
			String password = "123456";
			connection = DriverManager.getConnection(url, userId, password);
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}
	}
	
	public boolean ForgotEmail(String Email) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "SELECT * FROM dbo.LOGINFORM WHERE EMAIL = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1,Email);
			rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.println("Error :"+e.toString());
		}
		return false;
		
	}
	
	public int ChangePassword(String Email, String Pass) {
		PreparedStatement ps = null;
		try {
			Connection();
			String sql = "UPDATE dbo.LOGINFORM SET PASSWORD = ? WHERE EMAIL = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1,Pass);
			ps.setString(2,Email);
			
			if(ps.executeUpdate()>0) {
				return 1;
			}
			
			
		} catch (Exception e) {
			System.out.println("Error :"+e.toString());
		}
		
		return -1;
	}
	
}
