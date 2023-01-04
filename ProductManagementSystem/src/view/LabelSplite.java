package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

public class LabelSplite extends JLabel {
	private Color color = new Color(200,200,200);
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		
		g2.setColor(color);
		
		g2.drawLine(10, getHeight() / 2 , getWidth() - 10, getHeight() / 2);
		super.paint(g);
	}

}
