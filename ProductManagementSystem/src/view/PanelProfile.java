package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import componentLogin.MainLogin;

public class PanelProfile extends JPanel {
	private ImageIcon imageLogoShop = new ImageIcon(new ImageIcon(PanelProfile.class.getResource("/icon/logo-shop.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
	
	
	public PanelProfile() {
		setOpaque(false);
		
		JLabel lblLogoShop = new JLabel("");
		lblLogoShop.setIcon(imageLogoShop);
		lblLogoShop.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLogoShop.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTitle = new JLabel("FASHION SHOP");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(new Color(220, 20, 20));
		lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblLogoShop, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogoShop, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		
	}
}
