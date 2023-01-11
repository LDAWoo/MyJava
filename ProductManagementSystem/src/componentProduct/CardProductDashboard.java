package componentProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class CardProductDashboard extends JPanel {
	private Color color = new Color(41,49,51);
	private Color color1 = new Color(239,239,239);
	
	
	
	private JLabel lblIcon;
	private JLabel lblEarning;
	private JLabel lblValue;

	private Icon icon;
	private String text;
	private String value;
	
	public CardProductDashboard(Icon icon, String text, String value) {
		this.icon = icon;
		this.text = text;
		this.value = value;
		setOpaque(false);
		lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.LEFT);
		lblIcon.setIcon(icon);
		
		lblEarning = new JLabel(text);
		lblEarning.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblEarning.setForeground(color1);
		
		lblValue = new JLabel(value);
		lblValue.setFont(new Font("Roboto", Font.BOLD, 45));
		lblValue.setForeground(color1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setIcon(new ImageIcon(CardProductDashboard.class.getResource("/icon/curve-black.png")));
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblValue)
							.addGap(93)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEarning)
						.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(197, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEarning)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValue))
					.addContainerGap(163, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		
		super.paintComponent(g);
	}
}
