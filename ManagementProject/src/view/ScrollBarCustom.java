package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

import model.ModelScrollBarUI;

public class ScrollBarCustom extends JScrollBar{
	
	public ScrollBarCustom() {
		setBackground(new Color(93,58,196));
		setUI(new ModelScrollBarUI());
		setPreferredSize(new Dimension(5,8));
		setForeground(new Color(137,200,244));
		setUnitIncrement(20);
		setOpaque(true);
	}
	
}
