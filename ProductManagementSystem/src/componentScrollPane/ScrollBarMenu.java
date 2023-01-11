package componentScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.UIManager;



public class ScrollBarMenu extends JScrollBar{
	
	public ScrollBarMenu() {
		
		setUI(new ModelScrollBarUIMenu());
		setPreferredSize(new Dimension(0,8));
		setForeground(new Color(144,144,144));
		setUnitIncrement(50);
		setOpaque(true);
	}
	
}
