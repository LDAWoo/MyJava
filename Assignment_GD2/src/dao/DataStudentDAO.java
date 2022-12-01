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
import view2.ModelStudent;
import view2.TableStudent;

public class DataStudentDAO implements DAOInterface2<ModelStudent>{
	private TableStudent view;
	private Connection connection = null;
	
	public DataStudentDAO(TableStudent view) {
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
	public ArrayList<ModelStudent> SelectAll() {
		ArrayList<ModelStudent> dataModels = new ArrayList<ModelStudent>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "SELECT (TIENGANH + TINHOC + GDTC) / 3 AS TB,dbo.STUDENTS.*,dbo.GRADE.* FROM dbo.GRADE INNER JOIN dbo.STUDENTS ON STUDENTS.MASV = GRADE.MASV ORDER BY ID ";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ModelStudent gsm = new ModelStudent(rs.getInt("ID"),rs.getString("MASV"), rs.getString("HOTEN"), rs.getInt("TIENGANH"), rs.getInt("TINHOC"), rs.getInt("GDTC"),rs.getDouble("TB"));
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
	public ArrayList<ModelStudent> SelectTopThree() {

		return null;
	}
	
	@Override
	public void LoadData(String Code) {

		
	}
	

	@Override
	public boolean Insert(ModelStudent d) {
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
	public int Delete(int Id) {
		PreparedStatement ps = null;
		try {
			Connection();
			String sql = "DELETE GRADE WHERE ID = ?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, Id);
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
	public ArrayList<ModelStudent> Find(String Code) {
		return null;
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
	public ArrayList<ModelStudent> FindByCode(ModelStudent d) {
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
