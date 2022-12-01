package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StudentTableScore extends JPanel {

	public StudentTableScore() {
		setOpaque(false);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		
		JButton btnLearner = new JButton("Learner");
		btnLearner.setForeground(SystemColor.menu);
		btnLearner.setFont(new Font("SansSerif", Font.PLAIN, 25));
		btnLearner.setBorder(null);
		btnLearner.setBackground(new Color(93, 58, 196));
		
		JLabel lblStatistical = new JLabel("TỔNG HỢP SỐ LƯỢNG NGƯỜI ĐĂNG KÍ HỌC\r\n\r\n");
		lblStatistical.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistical.setForeground(Color.WHITE);
		lblStatistical.setFont(new Font("SansSerif", Font.BOLD, 20));
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNorth.createSequentialGroup()
							.addGap(22)
							.addComponent(btnLearner, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelNorth.createSequentialGroup()
							.addGap(230)
							.addComponent(lblStatistical)))
					.addContainerGap(260, Short.MAX_VALUE))
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addComponent(lblStatistical, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLearner, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
		);
		panelNorth.setLayout(gl_panelNorth);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 929, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(518, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		GradientPaint gra = new GradientPaint(0, 0, new Color(60,22,173), 0, 0, new Color(191,60,234));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
