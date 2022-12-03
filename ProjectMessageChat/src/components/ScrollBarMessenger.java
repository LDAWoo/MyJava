package components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

public class ScrollBarMessenger extends JScrollBar{

	public ScrollBarMessenger() {
		setBackground(getBackground());
		setUI(new ModelScrollBarMessengerUI());
		setPreferredSize(new Dimension(7,8));
		setForeground(new Color(171,171,171));
		setUnitIncrement(20);
		setOpaque(true);
	}
}
