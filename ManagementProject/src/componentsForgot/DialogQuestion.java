package componentsForgot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogQuestion extends JDialog {

	public JLabel lblTextMessage;
	public JLabel lblQuestion;
	
	
	
	public DialogQuestion(JFrame parent) {
		super(parent,false);
		init();
		setBackground(new Color(0, 0, 0, 0));
		setPreferredSize(new Dimension(400, 200));
		
		
	}
	
	public void init() {
		setUndecorated(true);
		
		PanelQuestion panel = new PanelQuestion();
		panel.setOpaque(false);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setIcon(img.img.iconQuestion());
		
		lblQuestion = new JLabel("");
		lblQuestion.setFont(new Font("SansSerif",Font.PLAIN,15));
		lblQuestion.setForeground(new Color(200,200,200));
		
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblTextMessage = new JLabel("");
		lblTextMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMessage.setFont(new Font("SansSerif",Font.PLAIN,15));
		lblTextMessage.setForeground(new Color(220,220,220));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblQuestion, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(lblTextMessage, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblQuestion, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTextMessage, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		
		Timer timer = new Timer(5000, new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);				
			}
		});
		timer.start();
		
		pack();
	}

}
