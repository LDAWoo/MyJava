package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import img.img;
import javax.swing.SwingConstants;

public class CardTuition extends JPanel{
	
	
	public CardTuition(Icon icon,String tuition, String tuitionWallet) {
		setOpaque(false);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setIcon(icon);
		JLabel lblTuition = new JLabel("<html>"+tuition+" "+"<u>đ</html>");
		lblTuition.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuition.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblTuition.setForeground(new Color(200,200,200));
		
		JLabel lblTuitionWallet = new JLabel(tuitionWallet);
		lblTuitionWallet.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuitionWallet.setFont(new Font("Segoe UI", Font.ITALIC, 16));
		lblTuitionWallet.setForeground(new Color(191,191,191));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
						.addComponent(lblTuition, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
						.addComponent(lblTuitionWallet, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTuition)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTuitionWallet, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(new Color(70,70,70));
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
	}

	

}