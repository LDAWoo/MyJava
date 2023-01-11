package componentCreateProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PanelTitle extends JPanel {

	private Color colorBackground = new Color(39,43,48);
	
	private Color colorClick;
	
	public PanelTitle() {
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorBackground);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(),25,25);
		g2.setColor(colorClick);
		g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);	
		super.paintComponent(g);
	}

	public Color getColorBackground() {
		return colorBackground;
	}

	public void setColorBackground(Color colorBackground) {
		this.colorBackground = colorBackground;
		repaint();
	}

	public Color getColorClick() {
		return colorClick;
	}

	public void setColorClick(Color colorClick) {
		this.colorClick = colorClick;
		repaint();
	}
	
	

	
	
	
}
