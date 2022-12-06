package view;

import javax.swing.*;
import javax.swing.JScrollBar;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import javax.swing.plaf.basic.BasicScrollBarUI;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;

import event.EventMenu;
import event.EventMenuSelected;
import img.img;
import interfaces.ShowPopup;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;

import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Menu extends JPanel{

	private JScrollPane scrollPane;
	private JPanel panel;
	private MigLayout layout;
	private Animator animator;
	private boolean enable = true;
	private boolean showMenu = true;
	private EventMenuSelected event;
	private img img = new img();
	private ShowPopup showPopup;
	private Profile profile;
	
	
	
	public Menu() {
		setOpaque(false);
		
		panel = new JPanel();
		panel.setOpaque(false);
	
		profile = new Profile();
		
		scrollPane = new JScrollPane(panel);
		scrollPane.setOpaque(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
	
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setVerticalScrollBar(new ScrollBarCustom());
		scrollPane.setViewportBorder(null);
		
		
		ScrollBarCustom barCustom = new ScrollBarCustom();
		barCustom.setOrientation(JScrollBar.HORIZONTAL);
		

		
		scrollPane.setHorizontalScrollBar(barCustom);
		
		layout = new MigLayout("wrap, fillx, insets 0", "[fill]","[]0[]");
		panel.setLayout(layout);
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(profile, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(profile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
		);
        this.setLayout(layout);
		setLayout(layout);
		
		
	}
	
	String distance = "                 ";
	
	public void initMenuItem() {
		addMenu(new ModelMenu(this.img.iconHome(),"Home"));
		addMenu(new ModelMenu(this.img.iconManager(), "Management", 
														   distance+"Employee",
														   distance+"Student",
														   distance+"Topic",
														   distance+"Course"
														   ));
		addMenu(new ModelMenu(this.img.iconLibrary(), "Statistical", 
														   distance+"Student Table Score",
														   distance+"Course Table Score",
														   distance+"Menu 03"
														   ));
		addMenu(new ModelMenu(this.img.iconCalendar(), "Calendar", 
				   										   distance+"Calendar 01",
				   										   distance+"Calendar 02",
				   										   distance+"Calendar 03"
														   ));
		addMenu(new ModelMenu(this.img.iconHelp(), "Help", 
														   distance+"Welcom",
														   distance+"User Manual",
														   distance+"Introduction Product"
														   ));
		addMenu(new ModelMenu(this.img.iconSystem(), "System", 
														   distance+"Login",
														   distance+"Log out",
														   distance+"Forgot Password",
														   distance+"Exit"	   
														   ));
	}
	
	private void addMenu(ModelMenu menu) {
		panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()),"h 40!");
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
	
	public void hideallMenu() {
		for(Component component : panel.getComponents()) {
			MenuItem item = (MenuItem) component;
			if(item.isOpen()) {
				new MenuAnimation(layout, component, 500).closeMenu();
				item.setOpen(false);
			}
			
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		GradientPaint gra = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, 730, Color.decode("#000046"));
		GradientPaint gra = new GradientPaint(0, 0, Color.decode("#DBD65C"), 250, 0, Color.decode("#5614B0"));
		g2.setPaint(gra);
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
