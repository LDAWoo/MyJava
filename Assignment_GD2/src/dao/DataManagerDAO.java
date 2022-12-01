package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ManagerStudentModel;
import view.ManagerStudentView;
import view2.ModelManager;
import view2.TableManager;

public class DataManagerDAO implements DAOInterface3<ModelManager> {
	private TableManager view;
	private java.sql.Connection connection = null;

	public DataManagerDAO(TableManager view) {
		this.view = view;
	}

	public void Connection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-2UOQ2VS:1433;databaseName=MANAGERGRADE;encrypt=false";
			String userId = "sa";
			String password = "123456";
			connection = DriverManager.getConnection(url, userId, password);
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}
	}

	@Override
	public int Delete(String Code) {
		PreparedStatement ps = null;

		try {
			Connection();
			String sql = "DELETE STUDENTS WHERE MASV = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, Code);
			if (ps.executeUpdate() > 0) {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {
			}
		}
		return -1;
	}

	
	public int Update (String Code,String Name, String Email, String PhoneNumber,boolean Sex,String Address) {
		PreparedStatement ps = null;
		
		try {
			Connection();
			String sql = "UPDATE STUDENTS SET HOTEN = ?, EMAIL = ?,SODT = ?,GIOITINH = ?,DIACHI = ? WHERE MASV = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1,Name);
			ps.setString(2,Email);
			ps.setString(3, PhoneNumber);
			ps.setBoolean(4, Sex);
			ps.setString(5, Address);
			ps.setString(6, Code);
			ps.execute();
			return 1;
			
		} catch (Exception e) {
			System.out.println("Error :"+e.toString());
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {

			}
		}
		return -1;
		
	}

	@Override
	public ArrayList<ModelManager> SelectAll() {
		ArrayList<ModelManager> dataModels = new ArrayList<ModelManager>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "SELECT * FROM dbo.STUDENTS";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ModelManager msm = new ModelManager(rs.getString("MASV"), rs.getString("HOTEN"),
				rs.getString("EMAIL"), rs.getString("SODT"), rs.getString("GIOITINH"), rs.getString("DIACHI"));
				dataModels.add(msm);
			}

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
		return dataModels;
	}

}
