package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import color.ColorBackground;
import componentCustomers.PanelCustomerlList;
import componentHeader.DialogNotification;
import componentHeader.DialogNotificationOption;
import componentHeader.DialogProfile;
import componentHeader.PanelDialogProfile;
import componentProduct.ButtonProductList;
import componentProduct.PanelCreateProduct;
import componentProduct.PanelDashboard;
import componentProduct.PanelOverviewProductDashboard;
import componentProduct.PanelProductDashboard;
import componentProduct.PanelProductList;
import componentScrollPane.ScrollBarMenu;
import componentStore.PanelHomeStore;
import componentStore.PanelStoreHeader;
import dialog.DialogSearchProduct;
import interfaces.EventMenuSelected;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private Menu panelMenu;

	private Color colorMain = ColorBackground.colorDark;
	public static PanelBody panelBody;

	private Point point;

	private Point currCoords = null;
	private Point mouseDownCompCoords = null;

	private int xScreenProfile;
	private int yScreenProfile;
	
	public static int xScreenMessenger;
	public static int yScreenMessenger;
	
	public static int xScreenNotification2;
	public static int yScreenNotification2;

	private int xScreenNotification;
	private int yScreenNotification;

	private int xScreenNotificationOption;
	private int yScreenNotificationOption;

	public static int xScreenSearchProduct;
	public static int yScreenSearchProduct;

	public static int xScreenFilterProduct;
	public static int yScreenFilterProduct;

	public static DialogProfile dialogProfile = new DialogProfile(null);
	public static DialogNotification dialogNotification = new DialogNotification(null);
	public static DialogNotificationOption dialogNotificationOption = new DialogNotificationOption(null);

	private PanelHeader panelHeader;
	private PanelNorth panelNorth;
	public static MainForm frame;

	private JPanel panelCenter;
	private JPanel panel;
	public static JScrollPane scrollPane;

	public static int menuIndexSelected;
	public static int subMenuIndexSelected;

	public static String mode = "Dark";

	public MainForm() {
		setUndecorated(true);
		setBounds(100, 100, 1200, 670);

		contentPane = new JPanel();
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(colorMain);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE));

		panelNorth = new PanelNorth();

		panelCenter = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panelNorth, GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
				.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 569, Short.MAX_VALUE)));
		panelCenter.setLayout(new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0"));

		panelMenu = new Menu();

		panelHeader = new PanelHeader();

		panelBody = new PanelBody();
		scrollPane = new JScrollPane(panelBody);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBar(new ScrollBarMenu());

		scrollPane.setOpaque(true);
		scrollPane.setBorder(null);
		scrollPane.setBackground(colorMain);

		panelCenter.add(panelMenu, "w 265!,spany 2");
		panelCenter.add(panelHeader, "h 80!, wrap");
		panelCenter.add(scrollPane, "w 100%, h 100%");

		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(MainForm.class.getResource("/icon/close.png")));
		btnExit.setOpaque(false);
		btnExit.setForeground(SystemColor.scrollbar);
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnExit.setFocusPainted(false);
		btnExit.setBorder(null);

		JButton btnMinimize = new JButton("");
		btnMinimize.setIcon(new ImageIcon(MainForm.class.getResource("/icon/minus.png")));
		btnMinimize.setOpaque(false);
		btnMinimize.setForeground(SystemColor.scrollbar);
		btnMinimize.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnMinimize.setFocusPainted(false);
		btnMinimize.setBorder(null);
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(gl_panelNorth.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNorth.createSequentialGroup().addContainerGap(1104, Short.MAX_VALUE)
						.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)));
		gl_panelNorth.setVerticalGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
						.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelNorth.setLayout(gl_panelNorth);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		pack();
		init();
		actionDialog();
		actionButtonMode();
	}

	public void init() {

		panelMenu.addEvent(new EventMenuSelected() {

			@Override
			public void menuSelected(int menuIndex, int subMenuIndex) {

				if (menuIndex == 0) {
					panelBody.showForm(new PanelDashboard());
				}

				if (menuIndex == 1) {
					if (subMenuIndex == 0) {
						panelBody.showForm(new PanelProductDashboard());
					}

				}

				if (menuIndex == 2) {
					if (subMenuIndex == 1) {
						panelBody.showForm(new PanelCustomerlList());
					}
				}

				if (menuIndex == 3) {
					panelBody.showForm(new PanelHomeStore());
				}

				menuIndexSelected = menuIndex;
				subMenuIndexSelected = subMenuIndex;
			}
		});

		Color color = ColorBackground.colorLight;
		panelMenu.initMenuItem(color);

	}

	public void actionDialog() {
		dialogNotification.actionButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogNotificationOption.setLocation(xScreenNotificationOption, yScreenNotificationOption);
				dialogNotificationOption.setVisible(true);

			}
		});

		dialogNotificationOption.addActionButtonDelete(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialogNotification.deleteNotification();
			}
		});

		panelHeader.addActionAvatar(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
					dialogProfile.setLocation(xScreenProfile, yScreenProfile);
					dialogProfile.setVisible(true);
					dialogNotification.setVisible(false);
					dialogNotificationOption.setVisible(false);
					PanelProductList.dialogSearchProduct.setVisible(false);
				} else {
					dialogProfile.setVisible(false);
					PanelProductList.dialogSearchProduct.setVisible(false);
				}
			}
		});

		panelHeader.addActionNotification(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
					dialogNotification.setLocation(xScreenNotification, yScreenNotification);
					dialogNotification.setVisible(true);
					dialogProfile.setVisible(false);
					dialogNotificationOption.setVisible(false);
					PanelProductList.dialogSearchProduct.setVisible(false);
				} else {
					dialogNotification.setVisible(false);
					dialogNotificationOption.setVisible(false);
					PanelProductList.dialogSearchProduct.setVisible(false);
				}
			}
		});

		panelHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dialogProfile.setVisible(false);
				dialogNotification.setVisible(false);
				dialogNotificationOption.setVisible(false);
				PanelProductList.dialogSearchProduct.setVisible(false);
			}
		});

		panelHeader.addActionAddProduct(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelBody.showForm(new PanelCreateProduct());
			}
		});

		panelMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dialogProfile.setVisible(false);
				dialogNotification.setVisible(false);
				dialogNotificationOption.setVisible(false);
				PanelProductList.dialogSearchProduct.setVisible(false);
			}
		});

		panelBody.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dialogProfile.setVisible(false);
				dialogNotification.setVisible(false);
				dialogNotificationOption.setVisible(false);
				PanelProductList.dialogSearchProduct.setVisible(false);
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

				xScreenProfile = currCoords.x - mouseDownCompCoords.x + 1060;
				yScreenProfile = currCoords.y - mouseDownCompCoords.y + 85;

				xScreenNotification = currCoords.x - mouseDownCompCoords.x + 880;
				yScreenNotification = currCoords.y - mouseDownCompCoords.y + 85;

				xScreenNotificationOption = currCoords.x - mouseDownCompCoords.x + 1040;
				yScreenNotificationOption = currCoords.y - mouseDownCompCoords.y + 135;

				xScreenSearchProduct = currCoords.x - mouseDownCompCoords.x + 285;
				yScreenSearchProduct = currCoords.y - mouseDownCompCoords.y + 67;

				xScreenFilterProduct = currCoords.x - mouseDownCompCoords.x + 1010;
				yScreenFilterProduct = currCoords.y - mouseDownCompCoords.y + 210;
				
				xScreenMessenger = currCoords.x - mouseDownCompCoords.x + 1060;
				yScreenMessenger = currCoords.y - mouseDownCompCoords.y + 80;
				
				xScreenNotification2 = currCoords.x - mouseDownCompCoords.x + 1130;
				yScreenNotification2 = currCoords.y - mouseDownCompCoords.y + 80;

				setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);

				dialogProfile.setVisible(false);
				dialogNotification.setVisible(false);
				dialogNotificationOption.setVisible(false);
				PanelProductList.dialogSearchProduct.setVisible(false);
			}

		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				point = e.getComponent().getLocationOnScreen();
				xScreenProfile = point.x + 1060;
				yScreenProfile = point.y + 81;

				xScreenNotification = point.x + 880;
				yScreenNotification = point.y + 85;

				xScreenNotificationOption = point.x + 1040;
				yScreenNotificationOption = point.y + 135;

				xScreenSearchProduct = point.x + 285;
				yScreenSearchProduct = point.y + 67;

				xScreenFilterProduct = point.x + 1010;
				yScreenFilterProduct = point.y + 210;
				
				xScreenMessenger = point.x + 1060;
				yScreenMessenger = point.y + 80;
				
				xScreenNotification2 = point.x + 1130;
				yScreenNotification2 = point.y + 80;
				

				scrollPane.getVerticalScrollBar().setValue(0);
			}

		});

	}

	public void actionButtonMode() {

		PanelMode.actionButonModeLight(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mode = "Light";
				panel.setBackground(ColorBackground.colorLight);
				panelMenu.setColorMenu(ColorBackground.colorLight);
				panelMenu.scrollPane.setBackground(ColorBackground.colorLight);

				panelBody.setColorBody(ColorBackground.colorGRB240242245);

			}
		});

		PanelMode.actionButonModeDark(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mode = "Dark";

				panel.setBackground(ColorBackground.colorDark);

				panelMenu.setColorMenu(ColorBackground.colorDark);
				panelMenu.scrollPane.setBackground(ColorBackground.colorDark);

				panelBody.setColorBody(ColorBackground.colorGRB000);

			}
		});

		dialogNotification.action();
	}

	public static void setVisible(boolean option, Window setLocation) {
		dialogProfile.setVisible(option);
		frame.setVisible(option);
		frame.setLocationRelativeTo(setLocation);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new MainForm();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
