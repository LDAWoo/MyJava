package componentButton;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Button extends JButton{
	
	private Color color;
	
	
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Button(String text) {
		setOpaque(false);
		setFocusPainted(false);
		setFont(new Font("SansSerif", Font.PLAIN, 13));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBorder(null);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.drawRect(0, 0, getWidth() -1 , getHeight() -1);
		super.paintComponent(g);
	}
}
