package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOProductList;
import jdbc.JDBCHelper;
import model.ModelCustomerList;
import model.ModelProductList;

public class DAOProducts implements DAOProductList<ModelProductList, Object> {

	final String SELECT_ALL_SQL = "SELECT IMAGE,SANPHAM.MASANPHAM,TENHANG,TENSANPHAM,TRANGTHAI,GIASANPHAM,SOLUONGSANPHAM,SUM(LIKEORNOLIKE) LUOTTHICH FROM dbo.SANPHAM LEFT JOIN dbo.HANG ON HANG.HANGID = SANPHAM.HANGID LEFT JOIN dbo.LIKECOMMENT ON LIKECOMMENT.MASANPHAM = SANPHAM.MASANPHAM GROUP BY IMAGE, SANPHAM.MASANPHAM,TENHANG, TENSANPHAM,TRANGTHAI,GIASANPHAM,SOLUONGSANPHAM,LIKEORNOLIKE ORDER BY SANPHAM.MASANPHAM ASC";

	final String DELETE_SQL = "DELETE dbo.SANPHAM WHERE MASANPHAM = ?";
	@Override
	public ArrayList<ModelProductList> SelectAll() {
		ArrayList<ModelProductList> datas = new ArrayList<ModelProductList>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_SQL);

			while (rs.next()) {
				ModelProductList data = new ModelProductList(rs.getInt("MASANPHAM"), rs.getString("IMAGE"), rs.getString("TENSANPHAM"), rs.getString("TENHANG"), rs.getBoolean("TRANGTHAI"), rs.getDouble("GIASANPHAM"), rs.getInt("SOLUONGSANPHAM"), rs.getInt("LUOTTHICH"));
				datas.add(data);
			}
			rs.close();
			return datas;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ModelProductList> SelectByName(Object k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Object k) {
		return JDBCHelper.executeUpdate(DELETE_SQL, k);
	}

	@Override
	public int update(ModelProductList e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
