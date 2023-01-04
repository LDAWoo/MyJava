package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.JDBCHelper;
import model.ModelAccount;

public class ForgotPasswordDAO {                                   
	
	final String SELECT_BY_EMAIL = "SELECT * FROM dbo.ACCOUNT WHERE EMAIL = ?";
	final String UPDATE_SQL = "UPDATE dbo.ACCOUNT SET PASSWORD = ? WHERE EMAIL = ?";

	public int ForgotEmail(String email) {
		try {		
			ResultSet rs = JDBCHelper.executeQuery(SELECT_BY_EMAIL, email);
			
			while(rs.next()) {
				return 1;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public ArrayList<ModelAccount> SelectALL(String email){
		ArrayList<ModelAccount> datas = new ArrayList<ModelAccount>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_BY_EMAIL, email);
			while(rs.next()) {
				ModelAccount data = new ModelAccount(rs.getString("USERNAME"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("SODIENTHOAI"), rs.getString("ROLE"));
				datas.add(data);
			}
			rs.close();
			return datas;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}
	

	public int ChangePassword(String Email, String Pass) {
		return JDBCHelper.executeUpdate(UPDATE_SQL, Pass, Email);
	
	}

}
