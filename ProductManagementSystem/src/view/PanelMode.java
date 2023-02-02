package view;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
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
	
	public Icon iconLight = new ImageIcon(PanelMode.class.getResource("/icon/sun-white.png"));
	public Icon iconDark = new ImageIcon(PanelMode.class.getResource("/icon/moon-white.png"));
//	public Icon iconLightB = new ImageIcon(MainForm.class.getResource("/icon/sun-black.png"));
//	public Icon iconDarkB = new ImageIcon(MainForm.class.getResource("/icon/moon-black.png"));
	public Icon iconLightW = new ImageIcon(MainForm.class.getResource("/icon/sun-white.png"));
	public Icon iconDarkW = new ImageIcon(MainForm.class.getResource("/icon/moon-white.png"));

	public static void setMode(Color colorMode) {
		PanelMode mode = new PanelMode(null,null);
		mode.colorMode = colorMode;
		mode.repaint();
	}
	
	
	
	public Icon getIconLight() {
		return iconLight;
	}



	public void setIconLight(Icon iconLight) {
		this.iconLight = iconLight;
	}



	public Icon getIconDark() {
		return iconDark;
	}



	public void setIconDark(Icon iconDark) {
		this.iconDark = iconDark;
	}



	public PanelMode(Icon iconLight, Icon iconDark) {
		this.iconLight = iconLight;
		this.iconDark = iconDark;
		setOpaque(false);
		setLayout(null);
		btnLight = new ButtonMode();
		btnLight.setIcon(iconLight);
		btnLight.setBounds(5, 5, 125, 30);
		btnLight.setColorMenu(colorMode);
		btnLight.setForeground(color1);
		btnLight.setText("Nhẹ");
		add(btnLight);

		btnDark = new ButtonMode();
		btnDark.setIcon(iconDark);
		btnDark.setText("Tối");
		btnDark.setBounds(135, 5, 125, 30);
		btnDark.setForeground(color2);
		add(btnDark);

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
