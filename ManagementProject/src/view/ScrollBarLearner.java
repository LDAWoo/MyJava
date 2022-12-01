package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

import model.ModelScrollBarUI;
import model.ModelScrollBarUILearner;

public class ScrollBarLearner extends JScrollBar{
	
	public ScrollBarLearner() {
		setBackground(Color.WHITE);
		setUI(new ModelScrollBarUILearner());
		setPreferredSize(new Dimension(5,8));
		setForeground(new Color(144,144,144));
		setUnitIncrement(20);
		setOpaque(true);
	}
	
}
