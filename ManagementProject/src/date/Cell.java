package date;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Cell extends JButton {

	private Date date;
	private boolean title;
	private boolean isToday;

	public Cell() {
		setContentAreaFilled(false);
		setBorder(null);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("SansSerif", Font.PLAIN, 14));
		setFocusPainted(false);
	
	}
	
	

	public void asTitle() {
		setForeground(new Color(255,255,255));
		title = true;
	}

	public boolean isTitle() {
		return title;
	}

	public void setDateTime(Date date) {
		this.date = date;
	}

	public void setAsDay() {
		isToday = true;
		setForeground(Color.WHITE);
	}

	public void currenMonth(boolean act) {

		if (act) {
			setForeground(new Color(255,255,255));

		} else {
			setForeground(new Color(100,100,100));

		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (isToday) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(new Color(97, 49, 237));
			int x = getWidth() / 2 - 17;
			int y = getHeight() / 2 - 17;
			g2.fillRoundRect(x, y, 35, 35, 100, 100);

		}
		super.paintComponent(g);
	}

}
