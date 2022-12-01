package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.GradeStudentModel;
import view.GradeStudentView;

public class GradeStudentDAO implements DAOInterface<GradeStudentModel>{
	private GradeStudentView view;
	private Connection connection = null;
	
	public GradeStudentDAO(GradeStudentView view) {
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
	public ArrayList<GradeStudentModel> SelectAll() {
		ArrayList<GradeStudentModel> dataModels = new ArrayList<GradeStudentModel>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "SELECT (TIENGANH + TINHOC + GDTC) / 3 AS TB,dbo.STUDENTS.*,dbo.GRADE.* FROM dbo.GRADE INNER JOIN dbo.STUDENTS ON STUDENTS.MASV = GRADE.MASV ORDER BY ID ";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				GradeStudentModel gsm = 
						new GradeStudentModel(rs.getInt("ID"),rs.getString("MASV"), rs.getString("HOTEN"), rs.getInt("TIENGANH"), rs.getInt("TINHOC"), rs.getInt("GDTC"),rs.getDouble("TB"));
				dataModels.add(gsm);
			}
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}finally {
			try {
				ps.close();
				rs.close();
				connection.close();
			} catch (Exception e2) {

			}
		}
		return dataModels;
	}
	
	@Override
	public ArrayList<GradeStudentModel> SelectTopThree() {
		ArrayList<GradeStudentModel> dataModels = new ArrayList<GradeStudentModel>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "SELECT TOP(3) (TIENGANH + TINHOC + GDTC) / 3 AS TB,dbo.STUDENTS.*,dbo.GRADE.* FROM dbo.GRADE INNER JOIN dbo.STUDENTS ON STUDENTS.MASV = GRADE.MASV ORDER BY TB DESC";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				GradeStudentModel gsm = 
						new GradeStudentModel(rs.getInt("ID"),rs.getString("MASV"), rs.getString("HOTEN"), rs.getInt("TIENGANH"), rs.getInt("TINHOC"), rs.getInt("GDTC"),rs.getDouble("TB"));
				dataModels.add(gsm);
			}
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}finally {
			try {
				ps.close();
				rs.close();
				connection.close();
			} catch (Exception e2) {

			}
		}
		return dataModels;
	}
	
	@Override
	public void LoadData(String Code) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "SELECT *,(TIENGANH + TINHOC + GDTC) / 3 AS TB FROM dbo.GRADE INNER JOIN dbo.STUDENTS ON STUDENTS.MASV = GRADE.MASV WHERE GRADE.MASV = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, Code);
			rs = ps.executeQuery();
			while(rs.next()) {
				this.view.getTextFieldName().setText(rs.getString("HOTEN"));
				this.view.getTextFieldCodeText().setText(rs.getString("MASV"));
				this.view.getTextFieldEnglish().setText(rs.getString("TIENGANH"));
				this.view.getTextFieldTechnology().setText(rs.getString("TINHOC"));
				this.view.getTextFieldPysical().setText(rs.getString("GDTC"));
				this.view.getLblMediumScore().setText(rs.getInt("TB")+".0");
				
			}
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}finally {
			try {
				ps.close();
				rs.close();
				connection.close();
			} catch (Exception e2) {

			}
		}
		
	}
	

	@Override
	public boolean Insert(GradeStudentModel d) {
		PreparedStatement ps = null;
		try {
			Connection();
			String sql = "INSERT INTO GRADE VALUES(?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, d.getCode());
			ps.setDouble(2, d.getEnglish());
			ps.setDouble(3, d.getInForTechnology());
			ps.setDouble(4, d.getPysical());
			
			if(ps.executeUpdate()>0) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}finally {
			try {
				ps.close();
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
			String sql = "DELETE GRADE WHERE MASV = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, Code);
			if(ps.executeUpdate()>0) {
				return 1;
			}
			
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e2) {

			}
		}
		
		return -1;
	}
	
	@Override
	public ArrayList<GradeStudentModel> Find(String Code) {
		ArrayList<GradeStudentModel> datas = new ArrayList<GradeStudentModel>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "SELECT *,(TIENGANH + TINHOC + GDTC) / 3 AS TB FROM dbo.GRADE INNER JOIN dbo.STUDENTS ON STUDENTS.MASV = GRADE.MASV WHERE GRADE.MASV = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, Code);
			rs = ps.executeQuery();
			if(rs.next()) {
				GradeStudentModel gsm = new GradeStudentModel(rs.getString("MASV"), 
				rs.getString("HOTEN"), rs.getDouble("TIENGANH"), 
				rs.getDouble("TINHOC"), rs.getDouble("GDTC"),rs.getDouble("TB"));
				datas.add(gsm);
				
			}else {
				this.view.getTextFieldName().setText("");
				this.view.getTextFieldCodeText().setText("");
				this.view.getTextFieldEnglish().setText("");
				this.view.getTextFieldTechnology().setText("");
				this.view.getTextFieldPysical().setText("");
				this.view.getLblMediumScore().setText("");
				JOptionPane.showMessageDialog(this.view, "Không Tìm Thấy");
				this.view.set_cal(true);
			}
			
			
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e2) {

			}
		}
		
		return datas;
	}

	@Override
	public int Update(int ID,String Code,double English,double Technology,double Pysical) {
		CallableStatement csm = null;
		try {
			Connection();
			String sql = "{call sp_st (?,?,?,?,?)}";
			csm = connection.prepareCall(sql);
			csm.setInt(1, ID);
			csm.setString(2,Code);
			csm.setDouble(3,English);
			csm.setDouble(4,Technology);
			csm.setDouble(5,Pysical);
			csm.execute();
				
			return 1;
			
			
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}finally {
			try {
				csm.close();
				connection.close();
			} catch (Exception e2) {

			}
		}
		return -1;
		
	}

	@Override
	public ArrayList<GradeStudentModel> FindByCode(GradeStudentModel d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Update(String Code, String Name, String Email, String PhoneNumber, boolean Sex, String Address,
			String Img) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
