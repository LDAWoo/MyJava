package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class PanelStudentHelp extends JPanel {

	
	private JPanel body;
	private ButtonConfirm btnIT;
	private ButtonConfirm btnAdministrative;
	private ButtonConfirm btnStudentEnterSchool;

	public PanelStudentHelp() {
		setOpaque(false);
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(new Color(55,55,55));
		
		JLabel lblHelp = new JLabel("TRỢ GIÚP");
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelp.setForeground(SystemColor.scrollbar);
		lblHelp.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		body = new JPanel();
		body.setOpaque(false);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHelp, GroupLayout.DEFAULT_SIZE, 1212, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelWest, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(body, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHelp, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(body, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
						.addComponent(panelWest, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
					.addContainerGap())
		);
		body.setLayout(new java.awt.BorderLayout());
		
		JLabel lblNewLabel = new JLabel("DANH MỤC");

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Noto Serif", Font.BOLD, 15));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(191,191,191));
		lblNewLabel.setForeground(new Color(70,70,70));
		
		btnStudentEnterSchool = new ButtonConfirm();
		btnStudentEnterSchool.setText("HV mới nhập học");
		btnStudentEnterSchool.setFont(new Font("Noto Serif", Font.BOLD, 15));
		btnStudentEnterSchool.setOpaque(true);
		btnStudentEnterSchool.setBackground(new Color(70,70,70));
		
		btnAdministrative = new ButtonConfirm();
		btnAdministrative.setText("Hành chính");
		btnAdministrative.setFont(new Font("Noto Serif", Font.BOLD, 15));
		btnAdministrative.setOpaque(true);
		btnAdministrative.setBackground(new Color(70,70,70));
		
		btnIT = new ButtonConfirm();
		btnIT.setText("IT");
		btnIT.setFont(new Font("Noto Serif", Font.BOLD, 15));
		btnIT.setOpaque(true);
		btnIT.setBackground(new Color(70,70,70));
		
		
		GroupLayout gl_panelWest = new GroupLayout(panelWest);
		gl_panelWest.setHorizontalGroup(
			gl_panelWest.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnStudentEnterSchool, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(btnAdministrative, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(btnIT, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		gl_panelWest.setVerticalGroup(
			gl_panelWest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWest.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(btnStudentEnterSchool, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAdministrative, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnIT, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(324, Short.MAX_VALUE))
		);
		panelWest.setLayout(gl_panelWest);
		setLayout(groupLayout);
		action();
	}
	
	public void action() {
		btnIT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showForm(new PanelITHelp());
				
			}
		});
		
		btnStudentEnterSchool.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				showForm(new PanelNewStudentEnterSchool());
				
			}
		});
		
		btnAdministrative.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				showForm(new PanelAdministrative());
				
			}
		});
		
		
		
	}
	
	public void showForm(Component com) {
		body.removeAll();
		body.add(com);
		body.revalidate();
		body.repaint();
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new Color(60, 60, 60));
		g2.fillRect(0, 0,getWidth(), getHeight());
		super.paintComponent(g);
	}
}
