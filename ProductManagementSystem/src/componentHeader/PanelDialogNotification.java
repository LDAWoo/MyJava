package componentHeader;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

public class PanelDialogNotification extends JPanel {

	private Color colorDialog = new Color(17,19,21);
	private Color color = new Color(39, 43, 49);

	public PanelDialogNotification() {
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(color);
		int x[] = { 325, 335, 345 };
		int y[] = { 8, 0, 8 };
		g2.fillPolygon(x, y, x.length);
		
		g2.setColor(colorDialog);
		g2.fillRoundRect(1, 8, getWidth(), getHeight()-8, 25, 25);
		
		g2.setColor(color);
		g2.drawRoundRect(0, 8, getWidth() - 1, getHeight() - 9, 25, 25);
		
		super.paintComponent(g);
	}

	public Color getColorDialog() {
		return colorDialog;
	}

	public void setColorDialog(Color colorDialog) {
		this.colorDialog = colorDialog;
		repaint();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		repaint();
	}
	
	
	
}
