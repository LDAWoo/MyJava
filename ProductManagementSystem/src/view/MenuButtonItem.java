package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import color.ColorBackground;

public class MenuButtonItem extends JButton {

	private Color effectColor = ColorBackground.colorDark;
	
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
				if (effectColor == ColorBackground.colorDark) {
					setOpaque(true);
					setBackground(ColorBackground.colorGRB707070);
				}
				if (effectColor == ColorBackground.colorLight) {
					setOpaque(true);
					setBackground(ColorBackground.colorGRB239239239);
				}
				setForeground(colorButton);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setOpaque(false);
				setForeground(colorButton);
			}
		});
		actionButtonMode();
	}
	
	public void actionButtonMode() {
		PanelMode.actionButonModeDark(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				effectColor = ColorBackground.colorDark;
				setForeground(ColorBackground.colorLight);
				repaint();
			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				effectColor = ColorBackground.colorLight;
				setForeground(ColorBackground.colorDark);
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(effectColor);
		g2.fillRect(0, 0, getWidth(), getHeight() - 2);
		super.paintComponent(g);
	}

}
