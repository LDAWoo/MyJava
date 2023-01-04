package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class DialogHelp extends JDialog {
	private PanelHelp panel;
	
	public DialogHelp(JFrame parent) {
		super(parent,false);
		init();
		setBackground(new Color(0, 0, 0, 0));
		setPreferredSize(new Dimension(200, 100));
	}

	public void init() {
		setUndecorated(true);
		panel = new PanelHelp();
		
		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		JLabel btnHelp = new JLabel();
		btnHelp.setText("Trợ giúp");
		btnHelp.setHorizontalAlignment(JLabel.CENTER);
		btnHelp.setFont(new Font("SansSerif",Font.PLAIN,14));
		btnHelp.setForeground(new Color(200,200,200));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnHelp, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnHelp, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(layout);
		pack();
	}
	
}
