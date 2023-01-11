package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.animation.timing.Animator;

import componentScrollPane.ScrollBarMenu;
import interfaces.EventMenu;
import interfaces.EventMenuSelected;
import interfaces.ShowPopup;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;
import view.MenuItem;

public class Menu extends JPanel {

	private JPanel panelMenu;
	private Color colorMenu = new Color(26,29,31);
	private Animator animator;
	private boolean enable = true;
	private boolean showMenu = true;
	private MigLayout layout;
	private EventMenuSelected event;

	private ShowPopup showPopup;
	
	public Menu() {
		setOpaque(false);
		PanelProfile panelProfile = new PanelProfile();	
		panelMenu = new JPanel();
		panelMenu.setOpaque(false);
		JScrollPane scrollPane = new JScrollPane(panelMenu);
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
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelProfile, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(panelProfile, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		
	}
	
	public void initMenuItem() {
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/icon-home.png")), "Trang Chủ"));
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/diamond-stone.png")), "Sản Phẩm","Bảng điều khiển","Drafts","Released"));
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/user-white.png")), "Khách Hàng","Tổng quan","Danh sách khách hàng"));
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/store-white.png")), "Cửa Hàng"));
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/income-white.png")), "Thu Nhập","Hoàn Lại Tiền","Doanh Thu"));
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/icon-calendar.png")), "Calendar"));
		
		JPanel panel1 = new JPanel();
		panel1.setOpaque(false);
		panel1.setLayout(null);
		panelMenu.add(panel1,"w 265,h 220!, pushy");

		
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/help-white.png")), "Trợ Giúp & Bắt Đầu"));
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		PanelMode panelMode = new PanelMode();
		panel2.setBackground(colorMenu);
		panelMenu.add(panel2,"w 265, h 40,pushy");
		
		panelMode.setBounds(0, 0, 265, 40);
		panel2.add(panelMode);
	}
	
	public void addMenu(ModelMenu menu) {
		panelMenu.add(new MenuItem(menu, getEventMenu(), event, panelMenu.getComponentCount())," h 40!");
	}
	
	public EventMenu getEventMenu() {
		return new EventMenu() {
			
			@Override
			public boolean menuPressed(Component com, boolean open) {
				if(enable) {
					if(showMenu) {
						if(open) {
							new MenuAnimation(layout, com).openMenu();
						}else {
							new MenuAnimation(layout, com).closeMenu();
						}
						return true;
					}else {
						showPopup.showPopup(com);
					}
				}
				return false;
			}
		};
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorMenu);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
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
