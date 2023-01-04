package componentForgot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import componentSignUp.DialogLanguage;
import componentSignUp.PanelNorth;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import componentButton.Button;
import componentLogin.MainLogin;
import java.awt.Cursor;

public class MainForgot extends JFrame {

	private JPanel contentPane;
	private ImageIcon imageLogoShop = new ImageIcon(new ImageIcon(MainForgot.class.getResource("/icon/logo-shop.png")).getImage().getScaledInstance(66, 66, Image.SCALE_SMOOTH));
	private Button btnLanguage;
	private static MainForgot frame;
	private java.awt.Point point = null;
	private int xScreen;
	private int yScreen;
	private JPanel panelBody;
	private JButton btnLogin;
	
	public MainForgot() {
		setUndecorated(true);
		setBounds(100, 100, 971, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JPanel body = new JPanel();
		body.setBackground(new Color(200,200,200));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(body, GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(body, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
		);
		
		PanelNorth panelNorth = new PanelNorth();
		panelNorth.setBounds(0, 0, 971, 25);
		panelNorth.setOpaque(false);
		
		JButton btnMinimize = new JButton("");
		btnMinimize.setIcon(new ImageIcon(MainForgot.class.getResource("/icon/minus.png")));
		btnMinimize.setOpaque(false);
		btnMinimize.setForeground(SystemColor.scrollbar);
		btnMinimize.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnMinimize.setFocusPainted(false);
		btnMinimize.setBorder(null);
		
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(MainForgot.class.getResource("/icon/close.png")));
		btnExit.setOpaque(false);
		btnExit.setForeground(SystemColor.scrollbar);
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnExit.setFocusPainted(false);
		btnExit.setBorder(null);
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap(908, Short.MAX_VALUE)
					.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGap(0, 25, Short.MAX_VALUE)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExit)
						.addComponent(btnMinimize))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelNorth.setLayout(gl_panelNorth);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 25, 971, 93);
		panel.setBackground(new Color(250, 250, 250));
		
		JLabel lblLogoShop = new JLabel("");
		lblLogoShop.setIcon(imageLogoShop);
		lblLogoShop.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblTitle = new JLabel("FASHION SHOP");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(new Color(220, 20, 20));
		lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		
		btnLanguage = new Button("");
		btnLanguage.setIcon(new ImageIcon(MainForgot.class.getResource("/icon/earths.png")));
		btnLanguage.setText("Việt Nam - Tiếng Việt");
		btnLanguage.setHorizontalAlignment(SwingConstants.LEFT);
		btnLanguage.setForeground(new Color(50, 50, 50));
		btnLanguage.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		btnLogin = new JButton("Đăng Nhập Tại Đây");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setForeground(new Color(230, 230, 230));
		btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(220, 20, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addGap(170)
					.addComponent(lblLogoShop)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLanguage, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addComponent(btnLanguage, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
								.addComponent(lblLogoShop, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		body.setLayout(null);
		body.add(panelNorth);
		body.add(panel);
		
		panelBody = new JPanel();
		panelBody.setBounds(210, 142, 550, 328);
		PanelVietnamese panelVietnamese = new PanelVietnamese();
		panelVietnamese.setBounds(0, 0, 550, 328);
		
		panelBody.add(panelVietnamese);
		body.add(panelBody);
		GroupLayout gl_panelBody = new GroupLayout(panelBody);
		gl_panelBody.setHorizontalGroup(
			gl_panelBody.createParallelGroup(Alignment.LEADING)
				.addGap(0, 730, Short.MAX_VALUE)
		);
		gl_panelBody.setVerticalGroup(
			gl_panelBody.createParallelGroup(Alignment.LEADING)
				.addGap(0, 328, Short.MAX_VALUE)
		);
		panelBody.setLayout(gl_panelBody);
		contentPane.setLayout(gl_contentPane);
		actionButton();
	}
	
	public void addComponent(JComponent panel) {
		panelBody.removeAll();
		panelBody.revalidate();
		panelBody.repaint();
		panel.setBounds(0, 0, 550, 328);
		panelBody.add(panel);
	}
	
	public void actionButton() {
		DialogLanguage dialog = new DialogLanguage(null);
		
		btnLanguage.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount()==1) {
					dialog.setLocation(xScreen, yScreen);
					dialog.setVisible(true);
				}else {
					dialog.setVisible(false);
				}
			}
		});
		
		dialog.addActionButtonEnglish(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogin.setText("Login Here");
				PanelEnglish panelEnglish = new PanelEnglish();
				addComponent(panelEnglish);
				btnLanguage.setText(dialog.btnEnglish.getText());
				dialog.setVisible(false);
			}
		});

		dialog.addActionButtonVietnamese(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogin.setText("Đăng Nhập Tại Đây");
				PanelVietnamese panelEnglish = new PanelVietnamese();
				addComponent(panelEnglish);
				btnLanguage.setText(dialog.btnVietnamese.getText());
				dialog.setVisible(false);
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainLogin.setVisible(true, null);
				setVisible(false);
			}
		});

		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(245, 100, 100));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(220, 20, 20));
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				point = e.getComponent().getLocationOnScreen();
				
				xScreen = point.x + 719;
				yScreen = point.y + 76;
			}
		});
	}
	
	public static void setVisible(boolean option, Window setLocationRelativeTo) {
		frame = new MainForgot();
		frame.setVisible(option);
		frame.setLocationRelativeTo(setLocationRelativeTo);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new MainForgot();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
