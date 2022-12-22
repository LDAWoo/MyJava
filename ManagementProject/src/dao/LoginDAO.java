package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import interfaces.DAOInterfaceLogin;
import jdbc.JDBCHelper;

public class LoginDAO implements DAOInterfaceLogin{

	final String SELECT_ALL_SQL = "SELECT * FROM ACCOUNT WHERE EMAIL = ? AND PASSWORD = ?";
	
	final String INSERT_SQL = "INSERT INTO dbo.ACCOUNT\r\n"
			+ "(USERNAME,PASSWORD,EMAIL,SODIENTHOAI,ROLE)\r\n"
			+ "VALUES\r\n"
			+ "(?,?,?,?,?)";
	
	@Override
	public String SellectAll(String email, String password) {
		ResultSet rs = null;
		
		String Role = "";
		
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_SQL, email, password);
			
			while(rs.next()) {
				Role = rs.getString("ROLE");
			}
			return Role;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int Insert(String codeStudent, String email, String password, String role) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
