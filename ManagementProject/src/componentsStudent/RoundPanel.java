package componentsStudent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class RoundPanel extends JPanel{
	public RoundPanel() {
		setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getWidth();
		int height = getHeight();
		g2.setBackground(getBackground());
		g2.fillRoundRect(0, 0, width, height,15,15);
		g2.dispose();
		super.paintComponent(g);
	}
}
