package view;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PanelMode extends JPanel {
	private Color colorMenu = new Color(17, 19, 21);
	private Color colorMenuLight = new Color(39,43,48);
	
	private Color color1 = new Color(200,200,200);
	private Color color2 = new Color(255,255,255);
	
	private ButtonMode btnLight;
	private ButtonMode btnDark;

	public PanelMode() {
		setOpaque(false);
		setLayout(null);
		btnLight = new ButtonMode();
		btnLight.setIcon(new ImageIcon(PanelMode.class.getResource("/icon/sun-white.png")));
		btnLight.setBounds(5, 5, 125, 30);
		btnLight.setColorMenu(colorMenu);
		btnLight.setForeground(color1);
		btnLight.setText("Nhẹ");
		add(btnLight);

		btnDark = new ButtonMode();
		btnDark.setIcon(new ImageIcon(PanelMode.class.getResource("/icon/moon-white.png")));
		btnDark.setText("Tối");
		btnDark.setBounds(135, 5, 125, 30);
		btnDark.setForeground(color2);
		add(btnDark);
		actionButton();
	}
	
	
	public void actionButton() {
		
		
		btnLight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnLight.setForeground(color2);
				btnLight.setColorMenu(colorMenuLight);
				
				btnDark.setForeground(color1);
				btnDark.setColorMenu(colorMenu);
			}
		});
		
		btnDark.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnDark.setForeground(color2);
				btnDark.setColorMenu(colorMenuLight);
				
				btnLight.setForeground(color1);
				btnLight.setColorMenu(colorMenu);
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorMenu);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
		super.paintComponent(g);
	}
}
