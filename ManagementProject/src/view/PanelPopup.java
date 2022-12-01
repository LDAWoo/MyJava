package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PanelPopup extends JPanel {

	public PanelPopup() {
		this.setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(50, 50, 50));
		g2.fillRect(8, 0, getSize().width - 8, getSize().height);
		int x[] = { 0, 10, 10 };
		int y[] = { 20, 13, 27 };

		g2.fillPolygon(x, y, x.length);

		super.paintComponent(g);
	}
}
