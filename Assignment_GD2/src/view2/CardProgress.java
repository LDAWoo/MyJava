package view2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardProgress extends JPanel {
	private Color color1;
	private Color color2;

	public CardProgress() {
		this.setOpaque(false);
		setPreferredSize(new Dimension(300, 200));
		setBounds(0, 0, 300, 200);
		setLayout(null);
		this.setBorder(null);

//		color1 = new Color(112, 69, 246);
//		color2 = new Color(223, 117, 239);
		
		color1 = new Color(247, 41, 4);
		color2 = new Color(247, 138, 4);

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gp = new GradientPaint(0, 600, color1, 300, 0, color2);
		g2D.setPaint(gp);
		g2D.fillRect(0, 0, 900, 500);
		
		g2D.setPaint(Color.white);
		g2D.setFont(new Font("Segoe UI",Font.BOLD,70));
		g2D.drawString("FPT POLYTECHNIC", 150, 145);
		

	}
}
