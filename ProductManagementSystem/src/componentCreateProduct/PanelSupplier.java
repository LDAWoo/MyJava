package componentCreateProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelSupplier extends JPanel {
	private Color color1 = new Color(252, 252, 252);
	private Color color = new Color(26, 29, 31);
	private PanelComboboxManufacturer comboBox;
	
	public PanelSupplier() {
		setOpaque(false);
		
		JLabel lblSupplier = new JLabel("Nhà Cung Cấp");
		lblSupplier.setForeground(color1);
		lblSupplier.setFont(new Font("Roboto", Font.BOLD, 18));
		
		JLabel lblSupplierName = new JLabel("Tên nhà cung cấp");
		lblSupplierName.setForeground(color1);
		lblSupplierName.setFont(new Font("Roboto", Font.BOLD, 14));
		
		comboBox = new PanelComboboxManufacturer();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBox, Alignment.LEADING, 0, 817, Short.MAX_VALUE)
						.addComponent(lblSupplierName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
						.addComponent(lblSupplier, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblSupplier, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSupplierName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(156, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
		
	}
}
