package view;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;

import img.img;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class Header extends JPanel {
	private img img = new img();
	private JButton btnMenu;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JLabel lbRole;
	private javax.swing.JLabel lbUserName;
	private PanelFind panelFind;
	
	public Header() {
		setOpaque(false);
		setBackground(SystemColor.window);
		
		btnMenu = new JButton("",this.img.iconMenu());
		btnMenu.setBorder(null);
		btnMenu.setOpaque(false);
		btnMenu.setBackground(SystemColor.window);

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
        
        GroupLayout layout = new GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(btnMenu, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panelFind, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
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
        					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
        					.addComponent(lbRole))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(panelFind, GroupLayout.DEFAULT_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        		.addComponent(btnMenu, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );
        this.setLayout(layout);

	}

	public void AddMenuEvent(ActionListener event) {
		btnMenu.addActionListener(event);
	}
}
