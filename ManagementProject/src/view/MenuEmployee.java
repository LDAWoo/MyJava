package view;

import javax.swing.JPanel;

import img.ImageAvatar;
import img.ImageHelper;
import img.img;
import model.ModelInformationEmployee;
import net.miginfocom.swing.MigLayout;
import view.Main;
import view.MainEmployee;
import view.ScrollBarCustom;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import dao.InformationEmployeeDAO;
import event.EventMenuSelected;

import javax.swing.ScrollPaneConstants;

public class MenuEmployee extends JPanel {
	img img = new img();
	private JScrollPane scrollPane;
	private JPanel panelMenu;
	private MenuButtons selectedMenu;
	private MenuButtons unSelectedMenu;
	private Animator animator;
	private MenuEvent event;

	private Color colorTextForeground = new Color(200, 200, 200);
	private Font font13BOLD = new Font("SansSerif", Font.BOLD, 13);
	private ImageAvatar avatar;
	private JComponent lblHello;
	private JLabel lblRole;
	public static ArrayList<ModelInformationEmployee> datas = new ArrayList<ModelInformationEmployee>();
	
	private InformationEmployeeDAO dao = new InformationEmployeeDAO();

	private String email;
	
	
	public MenuEmployee() {
		
		setOpaque(false);
		panelMenu = new JPanel();
		panelMenu.setBorder(new EmptyBorder(0, 0, 0, 5));
		panelMenu.setOpaque(false);

		scrollPane = new JScrollPane(panelMenu);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setOpaque(false);
		scrollPane.setViewportBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setVerticalScrollBar(new ScrollBarCustom());
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		JPanel panel = new JPanel();
		panel.setOpaque(false);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		JLabel lblManager = new JLabel("Management");
		lblManager.setForeground(new Color(200, 200, 200));
		lblManager.setFont(new Font("SansSerif", Font.BOLD, 23));
		lblManager.setIcon(img.iconProfile());

		lblHello = new JLabel("Hello, ");
		lblHello.setFont(font13BOLD);
		lblHello.setForeground(colorTextForeground);
		lblHello.setCursor(new Cursor(Cursor.HAND_CURSOR));

		lblRole = new JLabel("Vũ");
		lblRole.setFont(font13BOLD);
		lblRole.setForeground(colorTextForeground);
		lblRole.setCursor(new Cursor(Cursor.HAND_CURSOR));

		avatar = new ImageAvatar();
		avatar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		avatar.setBorderSize(3);
		avatar.setBorderSpace(2);

		avatar.setGradientColor1(new java.awt.Color(63, 109, 217));
		avatar.setGradientColor2(new java.awt.Color(199, 42, 42));
		
	

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblHello)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRole, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(lblManager, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addComponent(avatar, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblManager, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(avatar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRole, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
						.addComponent(lblHello, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		setLayout(groupLayout);
		init();

		Action();
	}

	public void Action() {
		avatar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1 || e.getClickCount() == 2) {
					MainEmployee.showForm(new PanelInformationEmployee());
				}
			}
		});

		lblHello.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1 || e.getClickCount() == 2) {
					MainEmployee.showForm(new PanelInformationEmployee());
				}
			}
		});

		lblRole.addMouseListener(new MouseAdapter() {
			;
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1 || e.getClickCount() == 2) {
					MainEmployee.showForm(new PanelInformationEmployee());
				}
			}
		});

		setAvatar();
	}

	public void init() {
		panelMenu.setLayout(new MigLayout("wrap, fillx, inset 0", "[fill]"));
		TimingTarget target = new TimingTargetAdapter() {
			public void timingEvent(float fraction) {
				selectedMenu.setAnimate(fraction - 0.15f);
				if (unSelectedMenu != null) {
					unSelectedMenu.setAnimate(1f - fraction);
				}
			};
		};
		animator = new Animator(300, target);
		animator.setAcceleration(.5f);
		animator.setDeceleration(.5f);
		animator.setResolution(0);

	}

	public void initMenu(MenuEvent event) {
		this.event = event;
		addMenu(img.iconHome2(), "  ", "Trang chủ", 0);
		split("Quản lý");
		addMenu(img.iconStudent2(), "Người học", 1);
		addMenu(img.iconTopic(), "Chuyên đề", 2);
		addMenu(img.iconCourse(), "Khóa học", 3);
		split("Tổng Hợp Thống kê");
		addMenu(img.iconStudent2(), "Người học", 4);
		addMenu(img.iconStudent2(), "Bảng điểm", 5);
		addMenu(img.iconStudent2(), "Tổng hợp điểm", 6);
		split("Calendar");
		addMenu(img.iconCalendar(), "Lịch", 7);
		
	}

	private void split(String name) {
		panelMenu.add(new Split(name));
	}

	private void addMenu(Icon icon, String Distance, String text, int index) {
		MenuButtons menu = new MenuButtons(index);
		setFont(getFont().deriveFont(Font.PLAIN, 17));
		menu.setIcon(icon);
		menu.setFont(getFont());
		menu.setText(Distance + text);
		menu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!animator.isRunning()) {
					unSelectedMenu = selectedMenu;
					selectedMenu = menu;
					animator.start();
					event.menuSelected(index);
				}

			}
		});
		
		panelMenu.add(menu);
	}

	private void addMenu(Icon icon, String text, int index) {
		MenuButtons menu = new MenuButtons(index);
		setFont(getFont().deriveFont(Font.PLAIN, 14));
		menu.setFont(getFont());
		menu.setIcon(icon);
		menu.setBorder(new EmptyBorder(8, 40, 8, 5));
		menu.setText("  " + text);
		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!animator.isRunning()) {
					unSelectedMenu = selectedMenu;
					selectedMenu = menu;
					animator.start();
					event.menuSelected(index);
				}
				}
			
		});
		
	

		panelMenu.add(menu);
	}
	
	
	public void setAvatar() {
		email = MainEmployee.email;
		datas = dao.SelectInformation(email);
		ImageHelper image = new ImageHelper();
		byte[] img = datas.get(0).getImg();
		
		try {
		Image icon = image.createImageFromByteArray(img, "jpg");
		avatar.setImage(new ImageIcon(icon));
		lblRole.setText(datas.get(0).getFullName());
		}catch(Exception e) {}
		
		
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
