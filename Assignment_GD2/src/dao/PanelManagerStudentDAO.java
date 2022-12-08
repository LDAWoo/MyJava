package dao;

import java.awt.Image;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import img.ImageHelper;
import model.ManagerStudentModel;
import view.ManagerStudentView;
import view2.PanelStudent;

public class PanelManagerStudentDAO implements DAOInterface<ManagerStudentModel> {
	private PanelStudent view;
	private Connection connection = null;
	
	private ImageHelper image = new ImageHelper();
	
	public PanelManagerStudentDAO(PanelStudent view) {
		this.view = view;
	}

	public void Connection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-2UOQ2VS:1433;databaseName=MANAGERGRADE;encrypt=false";
			String userId = "sa";
			String password = "123456";
			connection = DriverManager.getConnection(url, userId, password);
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}
	}

	@Override
	public ArrayList<ManagerStudentModel> SelectTopThree() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Insert(ManagerStudentModel d) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "INSERT INTO STUDENTS VALUES(?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, d.getCode());
			ps.setString(2, d.getName());
			ps.setString(3, d.getEmail());
			ps.setString(4, d.getPhoneNumber());
			ps.setBoolean(5, d.isSex());
			ps.setString(6, d.getAddress());
			ps.setBytes(7, d.getImg());	
			if (ps.executeUpdate() > 0) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		} finally {
			try {
				ps.close();
				rs.close();
				connection.close();
			} catch (Exception e2) {

			}
		}
		return false;
	}

	@Override
	public int Delete(String Code) {
		PreparedStatement ps = null;

		try {
			Connection();
			String sql = "DELETE STUDENTS WHERE MASV = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, Code);
			if (ps.executeUpdate() > 0) {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {
			}
		}
		return -1;
	}

	@Override
	public int Update(int ID, String Code, double English, double Technology, double Pysical) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int Update (String Code,String Name, String Email, String PhoneNumber,boolean Sex,String Address, byte[] Img) {
		PreparedStatement ps = null;
		
		
		try {
			Connection();
			String sql = "UPDATE STUDENTS SET HOTEN = ?, EMAIL = ?,SODT = ?,GIOITINH = ?,DIACHI = ?,HINH = ? WHERE MASV = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1,Name);
			ps.setString(2,Email);
			ps.setString(3, PhoneNumber);
			ps.setBoolean(4, Sex);
			ps.setString(5, Address);
			ps.setBytes(6, Img);
			ps.setString(7, Code);
			ps.execute();
			return 1;
			
		} catch (Exception e) {
			System.out.println("Error :"+e.toString());
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {

			}
		}
		return -1;
		
	}

	public String LoadImage(String Img) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Image = "";
		try {
			Connection();
			String sql = "SELECT TOP 1 * FROM STUDENTS WHERE HINH = ?";
			ps = connection.prepareStatement(sql);
			
			ps.setString(1,Img);
			rs = ps.executeQuery();
			while(rs.next()) {
				Image = rs.getString("HINH");
			}
			
		} catch (Exception e) {
			System.out.println("Error :"+e.toString());
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {

			}
		}
		return Image;
	}
	
	@Override
	public ArrayList<ManagerStudentModel> Find(String Code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ManagerStudentModel> FindByCode(ManagerStudentModel d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void LoadData(String Code) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "SELECT * FROM STUDENTS WHERE MASV = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, Code);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				ManagerStudentModel st = new ManagerStudentModel();
				st.setCode(rs.getString("MASV"));
				st.setName(rs.getString("HOTEN"));
				st.setEmail(rs.getString("EMAIL"));
				st.setPhoneNumber(rs.getString("SODT"));
				st.setSex(rs.getBoolean("GIOITINH"));
				st.setAddress(rs.getString("DIACHI"));
				st.setImg(rs.getBytes("HINH"));
				
				view.getTextFieldName().setText(st.getName());
				view.getTextFieldCode().setText(st.getCode());
				view.getTextFieldEmail().setText(st.getEmail());
				view.getTextFieldPhone().setText(st.getPhoneNumber());
				
				if(st.isSex()) {
					view.getRdbtnMale().setSelected(true);
				}else {
					view.getRdbtnFemale().setSelected(true);
				}
				
				view.getjTextAreaAddress().setText(st.getAddress());

				
				if(st.getImg()!=null) {
					Image img = image.createImageFromByteArray(st.getImg(), "jpg");
					System.out.println(img);
					view.getjLabelImg().setIcon(new ImageIcon(img));
					view.setPersonalImage(st.getImg());
				}else {
					view.getjLabelImg().setIcon(view.img.ImageUser());
				}
			}

			
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		} finally {
			try {
				ps.close();
				rs.close();
				connection.close();
			} catch (Exception e2) {

			}
		}

	}

	@Override
	public ArrayList<ManagerStudentModel> SelectAll() {
		ArrayList<ManagerStudentModel> dataModels = new ArrayList<ManagerStudentModel>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection();
			String sql = "SELECT * FROM dbo.STUDENTS";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ManagerStudentModel msm = new ManagerStudentModel(rs.getString("MASV"), rs.getString("HOTEN"),
						rs.getString("EMAIL"), rs.getString("SODT"), rs.getBoolean("GIOITINH"), rs.getString("DIACHI"),
						rs.getString("HINH"));
				
				
				dataModels.add(msm);
			}

		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		} finally {
			try {
				ps.close();
				rs.close();
				connection.close();
			} catch (Exception e2) {

			}
		}
		return dataModels;
	}

	@Override
	public int Update(String Code, String Name, String Email, String PhoneNumber, boolean Sex, String Address,
			String Img) {
		// TODO Auto-generated method stub
		return 0;
	}

}
