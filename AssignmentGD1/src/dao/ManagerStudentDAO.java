package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ManagerStudentModel;
import view.ManagerStudentView;

public class ManagerStudentDAO implements DAOInterface<ManagerStudentModel> {
	private ManagerStudentView view;
	private java.sql.Connection connection = null;

	public ManagerStudentDAO(ManagerStudentView view) {
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
	public ArrayList<ManagerStudentModel> SelectTopThree() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Insert(ManagerStudentModel d) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "INSERT INTO STUDENTS VALUES(?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, d.getCode());
			ps.setString(2, d.getName());
			ps.setString(3, d.getEmail());
			ps.setString(4, d.getPhoneNumber());
			ps.setBoolean(5, d.isSex());
			ps.setString(6, d.getAddress());
			ps.setString(7, d.getImg());
			if (ps.executeUpdate() > 0) {
				return true;
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
		return false;
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

	@Override
	public int Update(int ID, String Code, double English, double Technology, double Pysical) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int Update (String Code,String Name, String Email, String PhoneNumber,boolean Sex,String Address, String Img) {
		PreparedStatement ps = null;
		
		try {
			Connection();
			String sql = "UPDATE STUDENTS SET HOTEN = ?, EMAIL = ?,SODT = ?,GIOITINH = ?,DIACHI = ?,HINH = ? WHERE MASV = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1,Name);
			ps.setString(2,Email);
			ps.setString(3, PhoneNumber);
			ps.setBoolean(4, Sex);
			ps.setString(5, Address);
			ps.setString(6, Img);
			ps.setString(7, Code);
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

	public String LoadImage(String Img) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Image = "";
		try {
			Connection();
			String sql = "SELECT TOP 1 * FROM STUDENTS WHERE HINH = ?";
			ps = connection.prepareStatement(sql);
			
			ps.setString(1,Img);
			rs = ps.executeQuery();
			while(rs.next()) {
				Image = rs.getString("HINH");
			}
			
		} catch (Exception e) {
			System.out.println("Error :"+e.toString());
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {

			}
		}
		return Image;
	}
	
	@Override
	public ArrayList<ManagerStudentModel> Find(String Code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ManagerStudentModel> FindByCode(ManagerStudentModel d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void LoadData(String Code) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "SELECT * FROM STUDENTS WHERE MASV = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, Code);

			rs = ps.executeQuery();

			while (rs.next()) {
				this.view.getTextFieldCode().setText(rs.getString("MASV"));
				this.view.getTextFieldName().setText(rs.getString("HOTEN"));
				this.view.getTextFieldEmail().setText(rs.getString("EMAIL"));
				this.view.getTextFieldPhone().setText(rs.getString("SODT"));
				if (rs.getBoolean("GIOITINH")) {
					this.view.getRdbtnMale().setSelected(true);
				} else {
					this.view.getRdbtnFemale().setSelected(true);
				}
				this.view.getjTextAreaAddress().setText(rs.getString("DIACHI"));

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

	}

	@Override
	public ArrayList<ManagerStudentModel> SelectAll() {
		ArrayList<ManagerStudentModel> dataModels = new ArrayList<ManagerStudentModel>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "SELECT * FROM dbo.STUDENTS";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ManagerStudentModel msm = new ManagerStudentModel(rs.getString("MASV"), rs.getString("HOTEN"),
						rs.getString("EMAIL"), rs.getString("SODT"), rs.getBoolean("GIOITINH"), rs.getString("DIACHI"),
						rs.getString("HINH"));
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
