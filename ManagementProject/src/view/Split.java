package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Split extends JPanel {
	private LabelSplite splitLeft;
	private JLabel lblManager;
	
	public Split(String name) {
		setOpaque(false);
		splitLeft = new LabelSplite();
		lblManager = new JLabel("Management");
		lblManager.setFont(new Font("SansSerif",Font.PLAIN,17));
		lblManager.setForeground(new Color(191,191,191));
		lblManager.setText(name);
		LabelSplite splitRight = new LabelSplite();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(splitLeft, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblManager)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(splitRight, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(splitRight, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblManager)
						.addComponent(splitLeft, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
