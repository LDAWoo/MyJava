package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOInterfaceInformation;
import jdbc.JDBCHelper;
import model.ModelInformation;

public class InfomationStudentDAO implements DAOInterfaceInformation<ModelInformation>{
	final String SELECT_ALL_INFOR_SQL = "SELECT * FROM dbo.NGUOIHOC "
			+ "INNER JOIN dbo.HOCVIEN ON HOCVIEN.MANGUOIHOC = NGUOIHOC.MANGUOIHOC "
			+ "INNER JOIN dbo.KHOAHOC ON KHOAHOC.MAKHOAHOC = HOCVIEN.MAKHOAHOC "
			+ "INNER JOIN dbo.CHUYENDE ON CHUYENDE.MACHUYENDE = KHOAHOC.MACHUYENDE WHERE EMAIL = ?";
	
	
	@Override
	public ArrayList<ModelInformation> SelectInformation(String email) {
		ArrayList<ModelInformation> datas = new ArrayList<ModelInformation>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_INFOR_SQL, email);
			while(rs.next()) {
				ModelInformation data = new ModelInformation(
						rs.getString("HOVATEN"), 
						rs.getString("MANGUOIHOC"), 
						rs.getBoolean("GIOITINH"), 
						rs.getString("EMAIL"), 
						rs.getString("DIENTHOAI"), 
						rs.getString("STATUS"), 
						rs.getString("GHICHU"), 
						rs.getString("EMAIL"), 
						rs.getString("MAKHOAHOC"), 
						rs.getString("TENCHUYENDE"),
						rs.getString("NGAYDANGKY"));
				datas.add(data);
			}
			return datas;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
