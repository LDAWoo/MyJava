package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;

import img.img;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCourseList extends JPanel {
	private TableCourse table;
	private img img = new img();
	private SearchStudent find;
	
	public PanelCourseList() {
		setBackground(SystemColor.infoText);
		setOpaque(false);
		JPanel panelCenter = new JPanel();
		
		find = new SearchStudent();
		table = new TableCourse();
		
		JScrollPane scrollPane = new JScrollPane(table);
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
		);
		panelCenter.setLayout(gl_panelCenter);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCenter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
						.addComponent(panelNorth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		JLabel lblIconFind = new JLabel(img.iconSearch());
		lblIconFind.setBorder(null);
		lblIconFind.setBackground(Color.WHITE);
		
		JButton btnRefresh = new JButton(img.iconRefresh());
		btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("Refresh");
		lblNewLabel.setForeground(new Color(93,58,196));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIconFind, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelNorth.createSequentialGroup()
							.addGap(38)
							.addComponent(find, GroupLayout.PREFERRED_SIZE, 764, GroupLayout.PREFERRED_SIZE)))
					.addGap(5)
					.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(lblNewLabel))
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addComponent(lblIconFind, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGap(2)
					.addComponent(find, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGap(3)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
		);
		panelNorth.setLayout(gl_panelNorth);
		setLayout(groupLayout);
		table.initTable();
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(93,58,196));
		g2.fillRect(0, 20, getSize().width, getSize().height-20);
		g2.fillRect(255, 1, 142, 19);
		super.paintComponent(g);
	}
}
