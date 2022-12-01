package componentsClient;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ScrollBar extends JScrollBar{
	
	public ScrollBar() {
		setBackground(new Color(238,238,238));
		setUI(new ModelScrollBarUI());
		setPreferredSize(new Dimension(4,8));
		setForeground(new Color(0,0,0));
		setUnitIncrement(20);
		setOpaque(true);
	}
}
