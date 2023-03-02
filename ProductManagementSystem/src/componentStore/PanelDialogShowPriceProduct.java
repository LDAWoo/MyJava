package componentStore;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelDialogShowPriceProduct extends JPanel {

	private JLabel lblPrice;
	private int price;
	
	public PanelDialogShowPriceProduct(int price) {
		setOpaque(false);
		this.price = price;
		lblPrice = new JLabel(price+" VND"); 
		lblPrice.setVerticalAlignment(SwingConstants.CENTER);
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblPrice.setForeground(new Color(240,242,245));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPrice, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblPrice, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	


	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(0, 0, 0));
		g2.fillRoundRect(1, 1, getWidth(), getHeight() - 10, 15, 15);
		g2.setColor(new Color(147, 147, 147));
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 11, 15, 15);

		g2.setColor(new Color(200,200,200));
		int[] x = { getWidth() / 2 - 10, getWidth() / 2, getWidth() / 2 + 10 };
		int[] y = { getHeight() - 10, getHeight() - 5, getHeight() - 10};
		g2.fillPolygon(x, y, 3);

		super.paintComponent(g);
	}
}
