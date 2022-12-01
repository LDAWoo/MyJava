package view2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class FormHome extends JPanel{
	
	Card card;
	Card2 card2;
	Card3 card3;
	private JLabel label;
	private JLabel label_1;
	public FormHome() {
		this.setLayout(new BorderLayout());
		
		this.setForeground(new Color(0, 0, 128));
		this.setBackground(SystemColor.inactiveCaptionBorder);
		this.setPreferredSize(new Dimension(920, 200));
		
		this.setLayout(new GridLayout(1, 3, 5, 5));
		this.setBounds(244, 32,920,200);
		
		card = new Card();
		card.setOpaque(false);
		this.add(card);
		card.setLayout(null);
		
		card2= new Card2();
		card2.setOpaque(false);
		this.add(card2);
		card2.setLayout(null);
		
		card3= new Card3();
		card3.setOpaque(false);
		this.add(card3);
		card3.setLayout(null);
		
		
	}

}
