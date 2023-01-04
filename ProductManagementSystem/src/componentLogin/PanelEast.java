package componentLogin;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PanelEast extends JPanel {

	public PanelEast() {
		setOpaque(false);
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, 0, Color.decode("#93291E"), 0, getHeight(), Color.decode("#1F1C18"));
		g2.setPaint(gra);
		g2.fillRect(0, 0,  getWidth(), getHeight());
		super.paintComponent(g);
	}

}
