package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.UserController;
import dao.UserDAO;
import img.img;
import model.UserModel;
import view2.FrameView;
import view2.Menu;
import view2.ProgressbarView;

import javax.swing.BoxLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginUserView extends JFrame {

	private JPanel contentPane;
	private img img = new img(this);
	private JLabel Exit;
	private UserController controller = new UserController(this);
	private ForgotPasswordView view = new ForgotPasswordView();
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	private JLabel disable;
	private JLabel Show;
	private UserDAO userDAO = new UserDAO();
	private JLabel lblCheck;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					LoginUserView frame = new LoginUserView();
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginUserView() {
		
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
		lblImgLogin.setBounds(0, 90, 474, 340);
		panel.add(lblImgLogin);
		lblImgLogin.setIcon(this.img.ImageLogin());

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(564, 0, 490, 557);
		panel_1.setBackground(SystemColor.textHighlight);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		Exit = new JLabel("X");
		Exit.setForeground(Color.WHITE);
		Exit.setHorizontalAlignment(SwingConstants.CENTER);
		Exit.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		Exit.setBounds(450, 0, 39, 39);
		Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Exit.addMouseListener(controller);
		panel_1.add(Exit);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 61, 489, 46);
		panel_1.add(lblNewLabel);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername.setBounds(35, 150, 414, 25);
		lblUsername.setForeground(Color.getHSBColor(208, 67, 62));
		panel_1.add(lblUsername);

		JLabel IconUser = new JLabel("");
		IconUser.setHorizontalAlignment(SwingConstants.CENTER);
		IconUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconUser.setBounds(410, 185, 46, 46);
		panel_1.add(IconUser);
		IconUser.setIcon(this.img.IconUser());

		JLabel lblUsername_1 = new JLabel("______________________________________________________________");
		lblUsername_1.setForeground(new Color(243, 255, 253));
		lblUsername_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername_1.setBounds(35, 193, 375, 36);
		panel_1.add(lblUsername_1);

		JLabel lblPasword = new JLabel("Password");
		lblPasword.setForeground(new Color(243, 255, 253));
		lblPasword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPasword.setBounds(35, 227, 414, 25);
		panel_1.add(lblPasword);

		JLabel lblPassword1 = new JLabel("______________________________________________________________");
		lblPassword1.setForeground(new Color(243, 255, 253));
		lblPassword1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPassword1.setBounds(35, 270, 375, 36);
		panel_1.add(lblPassword1);

		disable = new JLabel("");
		disable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar((char) 0);
				disable.setVisible(false);
				disable.setEnabled(false);
				Show.setVisible(true);
				Show.setEnabled(true);
			}
		});
		disable.setHorizontalAlignment(SwingConstants.CENTER);
		disable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		disable.setBounds(410, 263, 46, 46);
		panel_1.add(disable);
		disable.setIcon(this.img.IconEyesInvisible());
		disable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JCheckBox chckbxRemenber = new JCheckBox("Remenber Password ");
		chckbxRemenber.setForeground(SystemColor.text);
		chckbxRemenber.setBackground(SystemColor.textHighlight);
		chckbxRemenber.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		chckbxRemenber.setBounds(37, 310, 163, 23);
		panel_1.add(chckbxRemenber);

		JLabel lblForgetPassword = new JLabel("Forget Password?");
		lblForgetPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				view.setVisible(true);
				view.setLocationRelativeTo(null);
			}
		});
		lblForgetPassword.setForeground(new Color(243, 255, 253));
		lblForgetPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblForgetPassword.setBounds(313, 319, 116, 25);
		panel_1.add(lblForgetPassword);
		lblForgetPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBorder(null);
		btnLogin.setBackground(SystemColor.text);
		btnLogin.setForeground(SystemColor.textHighlight);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnLogin.addActionListener(controller);
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnLogin.setBounds(35, 382, 411, 46);
		panel_1.add(btnLogin);

		JLabel lblDontHaveAn = new JLabel("Don't have an account?");
		lblDontHaveAn.setForeground(new Color(243, 255, 253));
		lblDontHaveAn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblDontHaveAn.setBounds(124, 461, 154, 25);
		panel_1.add(lblDontHaveAn);

		JLabel lblSignUp = new JLabel("Sign Up Now");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUpView signUpView = new SignUpView();
				setVisible(false);
				signUpView.setLocationRelativeTo(null);
				signUpView.setVisible(true);

			}
		});
		lblSignUp.setForeground(new Color(243, 255, 253));
		lblSignUp.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSignUp.setBounds(290, 461, 87, 25);
		panel_1.add(lblSignUp);
		lblSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel lblHelloLetsGet = new JLabel("Hello! Let's get started");
		lblHelloLetsGet.setForeground(new Color(243, 255, 253));
		lblHelloLetsGet.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblHelloLetsGet.setBounds(168, 118, 154, 25);
		panel_1.add(lblHelloLetsGet);

		textFieldUser = new JTextField();
		textFieldUser.setCaretColor(SystemColor.text);
		textFieldUser.setForeground(SystemColor.text);
		textFieldUser.setBorder(null);
		textFieldUser.setBackground(SystemColor.textHighlight);
		textFieldUser.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textFieldUser.setBounds(35, 173, 365, 43);
		panel_1.add(textFieldUser);
		textFieldUser.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setCaretColor(SystemColor.text);
		passwordField.setBorder(null);
		passwordField.setForeground(SystemColor.text);
		passwordField.setBackground(SystemColor.textHighlight);
		passwordField.setBounds(35, 250, 365, 43);
		panel_1.add(passwordField);

		Show = new JLabel("");
		Show.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar((char) 8226);
				disable.setVisible(true);
				disable.setEnabled(true);
				Show.setVisible(false);
				Show.setEnabled(false);
			}
		});
		Show.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Show.setHorizontalAlignment(SwingConstants.CENTER);
		Show.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Show.setBounds(410, 263, 46, 46);
		Show.setIcon(this.img.IconEyes());

		panel_1.add(Show);
		
		lblCheck = new JLabel("");
		lblCheck.setForeground(Color.ORANGE);
		lblCheck.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCheck.setBounds(35, 346, 414, 25);
		panel_1.add(lblCheck);
		lblCheck.setIcon(this.img.IconWarning());
		lblCheck.setVisible(false);
		setVisible(true);
		
	}

	public void Exit() {
		System.exit(0);
	}

	public boolean Validate() {
		String username = this.textFieldUser.getText();
		String password = new String(this.passwordField.getPassword());

		if (username.equals("")) {
			lblCheck.setText("Chưa Nhập Username!");
			lblCheck.setVisible(true);
			this.textFieldUser.requestFocus();
			return false;
		}

		if (password.equals("")) {
			lblCheck.setText("Chưa Nhập Password!");
			lblCheck.setVisible(true);
			this.passwordField.requestFocus();
			return false;
		}

		return true;
	}
	


	public void Login() {
		if(Validate()) {
		String username = this.textFieldUser.getText().trim();
		String password = new String(this.passwordField.getPassword()).trim();
		String Admin = "Admin";
		String User = "User";
		if(this.userDAO.selectAll(username, password).equals(Admin)) {
			ProgressbarView pbView = new ProgressbarView(username, Admin);
			pbView.setVisible(true);
			dispose();

		}else if(this.userDAO.selectAll(username, password).equals(User)) {
			ProgressbarView pbView = new ProgressbarView(username, User);
			pbView.setVisible(true);
			dispose();
		}
		else {
			lblCheck.setText("Sai Username Hoặc Password Không Đúng!");
			lblCheck.setVisible(true);
			this.passwordField.requestFocus();
		}
		
		}
		
	}
				
	}


