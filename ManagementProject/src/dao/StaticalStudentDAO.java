package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOInterfaceStaticalStudent;
import jdbc.JDBCHelper;
import model.ModelStaticalStudent;

public class StaticalStudentDAO implements DAOInterfaceStaticalStudent<ModelStaticalStudent>{
	
	final String SELECT_PROC_STATICAL_STUDENT = "{call SP_SOLUONGNGUOIHOC}";
	
	@Override
	public ArrayList<ModelStaticalStudent> SellectStaticalStudent() {
		ArrayList<ModelStaticalStudent> datas = new ArrayList<ModelStaticalStudent>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_PROC_STATICAL_STUDENT);
			while(rs.next()) {
				ModelStaticalStudent data = new ModelStaticalStudent(
						rs.getString("NAM"), 
						rs.getInt("SOLUONG"), 
						rs.getString("DAUTIEN"), 
						rs.getString("CUOICUNG"));
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
