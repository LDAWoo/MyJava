package componentSignUp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.microsoft.sqlserver.jdbc.spatialdatatypes.Point;

import animation.TextField;
import animation.TextPasswordField;
import componentButton.Button;
import componentLogin.MainLogin;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Cursor;

public class MainSignUp extends JFrame {
	java.awt.Point currCoords;
	java.awt.Point mouseDownCompCoords;
	private JPanel contentPane;
	private ImageIcon imageLogoShop = new ImageIcon(new ImageIcon(MainLogin.class.getResource("/icon/logo-shop.png"))
			.getImage().getScaledInstance(66, 66, Image.SCALE_SMOOTH));

	private Font font13 = new Font("Segoe UI", Font.PLAIN, 14);
	private Font font14 = new Font("SansSerif", Font.PLAIN, 14);

	private Color color = new Color(220, 20, 20);
	private Color gray = new Color(150, 150, 150);
	private JButton btnExit;
	private JButton btnMinimize;
	private PanelNorth panelNorth;
	public static Button btnLanguage;

	private static MainSignUp frame;
	private java.awt.Point point = null;
	private int xScreen;
	private int yScreen;
	private static JPanel panelBody;
	public JPanel body;
	public static JButton btnLogin;

	public MainSignUp() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();

		setContentPane(contentPane);

		body = new JPanel();
		body.setBackground(new Color(200, 200, 200));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(body,
				GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(body,
				GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE));

		panelNorth = new PanelNorth();
		panelNorth.setBounds(0, 0, 1000, 25);
		panelNorth.setOpaque(false);

		JPanel panel = new JPanel();
		panel.setBounds(0, 24, 1000, 93);
		panel.setBackground(new Color(250, 250, 250));

		btnLanguage = new Button("");
		btnLanguage.setHorizontalAlignment(SwingConstants.LEFT);
		btnLanguage.setIcon(new ImageIcon(MainSignUp.class.getResource("/icon/earths.png")));
		btnLanguage.setText("Việt Nam - Tiếng Việt");
		btnLanguage.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnLanguage.setForeground(new Color(50, 50, 50));

		JLabel lblLogoShop = new JLabel("");
		lblLogoShop.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogoShop.setIcon(imageLogoShop);

		JLabel lblTitle = new JLabel("FASHION SHOP");
		lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblTitle.setForeground(new Color(220, 20, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);

		btnLogin = new JButton("Đăng Nhập Tại Đây");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setForeground(new Color(230, 230, 230));
		btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(220, 20, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE).addGap(168)
						.addComponent(lblLogoShop).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnLanguage, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(28).addComponent(btnLanguage,
								GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLogoShop, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
										.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup().addGap(19).addComponent(btnLogin,
								GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		panel.setLayout(gl_panel);
		body.setLayout(null);

		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(MainSignUp.class.getResource("/icon/close.png")));
		btnExit.setOpaque(false);
		btnExit.setForeground(SystemColor.scrollbar);
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnExit.setFocusPainted(false);
		btnExit.setBorder(null);

		btnMinimize = new JButton("");
		btnMinimize.setIcon(new ImageIcon(MainSignUp.class.getResource("/icon/minus.png")));
		btnMinimize.setOpaque(false);
		btnMinimize.setForeground(SystemColor.scrollbar);
		btnMinimize.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnMinimize.setFocusPainted(false);
		btnMinimize.setBorder(null);
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(gl_panelNorth.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNorth.createSequentialGroup().addContainerGap(908, Short.MAX_VALUE)
						.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)));
		gl_panelNorth.setVerticalGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
						.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING).addComponent(btnExit)
								.addComponent(btnMinimize))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelNorth.setLayout(gl_panelNorth);
		body.add(panelNorth);
		body.add(panel);

		panelBody = new JPanel();
		panelBody.setBounds(130, 140, 735, 537);
		body.add(panelBody);

		PanelVietnamese panelVietnamese = new PanelVietnamese();
		panelVietnamese.setBounds(0, 0, 735, 537);
		panelBody.add(panelVietnamese);
		panelBody.setLayout(null);
		contentPane.setLayout(gl_contentPane);

		actionButton();
	}

	public static void addComponent(JComponent panel) {
		panelBody.removeAll();
		panelBody.revalidate();
		panelBody.repaint();
		panel.setBounds(0, 0, 735, 537);
		panelBody.add(panel);
	}

	public void actionButton() {
		DialogLanguage dialog = new DialogLanguage(null);

		btnLanguage.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
					dialog.setLocation(xScreen, yScreen);
					dialog.setVisible(true);

				} else {
					dialog.setVisible(false);
				}
			}
		});

		dialog.addActionButtonEnglish(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLanguage.setText(DialogLanguage.btnEnglish.getText());
				PanelEnglish panelEnglish = new PanelEnglish();
				addComponent(panelEnglish);
				btnLogin.setText("Login Here");
				dialog.setVisible(false);
			}
		});

		dialog.addActionButtonVietnamese(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLanguage.setText(DialogLanguage.btnVietnamese.getText());
				PanelVietnamese panelVietnamese = new PanelVietnamese();
				addComponent(panelVietnamese);
				btnLogin.setText("Đăng Nhập Tại Đây");
				dialog.setVisible(false);
			}
		});

		btnLanguage.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getItem());
				if (!e.getItem().equals(DialogLanguage.btnEnglish.getText())) {

				}

			}
		});

		btnLanguage.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

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

		btnMinimize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}

		});

		btnMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMinimize.setOpaque(true);
				btnMinimize.setBackground(Color.decode("#1F1C18"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMinimize.setOpaque(false);
			}
		});

		panelNorth.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseDownCompCoords = e.getPoint();

			}
		});

		panelNorth.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				currCoords = e.getLocationOnScreen();
				xScreen = currCoords.x - mouseDownCompCoords.x + 748;
				yScreen = currCoords.y - mouseDownCompCoords.y + 76;
				setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
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
				xScreen = point.x + 748;
				yScreen = point.y + 76;
			}
		});
	}

	public static void setVisible(boolean option, Window setLocationRelativeTo) {
		frame = new MainSignUp();
		frame.setVisible(option);
		frame.setLocationRelativeTo(setLocationRelativeTo);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new MainSignUp();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
