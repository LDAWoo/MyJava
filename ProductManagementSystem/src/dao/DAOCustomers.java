package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;

import interfaces.DAOCustomersList;
import jdbc.JDBCHelper;
import model.ModelCustomerList;

public class DAOCustomers implements DAOCustomersList<ModelCustomerList, String> {
	final String SelectAll = "SELECT KHACHHANG.IMAGE,KHACHHANG.TENKHACHHANG, KHACHHANG.EMAIL, KHACHHANG.SODIENTHOAI, COUNT(PRODUCTCOMMENT.MASANPHAM) AS LUOTMUA,SUM(SANPHAM.GIASANPHAM) AS TONGTIEN, COUNT(LIKECOMMENT.LIKEORNOLIKE) AS LUOTTHICH, COUNT(RATINGCOMMENT.MASANPHAM) AS LUOTDANHGIA\r\n"
			+ "FROM KHACHHANG\r\n"
			+ "LEFT JOIN PRODUCTCOMMENT ON KHACHHANG.MAKHACHHANG = PRODUCTCOMMENT.MAKHACHHANG\r\n"
			+ "LEFT JOIN LIKECOMMENT ON KHACHHANG.MAKHACHHANG = LIKECOMMENT.MAKHACHHANG\r\n"
			+ "LEFT JOIN SANPHAM ON SANPHAM.MASANPHAM = LIKECOMMENT.MASANPHAM\r\n"
			+ "LEFT JOIN RATINGCOMMENT ON KHACHHANG.MAKHACHHANG = RATINGCOMMENT.MAKHACHHANG\r\n"
			+ "GROUP BY KHACHHANG.IMAGE,KHACHHANG.TENKHACHHANG, KHACHHANG.EMAIL, KHACHHANG.SODIENTHOAI\r\n" + "";

	final String SelectAllByEmailOrUsername = "SELECT KHACHHANG.IMAGE,KHACHHANG.TENKHACHHANG, KHACHHANG.EMAIL, KHACHHANG.SODIENTHOAI, COUNT(PRODUCTCOMMENT.MASANPHAM) AS LUOTMUA,SUM(SANPHAM.GIASANPHAM) AS TONGTIEN, COUNT(LIKECOMMENT.LIKEORNOLIKE) AS LUOTTHICH, COUNT(RATINGCOMMENT.MASANPHAM) AS LUOTDANHGIA\r\n"
			+ "FROM KHACHHANG\r\n"
			+ "LEFT JOIN PRODUCTCOMMENT ON KHACHHANG.MAKHACHHANG = PRODUCTCOMMENT.MAKHACHHANG\r\n"
			+ "LEFT JOIN LIKECOMMENT ON KHACHHANG.MAKHACHHANG = LIKECOMMENT.MAKHACHHANG\r\n"
			+ "LEFT JOIN SANPHAM ON SANPHAM.MASANPHAM = LIKECOMMENT.MASANPHAM\r\n"
			+ "LEFT JOIN RATINGCOMMENT ON KHACHHANG.MAKHACHHANG = RATINGCOMMENT.MAKHACHHANG\r\n"
			+ "GROUP BY KHACHHANG.IMAGE,KHACHHANG.TENKHACHHANG, KHACHHANG.EMAIL, KHACHHANG.SODIENTHOAI HAVING TENKHACHHANG LIKE N'%?%'";

	final String SELECT_ALL_CUSTOMER = "SELECT * FROM dbo.KHACHHANG ORDER BY MAKHACHHANG DESC";
	 

	public ArrayList<ModelCustomerList> SelectCustomer() {
		ArrayList<ModelCustomerList> datas = new ArrayList<ModelCustomerList>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_CUSTOMER);

			while (rs.next()) {
				ModelCustomerList data = new ModelCustomerList(rs.getString("TENKHACHHANG"), rs.getString("EMAIL"), rs.getString("SODIENTHOAI"), rs.getString("IMAGE"));
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
	public ArrayList<ModelCustomerList> SelectAll() {
		ArrayList<ModelCustomerList> datas = new ArrayList<ModelCustomerList>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SelectAll);

			while (rs.next()) {
				ModelCustomerList data = new ModelCustomerList(rs.getString("IMAGE"), rs.getString("TENKHACHHANG"),
						rs.getString("EMAIL"), rs.getString("SODIENTHOAI"), rs.getString("LUOTMUA"),
						rs.getDouble("TONGTIEN"), rs.getInt("LUOTDANHGIA"), rs.getInt("LUOTTHICH"));
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
	public ArrayList<ModelCustomerList> SelectByName(String k) {
		ArrayList<ModelCustomerList> datas = new ArrayList<ModelCustomerList>();
		 String SelectAllByEmailOrUsername = "SELECT KHACHHANG.IMAGE,KHACHHANG.TENKHACHHANG, KHACHHANG.EMAIL, KHACHHANG.SODIENTHOAI, COUNT(PRODUCTCOMMENT.MASANPHAM) AS LUOTMUA,SUM(SANPHAM.GIASANPHAM) AS TONGTIEN, COUNT(LIKECOMMENT.LIKEORNOLIKE) AS LUOTTHICH, COUNT(RATINGCOMMENT.MASANPHAM) AS LUOTDANHGIA\r\n"
					+ "FROM KHACHHANG\r\n"
					+ "LEFT JOIN PRODUCTCOMMENT ON KHACHHANG.MAKHACHHANG = PRODUCTCOMMENT.MAKHACHHANG\r\n"
					+ "LEFT JOIN LIKECOMMENT ON KHACHHANG.MAKHACHHANG = LIKECOMMENT.MAKHACHHANG\r\n"
					+ "LEFT JOIN SANPHAM ON SANPHAM.MASANPHAM = LIKECOMMENT.MASANPHAM\r\n"
					+ "LEFT JOIN RATINGCOMMENT ON KHACHHANG.MAKHACHHANG = RATINGCOMMENT.MAKHACHHANG\r\n"
					+ "GROUP BY KHACHHANG.IMAGE,KHACHHANG.TENKHACHHANG, KHACHHANG.EMAIL, KHACHHANG.SODIENTHOAI HAVING TENKHACHHANG LIKE N'%"+k+"%' OR KHACHHANG.EMAIL LIKE N'%"+k+"%'";

		
	
		ResultSet rs = null;
		try {
			rs =JDBCHelper.executeQuery(SelectAllByEmailOrUsername);
			
			while (rs.next()) {
				ModelCustomerList data = new ModelCustomerList(rs.getString("IMAGE"), rs.getString("TENKHACHHANG"),
						rs.getString("EMAIL"), rs.getString("SODIENTHOAI"), rs.getString("LUOTMUA"),
						rs.getDouble("TONGTIEN"), rs.getInt("LUOTDANHGIA"), rs.getInt("LUOTTHICH"));
				
				
				datas.add(data);
			}
			rs.close();
			return datas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
