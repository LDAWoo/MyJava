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

public class Button extends JButton {

	public Button() {
		setOpaque(false);
		setContentAreaFilled(false);
		setForeground(new Color(189,189,189));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setHorizontalAlignment(SwingConstants.LEFT);
		setBackground(new Color(60,60,60));
		setBorder(new EmptyBorder(8, 20, 8, 5));
		setFocusPainted(false);
		setFont(new Font("SansSerif",Font.PLAIN,13));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setOpaque(true);
				setBackground(new Color(100, 100, 100));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setOpaque(false);
				
			}
		});
	}

}
