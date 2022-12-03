package components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PanelMessenger extends JPanel {

	public PanelMessenger() {
		setOpaque(false);
	
		
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
