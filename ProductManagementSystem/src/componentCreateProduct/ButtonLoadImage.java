package componentCreateProduct;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

public class ButtonLoadImage extends JButton {
	private Color colorBackground = new Color(39,43,48);
	
	private Color colorClick = new Color(150,150,150);
	
	
	public ButtonLoadImage(String text) {
		setText(text);
		setBorder(null);
		setFont(new Font("Roboto",Font.BOLD,14));
		setForeground(new Color(252,252,252));
		setOpaque(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setFocusPainted(false);

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

}
