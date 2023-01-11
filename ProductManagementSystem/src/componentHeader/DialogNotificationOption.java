package componentHeader;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class DialogNotificationOption extends JDialog {

	
	private PanelOption panelOption;

	public DialogNotificationOption(JFrame parent) {
		super(parent,false);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		init();
		
		setPreferredSize(new Dimension(300, 160));
		pack();
		
		
	}

	public void init() {
		panelOption = new PanelOption();
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelOption, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelOption, GroupLayout.PREFERRED_SIZE, 133, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public void addActionButtonCheck(ActionListener event) {
		panelOption.addActionButtonCheck(event);
	}
	
	public void addActionButtonDelete(ActionListener event) {
		panelOption.addActionButtonDelete(event);
	}
}
