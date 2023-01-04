package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.SignUpController;
import controller.UserController;
import dao.UserDAO;
import img.img;
import model.ModelAccount;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SignUpView extends JFrame {
	private img img = new img();
	private JPanel contentPane;
	private JLabel Exit;
	private SignUpController controller = new SignUpController(this);
	private UserDAO dao = new UserDAO();
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtPasswordConfirm;
	private JLabel disablepassword;
	private JLabel Showpassword;
	private JLabel disableConfirm;
	private JLabel ShowConfirm;
	private String email = "^([a-z0-9_\\.-]){2,}+@([\\da-z]){2,}\\.([a-z]){2,}(\\.|[a-z]{2,}){0,}$";
	private String phone_pattern = "^0+[1-9]{1}[0-9]{8}$";
	private JLabel lblCheck;
	private JCheckBox chckbxIAgreeAll;
	private JTextField txtPhoneNumber;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SignUpView frame = new SignUpView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignUpView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 565, 601);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblImgLogin = new JLabel("");
		lblImgLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgLogin.setBounds(0, 41, 565, 459);
		panel.add(lblImgLogin);
		lblImgLogin.setIcon(this.img.ImageSignUp());

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(565, 0, 500, 601);
		panel_1.setBackground(SystemColor.textHighlight);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		Exit = new JLabel("X");
		Exit.setForeground(Color.WHITE);
		Exit.setHorizontalAlignment(SwingConstants.CENTER);
		Exit.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		Exit.setBounds(450, 0, 50, 36);
		Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Exit.addMouseListener(controller);
		panel_1.add(Exit);

		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		lblSignUp.setBounds(0, 35, 489, 46);
		panel_1.add(lblSignUp);

		JLabel IconUser = new JLabel("");
		IconUser.setHorizontalAlignment(SwingConstants.CENTER);
		IconUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconUser.setBounds(10, 142, 46, 46);
		IconUser.setIcon(this.img.IconUserSignUp());
		panel_1.add(IconUser);

		JLabel IconEmail = new JLabel("");
		IconEmail.setHorizontalAlignment(SwingConstants.CENTER);
		IconEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconEmail.setBounds(10, 218, 46, 46);
		IconEmail.setIcon(this.img.IconEmail());
		panel_1.add(IconEmail);

		JLabel IconPassword = new JLabel("");
		IconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		IconPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconPassword.setBounds(10, 355, 46, 46);
		IconPassword.setIcon(this.img.IconLock());
		panel_1.add(IconPassword);

		JLabel IconPasswordConfirm = new JLabel("");
		IconPasswordConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		IconPasswordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconPasswordConfirm.setBounds(10, 431, 46, 46);
		IconPasswordConfirm.setIcon(this.img.IconLock());
		panel_1.add(IconPasswordConfirm);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(243, 255, 253));
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername.setBounds(66, 115, 414, 25);
		panel_1.add(lblUsername);

		JLabel lbl1 = new JLabel("______________________________________________________________");
		lbl1.setForeground(new Color(243, 255, 253));
		lbl1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl1.setBounds(66, 148, 375, 36);
		panel_1.add(lbl1);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(243, 255, 253));
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblEmail.setBounds(66, 190, 414, 25);
		panel_1.add(lblEmail);

		JLabel lbl2 = new JLabel("______________________________________________________________");
		lbl2.setForeground(new Color(243, 255, 253));
		lbl2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl2.setBounds(66, 223, 375, 36);
		panel_1.add(lbl2);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(243, 255, 253));
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPassword.setBounds(66, 325, 414, 25);
		panel_1.add(lblPassword);

		JLabel lbl4 = new JLabel("______________________________________________________________");
		lbl4.setForeground(new Color(243, 255, 253));
		lbl4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl4.setBounds(66, 371, 375, 21);
		panel_1.add(lbl4);

		JLabel lblRepectPassword = new JLabel("ConfirmPassword");
		lblRepectPassword.setForeground(new Color(243, 255, 253));
		lblRepectPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblRepectPassword.setBounds(66, 402, 414, 25);
		panel_1.add(lblRepectPassword);

		JLabel lbl5 = new JLabel("______________________________________________________________");
		lbl5.setForeground(new Color(243, 255, 253));
		lbl5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl5.setBounds(66, 448, 375, 21);
		panel_1.add(lbl5);

		txtUsername = new JTextField();
		txtUsername.setForeground(Color.WHITE);
		txtUsername.setSelectionColor(new Color(220, 204, 182));
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtUsername.setColumns(10);
		txtUsername.setCaretColor(Color.WHITE);
		txtUsername.setBorder(null);
		txtUsername.setBackground(SystemColor.textHighlight);
		txtUsername.setBounds(66, 135, 375, 36);
		panel_1.add(txtUsername);

		txtEmail = new JTextField();
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setSelectionColor(new Color(220, 204, 182));
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setCaretColor(Color.WHITE);
		txtEmail.setBorder(null);
		txtEmail.setBackground(SystemColor.textHighlight);
		txtEmail.setBounds(66, 211, 375, 36);
		panel_1.add(txtEmail);

		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setSelectionColor(new Color(220, 204, 182));
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setCaretColor(Color.WHITE);
		txtPassword.setBorder(null);
		txtPassword.setBackground(SystemColor.textHighlight);
		txtPassword.setBounds(66, 347, 341, 36);
		txtPassword.addCaretListener(controller);
		panel_1.add(txtPassword);

		txtPasswordConfirm = new JPasswordField();
		txtPasswordConfirm.setForeground(Color.WHITE);
		txtPasswordConfirm.setSelectionColor(new Color(220, 204, 182));
		txtPasswordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPasswordConfirm.setCaretColor(Color.WHITE);
		txtPasswordConfirm.setBorder(null);
		txtPasswordConfirm.setBackground(SystemColor.textHighlight);
		txtPasswordConfirm.setBounds(66, 424, 341, 36);
		txtPasswordConfirm.addCaretListener(controller);
		panel_1.add(txtPasswordConfirm);

		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.setForeground(SystemColor.textHighlight);
		btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnRegister.setBorder(null);
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setBounds(183, 544, 146, 46);
		btnRegister.addActionListener(controller);
		panel_1.add(btnRegister);

		chckbxIAgreeAll = new JCheckBox("I agree all statements in Term of servic\r\n");
		chckbxIAgreeAll.setForeground(Color.WHITE);
		chckbxIAgreeAll.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		chckbxIAgreeAll.setBackground(SystemColor.textHighlight);
		chckbxIAgreeAll.setBounds(66, 514, 286, 23);
		panel_1.add(chckbxIAgreeAll);

		JLabel lblLogin = new JLabel("Login here");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUserView loginUserView = new LoginUserView();
				setVisible(false);
				loginUserView.setLocationRelativeTo(null);
				loginUserView.setVisible(true);
			}
		});
		lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogin.setForeground(new Color(243, 255, 253));
		lblLogin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblLogin.setBounds(362, 513, 79, 25);
		panel_1.add(lblLogin);

		disablepassword = new JLabel("");
		disablepassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setEchoChar((char) 0);
				disablepassword.setVisible(false);
				disablepassword.setEnabled(false);
				Showpassword.setVisible(true);
				Showpassword.setEnabled(true);
			}
		});
		disablepassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		disablepassword.setHorizontalAlignment(SwingConstants.CENTER);
		disablepassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		disablepassword.setIcon(this.img.IconEyesInvisible());
		disablepassword.setBounds(402, 347, 36, 36);
		panel_1.add(disablepassword);

		Showpassword = new JLabel("");
		Showpassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setEchoChar((char) 8226);
				disablepassword.setVisible(true);
				disablepassword.setEnabled(true);
				Showpassword.setVisible(false);
				Showpassword.setEnabled(false);
			}
		});
		Showpassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Showpassword.setHorizontalAlignment(SwingConstants.CENTER);
		Showpassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Showpassword.setIcon(this.img.IconEyes());
		Showpassword.setBounds(402, 347, 36, 36);
		panel_1.add(Showpassword);

		disableConfirm = new JLabel("");
		disableConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPasswordConfirm.setEchoChar((char) 0);
				disableConfirm.setVisible(false);
				disableConfirm.setEnabled(false);
				ShowConfirm.setVisible(true);
				ShowConfirm.setEnabled(true);
			}
		});
		disableConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		disableConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		disableConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		disableConfirm.setBounds(402, 424, 36, 36);
		panel_1.add(disableConfirm);
		disableConfirm.setIcon(this.img.IconEyesInvisible());

		ShowConfirm = new JLabel("");
		ShowConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPasswordConfirm.setEchoChar((char) 8226);
				disableConfirm.setVisible(true);
				disableConfirm.setEnabled(true);
				ShowConfirm.setVisible(false);
				ShowConfirm.setEnabled(false);
			}
		});
		ShowConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ShowConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		ShowConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ShowConfirm.setBounds(402, 424, 36, 36);
		ShowConfirm.setIcon(this.img.IconEyes());
		panel_1.add(ShowConfirm);
		
		JLabel lblItsQuickAnd = new JLabel("It's quick and easy");
		lblItsQuickAnd.setForeground(new Color(243, 255, 253));
		lblItsQuickAnd.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblItsQuickAnd.setBounds(183, 89, 125, 25);
		panel_1.add(lblItsQuickAnd);
		
		lblCheck = new JLabel("");
		lblCheck.setForeground(Color.ORANGE);
		lblCheck.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCheck.setBounds(66, 482, 401, 25);
		panel_1.add(lblCheck);
		lblCheck.setIcon(this.img.IconWarning());
		
		JLabel lblPhoneNumber = new JLabel("Số điện thoại");
		lblPhoneNumber.setForeground(new Color(243, 255, 253));
		lblPhoneNumber.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(66, 258, 414, 25);
		panel_1.add(lblPhoneNumber);
		
		JLabel lbl3 = new JLabel("______________________________________________________________");
		lbl3.setForeground(new Color(243, 255, 253));
		lbl3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl3.setBounds(66, 300, 375, 21);
		panel_1.add(lbl3);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setSelectionColor(new Color(220, 204, 182));
		txtPhoneNumber.setForeground(Color.WHITE);
		txtPhoneNumber.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setCaretColor(Color.WHITE);
		txtPhoneNumber.setBorder(null);
		txtPhoneNumber.setBackground(SystemColor.textHighlight);
		txtPhoneNumber.setBounds(66, 278, 375, 36);
		panel_1.add(txtPhoneNumber);
		
		JLabel IconPhoneNumber = new JLabel("");
		IconPhoneNumber.setIcon(img.iconPhone());
		IconPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		IconPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconPhoneNumber.setBounds(10, 285, 46, 46);
		panel_1.add(IconPhoneNumber);

		this.disablepassword.setVisible(false);
		this.Showpassword.setVisible(false);
		disableConfirm.setVisible(false);
		ShowConfirm.setVisible(false);
		lblCheck.setVisible(false);
		
	}
	
	

	public void Exit() {
		System.exit(0);
	}

	public void ShowEyes() {
		String password = new String(this.txtPassword.getPassword());
		String passwordCofirm = new String(this.txtPasswordConfirm.getPassword());
		if (password.length() > 0) {
			this.disablepassword.setEnabled(true);
			this.disablepassword.setVisible(true);

		} else {
			this.disablepassword.setEnabled(false);
			this.disablepassword.setVisible(false);
		}

		if (passwordCofirm.length() > 0) {
			this.disableConfirm.setEnabled(true);
			this.disableConfirm.setVisible(true);

		} else {
			this.disableConfirm.setEnabled(false);
			this.disableConfirm.setVisible(false);
		}

	}

	public boolean Validate() {
		String User = this.txtUsername.getText().trim();
		String Email = this.txtEmail.getText().trim();
		String password = new String(this.txtPassword.getPassword()).trim();
		String passwordConfirm = new String(this.txtPasswordConfirm.getPassword()).trim();

		if (User.equals("")) {
			lblCheck.setText("Chưa Nhập Username!");
			lblCheck.setVisible(true);
			this.txtUsername.requestFocus();
			return false;
		}

		if (Email.equals("")) {
			lblCheck.setText("Chưa Nhập Email!");
			lblCheck.setVisible(true);
			this.txtEmail.requestFocus();
			return false;
		}

		if (!Email.matches(email)) {
			lblCheck.setText("Email Nhập Sai Định Dạng!");
			lblCheck.setVisible(true);
			this.txtEmail.requestFocus();
			return false;
		}
		
		if(txtPhoneNumber.getText().equals("")) {
			lblCheck.setText("Chưa nhập số điện thoại!");
			lblCheck.setVisible(true);
			this.txtEmail.requestFocus();
			return false;
		}
		
		if(!txtPhoneNumber.getText().matches(phone_pattern)) {
			lblCheck.setText("Số điện thoại nhập sai định dạng!");
			lblCheck.setVisible(true);
			this.txtEmail.requestFocus();
			return false;
		}

		if (password.equals("")) {
			lblCheck.setText("Chưa Nhập Password!");
			lblCheck.setVisible(true);
			this.txtPassword.requestFocus();
			return false;
		}

		if (passwordConfirm.equals("")) {
			lblCheck.setText("Chưa Nhập Password Confirm!");
			lblCheck.setVisible(true);
			this.txtPasswordConfirm.requestFocus();
			return false;
		}

		if (!passwordConfirm.equals(password)) {
			lblCheck.setText("Password Confirm Không Khớp Với Password!");
			lblCheck.setVisible(true);
			this.txtPasswordConfirm.requestFocus();
			return false;
		}

		if(chckbxIAgreeAll.isSelected()==false) {
			lblCheck.setText("Bạn Chưa Chọn Đồng Ý Để Tiếp Tục!");
			lblCheck.setVisible(true);
			return false;
		}
		return true;
	}

	public void Register() {
		if (Validate()) {
			String User = this.txtUsername.getText().trim();
			String Email = this.txtEmail.getText().trim();
			String phoneNumber = txtPhoneNumber.getText().trim();
			String password = new String(this.txtPassword.getPassword()).trim();
			String role = "Student";
			for (ModelAccount data : dao.SellectAll()) {
				if(data.getEmail().equals(Email)) {
					lblCheck.setText("Email đã tồn tại!");
					lblCheck.setVisible(true);
					txtUsername.requestFocus();
					return ;
				}else if(data.getPhoneNumber().equals(phoneNumber)) {
					lblCheck.setText("Số điện thoại đã tồn tại!");
					lblCheck.setVisible(true);
					txtUsername.requestFocus();
					return ;
				}else if(data.getUsername().equals(User)) {			
					lblCheck.setText("Username đã tồn tại!");
					lblCheck.setVisible(true);
					txtUsername.requestFocus();	
					return;
				}
	
			}
			dao.Insert(new ModelAccount(User, Email, password, phoneNumber, role));
			JOptionPane.showMessageDialog(null, "Đăng kí tài khoản thành công","Message",JOptionPane.INFORMATION_MESSAGE);
			
			
			
		}
	}
}
