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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpView extends JFrame {
	private img img = new img(this);
	private JPanel contentPane;
	private JLabel Exit;
	private SignUpController controller = new SignUpController(this);
	private UserDAO userDAO = new UserDAO();
	private JTextField textFieldUsername;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirm;
	private JLabel disablepassword;
	private JLabel Showpassword;
	private JLabel disableConfirm;
	private JLabel ShowConfirm;
	private String email = "^([a-z0-9_\\.-]){2,}+@([\\da-z]){2,}\\.([a-z]){2,}(\\.|[a-z]{2,}){0,}$";
	private JLabel lblCheck;
	private JCheckBox chckbxIAgreeAll;

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
		setBounds(100, 100, 1054, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 565, 557);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblImgLogin = new JLabel("");
		lblImgLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgLogin.setBounds(0, 41, 565, 459);
		panel.add(lblImgLogin);
		lblImgLogin.setIcon(this.img.ImageSignUp());

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(565, 0, 500, 557);
		panel_1.setBackground(SystemColor.textHighlight);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		Exit = new JLabel("X");
		Exit.setForeground(Color.WHITE);
		Exit.setHorizontalAlignment(SwingConstants.CENTER);
		Exit.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		Exit.setBounds(450, 0, 39, 36);
		Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Exit.addMouseListener(controller);
		panel_1.add(Exit);

		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		lblSignUp.setBounds(0, 61, 489, 46);
		panel_1.add(lblSignUp);

		JLabel IconUser = new JLabel("");
		IconUser.setHorizontalAlignment(SwingConstants.CENTER);
		IconUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconUser.setBounds(10, 152, 46, 46);
		IconUser.setIcon(this.img.IconUserSignUp());
		panel_1.add(IconUser);

		JLabel IconEmail = new JLabel("");
		IconEmail.setHorizontalAlignment(SwingConstants.CENTER);
		IconEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconEmail.setBounds(10, 228, 46, 46);
		IconEmail.setIcon(this.img.IconEmail());
		panel_1.add(IconEmail);

		JLabel IconPassword = new JLabel("");
		IconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		IconPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconPassword.setBounds(10, 305, 46, 46);
		IconPassword.setIcon(this.img.IconLock());
		panel_1.add(IconPassword);

		JLabel IconPasswordConfirm = new JLabel("");
		IconPasswordConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		IconPasswordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconPasswordConfirm.setBounds(10, 381, 46, 46);
		IconPasswordConfirm.setIcon(this.img.IconLock());
		panel_1.add(IconPasswordConfirm);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(243, 255, 253));
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername.setBounds(66, 125, 414, 25);
		panel_1.add(lblUsername);

		JLabel lblUsername_1 = new JLabel("______________________________________________________________");
		lblUsername_1.setForeground(new Color(243, 255, 253));
		lblUsername_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername_1.setBounds(66, 158, 375, 36);
		panel_1.add(lblUsername_1);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(243, 255, 253));
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblEmail.setBounds(66, 200, 414, 25);
		panel_1.add(lblEmail);

		JLabel lblUsername_1_1 = new JLabel("______________________________________________________________");
		lblUsername_1_1.setForeground(new Color(243, 255, 253));
		lblUsername_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername_1_1.setBounds(66, 233, 375, 36);
		panel_1.add(lblUsername_1_1);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(243, 255, 253));
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPassword.setBounds(66, 275, 414, 25);
		panel_1.add(lblPassword);

		JLabel lblUsername_1_1_1 = new JLabel("______________________________________________________________");
		lblUsername_1_1_1.setForeground(new Color(243, 255, 253));
		lblUsername_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername_1_1_1.setBounds(66, 321, 375, 21);
		panel_1.add(lblUsername_1_1_1);

		JLabel lblRepectPassword = new JLabel("ConfirmPassword");
		lblRepectPassword.setForeground(new Color(243, 255, 253));
		lblRepectPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblRepectPassword.setBounds(66, 352, 414, 25);
		panel_1.add(lblRepectPassword);

		JLabel lblUsername_1_1_1_1 = new JLabel("______________________________________________________________");
		lblUsername_1_1_1_1.setForeground(new Color(243, 255, 253));
		lblUsername_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername_1_1_1_1.setBounds(66, 398, 375, 21);
		panel_1.add(lblUsername_1_1_1_1);

		textFieldUsername = new JTextField();
		textFieldUsername.setForeground(Color.WHITE);
		textFieldUsername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textFieldUsername.setColumns(10);
		textFieldUsername.setCaretColor(Color.WHITE);
		textFieldUsername.setBorder(null);
		textFieldUsername.setBackground(SystemColor.textHighlight);
		textFieldUsername.setBounds(66, 145, 375, 36);
		panel_1.add(textFieldUsername);

		textFieldEmail = new JTextField();
		textFieldEmail.setForeground(Color.WHITE);
		textFieldEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textFieldEmail.setColumns(10);
		textFieldEmail.setCaretColor(Color.WHITE);
		textFieldEmail.setBorder(null);
		textFieldEmail.setBackground(SystemColor.textHighlight);
		textFieldEmail.setBounds(66, 221, 375, 36);
		panel_1.add(textFieldEmail);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBorder(null);
		passwordField.setBackground(SystemColor.textHighlight);
		passwordField.setBounds(66, 297, 341, 36);
		passwordField.addCaretListener(controller);
		panel_1.add(passwordField);

		passwordConfirm = new JPasswordField();
		passwordConfirm.setForeground(Color.WHITE);
		passwordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordConfirm.setCaretColor(Color.WHITE);
		passwordConfirm.setBorder(null);
		passwordConfirm.setBackground(SystemColor.textHighlight);
		passwordConfirm.setBounds(66, 374, 341, 36);
		passwordConfirm.addCaretListener(controller);
		panel_1.add(passwordConfirm);

		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.setForeground(SystemColor.textHighlight);
		btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnRegister.setBorder(null);
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setBounds(183, 495, 146, 46);
		btnRegister.addActionListener(controller);
		panel_1.add(btnRegister);

		chckbxIAgreeAll = new JCheckBox("I agree all statements in Term of servic\r\n");
		chckbxIAgreeAll.setForeground(Color.WHITE);
		chckbxIAgreeAll.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		chckbxIAgreeAll.setBackground(SystemColor.textHighlight);
		chckbxIAgreeAll.setBounds(66, 455, 286, 23);
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
		lblLogin.setBounds(362, 455, 79, 25);
		panel_1.add(lblLogin);

		disablepassword = new JLabel("");
		disablepassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar((char) 0);
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
		disablepassword.setBounds(402, 297, 36, 36);
		panel_1.add(disablepassword);

		Showpassword = new JLabel("");
		Showpassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar((char) 8226);
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
		Showpassword.setBounds(402, 297, 36, 36);
		panel_1.add(Showpassword);

		disableConfirm = new JLabel("");
		disableConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordConfirm.setEchoChar((char) 0);
				disableConfirm.setVisible(false);
				disableConfirm.setEnabled(false);
				ShowConfirm.setVisible(true);
				ShowConfirm.setEnabled(true);
			}
		});
		disableConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		disableConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		disableConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		disableConfirm.setBounds(402, 374, 36, 36);
		panel_1.add(disableConfirm);
		disableConfirm.setIcon(this.img.IconEyesInvisible());

		ShowConfirm = new JLabel("");
		ShowConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordConfirm.setEchoChar((char) 8226);
				disableConfirm.setVisible(true);
				disableConfirm.setEnabled(true);
				ShowConfirm.setVisible(false);
				ShowConfirm.setEnabled(false);
			}
		});
		ShowConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ShowConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		ShowConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ShowConfirm.setBounds(402, 374, 36, 36);
		ShowConfirm.setIcon(this.img.IconEyes());
		panel_1.add(ShowConfirm);
		
		JLabel lblItsQuickAnd = new JLabel("It's quick and easy");
		lblItsQuickAnd.setForeground(new Color(243, 255, 253));
		lblItsQuickAnd.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblItsQuickAnd.setBounds(186, 104, 125, 25);
		panel_1.add(lblItsQuickAnd);
		
		lblCheck = new JLabel("");
		lblCheck.setForeground(Color.ORANGE);
		lblCheck.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCheck.setBounds(66, 425, 401, 25);
		panel_1.add(lblCheck);
		lblCheck.setIcon(this.img.IconWarning());

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
		String password = new String(this.passwordField.getPassword());
		String passwordCofirm = new String(this.passwordConfirm.getPassword());
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
		String User = this.textFieldUsername.getText().trim();
		String Email = this.textFieldEmail.getText().trim();
		String password = new String(this.passwordField.getPassword()).trim();
		String passwordConfirm = new String(this.passwordConfirm.getPassword()).trim();

		if (User.equals("")) {
			lblCheck.setText("Chưa Nhập Username!");
			lblCheck.setVisible(true);
			this.textFieldUsername.requestFocus();
			return false;
		}

		if (Email.equals("")) {
			lblCheck.setText("Chưa Nhập Email!");
			lblCheck.setVisible(true);
			this.textFieldEmail.requestFocus();
			return false;
		}

		if (!Email.matches(email)) {
			lblCheck.setText("Email Nhập Sai Định Dạng!");
			lblCheck.setVisible(true);
			this.textFieldEmail.requestFocus();
			return false;
		}

		if (password.equals("")) {
			lblCheck.setText("Chưa Nhập Password!");
			lblCheck.setVisible(true);
			this.passwordField.requestFocus();
			return false;
		}

		if (passwordConfirm.equals("")) {
			lblCheck.setText("Chưa Nhập Password Confirm!");
			lblCheck.setVisible(true);
			this.passwordConfirm.requestFocus();
			return false;
		}

		if (!passwordConfirm.equals(password)) {
			lblCheck.setText("Password Confirm Không Khớp Với Password!");
			lblCheck.setVisible(true);
			this.passwordConfirm.requestFocus();
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
			String User = this.textFieldUsername.getText().trim();
			String Email = this.textFieldEmail.getText().trim();
			String password = new String(this.passwordField.getPassword()).trim();
			String Role = "User";
			if (this.userDAO.Insert(User, Email, password, Role)>1) {
				JOptionPane.showMessageDialog(this, "Register Succesfully");
				lblCheck.setText("");
				lblCheck.setVisible(false);
			} else if(this.userDAO.Insert(User, Email, password, Role)==1){
				lblCheck.setText("Username Đã Tồn Tại!");
				this.textFieldUsername.requestFocus();
				lblCheck.setVisible(true);
			}else if(this.userDAO.Insert(User, Email, password, Role)==0){
				lblCheck.setText("Email Đã Được Đăng Ký!");
				this.textFieldEmail.requestFocus();
				lblCheck.setVisible(true);
			}
		}
	}
}
