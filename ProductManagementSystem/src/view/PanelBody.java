package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PanelBody extends JPanel {
	private Color colorBody = new Color(0,0,0);
	
	

	public PanelBody() {
		setOpaque(false);
		setLayout(new BorderLayout());	
		setBorder(new EmptyBorder(30, 30, 30, 30));
	}
	
	public void showForm(JComponent com) {
		removeAll();
		add(com);
		repaint();
		revalidate();

	}
	
	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorBody);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

	public Color getColorBody() {
		return colorBody;
	}

	public void setColorBody(Color colorBody) {
		this.colorBody = colorBody;
		repaint();
	}
	
	
	
}
