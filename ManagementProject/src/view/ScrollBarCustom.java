package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

import model.ModelScrollBarUI;

public class ScrollBarCustom extends JScrollBar{
	
	public ScrollBarCustom() {
		setBackground(new Color(50,50,50));
		setUI(new ModelScrollBarUI());
		setPreferredSize(new Dimension(0,0));
		setForeground(new Color(191,191,191));
		setUnitIncrement(20);
		setOpaque(true);
	}
	
}
