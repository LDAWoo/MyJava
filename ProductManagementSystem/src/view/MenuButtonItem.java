package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MenuButtonItem extends JButton {

	private Color effectColor = new Color(26, 29, 31);
	
	private Color colorButton = new Color(200,200,200);
	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public MenuButtonItem(String text) {
		super(text);
		init();
		setBorder(new EmptyBorder(1, 20, 1, 1));

	}

	private void init() {
		setOpaque(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setForeground(colorButton);
		setFont(new Font("Roboto", Font.PLAIN, 15));
		setHorizontalAlignment(JLabel.LEFT);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				effectColor = new Color(70,70,70);
				colorButton = new Color(255,255,255);
				setForeground(colorButton);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				effectColor =  new Color(26, 29, 31);
				colorButton = new Color(200,200,200);
				setForeground(colorButton);
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(effectColor);
		g2.fillRoundRect(0, 0, getWidth() -10, getHeight() - 2, 15, 15);
		super.paintComponent(g);
	}

}
