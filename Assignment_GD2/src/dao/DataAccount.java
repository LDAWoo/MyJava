package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import view2.Card;
import view2.Card2;
import view2.Card3;


public class DataAccount {
	
	private java.sql.Connection connection = null;
	private Card card;
	private Card2 card2;
	private Card3 card3;
	
	public DataAccount(Card card) {
		this.card = card;
	}
	
	public DataAccount(Card2 card2) {
		this.card2 = card2;
	}
	
	public DataAccount(Card3 card3) {
		this.card3 = card3;
	}
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
	
	public void AmountAccoutAdmin() {
		PreparedStatement ps =null;
		ResultSet rs = null;
		int amount =0;
		try {
			Connection();
			String sql = "SELECT COUNT(*) AS AMOUNT FROM LOGINFORM WHERE ROLE = 'Admin'";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				amount = rs.getInt("AMOUNT");
				card.getLblValues().setText(amount+"");
			}

			ps.close();
			rs.close();
			connection.close();
		} catch (Exception e) {
			
		}
		
	}
	

	public void AmountAccoutUser() {
		PreparedStatement ps =null;
		ResultSet rs = null;
		int amount =0;
		try {
			Connection();
			String sql = "SELECT COUNT(*) AS AMOUNT FROM LOGINFORM WHERE ROLE = 'User'";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				amount = rs.getInt("AMOUNT");
				card2.getLblValues().setText(amount+"");
			}

			ps.close();
			rs.close();
			connection.close();
		} catch (Exception e) {
			
		}
	}
	
	// SELECT COUNT(*) AS AMOUNT FROM STUDENTS
	
	public void AmountStudent() {
		PreparedStatement ps =null;
		ResultSet rs = null;
		int amount =0;
		try {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://DESKTOP-2UOQ2VS:1433;databaseName=MANAGERGRADE;encrypt=false";
				String userId = "sa";
				String password = "123456";
				connection = DriverManager.getConnection(url, userId, password);
			} catch (Exception e) {
				System.out.println("Error:" + e.toString());
			}
			String sql = "SELECT COUNT(*) AS AMOUNT FROM STUDENTS";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				amount = rs.getInt("AMOUNT");
				card3.getLblValues().setText(amount+"");
			}

			ps.close();
			rs.close();
			connection.close();
		} catch (Exception e) {
			
		}
	}
	
}
