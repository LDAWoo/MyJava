package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOInterfaceTopic;
import jdbc.JDBCHelper;
import model.ModelTopic;

public class TopicDAO implements DAOInterfaceTopic<ModelTopic, Object> {
	final String SELECT_ALL_SQL = "SELECT * FROM CHUYENDE";

	final String UPDATE_SQL = "UPDATE dbo.CHUYENDE SET TENCHUYENDE = ?,HOCPHI = ?, THOILUONG = ?, MOTACHUYENDE = ?, HINHLOGO = ? WHERE MACHUYENDE = ?";

	final String INSERT_SQL = "INSERT INTO dbo.CHUYENDE\r\n"
			+ "(MACHUYENDE,TENCHUYENDE,HOCPHI,THOILUONG,MOTACHUYENDE,HINHLOGO)\r\n" + "VALUES\r\n" + "(?,?,?,?,?,?)";

	final String DELETE_SQL = "{call SP_DELETECHUYENDE(?)}";

	@Override
	public int Insert(ModelTopic E) {

		return JDBCHelper.executeUpdate(INSERT_SQL, E.getCodeTopic(), E.getNameTopic(), E.getTuition(), E.getTime(),
				E.getDescriber(), E.getLogo());

	}

	@Override
	public int Update(ModelTopic E) {
		return JDBCHelper.executeUpdate(UPDATE_SQL, E.getNameTopic(), E.getTuition(), E.getTime(), E.getDescriber(),
				E.getLogo(), E.getCodeTopic());
	}

	@Override
	public int Delete(Object K) {
		return JDBCHelper.executeUpdate(DELETE_SQL, K);
	}

	@Override
	public ArrayList<ModelTopic> SelectAll() {
		return SelectBySql(SELECT_ALL_SQL);
	}

	@Override
	public ArrayList<ModelTopic> FindById(Object K) {
		ArrayList<ModelTopic> datas = new ArrayList<ModelTopic>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String SELECT_BY_ID = "SELECT * FROM CHUYENDE WHERE TENCHUYENDE LIKE N'%" + K + "%' OR MACHUYENDE LIKE N'%"+ K +"%'";
			pstmt = JDBCHelper.connection.prepareStatement(SELECT_BY_ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ModelTopic data = new ModelTopic(rs.getString("MACHUYENDE"), rs.getString("TENCHUYENDE"),
						rs.getDouble("HOCPHI"), rs.getInt("THOILUONG"), rs.getString("MOTACHUYENDE"),
						rs.getBytes("HINHLOGO"));
				datas.add(data);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		} finally {
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
	public ArrayList<ModelTopic> SelectBySql(String sql, Object... args) {
		ArrayList<ModelTopic> datas = new ArrayList<ModelTopic>();

		try {
			ResultSet rs = JDBCHelper.executeQuery(sql, args);
			while (rs.next()) {
				ModelTopic data = new ModelTopic(rs.getString("MACHUYENDE"), rs.getString("TENCHUYENDE"),
						rs.getDouble("HOCPHI"), rs.getInt("THOILUONG"), rs.getString("MOTACHUYENDE"),
						rs.getBytes("HINHLOGO"));
				datas.add(data);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
		return datas;
	}

//	@Override
//	public ArrayList<ModelTopic> SellectALl() {
//		ArrayList<ModelTopic> datas = new ArrayList<ModelTopic>();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		try {
//			getConnection();
//			String sql = "SELECT * FROM CHUYENDE";
//			ps = connection.prepareStatement(sql);
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//				ModelTopic data = new ModelTopic(rs.getString("MACHUYENDE"), rs.getString("TENCHUYENDE"),
//						rs.getDouble("HOCPHI"), rs.getInt("THOILUONG"), rs.getString("MOTACHUYENDE"),
//						rs.getBytes("HINHLOGO"));
//				datas.add(data);
//			}
//
//		} catch (Exception e) {
//			System.out.println("Error: " + e.toString());
//		} finally {
//			try {
//				rs.close();
//				ps.close();
//				connection.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		return datas;
//	}
//

}
