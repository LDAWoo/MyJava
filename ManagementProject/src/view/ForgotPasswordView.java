package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import controller.ForgotPasswordController;
import dao.ForgotPasswordDAO;
import img.img;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForgotPasswordView extends JFrame {
	private img img = new img();
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private ForgotPasswordController controller = new ForgotPasswordController(this);
	private ForgotPasswordDAO daoPasswordDAO = new ForgotPasswordDAO();
	private String emailMaches = "^([a-z0-9_\\.-]){2,}+@([\\da-z]){2,}\\.([a-z]){2,}(\\.|[a-z]{2,}){0,}$";
	private JLabel lblCheck;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ForgotPasswordView frame = new ForgotPasswordView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ForgotPasswordView() {
		setBackground(SystemColor.textHighlight);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 303);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Forgot Password\r\n");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 32, 450, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your email address");
		lblNewLabel_1.setForeground(SystemColor.window);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(0, 74, 450, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel Exit = new JLabel("X");
		Exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUserView view = new LoginUserView();
				setVisible(false);
				view.setVisible(true);
				view.setLocationRelativeTo(null);
			}
		});
		Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Exit.setForeground(SystemColor.window);
		Exit.setFont(new Font("Segoe UI", Font.BOLD, 22));
		Exit.setHorizontalAlignment(SwingConstants.CENTER);
		Exit.setBounds(411, 0, 39, 39);
		contentPane.add(Exit);
		
		JLabel lblEnterEmailAddress = new JLabel("Enter email address");
		lblEnterEmailAddress.setForeground(new Color(243, 255, 253));
		lblEnterEmailAddress.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblEnterEmailAddress.setBounds(51, 106, 362, 25);
		contentPane.add(lblEnterEmailAddress);
		
		JLabel lblUsername_1 = new JLabel("___________________________________________________________");
		lblUsername_1.setForeground(new Color(243, 255, 253));
		lblUsername_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername_1.setBounds(52, 152, 375, 36);
		contentPane.add(lblUsername_1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setForeground(Color.WHITE);
		textFieldEmail.setSelectionColor(new Color(220, 204, 182));
		textFieldEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textFieldEmail.setColumns(10);
		textFieldEmail.setCaretColor(Color.WHITE);
		textFieldEmail.setBorder(null);
		textFieldEmail.setBackground(SystemColor.textHighlight);
		textFieldEmail.setBounds(51, 131, 365, 43);
		contentPane.add(textFieldEmail);
		
		JButton btnContine = new JButton("Continue");
		btnContine.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnContine.setForeground(SystemColor.textHighlight);
		btnContine.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnContine.setBorder(null);
		btnContine.setBackground(Color.WHITE);
		btnContine.setBounds(51, 220, 354, 46);
		btnContine.addActionListener(controller);
		contentPane.add(btnContine);
		
		JLabel IconEmail = new JLabel("");
		IconEmail.setHorizontalAlignment(SwingConstants.CENTER);
		IconEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconEmail.setBounds(5, 135, 46, 46);
		IconEmail.setIcon(this.img.IconEmail());
		contentPane.add(IconEmail);
		
		lblCheck = new JLabel("");
		lblCheck.setForeground(Color.ORANGE);
		lblCheck.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCheck.setBounds(51, 186, 362, 25);
		contentPane.add(lblCheck);
		lblCheck.setIcon(this.img.IconWarning());
		lblCheck.setVisible(false);

	}
	
	public boolean Validate() {
		String email = textFieldEmail.getText();
		if(email.equals("")) {
			lblCheck.setText("Chưa Nhập Email!");
			lblCheck.setVisible(true);
			textFieldEmail.requestFocus();
			return false;
		}
		if(!email.matches(emailMaches)) {
			lblCheck.setText("Email Không Đúng Định Dạng!");
			lblCheck.setVisible(true);
			textFieldEmail.requestFocus();
			return false;
		}
		
		return true;
	}
	
	
	public void Continue() {
		if(Validate()) {
		lblCheck.setText("");
		lblCheck.setVisible(false);
		String email = textFieldEmail.getText();
		if(this.daoPasswordDAO.ForgotEmail(email)>0){
			ChangePasswordView view = new ChangePasswordView();
			setVisible(false);
			view.setVisible(true);
			view.getEmail().setText(email);
			view.setLocationRelativeTo(null);
		}else {
			lblCheck.setText("Email Không Đúng Hoặc Không Tồn Tại!");
			lblCheck.setVisible(true);
			textFieldEmail.requestFocus();
		}
	
		}
	}
	
	
	
}

