package dao;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOManagerLearner;
import jdbc.JDBCHelper;
import model.ModelCourses;
import model.ModelGrade;
import model.ModelLearners;
import model.ModelName;
import model.ModelSex;
import model.ModelStudent;
import model.ModelAge;
import model.ModelLearnerNoCourse;
import model.ModelStudents;

public class ManagerLearnerCourseDAO implements DAOManagerLearner<ModelStudents, Object>{
	
	final String SELECT_ALL_SQL = "SELECT * FROM HOCVIEN INNER JOIN NGUOIHOC ON HOCVIEN.MANGUOIHOC = NGUOIHOC.MANGUOIHOC";
	
	final String SELECT_ALL_BY_CODE_SQL = "SELECT * FROM HOCVIEN INNER JOIN NGUOIHOC ON HOCVIEN.MANGUOIHOC = NGUOIHOC.MANGUOIHOC WHERE HOCVIEN.MAKHOAHOC = ?";
	
	final String SELECT_ALL_LEARNER_NO_COURSE = "SELECT * FROM dbo.NGUOIHOC WHERE NGUOIHOC.MANGUOIHOC NOT IN(SELECT MANGUOIHOC FROM dbo.HOCVIEN)";
	
	final String SELECT_NO_GRADE_SQL = "SELECT *, (YEAR(GETDATE()) - YEAR(NGAYSINH)) AS AGE FROM HOCVIEN INNER JOIN NGUOIHOC ON HOCVIEN.MANGUOIHOC = NGUOIHOC.MANGUOIHOC WHERE DIEM = -1.0 AND HOCVIEN.MAKHOAHOC = ?";
	
	final String SELECT_ALL_GRADE_SQL = "SELECT *, (YEAR(GETDATE()) - YEAR(NGAYSINH)) AS AGE FROM HOCVIEN INNER JOIN NGUOIHOC ON HOCVIEN.MANGUOIHOC = NGUOIHOC.MANGUOIHOC WHERE DIEM >=0.0 AND DIEM <= 10.0 AND HOCVIEN.MAKHOAHOC = ?";
	
	final String UPDATE_SQL = "UPDATE HOCVIEN SET DIEM = ? WHERE ID = ?";
	
	final String INSERT_SQL = "INSERT INTO HOCVIEN(MAHOCVIEN,MANGUOIHOC,MAKHOAHOC,DIEM)\r\n"
			+ "VALUES(?,?,?,?)";
	
	final String DELETE_SQL = "DELETE dbo.HOCVIEN WHERE MANGUOIHOC = ?";
	@Override
	public int Insert(ModelStudents E) {
		return JDBCHelper.executeUpdate(INSERT_SQL, E.getCodeStudent().getCodeStudent(),E.getCodeLearner().getCodeLerner(),E.getCodeCourse().getCodeCourse(),E.getGrade().getGrade());
	}

	@Override
	public int Update(ModelStudents E) {
		return JDBCHelper.executeUpdate(UPDATE_SQL, E.getGrade().getGrade(), E.getID());
	}

	@Override
	public int Delete(Object K) {
		return JDBCHelper.executeUpdate(DELETE_SQL, K);
	}

	@Override
	public ArrayList<ModelStudents> SelectAll() {
		return SelectBySql(SELECT_ALL_SQL);
	}
	
	public ArrayList<ModelStudents> SelectAll(String codeCourse){
		return SelectBySql(SELECT_ALL_BY_CODE_SQL,codeCourse);
	}

	@Override
	public ArrayList<ModelStudents> SelectAllGrade(String codeCourse) {
		return SelectBySql(SELECT_ALL_GRADE_SQL,codeCourse);
	}

	@Override
	public ArrayList<ModelStudents> SelectAllNoGrade(String codeCourse) {
		return SelectBySql(SELECT_NO_GRADE_SQL,codeCourse);
	}
	
	public ArrayList<ModelLearnerNoCourse> addLearnerNoCourse() {
		return SelectLearnerNoCourse(SELECT_ALL_LEARNER_NO_COURSE);
	} 
	
	public ArrayList<ModelLearnerNoCourse> FindNameLearnerNoCourse(String Name) {
		ArrayList<ModelLearnerNoCourse> datas = new ArrayList<ModelLearnerNoCourse>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String SELECT_FIND_BY_NAME_LEARNER_NO_COURSE = "SELECT * FROM dbo.NGUOIHOC WHERE NGUOIHOC.MANGUOIHOC NOT IN(SELECT MANGUOIHOC FROM dbo.HOCVIEN) AND HOVATEN LIKE N'%"+Name+"%' ";
			pstmt = JDBCHelper.connection.prepareStatement(SELECT_FIND_BY_NAME_LEARNER_NO_COURSE);		
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ModelLearnerNoCourse data = new ModelLearnerNoCourse(rs.getString("MANGUOIHOC"),rs.getString("HOVATEN"));			
				datas.add(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	} 


	public ArrayList<ModelLearnerNoCourse> SelectLearnerNoCourse(String sql, Object...args) {
		ArrayList<ModelLearnerNoCourse> datas = new ArrayList<ModelLearnerNoCourse>();
		try {
			ResultSet rs = JDBCHelper.executeQuery(sql, args);
			while(rs.next()) {
				ModelLearnerNoCourse data = new ModelLearnerNoCourse(rs.getString("MANGUOIHOC"),rs.getString("HOVATEN"));			
				datas.add(data);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return datas;
	}
	
	@Override
	public ArrayList<ModelStudents> SelectBySql(String sql, Object... args) {
		ArrayList<ModelStudents> datas = new ArrayList<ModelStudents>();
		try {
			ResultSet rs = JDBCHelper.executeQuery(sql, args);
			while(rs.next()) {
				ModelStudents data = new ModelStudents(
						rs.getInt("ID"),
						new ModelStudent(rs.getString("MAHOCVIEN")),
						new ModelCourses(rs.getString("MAKHOAHOC")), 
						new ModelLearners(rs.getString("MANGUOIHOC")), 
						new ModelName(rs.getString("HOVATEN")), 
						new ModelSex(rs.getBoolean("GIOITINH")), 
						new ModelAge(rs.getString("NGAYSINH")), 
						new ModelGrade(rs.getDouble("DIEM")));
				
				
				datas.add(data);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return datas;
	}

	

	
}
