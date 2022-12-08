package view;

import javax.swing.JPanel;

import img.img;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Profile extends JPanel{
	private img img = new img();
	public Profile() {
		JLabel lblManagement = new JLabel("Management");
		lblManagement.setForeground(Color.WHITE);
		lblManagement.setIcon(this.img.iconProfile());
		lblManagement.setFont(new Font("SansSerif", Font.BOLD, 23));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblManagement, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblManagement, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		GradientPaint gra = new GradientPaint(0, 0, new Color(33,105,249), 250, 0, new Color(93,58,196));
		GradientPaint gra = new GradientPaint(0, 0, Color.decode("#8E2DE2"), 250, 0, Color.decode("#4A00E0"));
		g2.setPaint(gra);
		
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
}
