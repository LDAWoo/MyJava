package view;

import javax.swing.JPanel;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import img.img;
import javax.swing.SwingConstants;

public class PanelFind extends JPanel {
	private JTextField textField;
	private img img = new img();
	private SearchText search;
	
	public PanelFind() {
		setOpaque(false);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setHorizontalTextPosition(SwingConstants.LEADING);
		lblIcon.setIcon(this.img.iconSearch());
		
		search = new SearchText();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(search, GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(search, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
				.addComponent(lblIcon, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(255,255,255,255));;
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
		g2.fillRect(0, 0, 25, getHeight());
		g2.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
