package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import color.ColorBackground;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelMessageDialog extends JPanel {

	Color color1 = ColorBackground.colorGRB000;
	Color color2 = ColorBackground.colorDark;
	
	
	private JLabel lblTitle;

	public PanelMessageDialog(String title) {
		setOpaque(false);
		lblTitle = new JLabel("Messenger");
		lblTitle.setText(title);
		lblTitle.setForeground(ColorBackground.colorLight);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE).addContainerGap()));
		setLayout(groupLayout);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color1);
		g2.fillRoundRect(1, 1, getWidth(), getHeight(), 20, 20);
		
		g2.setColor(color2);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		super.paintComponents(g);
	}

	public Color getColor() {
		return color1;
	}

	public void setColor(Color color) {
		this.color1 = color;
		repaint();
	}

	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
		repaint();
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	
}
