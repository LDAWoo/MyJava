package dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import color.ColorBackground;

public class PanelSearchProduct extends JPanel {
	private Color color1 = ColorBackground.colorDark;
	private Color color2 = new Color(47,127,252);
	
	public PanelSearchProduct() {
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color1);
		g2.fillRoundRect(1, 1, getWidth(), getHeight(),15,15);
		g2.setColor(color2);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1,15,15);
	}
}
