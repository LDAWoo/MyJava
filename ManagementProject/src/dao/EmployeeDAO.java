package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import interfaces.DAOInterfaceEmployee;
import model.ModelEmployee;

public class EmployeeDAO implements DAOInterfaceEmployee<ModelEmployee>{
	private Connection connection =null;
	
	public void getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-2UOQ2VS:1433;databaseName=DUANMAUSOF203;encrypt=false";
			String user = "sa";
			String password = "123456";
			connection= DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("Error: "+e.toString());
		}
		
	}
	
	@Override
	public ArrayList<ModelEmployee> SellectALl() {
		ArrayList<ModelEmployee> datas = new ArrayList<ModelEmployee>();
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			getConnection();
			String sql = "SELECT * FROM dbo.NHANVIEN";
			psm = connection.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				ModelEmployee employee = new ModelEmployee(
						rs.getString("MANHANVIEN"),
						rs.getString("HOVATEN"),
						rs.getString("NGAYSINH"),
						rs.getBoolean("GIOITINH"),
						rs.getString("VAITRO"),
						rs.getString("MATKHAU"),
						rs.getString("NGAYTHAMGIA"),
						rs.getString("HINH"),
						rs.getString("GHICHU")
						);
				datas.add(employee);
			}
		
		}catch(Exception e) {
			System.out.println("Error:" + e.toString());
		}finally {
			try {
				psm.close();
				rs.close();
				connection.close();
			} catch (Exception e) {
			}
			
		}
		return datas;
	}
	
	@Override
	public ArrayList<ModelEmployee> SellectALlDayMonthYear() {
		ArrayList<ModelEmployee> datas = new ArrayList<ModelEmployee>();
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			getConnection();
			String sql = "SELECT *,DAY(NGAYSINH) DAYOFBIRTH, MONTH(NGAYSINH) MONTHOFBIRTH, YEAR(NGAYSINH) YEAROFBIRTH, DAY(NGAYTHAMGIA) DAY, MONTH(NGAYTHAMGIA) MONTH,YEAR(NGAYTHAMGIA) YEAR FROM dbo.NHANVIEN";
			psm = connection.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				ModelEmployee employee = new ModelEmployee(
						rs.getString("MANHANVIEN"),
						rs.getString("HOVATEN"),
						rs.getString("NGAYSINH"),
						rs.getBoolean("GIOITINH"),
						rs.getString("NGAYTHAMGIA"),
						rs.getString("VAITRO"),
						rs.getString("MATKHAU"),
						rs.getString("HINH"),
						rs.getString("GHICHU"),
						rs.getString("DAYOFBIRTH"),
						rs.getString("MONTHOFBIRTH"),
						rs.getString("YEAROFBIRTH"),
						rs.getString("DAY"),
						rs.getString("MONTH"),
						rs.getString("YEAR")
						);
				datas.add(employee);
			}
		
		}catch(Exception e) {
			System.out.println("Error:" + e.toString());
		}finally {
			try {
				psm.close();
				rs.close();
				connection.close();
			} catch (Exception e) {
			}
			
		}
		return datas;
	}
	

	@Override
	public boolean Insert(ModelEmployee t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Object... arg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(String Code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ModelEmployee> FindByCode(String Code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void LoadData(String Code) {
		// TODO Auto-generated method stub
		
	}

}
