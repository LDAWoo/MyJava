package componentScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;



public class ScrollBarMenu extends JScrollBar{
	
	public ScrollBarMenu() {
		setBackground(Color.WHITE);
		setUI(new ModelScrollBarUIMenu());
		setPreferredSize(new Dimension(0,8));
		setForeground(new Color(144,144,144));
		setUnitIncrement(20);
		setOpaque(true);
	}
	
}
