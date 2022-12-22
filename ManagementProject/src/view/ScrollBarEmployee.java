package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

import model.ModelScrollBarUI;
import model.ModelScrollBarUIEmployee;
import model.ModelScrollBarUILearner;

public class ScrollBarEmployee extends JScrollBar{
	
	public ScrollBarEmployee() {
		setBackground(new Color(60,60,60));
		setUI(new ModelScrollBarUIEmployee());
		setPreferredSize(new Dimension(0,8));
		setForeground(new Color(144,144,144));
		setUnitIncrement(20);
		setOpaque(true);
	}
	
}
