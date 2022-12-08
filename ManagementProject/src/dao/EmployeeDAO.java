package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import interfaces.DAOInterfaceEmployee;
import model.ModelEmployee;

public class EmployeeDAO implements DAOInterfaceEmployee<ModelEmployee> {
	private Connection connection = null;

	public void getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-2UOQ2VS:1433;databaseName=DUANMAUSOF203;encrypt=false";
			String user = "sa";
			String password = "123456";
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}

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
			while (rs.next()) {
				ModelEmployee employee = new ModelEmployee(rs.getString("MANHANVIEN"), rs.getString("HOVATEN"),
						rs.getString("NGAYSINH"), rs.getBoolean("GIOITINH"), rs.getString("NGAYTHAMGIA"),
						rs.getString("VAITRO"), rs.getString("MATKHAU"), rs.getBytes("HINH"), rs.getString("GHICHU"),
						rs.getString("DAYOFBIRTH"), rs.getString("MONTHOFBIRTH"), rs.getString("YEAROFBIRTH"),
						rs.getString("DAY"), rs.getString("MONTH"), rs.getString("YEAR"));
				datas.add(employee);
			}

		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		} finally {
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
	public boolean Insert(ModelEmployee employee) {
		PreparedStatement psm = null;
		try {
			getConnection();
			String sql = "INSERT INTO dbo.NHANVIEN\r\n"
					+ "(MANHANVIEN,HOVATEN,NGAYSINH,GIOITINH,NGAYTHAMGIA,MATKHAU,VAITRO,HINH,GHICHU)\r\n" + "VALUES\r\n"
					+ "(?,?,?,?,?,?,?,?,?)";
			psm = connection.prepareStatement(sql);

			psm.setString(1, employee.getCodeEmployee());
			psm.setString(2, employee.getName());
			psm.setString(3, employee.getDate());
			psm.setBoolean(4, employee.isSex());
			psm.setString(5, employee.getDateOpening());
			psm.setString(6, employee.getPassword());
			psm.setString(7, employee.getRole());
			psm.setBytes(8, employee.getImg());
			psm.setString(9, employee.getNote());
			if (psm.executeUpdate() > 0) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				psm.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return false;
	}

	public int Update(String Code, String Name, String DayBirth, boolean Sex, String Role, String Password,
			String DayOfOpeing, byte[] image, String Note) {
		PreparedStatement psm = null;

		try {
			getConnection();
			String sql = "UPDATE dbo.NHANVIEN SET HOVATEN = ?,NGAYSINH = ?, GIOITINH = ?, NGAYTHAMGIA = ?,MATKHAU = ?, VAITRO = ?, HINH = ?,GHICHU = ? WHERE MANHANVIEN = ?";
			psm = connection.prepareStatement(sql);

			psm.setString(1, Name);
			psm.setString(2, DayBirth);
			psm.setBoolean(3, Sex);
			psm.setString(4, DayOfOpeing);
			psm.setString(5, Password);
			psm.setString(6, Role);
			psm.setBytes(7, image);
			psm.setString(8, Note);
			psm.setString(9, Code);

			psm.execute();
			return 1;

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				psm.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return -1;
	}

	@Override
	public int Delete(String Code) {
		CallableStatement cstmt = null;
		try {
			getConnection();
			String sql = " {call SP_DELETENHANVIEN(?)}";
			cstmt = connection.prepareCall(sql);
			cstmt.setString(1,Code);
			
			cstmt.execute();
				
			return 1;
			
			
		} catch (Exception e) {
			System.out.println("Error: "+e.toString());
		}finally {
			try {
				cstmt.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return -1;
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

	@Override
	public ArrayList<ModelEmployee> SellectALl() {
		// TODO Auto-generated method stub
		return null;
	}

}
