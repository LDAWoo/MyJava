package componentProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PanelCustomers extends JPanel {

	private Color colorCustomers = new Color(0,0,0);
	
	public PanelCustomers() {
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

	public Color getColorCustomers() {
		return colorCustomers;
	}

	public void setColorCustomers(Color colorCustomers) {
		this.colorCustomers = colorCustomers;
	}

	
	
	
}
