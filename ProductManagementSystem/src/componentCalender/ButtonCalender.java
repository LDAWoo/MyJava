package componentCalender;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ButtonCalender extends JButton {
	private Date date;
	private boolean title;
	private boolean isToday;
	
	public ButtonCalender() {
		setOpaque(false);
		setBorder(null);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("SansSerif", Font.PLAIN, 14));
		setFocusPainted(false);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isTitle() {
		setForeground(new Color(255,255,255));
		return true;
	}

	public void setTitle(boolean title) {
		this.title = title;
	}

	public void isToday() {
		 isToday = true;
		 setForeground(Color.WHITE);
	}

	public void setToday(boolean isToday) {
		this.isToday = isToday;
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
