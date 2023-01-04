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
		
		JPanel panelProfile = new JPanel();
		panelProfile.setOpaque(false);
		
		panelMenu = new JPanel();
		panelMenu.setOpaque(false);
		JScrollPane scrollPane = new JScrollPane(panelMenu);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBar(new ScrollBarMenu());
		scrollPane.setOpaque(true);
		scrollPane.setBorder(null);
		scrollPane.setBackground(colorMenu);
		
		layout = new MigLayout("fillx,wrap, insets 0", "[fill]", "[]0[]");
		panelMenu.setLayout(layout);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelProfile, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelProfile, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		
	}
	
	public void initMenuItem() {
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/icon-home.png")), "Trang Chủ"));
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/diamond-stone.png")), "Sản Phẩm","Dashboard","Drafts","Released"));
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/user-white.png")), "Khách Hàng","Overview","Customer List"));
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/store-white.png")), "Cửa Hàng"));
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/income-white.png")), "Thu Nhập","Hoàn Lại Tiền","Doanh Thu"));
		addMenu(new ModelMenu(new ImageIcon(Menu.class.getResource("/icon/income-white.png")), "Trợ Giúp & Bắt Đầu"));
		
		
		PanelMode panel = new PanelMode();
		panel.setBackground(colorMenu);
		panelMenu.add(panel,"w 265, h 40");
		
		
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
