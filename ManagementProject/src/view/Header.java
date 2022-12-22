package view;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;

import img.img;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import animation.AnimationButtonAction;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class Header extends JPanel {
	private img img = new img();
	private AnimationButtonAction btnMenu;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JLabel lbRole;
	private javax.swing.JLabel lbUserName;
	private PanelFind panelFind;
	
	public Header() {
		setOpaque(false);
		
		
		btnMenu = new AnimationButtonAction(this.img.iconMenu(),"");
		btnMenu.setBorder(null);
		btnMenu.setOpaque(false);
		btnMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMenu.setBackground(new Color(0,0,0));
        lbUserName = new JLabel();
        lbRole = new JLabel();
        jSeparator1 = new JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        lbUserName.setFont(new Font("sansserif", 1, 12)); 
        lbUserName.setForeground(new java.awt.Color(127, 127, 127));
        lbUserName.setText("User Name");

        lbRole.setForeground(new java.awt.Color(127, 127, 127));
        lbRole.setText("Admin");

        jSeparator1.setOrientation(SwingConstants.VERTICAL);

        panelFind = new PanelFind();
        panelFind.search.setBackground(new Color(60,60,60));
        panelFind.search.setForeground(new Color(200,200,200));
        panelFind.lblIcon.setBackground(new Color(0,0,0));
        GroupLayout layout = new GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(btnMenu, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panelFind, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbUserName, Alignment.TRAILING)
        				.addComponent(lbRole, Alignment.TRAILING))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lbUserName)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(lbRole))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(panelFind, GroupLayout.DEFAULT_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        		.addComponent(btnMenu, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );
        this.setLayout(layout);

	}

	public void AddMenuEvent(ActionListener event) {
		btnMenu.addActionListener(event);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, 0, new Color(0, 0, 0), 250, 0, new Color(0,0,0));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
