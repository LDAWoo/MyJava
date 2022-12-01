package view2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class FPTHome extends JPanel {
	private Home home;

	public FPTHome() {
		this.setBackground(SystemColor.inactiveCaptionBorder);
		this.setForeground(new Color(0, 0, 128));
		this.setPreferredSize(new Dimension(920,430));
		this.setLayout(null);	
		
		home = new Home();
		home.setBounds(0, 0, 920, 430);
		this.add(home);		
	}

}
