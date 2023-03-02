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
	private Color color = new Color(39,43,48);
	private JLabel lblOption;
	
	
	public ButtonNotificationOption() {
		setHorizontalAlignment(CENTER);
		setContentAreaFilled(false);
		setBorder(null);
		setOpaque(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblOption = new JLabel("...");
		lblOption.setForeground(Color.WHITE);
		lblOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption.setFont(new Font("Segoe UI", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblOption, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblOption, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
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
		g2.setColor(color);
		g2.fillOval(8,15,35,35);
		super.paintComponent(g);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		repaint();
	}

	public JLabel getLblOption() {
		return lblOption;
	}

	public void setLblOption(JLabel lblOption) {
		this.lblOption = lblOption;
	}
	
	
	

}
