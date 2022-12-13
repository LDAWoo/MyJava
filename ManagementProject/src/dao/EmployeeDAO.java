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
import jdbc.JDBCHelper;
import model.ModelEmployee;

public class EmployeeDAO implements DAOInterfaceEmployee<ModelEmployee, Object> {

	final String SELECT_ALL_SQL = "SELECT *,DAY(NGAYSINH) DAYOFBIRTH, MONTH(NGAYSINH) MONTHOFBIRTH, YEAR(NGAYSINH) YEAROFBIRTH, DAY(NGAYTHAMGIA) DAY, MONTH(NGAYTHAMGIA) MONTH,YEAR(NGAYTHAMGIA) YEAR FROM dbo.NHANVIEN";

	final String UPDATE_SQL = "UPDATE dbo.NHANVIEN SET HOVATEN = ?,NGAYSINH = ?, GIOITINH = ?, NGAYTHAMGIA = ?,MATKHAU = ?, VAITRO = ?, HINH = ?,GHICHU = ? WHERE MANHANVIEN = ?";

	final String INSERT_SQL = "INSERT INTO dbo.NHANVIEN (MANHANVIEN,HOVATEN,NGAYSINH,GIOITINH,NGAYTHAMGIA,MATKHAU,VAITRO,HINH,GHICHU) VALUES(?,?,?,?,?,?,?,?,?)";

	final String DELETE_SQL = "{call SP_DELETENHANVIEN(?)}";


	@Override
	public int Insert(ModelEmployee E) {
		return JDBCHelper.executeUpdate(INSERT_SQL, E.getCodeEmployee(), E.getName(), E.getDate(), E.isSex(),
				E.getDateOpening(), E.getPassword(), E.getRole(), E.getImg(), E.getNote());
	}

	@Override
	public int Update(ModelEmployee E) {
		return JDBCHelper.executeUpdate(UPDATE_SQL, E.getName(), E.getDate(), E.isSex(), E.getDateOpening(),
				E.getPassword(), E.getRole(), E.getImg(), E.getNote(), E.getCodeEmployee());
	}

	@Override
	public int Delete(Object K) {
		return JDBCHelper.executeUpdate(DELETE_SQL, K);
	}

	@Override
	public ArrayList<ModelEmployee> SelectALl() {
		return SelectBySql(SELECT_ALL_SQL);
	}

	@Override
	public ArrayList<ModelEmployee> FindById(Object K) {
		ArrayList<ModelEmployee> datas = new ArrayList<ModelEmployee>();
		PreparedStatement pstmt =null;
		ResultSet rs =null;		
		String SELECT_BY_ID_SQL = "SELECT *,DAY(NGAYSINH) DAYOFBIRTH, MONTH(NGAYSINH) MONTHOFBIRTH, YEAR(NGAYSINH) YEAROFBIRTH, DAY(NGAYTHAMGIA) DAY, MONTH(NGAYTHAMGIA) MONTH,YEAR(NGAYTHAMGIA) YEAR FROM dbo.NHANVIEN WHERE HOVATEN LIKE N'%"
				+ K +"%' OR MANHANVIEN LIKE N'%"+ K +"%'";
		try {
			pstmt = JDBCHelper.connection.prepareStatement(SELECT_BY_ID_SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ModelEmployee employee = new ModelEmployee(rs.getString("MANHANVIEN"), rs.getString("HOVATEN"),
						rs.getString("NGAYSINH"), rs.getBoolean("GIOITINH"), rs.getString("NGAYTHAMGIA"),
						rs.getString("VAITRO"), rs.getString("MATKHAU"), rs.getBytes("HINH"), rs.getString("GHICHU"),
						rs.getString("DAYOFBIRTH"), rs.getString("MONTHOFBIRTH"), rs.getString("YEAROFBIRTH"),
						rs.getString("DAY"), rs.getString("MONTH"), rs.getString("YEAR"));
				datas.add(employee);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			try {
				rs.close();
				pstmt.close();
				pstmt.getConnection().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return datas;
	}

	@Override
	public ArrayList<ModelEmployee> SelectBySql(String sql, Object... args) {
		ArrayList<ModelEmployee> datas = new ArrayList<ModelEmployee>();
		try {
			ResultSet rs = JDBCHelper.executeQuery(sql, args);
			while (rs.next()) {
				ModelEmployee employee = new ModelEmployee(rs.getString("MANHANVIEN"), rs.getString("HOVATEN"),
						rs.getString("NGAYSINH"), rs.getBoolean("GIOITINH"), rs.getString("NGAYTHAMGIA"),
						rs.getString("VAITRO"), rs.getString("MATKHAU"), rs.getBytes("HINH"), rs.getString("GHICHU"),
						rs.getString("DAYOFBIRTH"), rs.getString("MONTHOFBIRTH"), rs.getString("YEAROFBIRTH"),
						rs.getString("DAY"), rs.getString("MONTH"), rs.getString("YEAR"));
				datas.add(employee);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return datas;
	}

}
