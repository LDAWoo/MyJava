package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import interfaces.DAOInterfaceCourse;
import jdbc.JDBCHelper;
import model.ModelCodeTopic;
import model.ModelCourse;

public class CourseDAO implements DAOInterfaceCourse<ModelCourse, Object>{
	final String SELECT_ALL_SQL = "SELECT *,DAY(NGAYKHAIGIANG) DAYOFOPENING, MONTH(NGAYKHAIGIANG) MONTHOFOPENING, YEAR(NGAYKHAIGIANG) YEAROFOPENING, DAY(NGAYTAO) DAYOFCREATE, MONTH(NGAYTAO) MONTHOFCREATE, YEAR(NGAYTAO) YEAROFCREATE FROM KHOAHOC";
	
	final String SELECT_BY_CODE_SQL = "SELECT MACHUYENDE FROM CHUYENDE";
	
	@Override
	public int Insert(ModelCourse E) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update(ModelCourse E) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(Object K) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ModelCourse> SelectAll() {
		return SelectBySql(SELECT_ALL_SQL);
	}

	@Override
	public ArrayList<ModelCourse> FindById(Object K) {
		// TODO Auto-generated method stub
		return null;
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
						rs.getDouble("HOCPHI"), 
						rs.getInt("THOILUONG"), 
						rs.getString("NGAYKHAIGIANG"), 
						rs.getString("NGAYTAO"), 
						rs.getString("MANHANVIEN"), 
						rs.getString("GHICHU"), 
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
				ModelCodeTopic data = new ModelCodeTopic(rs.getString("MACHUYENDE"));	
				datas.add(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}
	
}
