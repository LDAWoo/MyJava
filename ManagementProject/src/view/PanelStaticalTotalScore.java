package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

public class PanelStaticalTotalScore extends JPanel {
	
	private TableStaticalTableTotalScore table;

	public PanelStaticalTotalScore() {
		setOpaque(false);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		
		JLabel lblTotalScore = new JLabel("TỔNG HỢP ĐIỂM");
		lblTotalScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalScore.setForeground(SystemColor.scrollbar);
		lblTotalScore.setFont(new Font("SansSerif", Font.BOLD, 20));
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1258, Short.MAX_VALUE)
				.addComponent(lblTotalScore, GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGap(0, 49, Short.MAX_VALUE)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTotalScore, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelNorth.setLayout(gl_panelNorth);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCenter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
						.addComponent(panelNorth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
					.addContainerGap())
		);
		table = new TableStaticalTableTotalScore();	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		table.addTableStyle(scrollPane);
		
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
		);
		panelCenter.setLayout(gl_panelCenter);
		setLayout(groupLayout);

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(60,60,60));
		g2.fillRect(0, 0, getWidth(), getHeight());
		
		super.paintComponent(g);
	}

}
