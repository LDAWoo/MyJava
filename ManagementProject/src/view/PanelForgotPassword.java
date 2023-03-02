package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PanelForgotPassword extends JPanel {

	
	public PanelForgotPassword() {
		setOpaque(false);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(70,70,70));
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
