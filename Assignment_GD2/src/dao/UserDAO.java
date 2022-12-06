package dao;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.UserModel;
import view.LoginUserView;


public class UserDAO {

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


	public String selectAll(String user, String password) {
		PreparedStatement ps = null;
		ResultSet rs=null;
		String Role = new String();
		try {
			Connection();
			String sql = "SELECT * FROM LOGINFORM WHERE USERNAME = ? AND PASSWORD = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				Role = rs.getString("ROLE");
			
			}	
			return Role;
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		} finally {
			try {
				ps.close();
				rs.close();
				connection.close();
			} catch (Exception e2) {

			}
		}
		return "";
		
	}
	
	public int Insert(String username, String Email, String Password,String Role) {
		PreparedStatement ps = null;
		try {
			Connection();
			String sql = "INSERT INTO LOGINFORM\r\n"
					+ "VALUES(?,?,?,?)";
			ps= connection.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,Password);
			ps.setString(3,Email);
			ps.setString(4,Role);
			ps.executeUpdate();
			return 2;
		} catch (Exception e) {
			String Error = e.toString(); 	
			String userError = "com.microsoft.sqlserver.jdbc.SQLServerException: Violation of PRIMARY KEY constraint "
					+ "'PK__LOGINFOR__B15BE12F7D3F9113'. "
					+ "Cannot insert duplicate key in object 'dbo.LOGINFORM'. "
					+ "The duplicate key value is ("+username.trim()+").";
			String emailError = "com.microsoft.sqlserver.jdbc.SQLServerException: Violation of UNIQUE KEY constraint "
					+ "'UQ__LOGINFOR__161CF724E080B635'. "
					+ "Cannot insert duplicate key in object 'dbo.LOGINFORM'. "
					+ "The duplicate key value is ("+Email.trim()+").";
			if(userError.equals(Error)) {
				return 1;
			}else if(emailError.equals(Error)) {
				return 0;
			}	
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e2) {
				
			}
		} 
		return -1;
	}
	
	
	
}
