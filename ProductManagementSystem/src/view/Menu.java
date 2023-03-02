package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.animation.timing.Animator;

import color.ColorBackground;
import componentScrollPane.ScrollBarMenu;
import interfaces.EventMenu;
import interfaces.EventMenuSelected;
import interfaces.ShowPopup;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;
import view.MenuItem;

public class Menu extends JPanel {

	private JPanel panelMenu;
	private Color colorMenu = ColorBackground.colorDark;
	private Animator animator;
	private boolean enable = true;
	private boolean showMenu = true;
	private MigLayout layout;
	private EventMenuSelected event;

	private ShowPopup showPopup;
	private PanelMode panelMode;
	public JScrollPane scrollPane;
	
	Icon iconHomeWhite = new ImageIcon(Menu.class.getResource("/icon/home-white.png"));
	Icon iconProductWhite = new ImageIcon(Menu.class.getResource("/icon/diamond-white.png"));
	Icon iconCustomerWhite = new ImageIcon(Menu.class.getResource("/icon/user-white.png"));
	Icon iconStoreWhite = new ImageIcon(Menu.class.getResource("/icon/store-white.png"));
	Icon iconIncomeWhite = new ImageIcon(Menu.class.getResource("/icon/income-white.png"));
	Icon iconCaledarWhite = new ImageIcon(Menu.class.getResource("/icon/calendar-white.png"));
	Icon iconHelpWhite = new ImageIcon(Menu.class.getResource("/icon/help-white.png"));
	
	Icon iconHomeGray = new ImageIcon(Menu.class.getResource("/icon/home-gray.png"));
	Icon iconProductGray = new ImageIcon(Menu.class.getResource("/icon/diamond-gray.png"));
	Icon iconCustomerGray = new ImageIcon(Menu.class.getResource("/icon/user-gray.png"));
	Icon iconStoreGray = new ImageIcon(Menu.class.getResource("/icon/store-gray.png"));
	Icon iconIncomeGray = new ImageIcon(Menu.class.getResource("/icon/income-gray.png"));
	Icon iconCaledarGray = new ImageIcon(Menu.class.getResource("/icon/calendar-gray.png"));
	Icon iconHelpGray = new ImageIcon(Menu.class.getResource("/icon/help-gray.png"));

	
	public void setColorMenu(Color colorMenu) {
		this.colorMenu = colorMenu;
		repaint();
	}
	
	public Menu() {
		setOpaque(false);
		PanelProfile panelProfile = new PanelProfile();
		panelMode = new PanelMode();
		panelMenu = new JPanel();
		panelMenu.setOpaque(false);
		scrollPane = new JScrollPane(panelMenu);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBar(new ScrollBarMenu());
		scrollPane.setOpaque(true);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		scrollPane.setBackground(colorMenu);

		layout = new MigLayout("fillx, wrap, insets 0", "[fill]", "[]0[]");
		panelMenu.setLayout(layout);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelProfile, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup()
						.addComponent(panelProfile, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)));
		setLayout(groupLayout);
		action();
	}
	

	public void initMenuItem(Color color) {
		addMenu(new ModelMenu(iconHomeWhite, "Trang Chủ",0),color);
		addMenu(new ModelMenu(iconProductWhite, "Sản Phẩm",1, "Bảng điều khiển", "Drafts", "Released"),color);
		addMenu(new ModelMenu(iconCustomerWhite, "Khách Hàng",2, "Tổng quan", "Danh sách khách hàng"),color);
		addMenu(new ModelMenu(iconStoreWhite, "Cửa Hàng",3),color);
		addMenu(new ModelMenu(iconIncomeWhite, "Thu Nhập",4, "Hoàn Lại Tiền", "Doanh Thu"),color);
		addMenu(new ModelMenu(iconCaledarWhite, "Calendar",5),color);

		JPanel panel1 = new JPanel();
		panel1.setOpaque(false);
		panel1.setLayout(null);
		panelMenu.add(panel1, "w 265,h 220!, pushy");

		addMenu(new ModelMenu(iconHelpWhite, "Trợ Giúp & Bắt Đầu",6),color);
		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setLayout(null);

		panel2.setBackground(colorMenu);
		panelMenu.add(panel2, "w 265, h 40,pushy");

		panelMode.setBounds(0, 0, 265, 40);
		panel2.add(panelMode);
		
		
	}
	
	public void initMenuItem2(Color color) {
		addMenu(new ModelMenu(iconHomeGray, "Trang Chủ",0),color);
		addMenu(new ModelMenu(iconProductGray, "Sản Phẩm",1, "Bảng điều khiển", "Drafts", "Released"),color);
		addMenu(new ModelMenu(iconCustomerGray, "Khách Hàng",2, "Tổng quan", "Danh sách khách hàng"),color);
		addMenu(new ModelMenu(iconStoreGray, "Cửa Hàng",3),color);
		addMenu(new ModelMenu(iconIncomeGray, "Thu Nhập",4, "Hoàn Lại Tiền", "Doanh Thu"),color);
		addMenu(new ModelMenu(iconCaledarGray, "Calendar",5),color);

		JPanel panel1 = new JPanel();
		panel1.setOpaque(false);
		panel1.setLayout(null);
		panelMenu.add(panel1, "w 265,h 220!, pushy");

		addMenu(new ModelMenu(iconHelpGray, "Trợ Giúp & Bắt Đầu",6),color);
		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setLayout(null);

		panel2.setBackground(colorMenu);
		panelMenu.add(panel2, "w 265, h 40,pushy");

		panelMode.setBounds(0, 0, 265, 40);
		panel2.add(panelMode);
		
		
	}
	
	public void action() {
		PanelMode.btnLight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMenu.removeAll();
				panelMenu.revalidate();
				panelMenu.repaint();
				Color color = ColorBackground.colorGRB147147147;
				initMenuItem2(color);
				
				
			}
		});
		
		PanelMode.btnDark.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMenu.removeAll();
				panelMenu.revalidate();
				panelMenu.repaint();
				Color color = ColorBackground.colorLight;
				initMenuItem(color);
				
				
			}
		});
	}

	public void addMenu(ModelMenu menu,Color color) {
		panelMenu.add(new MenuItem(menu, getEventMenu(), event, panelMenu.getComponentCount(),color), " h 40!");
	}

	public EventMenu getEventMenu() {
		return new EventMenu() {

			@Override
			public boolean menuPressed(Component com, boolean open) {
				if (enable) {
					if (showMenu) {
						if (open) {
							new MenuAnimation(layout, com).openMenu();
						} else {
							new MenuAnimation(layout, com).closeMenu();
						}
						return true;
					} else {
						showPopup.showPopup(com);
					}
				}
				return false;
			}
		};
	}


	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorMenu);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

	public Color getColorMenu() {
		return colorMenu;
	}

	public void setEnableMenu(boolean enable) {
		this.enable = enable;
	}

	public void setShowMenu(boolean showMenu) {
		this.showMenu = showMenu;
	}

	public void addEvent(EventMenuSelected event) {
		this.event = event;
	}

	public boolean isShowMenu() {
		return showMenu;
	}

	public ShowPopup getShowPopup() {
		return showPopup;
	}

	public void addShowPopup(ShowPopup showPopup) {
		this.showPopup = showPopup;
	}
}
