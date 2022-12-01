package view2;

import javax.swing.JPanel;

import dao.DataAccount;
import img.img;

import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Card2 extends JPanel {

	private JLabel lblIcon;
	private JLabel lblTitle;
	private JLabel lblValues;
	private JLabel lblDescription;
	private Color color1;
	private Color color2;
	private img img = new img(this);
	private DataAccount data = new DataAccount(this);
	
	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
	}

	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
	}

	public Card2() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setOpaque(false);
		setPreferredSize(new Dimension(300, 200));
		setBounds(0, 0, 300, 200);
		setLayout(null);
		this.setBorder(null);

		lblIcon = new JLabel("");
		lblIcon.setBounds(45, 50, 34, 34);
		lblIcon.setIcon(this.img.ImageTea());
		add(lblIcon);

		lblTitle = new JLabel("Teacher");
		lblTitle.setForeground(SystemColor.window);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTitle.setBounds(45, 95, 115, 21);
		add(lblTitle);

		lblValues = new JLabel("");
		lblValues.setForeground(Color.WHITE);
		lblValues.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblValues.setBounds(45, 127, 56, 21);
		add(lblValues);

		lblDescription = new JLabel("Description");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblDescription.setBounds(45, 166, 245, 21);
		add(lblDescription);
		
		
		color1 = new Color(142,142,250);
		color2 = new Color(123,123,245);
		
		data.AmountAccoutUser();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;

		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gp = new GradientPaint(0, 0, color1, 0, 300, color2);
		g2D.setPaint(gp);

		g2D.fillRoundRect(0, 0, 300, 200, 25, 25);

		g2D.setColor(new Color(255, 255, 255, 50));
		g2D.fillOval(300 - 200 / 2, 10, 200, 200);

		g2D.fillOval(300 - (200 / 2) - 20, 200 / 2 + 20, 200, 200);
	}

	public void setData(Model_Card data) {
		lblIcon.setIcon(data.getIcon());
		lblTitle.setText(data.getTitle());
		lblValues.setText(data.getValues());
		lblDescription.setText(data.getDescription());
	}

	public JLabel getLblValues() {
		return lblValues;
	}

	public void setLblValues(JLabel lblValues) {
		this.lblValues = lblValues;
	}
	
	

}
