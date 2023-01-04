package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import interfaces.DAOInterfaceCourse;
import jdbc.JDBCHelper;
import model.ModelCodeTopic;
import model.ModelCourse;

public class CourseDAO implements DAOInterfaceCourse<ModelCourse, Object>{
	final String SELECT_ALL_SQL = "SELECT *,DAY(NGAYKHAIGIANG) DAYOFOPENING, MONTH(NGAYKHAIGIANG) MONTHOFOPENING, YEAR(NGAYKHAIGIANG) YEAROFOPENING, DAY(NGAYTAO) DAYOFCREATE, MONTH(NGAYTAO) MONTHOFCREATE, YEAR(NGAYTAO) YEAROFCREATE FROM KHOAHOC INNER JOIN CHUYENDE ON KHOAHOC.MACHUYENDE = CHUYENDE.MACHUYENDE";
	
	final String SELECT_BY_CODE_SQL = "SELECT * FROM CHUYENDE";
	
	final String INSERT_SQL = "INSERT INTO KHOAHOC(MAKHOAHOC,MACHUYENDE,HOCPHI,THOILUONG,NGAYKHAIGIANG,NGAYTAO,MANHANVIEN,GHICHU)\r\n"
			+ "VALUES(?,?,?,?,?,?,?,?);\r\n";
	final String UPDATE_SQL = "UPDATE KHOAHOC SET MACHUYENDE = ?, HOCPHI = ?, THOILUONG = ?, NGAYKHAIGIANG = ?, NGAYTAO = ? , MANHANVIEN = ?, GHICHU = ? WHERE MAKHOAHOC= ?";
	
	final String DELETE_SQL = "DELETE TABLE KHOAHOC WHERE MAKHOAHOC = ?";
	@Override
	public int Insert(ModelCourse E) {
		return JDBCHelper.executeUpdate(INSERT_SQL, E.getCodeCourse(), E.getCodeTopic(), E.getTuition(), E.getTime() ,E.getDayOpening(), E.getDayCreate(), E.getCreatePerson(), E.getNote());
	}

	@Override
	public int Update(ModelCourse E) {
		return JDBCHelper.executeUpdate(UPDATE_SQL, E.getCodeTopic(), E.getTuition(), E.getTime(), E.getDayOpening(), E.getDayCreate(), E.getCreatePerson(), E.getNote(), E.getCodeCourse());
	}

	@Override
	public int Delete(Object K) {
		return JDBCHelper.executeUpdate(DELETE_SQL, K);
	}

	@Override
	public ArrayList<ModelCourse> SelectAll() {
		return SelectBySql(SELECT_ALL_SQL);
	}

	@Override
	public ArrayList<ModelCourse> FindById(Object K) {
		ArrayList<ModelCourse> datas = new ArrayList<ModelCourse>();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			String SELECT_BY_ID_SQL = "SELECT *,DAY(NGAYKHAIGIANG) DAYOFOPENING, MONTH(NGAYKHAIGIANG) MONTHOFOPENING, YEAR(NGAYKHAIGIANG) YEAROFOPENING, DAY(NGAYTAO) DAYOFCREATE, MONTH(NGAYTAO) MONTHOFCREATE, YEAR(NGAYTAO) YEAROFCREATE FROM KHOAHOC INNER JOIN CHUYENDE ON KHOAHOC.MACHUYENDE = CHUYENDE.MACHUYENDE "
					+ "WHERE KHOAHOC.MAKHOAHOC LIKE N'%"+ K +"%' OR CHUYENDE.MACHUYENDE LIKE N'%"+ K +"%'";
			pstmt = JDBCHelper.connection.prepareStatement(SELECT_BY_ID_SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ModelCourse data = new ModelCourse(
						rs.getString("MAKHOAHOC"), 
						rs.getString("MACHUYENDE"),
						rs.getString("TENCHUYENDE"),
						rs.getDouble("HOCPHI"), 
						rs.getInt("THOILUONG"), 
						rs.getString("NGAYKHAIGIANG"), 
						rs.getString("NGAYTAO"), 
						rs.getString("GHICHU"), 
						rs.getString("MANHANVIEN"), 
						rs.getString("DAYOFOPENING"), 
						rs.getString("MONTHOFOPENING"), 
						rs.getString("YEAROFOPENING"), 
						rs.getString("DAYOFCREATE"), 
						rs.getString("MONTHOFCREATE"),
						rs.getString("YEAROFCREATE")
						);
				datas.add(data);
			}
		} catch (Exception e) {
			System.out.println("Error: "+e.toString());
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
	public ArrayList<ModelCourse> SelectBySql(String sql, Object... args) {
		ArrayList<ModelCourse> datas = new ArrayList<ModelCourse>();
		try {
			ResultSet rs = JDBCHelper.executeQuery(sql, args);
			while(rs.next()) {
				ModelCourse data = new ModelCourse(
						rs.getString("MAKHOAHOC"), 
						rs.getString("MACHUYENDE"),
						rs.getString("TENCHUYENDE"),
						rs.getDouble("HOCPHI"), 
						rs.getInt("THOILUONG"), 
						rs.getString("NGAYKHAIGIANG"), 
						rs.getString("NGAYTAO"), 
						rs.getString("GHICHU"), 
						rs.getString("MANHANVIEN"), 
						rs.getString("DAYOFOPENING"), 
						rs.getString("MONTHOFOPENING"), 
						rs.getString("YEAROFOPENING"), 
						rs.getString("DAYOFCREATE"), 
						rs.getString("MONTHOFCREATE"),
						rs.getString("YEAROFCREATE")
						);
				datas.add(data);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return datas;
	}
	
	public ArrayList<ModelCodeTopic> SelectCodeTopicAddCombobox(){
		return SelectCodeTopicAddToComBoBox(SELECT_BY_CODE_SQL);
	}
	
	public ArrayList<ModelCodeTopic> SelectCodeTopicAddToComBoBox(String sql, Object...args){
		ArrayList<ModelCodeTopic> datas = new ArrayList<ModelCodeTopic>();
		try {
			ResultSet rs = JDBCHelper.executeQuery(sql, args);
	
			while(rs.next()) {
				ModelCodeTopic data = new ModelCodeTopic(rs.getString("MACHUYENDE"), rs.getString("TENCHUYENDE"));	
				datas.add(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}
	
}
