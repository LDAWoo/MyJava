package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

import model.ModelScrollBarUI;

public class ScrollBarCustom extends JScrollBar{
	
	public ScrollBarCustom() {
		setBackground(getBackground());
		setUI(new ModelScrollBarUI());
		setPreferredSize(new Dimension(0,0));
		setForeground(getForeground());
		setUnitIncrement(20);
		setOpaque(true);
	}
	
}
