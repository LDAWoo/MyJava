package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ButtonHelp extends JButton {

	
	
	public ButtonHelp(String text) {
		setContentAreaFilled(false);
		setForeground(new Color(189,189,189));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBorder(new EmptyBorder(8, 20, 8, 5));
		setFocusPainted(false);
		setText(text);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setOpaque(true);
				setBackground(new Color(100, 100, 100));
				setForeground(new Color(255,255,255));
				setText("<html> <u> "+text+"</html>");
				setFont(new Font("SansSerif",Font.PLAIN , 15));		
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setOpaque(true);
				setBackground(new Color(70, 70, 70));
				setForeground(new Color(189,189,189));
				setText(text);
				setFont(new Font("SansSerif",Font.PLAIN , 14));
				setForeground(new Color(191,191,191));
			}
		});
		
		
	}

}
