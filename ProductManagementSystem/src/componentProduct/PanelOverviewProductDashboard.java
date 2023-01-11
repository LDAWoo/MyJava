package componentProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelOverviewProductDashboard extends JPanel {
	private Color color = new Color(26, 29, 31);
	private ImageIcon icon = new ImageIcon(PanelOverviewProductDashboard.class.getResource("/icon/shopping-white.png"));
	
	public PanelOverviewProductDashboard() {
		setOpaque(false);
		
		CardProductDashboard panel = new CardProductDashboard(icon,"Earning","100");
		panel.setOpaque(false);
		
		CardProductDashboard panel_1 = new CardProductDashboard(icon,"Customer","100");
		panel_1.setOpaque(false);
		
		CardProductDashboard panel_2 = new CardProductDashboard(icon,"Payouts","100");
		panel_2.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(169, Short.MAX_VALUE))
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
