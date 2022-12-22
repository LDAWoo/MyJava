package calendar;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Cell extends JButton {

	private Date date;
	
	private boolean title;

	public Cell() {
		setContentAreaFilled(false);
		setBorder(null);	
		setFont(new Font("SansSerif",Font.PLAIN,14));
		setHorizontalAlignment(JLabel.CENTER);
		
	}
	
	

	public void asTitle() {
		setForeground(new Color(50,50,50));
		title = true;
	}
	
	public boolean isTitle() {
		return title;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void currenMonth(boolean act) {
		if(act) {
			setForeground(new Color(50,50,50));
		}else {
			setForeground(new Color(60,60,60));
		}
	}
}
