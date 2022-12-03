package components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import img.img;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;


public class PanelMenu extends JPanel {
	
	private img img = new img();
	JPanel panelHeader;
	MigLayout layout;
	
	PanelFaceBook facebook;
	private JScrollPane scrollPane;
	private ButtonChatHeader btnStar;
	private ButtonChatHeader btnSeeting;
	private ButtonChatHeader btnMess;
	private ButtonChatHeader btnListFriends;
	private MainFormChat main = new MainFormChat();
	
	public PanelMenu() {
		setOpaque(false);
		layout = new MigLayout("fill,wrap, inset 1", "[fill]", "[90!,fill][fill,100%][::60%,shrink 0]");
		
		panelHeader = createHeader();
	
		setLayout(layout);

		add(panelHeader);
		ActionButton();
	}
	
	
	
	public JPanel createHeader() {
		JPanel panelHeader = new JPanel();
		panelHeader.setOpaque(false);
		panelHeader.setLayout(new MigLayout("fill,inset 0"));
		facebook = new PanelFaceBook();
		
		panelHeader.add(facebook,"wrap");
			
		btnMess = new ButtonChatHeader();
		
		btnListFriends = new ButtonChatHeader();
		
		btnStar = new ButtonChatHeader();
		
		btnSeeting = new ButtonChatHeader();
		
		btnMess.setIcon(img.iconMessWhite());
		btnListFriends.setIcon(img.iconListFriends());
		btnStar.setIcon(img.iconStar());
		btnSeeting.setIcon(img.iconSetting());
		
		panelHeader.add(btnMess,"h 65!, w 65!, wrap");
		panelHeader.add(btnListFriends,"h 65!, w 65!,wrap");
		panelHeader.add(btnStar,"h 65!, w 65!,wrap");
		panelHeader.add(btnSeeting,"h 65!, w 65!,wrap");
		
		return panelHeader;
	}
	
	public void ActionButton() {
		btnMess.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				
			}
		});
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, 0, new Color(0,150,255), 250, 0, new Color(0,150,255));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	

}


