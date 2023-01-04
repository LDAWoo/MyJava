package componentLogin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import animation.TextField;
import animation.TextPasswordField;
import componentButton.Button;
import componentForgot.MainForgot;
import componentSignUp.MainSignUp;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class MainLogin extends JFrame {
	Point currCoords;
	Point mouseDownCompCoords;
	private JPanel contentPane;
	private static MainLogin frame;
	private Color color;
	private Color colorBackgroundPanel = new Color(50, 50, 50);
	private Color colorForegroundButton = new Color(200, 200, 200);

	private JButton btnExit;
	private JPanel panel;
	
	private PanelNorth panelNorth;
	private PanelEast panelEast;
	private JLabel lbl2;
	
	private TextField txtEmail;
	private TextPasswordField txtPassword;

	private JCheckBox checkBoxRemenberMe;
	private JLabel lblError;
	private JButton btnLogin;
	private Button btnSignUp;
	private JLabel lblForgotPassword;
	private JLabel lblTitle;
	private PanelWest panelWest;
	private JLabel lblImageShop;
	private JLabel lblLogoShop;
	private ImageIcon imageShop = new ImageIcon(new ImageIcon(MainLogin.class.getResource("/icon/shop.png")).getImage().getScaledInstance(310, 480, Image.SCALE_SMOOTH));
	private ImageIcon imageLogoShop = new ImageIcon(new ImageIcon(MainLogin.class.getResource("/icon/logo-shop.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
	public MainLogin() {
		setUndecorated(true);   
		setBounds(100, 100, 740, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 740, 570);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panelNorth = new PanelNorth();
		panelNorth.setBounds(0, 0, 740, 30);
		panel.add(panelNorth);
		panelNorth.setLayout(null);
		
		btnExit = new JButton();
		btnExit.setFocusPainted(false);
		btnExit.setOpaque(false);
		btnExit.setIcon(new ImageIcon(MainLogin.class.getResource("/icon/close.png")));
		btnExit.setBorder(null);
		btnExit.setBounds(710, 0, 30, 30);
		panelNorth.add(btnExit);
		
		panelEast = new PanelEast();
		panelEast.setBounds(370, 30, 370, 540);
		panel.add(panelEast);
		panelEast.setLayout(null);
		
		JLabel lbl1 = new JLabel("________________________________________");
		lbl1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setForeground(new Color(150,150,150));
		lbl1.setBounds(77, 220, 240, 11);
		panelEast.add(lbl1);
		
		txtEmail = new TextField();
		txtEmail.setHint("Tên đăng nhập/E-mail");
		txtEmail.setCaretColor(new Color(250,250,250));
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtEmail.setForeground(new Color(150,150,150));
		txtEmail.setBorder(null);
		txtEmail.setOpaque(false);
		txtEmail.setBounds(107, 199, 210, 30);
		panelEast.add(txtEmail);
		txtEmail.setColumns(10);
		
		lbl2 = new JLabel("________________________________________");
		lbl2.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setForeground(new Color(150, 150, 150));
		lbl2.setBounds(77, 260, 240, 11);
		panelEast.add(lbl2);
		
		txtPassword = new TextPasswordField();
		txtPassword.setOpaque(false);
		txtPassword.setHint("Mật khẩu");
		txtPassword.setForeground(new Color(150, 150, 150));
		txtPassword.setCaretColor(new Color(250,250,250));
		txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		txtPassword.setBorder(null);
		txtPassword.setBounds(107, 239, 210, 30);
		panelEast.add(txtPassword);
		
	
		checkBoxRemenberMe = new JCheckBox("   Nhớ Mật Khẩu");
	
		checkBoxRemenberMe.setForeground(new Color(150, 150, 150));
		checkBoxRemenberMe.setFont(new Font("SansSerif", Font.PLAIN, 13));
		checkBoxRemenberMe.setOpaque(false);
		checkBoxRemenberMe.setBounds(72, 290, 122, 23);
		checkBoxRemenberMe.setFocusPainted(false);
		checkBoxRemenberMe.setContentAreaFilled(false);
		checkBoxRemenberMe.setBorderPainted(false);
		
		panelEast.add(checkBoxRemenberMe);
		
		lblError = new JLabel("  Đăng Nhập Thất Bại");
		lblError.setIcon(new ImageIcon(MainLogin.class.getResource("/icon/warning.png")));
		lblError.setForeground(new Color(220, 20, 20));
		lblError.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblError.setBounds(77, 320, 240, 30);
//		lblError.setVisible(false);
		
		panelEast.add(lblError);
	
		btnLogin = new JButton("Đăng nhập");
		btnLogin.setFocusPainted(false);
		btnLogin.setForeground(new Color(250,250,250));
		btnLogin.setBackground(new Color(220,20,20));
		btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnLogin.setBorder(null);
		btnLogin.setBounds(77, 383, 240, 45);
		panelEast.add(btnLogin);
		
		btnSignUp = new Button("Tạo tài khoản");
		btnSignUp.setForeground(new Color(155,155,155));
		btnSignUp.setColor(new Color(150,150,150));
		btnSignUp.setText("Tạo tài khoản");
		btnSignUp.setBounds(77, 435, 240, 30);
		panelEast.add(btnSignUp);
		
		lblForgotPassword = new JLabel("Quên mật khẩu?");
		lblForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblForgotPassword.setForeground(new Color(150,150,150));
		lblForgotPassword.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblForgotPassword.setBounds(77, 499, 96, 30);
		panelEast.add(lblForgotPassword);
		
		lblTitle = new JLabel("FASHION SHOP");
		lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblTitle.setForeground(new Color(220,20,20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(77, 120, 240, 50);
		panelEast.add(lblTitle);
		
		lblLogoShop = new JLabel("");
		lblLogoShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoShop.setVerticalAlignment(SwingConstants.BOTTOM);
		
		lblLogoShop.setBounds(77, 0, 240, 119);
		lblLogoShop.setIcon(imageLogoShop);
		panelEast.add(lblLogoShop);
		
		panelWest = new PanelWest();
		panelWest.setOpaque(false);
		panelWest.setBounds(0, 30, 370, 540);
		panel.add(panelWest);
		panelWest.setLayout(null);
		
		lblImageShop = new JLabel("");
		lblImageShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageShop.setIcon(imageShop);
		lblImageShop.setBounds(30, 30, 310, 480);
		panelWest.add(lblImageShop);

		actionButton();
	}
	
	public void actionButton() {
		txtEmail.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				if(txtEmail.getText().length()>0) {
					txtEmail.setForeground(new Color(250,250,250));
				}else {
					txtEmail.setForeground(new Color(150,150,150));
				}
				
			}
		});
		
		txtPassword.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				if(txtPassword.getText().length()>0) {
					txtPassword.setForeground(new Color(250,250,250));
				}else {
					txtPassword.setForeground(new Color(150,150,150));
				}
				
			}
		});
		
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					System.exit(0);
			}
			
		});
		
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setOpaque(true);
				btnExit.setBackground(Color.decode("#1F1C18"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setOpaque(false);		
			}
		});
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(245,100,100));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(220,20,20));
			}
		});
		
		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					MainSignUp.setVisible(true, null);
					setVisible(false);
			}
			
		});
		
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSignUp.setColor(new Color(220,20,20));
				btnSignUp.setForeground(new Color(220,20,20));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnSignUp.setColor(new Color(150,150,150));
				btnSignUp.setForeground(new Color(150,150,150));
			}
		});
		
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblForgotPassword.setForeground(new Color(250,250,250));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblForgotPassword.setForeground(new Color(150,150,150));
			}
		});
		
		
		panelNorth.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseDownCompCoords = e.getPoint();
			}
		});
		
		panelNorth.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				currCoords = e.getLocationOnScreen();
				setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
			}
			
		});
		
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount()==1) {
					MainForgot.setVisible(true, null);
					setVisible(false);
				}
			}
		});
		
	}
	
	public static void setVisible(boolean option, Window setLocationRelativeTo) {
		frame =new MainLogin();
		frame.setVisible(option);
		frame.setLocationRelativeTo(setLocationRelativeTo);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new MainLogin();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
