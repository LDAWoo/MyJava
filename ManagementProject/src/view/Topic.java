package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Topic extends JPanel {
	private PanelTopicUpdate panelTopic;
	private JPanel panelCenter;
	private PanelTopicList panelList;
	
	public Topic() {
		setOpaque(false);
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		panelCenter = new JPanel();
		panelCenter.setBackground(new Color(60,22,173));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelNorth, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
		);
		
		panelTopic = new PanelTopicUpdate();
		panelTopic.setBounds(0,0,932,543);
		panelCenter.add(panelTopic); 
		
		panelList = new PanelTopicList();
		panelList.setBounds(0,0,932,543);
		panelCenter.add(panelList); 
		
		panelList.setVisible(false);
		
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGap(0, 912, Short.MAX_VALUE)
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGap(0, 514, Short.MAX_VALUE)
		);
		panelCenter.setLayout(null);
		
		JLabel lblManagerTopic = new JLabel("QUẢN LÝ CHUYÊN ĐỀ\r\n");
		lblManagerTopic.setForeground(Color.WHITE);
		lblManagerTopic.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblManagerTopic.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelList.setVisible(false);
				panelTopic.setVisible(true);
			}
		});
		btnUpdate.setForeground(SystemColor.menu);
		btnUpdate.setFont(new Font("SansSerif", Font.PLAIN, 25));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(93, 58, 196));
		
		JButton btnList = new JButton("List Topic");
		btnList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelList.setVisible(true);
				panelTopic.setVisible(false);
			}
		});
		btnList.setForeground(SystemColor.menu);
		btnList.setFont(new Font("SansSerif", Font.PLAIN, 25));
		btnList.setBorder(null);
		btnList.setBackground(new Color(93, 58, 196));
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelNorth.createSequentialGroup()
					.addGap(22)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
						.addComponent(lblManagerTopic, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnList, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(295, Short.MAX_VALUE))
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addComponent(lblManagerTopic, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnList, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
		);
		panelNorth.setLayout(gl_panelNorth);
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
