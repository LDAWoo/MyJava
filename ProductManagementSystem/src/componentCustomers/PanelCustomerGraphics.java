package componentCustomers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PanelCustomerGraphics extends JPanel {
	
	private Color colorCustomers = new Color(26,29,31);
	
	
	public PanelCustomerGraphics() {
		setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorCustomers);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(),25,25);
		super.paintComponent(g);
	}

}
