package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

import model.ModelCard;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.SystemColor;
import java.text.DecimalFormat;
import java.awt.Component;

public class Card extends JPanel {

	private Color color1;
	private JLabel lblValues;
	private JLabel lblTitle;
	private JLabel lblPercent;
	private ScrollBarCustom barCustom;
	private JLabel lblIcon;

	public Card() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setOpaque(false);
		setBackground(new Color(112, 69, 246));
		
		
		barCustom = new ScrollBarCustom();

		lblTitle = new JLabel("Title");
		lblTitle.setForeground(SystemColor.window);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		lblValues = new JLabel("Values");
		lblValues.setForeground(SystemColor.window);
		lblValues.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		lblPercent = new JLabel("0%");
		lblPercent.setAlignmentY(Component.TOP_ALIGNMENT);
		lblPercent.setForeground(Color.WHITE);
		lblPercent.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		lblIcon = new JLabel("");
		lblIcon.setForeground(Color.WHITE);
		lblIcon.setFont(new Font("SansSerif", Font.BOLD, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(barCustom, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitle)
								.addComponent(lblValues))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addComponent(lblPercent)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTitle)
							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
							.addComponent(lblValues))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(barCustom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(lblPercent, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		barCustom.setBackground(new Color(255,255,255,100));
		barCustom.setForeground(Color.WHITE);
		color1 = new Color(191,60,234);
	}

	
	public void setData(ModelCard data) {
		DecimalFormat df = new DecimalFormat("#,##0.##");
		lblTitle.setText(data.getTitle());
		lblValues.setText(data.getValues()+"");
		lblIcon.setIcon(data.getIcon());
		barCustom.setValue(data.getPercentage());
		lblPercent.setText(df.format(data.getPercentage())+"%");
	}
	
	
	
	
	public JLabel getLblValues() {
		return lblValues;
	}





	public void setLblValues(JLabel lblValues) {
		this.lblValues = lblValues;
	}





	public JLabel getLblTitle() {
		return lblTitle;
	}





	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}





	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, getHeight(), new Color(60,60,60), getWidth(), 0, new Color(200,200,200));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
