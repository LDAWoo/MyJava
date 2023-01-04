package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import img.img;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.ChangepasswordController;
import dao.ForgotPasswordDAO;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class ChangePasswordView extends JFrame {
	private img img = new img();
	private JPanel contentPane;
	private ChangepasswordController controller = new ChangepasswordController(this);
	private JLabel Email;
	private ForgotPasswordDAO forgotPasswordDAO = new ForgotPasswordDAO();
	private JPasswordField passwordCreate;
	private JPasswordField passwordConfirm;
	private JLabel ShowCreate;
	private JLabel ShowConfirm;
	private JLabel disableConfirm;
	private JLabel disableCreate;
	private JLabel lblCheck;
	

	public ChangePasswordView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 373);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewPassword = new JLabel("New Password\r\n");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewPassword.setBounds(0, 37, 450, 41);
		contentPane.add(lblNewPassword);
		
		JLabel lblCreateNewPassword = new JLabel("Create new password\r\n");
		lblCreateNewPassword.setForeground(new Color(243, 255, 253));
		lblCreateNewPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCreateNewPassword.setBounds(46, 102, 362, 25);
		contentPane.add(lblCreateNewPassword);
		
		JLabel lblUsername_1 = new JLabel("___________________________________________________________");
		lblUsername_1.setForeground(new Color(243, 255, 253));
		lblUsername_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername_1.setBounds(46, 153, 375, 24);
		contentPane.add(lblUsername_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password\r\n");
		lblConfirmPassword.setForeground(new Color(243, 255, 253));
		lblConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblConfirmPassword.setBounds(46, 184, 362, 25);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblUsername_1_1 = new JLabel("___________________________________________________________");
		lblUsername_1_1.setForeground(new Color(243, 255, 253));
		lblUsername_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername_1_1.setBounds(46, 228, 375, 36);
		contentPane.add(lblUsername_1_1);
		
		JButton btnChange = new JButton("Change");
		btnChange.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChange.setForeground(SystemColor.textHighlight);
		btnChange.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnChange.setBorder(null);
		btnChange.setBackground(Color.WHITE);
		btnChange.setBounds(46, 294, 354, 46);
		btnChange.addActionListener(controller);
		contentPane.add(btnChange);
		
		JLabel Exit = new JLabel("X");
		Exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				LoginUserView view = new LoginUserView();
				view.setVisible(true);
				view.setLocationRelativeTo(null);
			}
		});
		Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Exit.setHorizontalAlignment(SwingConstants.CENTER);
		Exit.setForeground(Color.WHITE);
		Exit.setFont(new Font("Segoe UI", Font.BOLD, 22));
		Exit.setBounds(411, 0, 39, 39);
		contentPane.add(Exit);
		
		JLabel IconCreate = new JLabel("");
		IconCreate.setHorizontalAlignment(SwingConstants.CENTER);
		IconCreate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconCreate.setBounds(0, 127, 46, 46);
		IconCreate.setIcon(this.img.IconLock());
		contentPane.add(IconCreate);
		
		JLabel IconConfirm = new JLabel("");
		IconConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		IconConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconConfirm.setBounds(0, 204, 46, 46);
		IconConfirm.setIcon(this.img.IconLock());
		contentPane.add(IconConfirm);
		
		Email = new JLabel("");
		Email.setVisible(false);
		Email.setForeground(new Color(243, 255, 253));
		Email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Email.setBounds(46, 76, 176, 25);
		contentPane.add(Email);
		
		passwordCreate = new JPasswordField();
		passwordCreate.setForeground(Color.WHITE);
		passwordCreate.setSelectionColor(new Color(220, 204, 182));
		passwordCreate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordCreate.setCaretColor(Color.WHITE);
		passwordCreate.setBorder(null);
		passwordCreate.setBackground(SystemColor.textHighlight);
		passwordCreate.setBounds(48, 127, 308, 43);
		passwordCreate.addCaretListener(controller);
		contentPane.add(passwordCreate);
		
		passwordConfirm = new JPasswordField();
		passwordConfirm.setForeground(Color.WHITE);
		passwordConfirm.setSelectionColor(new Color(220, 204, 182));
		passwordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordConfirm.setCaretColor(Color.WHITE);
		passwordConfirm.setBorder(null);
		passwordConfirm.setBackground(SystemColor.textHighlight);
		passwordConfirm.setBounds(48, 207, 308, 43);
		passwordConfirm.addCaretListener(controller);
		contentPane.add(passwordConfirm);
		
		disableCreate = new JLabel("");
		disableCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		disableCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordCreate.setEchoChar((char)0);
				disableCreate.setEnabled(false);
				disableCreate.setVisible(false);
				ShowCreate.setEnabled(true);
				ShowCreate.setVisible(true);
				
			}
		});
		disableCreate.setHorizontalAlignment(SwingConstants.CENTER);
		disableCreate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		disableCreate.setBounds(356, 127, 46, 46);
		disableCreate.setIcon(this.img.IconEyesInvisible());
		contentPane.add(disableCreate);
		
		disableConfirm = new JLabel("");
		disableConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordConfirm.setEchoChar((char)0);
				disableConfirm.setEnabled(false);
				disableConfirm.setVisible(false);
				ShowConfirm.setEnabled(true);
				ShowConfirm.setVisible(true);
			}
		});
		disableConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		disableConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		disableConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		disableConfirm.setBounds(356, 204, 46, 46);
		disableConfirm.setIcon(this.img.IconEyesInvisible());
		contentPane.add(disableConfirm);
		
		ShowCreate = new JLabel("");
		ShowCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ShowCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordCreate.setEchoChar((char) 8226);
				ShowCreate.setEnabled(false);
				ShowCreate.setVisible(false);
				disableCreate.setEnabled(true);
				disableCreate.setVisible(true);
			}
		});
		ShowCreate.setHorizontalAlignment(SwingConstants.CENTER);
		ShowCreate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ShowCreate.setBounds(356, 127, 46, 46);
		ShowCreate.setIcon(this.img.IconEyes());
		contentPane.add(ShowCreate);
		
		ShowConfirm = new JLabel("");
		ShowConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordConfirm.setEchoChar((char) 8226);
				ShowConfirm.setEnabled(false);
				ShowConfirm.setVisible(false);
				disableConfirm.setEnabled(true);
				disableConfirm.setVisible(true);
			}
		});
		ShowConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ShowConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		ShowConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ShowConfirm.setBounds(356, 204, 46, 46);
		ShowConfirm.setIcon(this.img.IconEyes());
		contentPane.add(ShowConfirm);
		
		lblCheck = new JLabel("");
		lblCheck.setForeground(Color.ORANGE);
		lblCheck.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCheck.setBounds(46, 262, 362, 25);
		contentPane.add(lblCheck);
		lblCheck.setIcon(this.img.IconWarning());
		
		
		disableConfirm.setVisible(false);
		disableCreate.setVisible(false);
		ShowConfirm.setVisible(false);
		ShowCreate.setVisible(false);
		lblCheck.setVisible(false);
	}
	
	public boolean Validate() {
		String CreatePass = new String(passwordCreate.getPassword());
		String ConfirmPass = new String(passwordConfirm.getPassword());
		
		if(CreatePass.equals("")) {
			lblCheck.setText("Chưa Nhập Password");
			lblCheck.setVisible(true);
			passwordCreate.requestFocus();
			return false;
		}
		if(ConfirmPass.equals("")) {
			lblCheck.setText("Chưa Nhập Password Confirm");
			lblCheck.setVisible(true);
			passwordConfirm.requestFocus();
			return false;
		}
		
		if(!CreatePass.equals(ConfirmPass)) {
			lblCheck.setText("Password Confirm Không Khớp");
			lblCheck.setVisible(true);
			passwordConfirm.requestFocus();
			return false;
		}
		
		return true;
	}
	
	
	public void Change() {
		if(Validate()) {
		lblCheck.setText("");
		lblCheck.setVisible(false);
		String Email = getEmail().getText();
		String Pass = new String(passwordCreate.getPassword());
		if(forgotPasswordDAO.ChangePassword(Email, Pass)>0) {
			LoginUserView view = new LoginUserView();
			setVisible(false);
			view.setVisible(true);
			view.setLocationRelativeTo(null);
		}
		
		}
	}
	
	public void ChangeText() {
		String passCreate = new String(passwordCreate.getPassword());
		String passConfirm = new String(passwordConfirm.getPassword());
		
		if(passCreate.length()>0) {
			disableCreate.setVisible(true);
			disableCreate.setEnabled(true);
		}else {
			disableCreate.setVisible(false);
			disableCreate.setEnabled(false);
		}
		
		if(passConfirm.length()>0) {
			disableConfirm.setVisible(true);
			disableConfirm.setEnabled(true);
		}else {
			disableConfirm.setVisible(false);
			disableConfirm.setEnabled(false);
		}
		
	}

	public JLabel getEmail() {
		return Email;
	}

	public void setEmail(JLabel email) {
		Email = email;
	}
}
