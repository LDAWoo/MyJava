package componentProduct;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelProductDashboard extends JPanel {

	private Color color1 = new Color(252, 252, 252);
	
	public PanelProductDashboard() {
		setOpaque(false);
		
		JLabel lblTitle = new JLabel("Bảng Điều Khiển Sản Phẩm");
		lblTitle.setForeground(color1);
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 30));
		
		PanelOverviewProductDashboard panel = new PanelOverviewProductDashboard();
		
		PanelProductList panelListProduct = new PanelProductList();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelListProduct, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 900, Short.MAX_VALUE)
						.addComponent(lblTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelListProduct, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
