package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import dao.InfomationStudentDAO;
import dao.InformationEmployeeDAO;

import javax.swing.LayoutStyle.ComponentPlacement;
import model.ModelInformation;
import model.ModelInformationEmployee;
import view.Main;
import view.MainStudent;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import java.util.ArrayList;

public class PanelInformationEmployee extends JPanel {
	private JPanel panelWest;
	private JLabel lblTextStatus;
	private JLabel lblTextEmail;
	private JLabel lblStatus;
	private JLabel lblEmail;
	
	
	
	
	private Color colorForeground1 = new Color(255,255,255);
	
	private Color colorForeground2 = new Color(191,191,191);
	
	private Color colorBackground = new Color(60,60,60);
	
	private Color colorTextForeground = new Color(200,200,200);
	
	private Font font14 = new Font("SansSerif",Font.PLAIN,14);
	private Font font15BOLD = new Font("SansSerif",Font.BOLD,15);
	private JPanel panelEast;
	private JLabel lblInfo;
	private JLabel lblFullName;
	private JTextField txtFullName;
	private JLabel lblCode;
	private JTextField txtCodeStudent;
	private JTextField txtSex;
	private JTextField txtAddress;
	private JLabel lblSex;
	private JLabel lblAddRess;
	private JTextField txtCodeAccount;
	private JTextField txtDate;
	private JLabel lblCodeAccount;
	private JLabel lblDate;
	private JLabel lblName;
	private JLabel lblRole;
	private JLabel lblDayOpening;
	private JTextField txtDateOpening;
	
	 

	public PanelInformationEmployee() {
		setOpaque(false);
		JPanel panelInfor = new JPanel();
		panelInfor.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelInfor, GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelInfor, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
		);
		
		JLabel lblInfor = new JLabel("Thông tin cá nhân");
		lblInfor.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfor.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInfor.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblInfor.setForeground(colorForeground1);
		
		panelWest = new JPanel();
		panelWest.setBackground(new Color(50,50,50));
		
		panelEast = new JPanel();
		panelEast.setBackground(new Color(50,50,50));
		

		
		GroupLayout gl_panelInfor = new GroupLayout(panelInfor);
		gl_panelInfor.setHorizontalGroup(
			gl_panelInfor.createParallelGroup(Alignment.LEADING)
				.addComponent(lblInfor, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
				.addGroup(gl_panelInfor.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelWest, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelEast, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelInfor.setVerticalGroup(
			gl_panelInfor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfor.createSequentialGroup()
					.addComponent(lblInfor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfor.createParallelGroup(Alignment.LEADING)
						.addComponent(panelEast, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
						.addComponent(panelWest, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		lblInfo = new JLabel("          Thông tin cá nhân");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		lblFullName = new JLabel("Họ và tên");
		lblFullName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFullName.setForeground(Color.WHITE);
		lblFullName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtFullName = new JTextField();
		txtFullName.setForeground(SystemColor.scrollbar);
		txtFullName.setBorder(null);
		txtFullName.setBackground(new Color(60, 60, 60));
		txtFullName.setCaretColor(colorForeground1);
		txtFullName.setFocusable(false);
		
		lblCode = new JLabel("Mã nhân viên");
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCode.setForeground(Color.WHITE);
		lblCode.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtCodeStudent = new JTextField();
		txtCodeStudent.setForeground(SystemColor.scrollbar);
		txtCodeStudent.setBorder(null);
		txtCodeStudent.setBackground(new Color(60, 60, 60));
		txtCodeStudent.setCaretColor(colorForeground1);
		txtCodeStudent.setFocusable(false);
		
		txtSex = new JTextField();
		txtSex.setForeground(SystemColor.scrollbar);
		txtSex.setBorder(null);
		txtSex.setBackground(new Color(60, 60, 60));
		txtSex.setCaretColor(colorForeground1);
		txtSex.setFocusable(false);
		
		txtAddress = new JTextField();
		txtAddress.setForeground(SystemColor.scrollbar);
		txtAddress.setBorder(null);
		txtAddress.setBackground(new Color(60, 60, 60));
		txtAddress.setCaretColor(colorForeground1);
		txtAddress.setFocusable(false);
		
		lblSex = new JLabel("Giới tính");
		lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSex.setForeground(Color.WHITE);
		lblSex.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		lblAddRess = new JLabel("Địa chỉ");
		lblAddRess.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddRess.setForeground(Color.WHITE);
		lblAddRess.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtCodeAccount = new JTextField();
		txtCodeAccount.setForeground(SystemColor.scrollbar);
		txtCodeAccount.setBorder(null);
		txtCodeAccount.setBackground(new Color(60, 60, 60));
		txtCodeAccount.setCaretColor(colorForeground1);
		txtCodeAccount.setFocusable(false);
		
		txtDate = new JTextField();
		txtDate.setForeground(SystemColor.scrollbar);
		txtDate.setBorder(null);
		txtDate.setBackground(new Color(60, 60, 60));
		txtDate.setCaretColor(colorForeground1);
		txtDate.setFocusable(false);
		
		lblCodeAccount = new JLabel("Mã tài khoản");
		lblCodeAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodeAccount.setForeground(Color.WHITE);
		lblCodeAccount.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		lblDate = new JLabel("Ngày sinh");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		lblDayOpening = new JLabel("Ngày tham gia");
		lblDayOpening.setFont(font14);
		lblDayOpening.setForeground(colorForeground1);
		
		txtDateOpening = new JTextField();
		txtDateOpening.setText((String) null);
		txtDateOpening.setForeground(colorForeground2);
		txtDateOpening.setCaretColor(Color.WHITE);
		txtDateOpening.setBorder(null);
		txtDateOpening.setBackground(new Color(60, 60, 60));
		txtDateOpening.setFocusable(false);
		
		GroupLayout gl_panelEast = new GroupLayout(panelEast);
		gl_panelEast.setHorizontalGroup(
			gl_panelEast.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblInfo, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
				.addGroup(gl_panelEast.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblDayOpening, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSex, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddRess, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCode)
						.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodeAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(txtDateOpening)
						.addComponent(txtCodeAccount)
						.addComponent(txtDate)
						.addComponent(txtFullName, Alignment.LEADING, 399, 399, Short.MAX_VALUE)
						.addComponent(txtCodeStudent, Alignment.LEADING, 399, 399, Short.MAX_VALUE)
						.addComponent(txtSex, Alignment.LEADING, 399, 399, Short.MAX_VALUE)
						.addComponent(txtAddress, Alignment.LEADING, 399, 399, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelEast.setVerticalGroup(
			gl_panelEast.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEast.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFullName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCodeStudent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSex, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSex, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddRess, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodeAccount, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCodeAccount, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDayOpening)
						.addComponent(txtDateOpening, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(264, Short.MAX_VALUE))
		);
		panelEast.setLayout(gl_panelEast);
		
		lblName = new JLabel("Lê Đức Anh Vũ");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblName.setForeground(colorForeground1);
		
		lblRole = new JLabel("Nhân viên");
		lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		lblRole.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRole.setForeground(colorForeground2);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(colorForeground1);
		lblEmail.setFont(font14);
		
		lblStatus = new JLabel("Trạng thái:");
		lblStatus.setForeground(colorForeground1);
		lblStatus.setFont(font14);
		
		lblTextEmail = new JLabel("leducanhvu3006@gmail.com");
		lblTextEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTextEmail.setForeground(colorForeground2);
		lblTextEmail.setFont(font14);
		
		lblTextStatus = new JLabel("Đang làm");
		lblTextStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTextStatus.setForeground(colorForeground2);
		lblTextStatus.setFont(font14);
		
		GroupLayout gl_panelWest = new GroupLayout(panelWest);
		gl_panelWest.setHorizontalGroup(
			gl_panelWest.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelWest.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelWest.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
						.addGroup(gl_panelWest.createSequentialGroup()
							.addComponent(lblEmail)
							.addGap(51)
							.addComponent(lblTextEmail, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
						.addComponent(lblRole, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
						.addGroup(gl_panelWest.createSequentialGroup()
							.addComponent(lblStatus)
							.addGap(28)
							.addComponent(lblTextStatus, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelWest.setVerticalGroup(
			gl_panelWest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWest.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(85)
					.addGroup(gl_panelWest.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelWest.createSequentialGroup()
							.addComponent(lblEmail)
							.addGap(18)
							.addGroup(gl_panelWest.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStatus)
								.addComponent(lblTextStatus)))
						.addComponent(lblTextEmail))
					.addContainerGap(417, Short.MAX_VALUE))
		);
		panelWest.setLayout(gl_panelWest);
		panelInfor.setLayout(gl_panelInfor);
		setLayout(groupLayout);
		getEmail();
	}
	
	public void getEmail() {
		lblName.setText(MenuEmployee.datas.get(0).getFullName());
		lblTextEmail.setText(MenuEmployee.datas.get(0).getEmail());
		lblTextStatus.setText(MenuEmployee.datas.get(0).getStatus());
		
		txtFullName.setText(MenuEmployee.datas.get(0).getFullName());
		txtCodeStudent.setText(MenuEmployee.datas.get(0).getCodeEmployee());
		
		boolean gender = MenuEmployee.datas.get(0).isGender();
		if(gender) {
			txtSex.setText("Nam");
		}else {
			txtSex.setText("Nữ");
		}
		
		txtAddress.setText(MenuEmployee.datas.get(0).getAddRess());
		txtDate.setText(MenuEmployee.datas.get(0).getDayOfBirth());
		
		String codeAccount = MenuEmployee.datas.get(0).getCodeAccount();
		int atIndex = codeAccount.indexOf("@");
		
		txtCodeAccount.setText(codeAccount.substring(0, atIndex));
		
		txtDateOpening.setText(MenuEmployee.datas.get(0).getDayOfOpening());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, 0, new Color(60,60,60), 0, 0, new Color(60,60,60));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
