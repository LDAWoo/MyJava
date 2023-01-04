package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogMessage extends JDialog {

	private PanelMessage panel;
	public  JLabel lblTitle;
	public  JLabel lblIcon;
	public  JLabel lblMessageText;
	private Button btnOk;
	private Button btnExit;
	

	public DialogMessage(JFrame parent) {
		super(parent,false);
		init();
		setBackground(new Color(0, 0, 0, 0));
		setPreferredSize(new Dimension(400, 250));
	}
	
	public void init() {
		setUndecorated(true);
		panel = new PanelMessage();
		panel.setBorder(new LineBorder(new Color(249, 149, 149),2));
		
		
		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		btnExit = new Button();
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnExit.setText("X");
		btnExit.setHorizontalAlignment(JLabel.LEFT);
		
		lblTitle = new JLabel("");
		lblTitle.setFont(new Font("SansSerif",Font.PLAIN,14));
		lblTitle.setForeground(new Color(200,200,200));
		
		
		btnOk = new Button();
		btnOk.setText("OK");
		btnOk.setHorizontalAlignment(SwingConstants.CENTER);
		btnOk.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnOk.setBorder(new LineBorder(new Color(150, 150, 150),1));
		
		lblIcon = new JLabel("");
		
		
		lblMessageText = new JLabel("");
		lblMessageText.setFont(new Font("SansSerif",Font.PLAIN,13));
		lblMessageText.setForeground(new Color(200,200,200));
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(8)
					.addComponent(lblIcon)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMessageText, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(102)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExit, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblMessageText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(layout);
		pack();
		action();
	}
	
	public void action() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	

}
