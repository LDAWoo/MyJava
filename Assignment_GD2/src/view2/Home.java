package view2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.SystemColor;

import javax.swing.*;

public class Home extends JPanel{

	private Color color1;
	private Color color2;
	public Home() {
		this.setOpaque(false);
		setPreferredSize(new Dimension(300, 200));
		setBounds(0, 0, 300, 200);
		setLayout(null);
		this.setBorder(null);

		color1 = new Color(112, 69, 246);


	}

	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2D.setPaint(new Color(243,111,36));
		g2D.fillRoundRect(0, 0, 920, 430,25,25);
		
		g2D.setPaint(Color.white);
		g2D.fillRoundRect(217, 90, 65, 130, 15,15);
	
		g2D.fillRoundRect(293, 90, 65, 130, 15,15);
		
		g2D.fillRoundRect(367, 90, 65, 130, 15,15);
		
		g2D.setFont(new Font("Segoe UI",Font.BOLD,25));
		
		g2D.drawString("®", 437, 224);
		
		g2D.setPaint(new Color(243,111,36));
		g2D.setFont(new Font("Segoe UI",Font.BOLD,85));
		g2D.drawString("F", 225, 185);
		
		g2D.setFont(new Font("Segoe UI",Font.BOLD,85));
		g2D.drawString("P", 300, 185);
		
		g2D.setFont(new Font("Segoe UI",Font.BOLD,85));
		g2D.drawString("T", 375, 185);
		
		g2D.setFont(new Font("SanSerif",Font.PLAIN,55));
		
		g2D.setPaint(Color.white);
		g2D.drawString("Education", 475, 185);
		
		g2D.setFont(new Font("Times New Roman",Font.BOLD,65));
		g2D.drawString("FPT POLYTECHNIC", 150, 345);
		
		
	}
	
}
