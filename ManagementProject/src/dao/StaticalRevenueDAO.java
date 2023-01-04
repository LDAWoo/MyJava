package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOInterfaceStaticalRevenue;
import jdbc.JDBCHelper;
import model.ModelStaticalRevenue;

public class StaticalRevenueDAO implements DAOInterfaceStaticalRevenue<ModelStaticalRevenue, Integer>{
	final String SELECT_ALL_BY_PROC = "{call SP_DOANHTHU(?)}";
	
	@Override
	public ArrayList<ModelStaticalRevenue> SelectAll(Integer K) {
		ArrayList<ModelStaticalRevenue> datas = new ArrayList<ModelStaticalRevenue>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_BY_PROC, K);
			while(rs.next()) {
				ModelStaticalRevenue data = new ModelStaticalRevenue(
						rs.getString("TENCHUYENDE"), 
						rs.getInt("SOKHOAHOC"), 
						rs.getInt("SOHOCVIEN"), 
						rs.getDouble("DOANHTHU"), 
						rs.getDouble("DTCAONHAT"), 
						rs.getDouble("DTTHAPNHAT"), 
						rs.getDouble("TRUNGBINH"));
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
