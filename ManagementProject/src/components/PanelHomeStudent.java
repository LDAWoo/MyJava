package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import components.TableInformationStudent;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class PanelHomeStudent extends JPanel {

	
	private TableInformationStudent tableInformation;

	public PanelHomeStudent() {
		setOpaque(false);
		
		JPanel panelWest = new JPanel();
		panelWest.setOpaque(false);
		
		
		
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		
		TableActivityStudent tableActivityStudent = new TableActivityStudent();
		
		JScrollPane scrollPaneCenter = new JScrollPane(tableActivityStudent);
		scrollPaneCenter.setBackground(new Color(50,50,50));
		tableActivityStudent.addTableStyle(scrollPaneCenter);
		
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneCenter, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneCenter, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
		);
		panelCenter.setLayout(gl_panelCenter);
		
		JPanel panelEast = new JPanel();
		panelEast.setOpaque(false);
		
		TableTuitionStudent tableTuitionStudent = new TableTuitionStudent();
		
		JScrollPane scrollPaneEast = new JScrollPane(tableTuitionStudent);
		scrollPaneEast.setBackground(new Color(50,50,50));
		tableTuitionStudent.addTableStyle(scrollPaneEast);
		
		GroupLayout gl_panelEast = new GroupLayout(panelEast);
		gl_panelEast.setHorizontalGroup(
			gl_panelEast.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneEast, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
		);
		gl_panelEast.setVerticalGroup(
			gl_panelEast.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneEast, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
		);
		panelEast.setLayout(gl_panelEast);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelNorth, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(panelWest, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelEast, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(207, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
						.addComponent(panelEast, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
						.addComponent(panelWest, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel lblHome = new JLabel("TRANG CHỦ");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("SansSerif",Font.BOLD,20));
		lblHome.setForeground(new Color(200,200,200));
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHome, GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHome, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelNorth.setLayout(gl_panelNorth);
		
		tableInformation = new TableInformationStudent();
		
		JScrollPane scrollPaneWest = new JScrollPane(tableInformation);
		scrollPaneWest.setBackground(new Color(50,50,50));
		
		
		tableInformation.addTableStyle(scrollPaneWest);
	
		
		GroupLayout gl_panelWest = new GroupLayout(panelWest);
		gl_panelWest.setHorizontalGroup(
			gl_panelWest.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneWest, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
		);
		gl_panelWest.setVerticalGroup(
			gl_panelWest.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneWest, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
		);
		panelWest.setLayout(gl_panelWest);
		setLayout(groupLayout);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new Color(60, 60, 60));
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
