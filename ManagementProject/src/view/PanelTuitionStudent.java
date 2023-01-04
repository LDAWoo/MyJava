package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;

public class PanelTuitionStudent extends JPanel {
	private TableTuitionStudent table;
	
	public PanelTuitionStudent() {
		setOpaque(false);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCenter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1453, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1453, Short.MAX_VALUE)
						.addComponent(panelNorth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1453, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		CardTuition panelTuitionWallet = new CardTuition(img.img.iconWallet1(),"0","Ví học phí");
		
		CardTuition panelLearnerAgainWallet = new CardTuition(img.img.iconWallet2(),"0","Ví học lại/Thi lại");
		
		CardTuition panelDifferentWallet = new CardTuition(img.img.iconWallet3(),"0","Ví khác");
		
		CardTuition panelEndowWallet = new CardTuition(img.img.iconWallet4(),"0","Ví ưu đãi");
		
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTuitionWallet, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelLearnerAgainWallet, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelDifferentWallet, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelEndowWallet, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(panelEndowWallet, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelDifferentWallet, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelLearnerAgainWallet, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelTuitionWallet, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelCenter.setLayout(gl_panelCenter);
		
		JLabel lblInfor = new JLabel("Thông tin giao dịch, hóa đơn");
		lblInfor.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblInfor.setForeground(new Color(191,191,191));
		
		table = new TableTuitionStudent();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		table.addTableStyle(scrollPane);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
						.addComponent(lblInfor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInfor, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JLabel lblTuition = new JLabel("HỌC PHÍ");
		lblTuition.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTuition.setForeground(new Color(200,200,200));
		lblTuition.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addComponent(lblTuition, GroupLayout.DEFAULT_SIZE, 1235, Short.MAX_VALUE)
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addComponent(lblTuition, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
		);
		panelNorth.setLayout(gl_panelNorth);
		setLayout(groupLayout);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(new Color(60,60,60));
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
}
