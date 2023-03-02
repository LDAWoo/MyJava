package componentProduct;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;
import javax.swing.JButton;

import color.ColorBackground;



public class IconEditProduct extends JButton {
	private Color color = new Color(39,43,48);
	
	private Icon icon;
	
	

	public IconEditProduct(Icon icon) {
		this.icon = icon;
		setOpaque(false);
		setBorder(null);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setIcon(icon);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int x = getWidth() ;
		int y = getHeight() ;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillOval(0, 0, x, y);
		super.paintComponent(g);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		repaint();
	}

	


	

}
