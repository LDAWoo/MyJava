package view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import componentTableScore.PanelTableScoreStudents;
import componentTableShedule.PanelTableSheduleStudent;
import components.Menu;
import components.MenuEvent;
import components.MenuStudent;
import components.PanelHomeStudent;
import componentsAttendance.PanelAttendanceStudent;
import componentsCourse.Course;
import componentsEmployee.Employee;
import componentsForgot.DialogForgotPassword;
import componentsLearner.Learner;
import componentsStudent.PanelTableStudents;
import componentsTopic.Topic;
import date.CurrendarCustom;
import img.img;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;

import java.awt.SystemColor;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import javax.swing.ImageIcon;

public class MainStudent extends JFrame {
	private static javax.swing.JPanel body;
	private javax.swing.JPanel jPanelCenter;
	private components.MenuStudent menu;
	private LoginUserView login;
	private ForgotPasswordView forgot;

	public static String email;
	private JButton btnMinimize;
	private JButton btnExit;
	private JButton btnSetting;
	private JButton btnHelp;

	private Point currCoords = null;
	private Point mouseDownCompCoords = null;
	private Point Point = null;

	private int y;
	private int x;

	private int xHelp;
	private int yHelp;

	public static int xScreen;
	public static int yScreen;

	public static int xScreenExit;
	public static int yScreenExit;

	public static int xScreenForgot;
	public static int yScreenForgot;

	public static int height;
	DialogConfirmMessage confirm = new DialogConfirmMessage(null);
	public static MainStudent frame;

	public MainStudent(String email) {
		this.email = email;
		setUndecorated(true);
		getContentPane().setBackground(new Color(63, 109, 217));
		jPanelCenter = new JPanel();

		menu = new MenuStudent();

		body = new JPanel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanelCenter.setBackground(new java.awt.Color(50, 50, 50));

		body.setOpaque(false);
		body.setLayout(new java.awt.BorderLayout());

		btnExit = new JButton("X");
		btnExit.setFocusPainted(false);
		btnExit.setOpaque(false);
		btnExit.setBorder(null);
		btnExit.setForeground(new Color(200, 200, 200));
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 15));

		btnSetting = new JButton(img.iconSetting());
		btnSetting.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnSetting.setFocusPainted(false);
		btnSetting.setOpaque(false);
		btnSetting.setBorder(null);
		btnSetting.setForeground(new Color(200, 200, 200));

		btnMinimize = new JButton("—");
		btnMinimize.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnMinimize.setFocusPainted(false);
		btnMinimize.setOpaque(false);
		btnMinimize.setBorder(null);
		btnMinimize.setForeground(new Color(200, 200, 200));

		btnHelp = new JButton("?");
		btnHelp.setOpaque(false);
		btnHelp.setForeground(SystemColor.scrollbar);
		btnHelp.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnHelp.setFocusPainted(false);
		btnHelp.setBorder(null);

		javax.swing.GroupLayout gl_jPanelCenter = new javax.swing.GroupLayout(jPanelCenter);
		gl_jPanelCenter
				.setHorizontalGroup(
						gl_jPanelCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPanelCenter.createSequentialGroup()
										.addComponent(menu, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_jPanelCenter.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_jPanelCenter.createSequentialGroup()
														.addComponent(body, GroupLayout.DEFAULT_SIZE, 1036,
																Short.MAX_VALUE)
														.addContainerGap())
												.addGroup(gl_jPanelCenter.createSequentialGroup()
														.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 43,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 43,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnSetting, GroupLayout.PREFERRED_SIZE, 43,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 43,
																GroupLayout.PREFERRED_SIZE)))));
		gl_jPanelCenter.setVerticalGroup(gl_jPanelCenter.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_jPanelCenter.createSequentialGroup()
						.addGroup(gl_jPanelCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSetting, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_jPanelCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(menu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
								.addComponent(body, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE))
						.addContainerGap()));
		jPanelCenter.setLayout(gl_jPanelCenter);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(jPanelCenter,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(3, 3, 3)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(jPanelCenter,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(3, 3, 3)));
		showForm(new PanelHomeStudent());
		pack();
		setLocationRelativeTo(null);

		MenuEvent event = new MenuEvent() {
			@Override
			public void menuSelected(int index) {
				if (index == 0) {
					showForm(new PanelHomeStudent());
				}

				if (index == 1) {
					showForm(new PanelAttendanceStudent());
				}

				if (index == 2) {
					showForm(new PanelTableSheduleStudent());
				}

				if (index == 3) {
					showForm(new PanelTableScoreStudents(email));
				}

				if (index == 4) {
					showForm(new PanelTuitionStudent());
				}

				if (index == 5) {
					showForm(new CurrendarCustom());

				}

			}
		};

		menu.initMenu(event);
		height = body.getHeight();

		action();
	}

	public void action() {

		DialogSettingStudent setting = new DialogSettingStudent(MainStudent.this, height);
		DialogHelp help = new DialogHelp(MainStudent.this);

		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setOpaque(true);
				btnExit.setBackground(new Color(220, 20, 20));
				setting.setVisible(false);
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
				btnMinimize.setBackground(new Color(70, 70, 70));
				setting.setVisible(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMinimize.setOpaque(false);

			}
		});

		addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				mouseDownCompCoords = e.getPoint();

			}
		});

		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				currCoords = e.getLocationOnScreen();
				x = currCoords.x - mouseDownCompCoords.x + 1055;
				y = currCoords.y - mouseDownCompCoords.y + 20;

				xHelp = currCoords.x - mouseDownCompCoords.x + 1032;
				yHelp = currCoords.y - mouseDownCompCoords.y + 20;

				xScreen = currCoords.x - mouseDownCompCoords.x + 510;
				yScreen = currCoords.y - mouseDownCompCoords.y + 243;

				xScreenExit = currCoords.x - mouseDownCompCoords.x + 450;
				yScreenExit = currCoords.y - mouseDownCompCoords.y + 243;

				xScreenForgot = currCoords.x - mouseDownCompCoords.x + 450;
				yScreenForgot = currCoords.y - mouseDownCompCoords.y + 130;

				setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
			}

			@Override
			public void mouseMoved(MouseEvent e) {

				if (e.getX() < 1061) {
					setting.setVisible(false);
				}
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Point = e.getComponent().getLocationOnScreen();

				x = Point.x + 1055;
				y = Point.y + 20;

				xHelp = Point.x + 1032;
				yHelp = Point.y + 20;

				xScreen = Point.x + 510;
				yScreen = Point.y + 243;

				xScreenExit = Point.x + 450;
				yScreenExit = Point.y + 243;

				xScreenForgot = Point.x + 450;
				yScreenForgot = Point.y + 130;

			}
		});

		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirm.setLocation(xScreenExit, yScreenExit);
				confirm.setModalityType(ModalityType.APPLICATION_MODAL);
				confirm.setVisible(true);
				if (confirm.option == 1) {
					System.exit(0);

				}

			}
		});

		btnSetting.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setting.setLocation(x, y);
				setting.setVisible(true);

			}
		});

		btnSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSetting.setOpaque(true);
				btnSetting.setBackground(new Color(70, 70, 70));
				setting.setLocation(x, y);
				setting.setVisible(true);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSetting.setOpaque(false);

			}
		});

		btnHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showForm(new PanelStudentHelp());
			}
		});

		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHelp.setOpaque(true);
				btnHelp.setBackground(new Color(70, 70, 70));

				help.setLocation(xHelp, yHelp);
				help.setVisible(true);
				setting.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnHelp.setOpaque(false);
				help.setVisible(false);
			}
		});

		setting.addActionButtonLogout(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DialogConfirmMessage confirm = new DialogConfirmMessage(null);
				confirm.setLocation(MainStudent.xScreenExit, MainStudent.yScreenExit);
				confirm.setModalityType(ModalityType.APPLICATION_MODAL);
				confirm.lblTitle.setText("ĐĂNG XUẤT?");
				confirm.lblTextMessage.setText("Bạn có chắc chắn muốn đăng xuất không ?");
				confirm.setVisible(true);
				if (confirm.option == 1) {
					LoginUserView.setVisible(true, null);
					setVisible(false);

				}
			}
		});

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new MainStudent("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void showForm(Component com) {
		body.removeAll();
		body.add(com);
		body.revalidate();
		body.repaint();
	}
}
