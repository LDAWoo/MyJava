package componetInformation;

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

import javax.swing.LayoutStyle.ComponentPlacement;

import model.ModelInformation;
import view.Main;
import view.MainStudent;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import java.util.ArrayList;

public class PanelInformation extends JPanel {
	private JPanel panelWest;
	private JLabel lblTextStatus;
	private JLabel lblTextPhoneNumber;
	private JLabel lblTextEmail;
	private JLabel lblStatus;
	private JLabel lblEmail;
	private JLabel lblPhoneNumber;
	
	private ArrayList<ModelInformation> datas = new ArrayList<ModelInformation>();
	
	private InfomationStudentDAO dao = new InfomationStudentDAO();
	
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
	private JTextField txtCourse;
	private JLabel lblCodeAccount;
	private JLabel lblCourse;
	private JLabel lblSpecialized;
	private JLabel lblInfo1;
	private JLabel lblName;
	private JLabel lblRole;
	private JTextField txtSpecialized;
	private JLabel lblDay;
	private JTextField txtRegistrationDate;
	
	 

	public PanelInformation() {
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
		
		lblCode = new JLabel("Mã sinh viên");
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCode.setForeground(Color.WHITE);
		lblCode.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtCodeStudent = new JTextField();
		txtCodeStudent.setForeground(SystemColor.scrollbar);
		txtCodeStudent.setBorder(null);
		txtCodeStudent.setBackground(new Color(60, 60, 60));
		txtCodeStudent.setCaretColor(colorForeground1);
		
		txtSex = new JTextField();
		txtSex.setForeground(SystemColor.scrollbar);
		txtSex.setBorder(null);
		txtSex.setBackground(new Color(60, 60, 60));
		txtSex.setCaretColor(colorForeground1);
		
		txtAddress = new JTextField();
		txtAddress.setForeground(SystemColor.scrollbar);
		txtAddress.setBorder(null);
		txtAddress.setBackground(new Color(60, 60, 60));
		txtAddress.setCaretColor(colorForeground1);
		
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
		
		txtCourse = new JTextField();
		txtCourse.setForeground(SystemColor.scrollbar);
		txtCourse.setBorder(null);
		txtCourse.setBackground(new Color(60, 60, 60));
		txtCourse.setCaretColor(colorForeground1);
		
		lblCodeAccount = new JLabel("Mã tài khoản");
		lblCodeAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodeAccount.setForeground(Color.WHITE);
		lblCodeAccount.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		lblCourse = new JLabel("Khóa học");
		lblCourse.setForeground(Color.WHITE);
		lblCourse.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		lblSpecialized = new JLabel("Chuyên ngành");
		lblSpecialized.setForeground(Color.WHITE);
		lblSpecialized.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		lblInfo1 = new JLabel("          Thông tin học tập");
		lblInfo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo1.setForeground(Color.WHITE);
		lblInfo1.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		txtSpecialized = new JTextField();
		txtSpecialized.setText((String) null);
		txtSpecialized.setForeground(colorForeground2);
		txtSpecialized.setCaretColor(Color.WHITE);
		txtSpecialized.setBorder(null);
		txtSpecialized.setBackground(new Color(60, 60, 60));
		
		lblDay = new JLabel("Ngày đăng ký");
		lblDay.setFont(font14);
		lblDay.setForeground(colorForeground1);
		
		txtRegistrationDate = new JTextField();
		txtRegistrationDate.setText((String) null);
		txtRegistrationDate.setForeground(colorForeground2);
		txtRegistrationDate.setCaretColor(Color.WHITE);
		txtRegistrationDate.setBorder(null);
		txtRegistrationDate.setBackground(new Color(60, 60, 60));
		
		GroupLayout gl_panelEast = new GroupLayout(panelEast);
		gl_panelEast.setHorizontalGroup(
			gl_panelEast.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblInfo, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
				.addGroup(gl_panelEast.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDay)
						.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSex, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddRess, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodeAccount, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCourse, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSpecialized))
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtRegistrationDate)
						.addComponent(txtSpecialized)
						.addComponent(txtFullName, 399, 399, Short.MAX_VALUE)
						.addComponent(txtCodeStudent, 399, 399, Short.MAX_VALUE)
						.addComponent(txtSex, 399, 399, Short.MAX_VALUE)
						.addComponent(txtAddress, 399, 399, Short.MAX_VALUE)
						.addComponent(txtCodeAccount, 399, 399, Short.MAX_VALUE)
						.addComponent(txtCourse, 399, 399, Short.MAX_VALUE))
					.addContainerGap())
				.addComponent(lblInfo1, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
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
					.addGap(55)
					.addComponent(lblInfo1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCodeAccount, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodeAccount, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCourse, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCourse, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpecialized, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSpecialized, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelEast.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDay)
						.addComponent(txtRegistrationDate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		panelEast.setLayout(gl_panelEast);
		
		JLabel lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblName = new JLabel("Lê Đức Anh Vũ");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblName.setForeground(colorForeground1);
		
		lblRole = new JLabel("Sinh viên");
		lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		lblRole.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRole.setForeground(colorForeground2);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(colorForeground1);
		lblEmail.setFont(font14);
		
		lblPhoneNumber = new JLabel("Số điện thoại:");
		lblPhoneNumber.setForeground(colorForeground1);
		lblPhoneNumber.setFont(font14);
		
		lblStatus = new JLabel("Trạng thái:");
		lblStatus.setForeground(colorForeground1);
		lblStatus.setFont(font14);
		
		lblTextEmail = new JLabel("leducanhvu3006@gmail.com");
		lblTextEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTextEmail.setForeground(colorForeground2);
		lblTextEmail.setFont(font14);
		
		 lblTextPhoneNumber = new JLabel("0352843864");
		lblTextPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTextPhoneNumber.setForeground(colorForeground2);
		lblTextPhoneNumber.setFont(font14);
		
		 lblTextStatus = new JLabel("Đang đi học");
		lblTextStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTextStatus.setForeground(colorForeground2);
		lblTextStatus.setFont(font14);
		
		GroupLayout gl_panelWest = new GroupLayout(panelWest);
		gl_panelWest.setHorizontalGroup(
			gl_panelWest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWest.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelWest.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelWest.createSequentialGroup()
							.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelWest.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRole, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
								.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
						.addGroup(gl_panelWest.createSequentialGroup()
							.addComponent(lblEmail)
							.addGap(51)
							.addComponent(lblTextEmail, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
						.addGroup(gl_panelWest.createSequentialGroup()
							.addGroup(gl_panelWest.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPhoneNumber)
								.addComponent(lblStatus))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelWest.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTextStatus, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
								.addComponent(lblTextPhoneNumber, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panelWest.setVerticalGroup(
			gl_panelWest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWest.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelWest.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelWest.createSequentialGroup()
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelWest.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelWest.createSequentialGroup()
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelWest.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPhoneNumber)
								.addComponent(lblTextPhoneNumber))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelWest.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStatus)
								.addComponent(lblTextStatus)))
						.addComponent(lblTextEmail))
					.addContainerGap(185, Short.MAX_VALUE))
		);
		panelWest.setLayout(gl_panelWest);
		panelInfor.setLayout(gl_panelInfor);
		setLayout(groupLayout);
		getEmail();
	}
	
	public void getEmail() {
		String email = MainStudent.email;
		
		
		datas = dao.SelectInformation(email);
		
		lblName.setText(datas.get(0).getFullName());
		lblTextEmail.setText(datas.get(0).getEmail());
		
		lblTextPhoneNumber.setText(datas.get(0).getPhoneNumber());
		
		lblTextStatus.setText(datas.get(0).getStatus());
		
		txtFullName.setText(datas.get(0).getFullName());
		txtCodeStudent.setText(datas.get(0).getCodeStudent());
		
		String gender = "";
		boolean sex = datas.get(0).isSex();
		
		if(sex) {
			gender = "Nam";
		}else {
			gender = "Nữ";
		}
		
		txtSex.setText(gender);
		txtAddress.setText(datas.get(0).getAddRess());
		
		String codeAccount = datas.get(0).getCodeAccount();
		int atIndex = codeAccount.indexOf("@");
		
		txtCodeAccount.setText(codeAccount.substring(0,atIndex));

		txtCourse.setText(datas.get(0).getCourse());
		txtSpecialized.setText(datas.get(0).getSpecialized());
		txtRegistrationDate.setText(datas.get(0).getRegistrationDate());
		
		
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
