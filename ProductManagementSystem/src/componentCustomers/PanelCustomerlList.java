package componentCustomers;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class PanelCustomerlList extends JPanel {
	private Color color1 = new Color(252, 252, 252);
	

	public PanelCustomerlList() {
		setOpaque(false);
		
		JLabel lblTitle = new JLabel("Danh Sách Khách Hàng");
		lblTitle.setForeground(color1);
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 30));
		
		PanelCustomerGraphics panelBody = new PanelCustomerGraphics();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelBody, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1026, Short.MAX_VALUE)
						.addComponent(lblTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBody, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		PanelTableCustomer panelTable = new PanelTableCustomer();
		GroupLayout gl_panelBody = new GroupLayout(panelBody);
		gl_panelBody.setHorizontalGroup(
			gl_panelBody.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelBody.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTable, GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelBody.setVerticalGroup(
			gl_panelBody.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelBody.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTable, GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelBody.setLayout(gl_panelBody);
		setLayout(groupLayout);
		
	}
}
