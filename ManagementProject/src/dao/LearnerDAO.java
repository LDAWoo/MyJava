package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOInterfaceLearner;
import jdbc.JDBCHelper;
import model.ModelLearner;

public class LearnerDAO implements DAOInterfaceLearner<ModelLearner, Object> {

	final String SELECT_ALL_SQL = "SELECT *,DAY(NGAYSINH) DAY, MONTH(NGAYSINH) MONTH, YEAR(NGAYSINH) YEAR, DAY(NGAYDANGKY) DAYOFREGISTER,MONTH(NGAYDANGKY) MONTHOFREGISTER, YEAR(NGAYDANGKY) YEAROFREGISTER FROM dbo.NGUOIHOC";
	final String UPDATE_SQL = "";

	@Override
	public int Insert(ModelLearner E) {
		return 0;
	}

	@Override
	public int Update(ModelLearner E) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(Object K) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ModelLearner> SelectAll() {
		return SelectBySql(SELECT_ALL_SQL);
	}
	
	@Override
	public ArrayList<ModelLearner> FindById(Object K) {
		ArrayList<ModelLearner> datas = new ArrayList<ModelLearner>();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			String SELECT_BY_ID_SQL = "SELECT *,DAY(NGAYSINH) DAY, MONTH(NGAYSINH) MONTH, YEAR(NGAYSINH) YEAR, DAY(NGAYDANGKY) DAYOFREGISTER,MONTH(NGAYDANGKY) MONTHOFREGISTER, YEAR(NGAYDANGKY) YEAROFREGISTER FROM dbo.NGUOIHOC "
					+ "WHERE MANGUOIHOC LIKE '%"+ K +"%' OR HOVATEN LIKE N'%"+ K +"%'";
			pstmt = JDBCHelper.connection.prepareStatement(SELECT_BY_ID_SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ModelLearner data = new ModelLearner(rs.getString("MANGUOIHOC"), rs.getString("HOVATEN"),
						rs.getString("NGAYSINH"), rs.getBoolean("GIOITINH"), rs.getString("DIENTHOAI"),
						rs.getString("EMAIL"),rs.getString("NGAYDANGKY"), rs.getString("GHICHU"), rs.getString("DAY"), rs.getString("MONTH"),
						rs.getString("YEAR"), rs.getString("DAYOFREGISTER"), rs.getString("MONTHOFREGISTER"),
						rs.getString("YEAROFREGISTER"));
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
	public ArrayList<ModelLearner> SelectBySql(String sql, Object... args) {
		ArrayList<ModelLearner> datas = new ArrayList<ModelLearner>();
		try {
			ResultSet rs = JDBCHelper.executeQuery(sql, args);
			while (rs.next()) {
				ModelLearner data = new ModelLearner(rs.getString("MANGUOIHOC"), rs.getString("HOVATEN"),
						rs.getString("NGAYSINH"), rs.getBoolean("GIOITINH"), rs.getString("DIENTHOAI"),
						rs.getString("EMAIL"),rs.getString("NGAYDANGKY"), rs.getString("GHICHU"), rs.getString("DAY"), rs.getString("MONTH"),
						rs.getString("YEAR"), rs.getString("DAYOFREGISTER"), rs.getString("MONTHOFREGISTER"),
						rs.getString("YEAROFREGISTER"));
				datas.add(data);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
		return datas;
	}



}
