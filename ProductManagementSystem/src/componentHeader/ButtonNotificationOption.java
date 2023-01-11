package componentHeader;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

public class ButtonNotificationOption extends JButton {
	private Color color1 = new Color(39,43,48);
	
	
	public ButtonNotificationOption() {
		setHorizontalAlignment(CENTER);
		setContentAreaFilled(false);
		setBorder(null);
		setOpaque(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel = new JLabel("...");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}
	
	public void addActionButtonOption(ActionListener event) {
		addActionListener(event);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color1);
		g2.fillOval(8,15,35,35);
		super.paintComponent(g);
	}

}
