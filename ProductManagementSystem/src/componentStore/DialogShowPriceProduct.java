package componentStore;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class DialogShowPriceProduct extends JDialog {

	/**
	 * Create the panel.
	 */
	
	private int w;
	private int price;
	private PanelDialogShowPriceProduct panel;
	public DialogShowPriceProduct(JFrame parent,int w,int price) {
		super(parent,false);
		this.w = w;
		this.price = price;
		setUndecorated(true);
		
		
		setBackground(new Color(0,0,0,0));
		setPreferredSize(new Dimension(250,80));
		

		panel = new PanelDialogShowPriceProduct(price);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE,w, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(90, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		pack();
	}
	
	
}
