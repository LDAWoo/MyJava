package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOInterfaceInformation;
import jdbc.JDBCHelper;
import model.ModelInformationEmployee;

public class InformationEmployeeDAO implements DAOInterfaceInformation<ModelInformationEmployee>{

	final String SELECT_ALL = "SELECT * FROM NHANVIEN WHERE EMAIL = ?";
	@Override
	public ArrayList<ModelInformationEmployee> SelectInformation(String email) {
		ArrayList<ModelInformationEmployee> datas = new ArrayList<ModelInformationEmployee>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL, email);
			while(rs.next()) {
				ModelInformationEmployee data = new ModelInformationEmployee(
						rs.getString("HOVATEN"), 
						rs.getString("EMAIL"), 
						"", 
						rs.getString("MANHANVIEN"), 
						rs.getBoolean("GIOITINH"), 
						rs.getString("GHICHU"), 
						rs.getString("NGAYSINH"), 
						rs.getString("EMAIL"), 
						rs.getString("NGAYTHAMGIA"),
						rs.getBytes("HINH"));	
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
