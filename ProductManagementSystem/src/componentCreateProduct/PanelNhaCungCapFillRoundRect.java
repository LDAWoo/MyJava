package componentCreateProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelNhaCungCapFillRoundRect extends JPanel {
	private Color color = new Color(26, 29, 31);
	
	public PanelNhaCungCapFillRoundRect() {
		setOpaque(false);
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D)g;
		
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
		
	}

}
