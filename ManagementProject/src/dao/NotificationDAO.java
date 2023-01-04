package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.JDBCHelper;
import model.ModelNotification;

public class NotificationDAO {
	final String SELECT_ALL = "SELECT * FROM THONGTINHOCTAP";
	
	public ArrayList<ModelNotification> SelectAll(){
		ArrayList<ModelNotification> datas = new ArrayList<ModelNotification>();
		ResultSet rs =  null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL);
			while(rs.next()) {
				ModelNotification data = new ModelNotification(rs.getInt("ID"), rs.getString("THONGTIN"));
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
