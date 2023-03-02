package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

public class PanelStaticalStudent extends JPanel {

	private TableStaticalStudent table;
	
	public PanelStaticalStudent() {
		setOpaque(false);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCenter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE)
						.addComponent(panelNorth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
					.addContainerGap())
		);
		table = new TableStaticalStudent();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		table.addTableStyle(scrollPane);
		
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE)
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
		);
		panelCenter.setLayout(gl_panelCenter);
		
		JLabel lblLearner = new JLabel("NGƯỜI HỌC");
		lblLearner.setHorizontalAlignment(SwingConstants.CENTER);
		lblLearner.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblLearner.setForeground(new Color(200,200,200));
		
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addComponent(lblLearner, GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE)
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLearner, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		panelNorth.setLayout(gl_panelNorth);
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
