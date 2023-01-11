package componentHeader;

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

public class ButtonShowAllNotification extends JButton{
	
	private Color color1 = new Color(42 ,133,255); 
	private Color color2 = new Color(0,105,246);
	private Color color = new Color(237,243,252);
	public ButtonShowAllNotification(String text) {
		setText(text);
		setOpaque(false);
		setFocusPainted(false);
		setFont(new Font("Roboto", Font.BOLD, 17));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setContentAreaFilled(false);
		setForeground(color);
		setBorder(null);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				color1 = color2;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				color1 = new Color(42 ,133,255); 
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color1);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
		super.paintComponent(g);
	}
}
