package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOInterfaceLearner;
import model.ModelLearner;

public class LearnerDAO implements DAOInterfaceLearner<ModelLearner>{
	private Connection connection = null;
	
	public void getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-2UOQ2VS:1433;databaseName=DUANMAUSOF203;encrypt=false";
			String user = "sa";
			String pass = "123456";
			connection = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println("Error: "+e.toString());
		}
	}
	
	@Override
	public ArrayList<ModelLearner> SelectAll() {
		ArrayList<ModelLearner> datas = new ArrayList<ModelLearner>();
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			getConnection();
			String sql = "SELECT * FROM dbo.NGUOIHOC";
			psm = connection.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				ModelLearner data = new ModelLearner(
						rs.getString("MANGUOIHOC"), 
						rs.getString("HOVATEN"), 
						rs.getString("NGAYSINH"), 
						rs.getBoolean("GIOITINH"), 
						rs.getString("DIENTHOAI"), 
						rs.getString("EMAIL"),
						rs.getString("NGAYDANGKY"),
						rs.getString("GHICHU"));
				datas.add(data);
			}
			
		} catch (Exception e) {
			System.out.println("Error: "+e.toString());
		}finally {
			try {
				rs.close();
				psm.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return datas;
	}

	@Override
	public ArrayList<ModelLearner> SellectALlDayMonthYear() {
		ArrayList<ModelLearner> datas = new ArrayList<ModelLearner>();
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			getConnection();
			String sql = "SELECT *,DAY(NGAYSINH) DAY, MONTH(NGAYSINH) MONTH, YEAR(NGAYSINH) YEAR, DAY(NGAYDANGKY) DAYOFREGISTER,MONTH(NGAYDANGKY) MONTHOFREGISTER, YEAR(NGAYDANGKY) YEAROFREGISTER FROM dbo.NGUOIHOC";
			psm = connection.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				ModelLearner data = new ModelLearner(
						rs.getString("MANGUOIHOC"), 
						rs.getString("HOVATEN"), 
						rs.getString("NGAYSINH"), 
						rs.getBoolean("GIOITINH"), 
						rs.getString("DIENTHOAI"), 
						rs.getString("EMAIL"), 
						rs.getString("GHICHU"), 
						rs.getString("DAY"), 
						rs.getString("MONTH"), 
						rs.getString("YEAR"),
						rs.getString("DAYOFREGISTER"), 
						rs.getString("MONTHOFREGISTER"), 
						rs.getString("YEAROFREGISTER")
						);
				datas.add(data);
			}
			
			
		} catch (Exception e) {
			System.out.println("Error: "+e.toString());
		}finally {
			try {
				rs.close();
				psm.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return datas;
	}

	@Override
	public boolean Insert(ModelLearner m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Object... arg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(String Code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ModelLearner> FindByCode(String Code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void LoadData(String Code) {
		// TODO Auto-generated method stub
		
	}

}
