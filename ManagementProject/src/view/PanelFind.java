package view;

import javax.swing.JPanel;

import java.awt.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import img.img;
import javax.swing.SwingConstants;

public class PanelFind extends JPanel {
	private JTextField textField;
	private img img = new img();
	public SearchText search;
	public JButton lblIcon;
	
	public PanelFind() {
		setOpaque(false);
		lblIcon = new JButton("");
		lblIcon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIcon.setHorizontalTextPosition(SwingConstants.LEADING);
		lblIcon.setIcon(this.img.iconSearch());
		lblIcon.setBorder(null);
		
		search = new SearchText();
		search.setBackground(getBackground());
		search.setForeground(getForeground());
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(search, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblIcon, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
				.addComponent(search, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		
	}


}
