package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOInterfaceStaticalTotalScore;
import jdbc.JDBCHelper;
import model.ModelStaticalTotalScore;

public class StaticalTotalScoreDAO implements DAOInterfaceStaticalTotalScore<ModelStaticalTotalScore>{
	final String SELECT_ALL__BY_PROC = "{ call SP_DIEMCHUYENDE}";
	
	@Override
	public ArrayList<ModelStaticalTotalScore> SelectAll() {
		ArrayList<ModelStaticalTotalScore> datas = new ArrayList<ModelStaticalTotalScore>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL__BY_PROC);
			while(rs.next()) {
				ModelStaticalTotalScore data = new ModelStaticalTotalScore(
						rs.getString("TENCHUYENDE"), 
						rs.getInt("SOHV"), 
						rs.getDouble("DIEMTHAPNHAT"), 
						rs.getDouble("DIEMCAONHAT"), 
						rs.getDouble("DIEMTRUNGBINH"));
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
