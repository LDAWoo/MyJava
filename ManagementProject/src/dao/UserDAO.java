package dao;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOInterfaceLogin;
import jdbc.JDBCHelper;
import model.ModelAccount;
import model.UserModel;
import view.LoginUserView;


public class UserDAO {
final String SELECT_ALL_SQL = "SELECT * FROM ACCOUNT";
	
	final String INSERT_SQL = "INSERT INTO dbo.ACCOUNT\r\n"
			+ "(USERNAME,PASSWORD,EMAIL,SODIENTHOAI,ROLE)\r\n"
			+ "VALUES\r\n"
			+ "(?,?,?,?,?)";


	public ArrayList<ModelAccount> SellectAll() {
		ArrayList<ModelAccount> datas = new ArrayList<ModelAccount>();
		ResultSet rs = null;
		try {
			 rs = JDBCHelper.executeQuery(SELECT_ALL_SQL);
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


	public int Insert(ModelAccount E) {
		return	JDBCHelper.executeUpdate(INSERT_SQL, E.getUsername(),E.getPassword(),E.getEmail(),E.getPhoneNumber(),E.getRole());
	}
	
	
	
	
}
