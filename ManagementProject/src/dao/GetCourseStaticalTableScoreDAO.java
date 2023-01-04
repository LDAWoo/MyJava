package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOInterfaceStaticalTableScore;
import jdbc.JDBCHelper;
import model.ModelStaticalTableScore;
import model.ModelStaticalTableScoreGetCourse;

public class GetCourseStaticalTableScoreDAO implements DAOInterfaceStaticalTableScore<ModelStaticalTableScore>{
	final String SELECT_ALL = "SELECT * FROM dbo.KHOAHOC";
	
	final String SELECT_ALL_BY_CODE_COURSE = "{ call SP_BANGDIEM(?)}";
	
	
	public ArrayList<ModelStaticalTableScoreGetCourse> SelectAllCourse() {
		ArrayList<ModelStaticalTableScoreGetCourse> datas = new ArrayList<ModelStaticalTableScoreGetCourse>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL);
			while(rs.next()) {
			ModelStaticalTableScoreGetCourse data = new ModelStaticalTableScoreGetCourse(
					rs.getString("MAKHOAHOC"), 
					rs.getString("MACHUYENDE"), 
					rs.getString("NGAYKHAIGIANG"));
			
			datas.add(data);
			}
			rs.close();
			return datas;
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}


	@Override
	public ArrayList<ModelStaticalTableScore> SelectByCodeCourse(String codeCourse) {
		ArrayList<ModelStaticalTableScore> datas = new ArrayList<ModelStaticalTableScore>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_BY_CODE_COURSE, codeCourse);
			while(rs.next()) {
				ModelStaticalTableScore data = new ModelStaticalTableScore(rs.getString("MANGUOIHOC"), rs.getString("HOVATEN"), rs.getDouble("DIEM"), "");
				datas.add(data);
			}
			
			rs.close();
			return datas;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

}
