package view;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import color.ColorBackground;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PanelMode extends JPanel {
	public static Color colorMode = new Color(17, 19, 21);
	
	
	private Color color1 = new Color(200,200,200);
	private Color color2 = new Color(255,255,255);
	
	public static ButtonMode btnLight;
	public static ButtonMode btnDark;
	
	
	
	public Icon iconLightB = new ImageIcon(MainForm.class.getResource("/icon/sun-black.png"));
	public Icon iconDarkB = new ImageIcon(MainForm.class.getResource("/icon/moon-black.png"));
	
	public Icon iconLightW = new ImageIcon(MainForm.class.getResource("/icon/sun-white.png"));
	public Icon iconDarkW = new ImageIcon(MainForm.class.getResource("/icon/moon-white.png"));

	
	public PanelMode() {
		setOpaque(false);
		setLayout(null);
		btnLight = new ButtonMode();
		btnLight.setIcon(iconLightW);
		btnLight.setBounds(5, 5, 125, 30);
		btnLight.setColorMenu(colorMode);
		btnLight.setForeground(color1);
		btnLight.setText("Nhẹ");
		add(btnLight);

		btnDark = new ButtonMode();
		btnDark.setIcon(iconDarkW);
		btnDark.setText("Tối");
		btnDark.setBounds(135, 5, 125, 30);
		btnDark.setForeground(color2);
		add(btnDark);
		
		
		btnLight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLight.setIcon(iconLightB);
				btnDark.setIcon(iconDarkB);
				colorMode = ColorBackground.colorGRB240242245;
				
				btnLight.setForeground(ColorBackground.colorDark);
				btnDark.setForeground(ColorBackground.colorDark);
				
				
				btnLight.setColorMenu(ColorBackground.colorLight);
				btnDark.setColorMenu(ColorBackground.colorGRB240242245);
				
				
				repaint();
			}
		});

		
		btnDark.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDark.setIcon(iconDarkW);
				btnLight.setIcon(iconLightW);
				colorMode = ColorBackground.colorGRB171921;
				
				btnLight.setForeground(color1);
				btnDark.setForeground(color2);	
				
				btnLight.setColorMenu(ColorBackground.colorGRB171921);
				btnDark.setColorMenu(ColorBackground.colorGRB394348);
				
				repaint();
			}
		});
	}
	
	
	
	public static void actionButonModeDark(ActionListener event) {
		btnDark.addActionListener(event);
	}
	
	public static void actionButonModeLight(ActionListener event) {
		btnLight.addActionListener(event);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorMode);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
		super.paintComponent(g);
	}









	
	
	
}
