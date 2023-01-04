package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOInterfaceScore;
import jdbc.JDBCHelper;
import model.ModelScoreStudent;

public class ScoreStudentDAO implements DAOInterfaceScore<ModelScoreStudent>{
	final String SELECT_SCORE_STUDENT_BY_EMAIL = "SELECT * FROM dbo.NGUOIHOC "
			+ "INNER JOIN dbo.HOCVIEN ON HOCVIEN.MANGUOIHOC = NGUOIHOC.MANGUOIHOC "
			+ "INNER JOIN dbo.KHOAHOC ON KHOAHOC.MAKHOAHOC = HOCVIEN.MAKHOAHOC "
			+ "INNER JOIN dbo.CHUYENDE ON CHUYENDE.MACHUYENDE = KHOAHOC.MACHUYENDE WHERE EMAIL = ?";
	
	@Override
	public ArrayList<ModelScoreStudent> SelectScoreStudents(String email) {
		ArrayList<ModelScoreStudent> datas = new ArrayList<ModelScoreStudent>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_SCORE_STUDENT_BY_EMAIL, email);
			
			while(rs.next()) {
				ModelScoreStudent data = new ModelScoreStudent(
						1, 
						"1", 
						"Spring 2023", 
						rs.getString("TENCHUYENDE"), 
						rs.getString("MACHUYENDE"), 
						rs.getString("MACHUYENDE"), 
						"", 
						rs.getDouble("DIEM"), 
						"");
				datas.add(data);
			}
			return datas;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

}
