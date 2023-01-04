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

public class ButtonConfirm extends JButton {

	public ButtonConfirm() {

		setContentAreaFilled(false);
		setForeground(new Color(189,189,189));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBorder(new EmptyBorder(8, 20, 8, 5));
		setFocusPainted(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setOpaque(true);
				setBackground(new Color(100, 100, 100));
				setForeground(new Color(255,255,255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setOpaque(true);
				setBackground(new Color(70, 70, 70));
				setForeground(new Color(189,189,189));
			}
		});
	}

}
