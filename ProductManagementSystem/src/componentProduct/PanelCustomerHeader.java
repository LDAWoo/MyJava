package componentProduct;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import animation.TextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class PanelCustomerHeader extends JPanel {

	public PanelCustomerHeader() {
		setOpaque(false);
		JLabel lblDanhSchSn = new JLabel("Sản phẩm");
		lblDanhSchSn.setForeground(new Color(252, 252, 252));
		lblDanhSchSn.setFont(new Font("Roboto", Font.BOLD, 18));
		
		PanelCustomers panelFind = new PanelCustomers();
		panelFind.setOpaque(false);
		panelFind.setColorCustomers(new Color(39, 43, 48));
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(PanelCustomerHeader.class.getResource("/icon/search.png")));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		TextField txtSearch = new TextField();
		txtSearch.setHint("Tìm kiếm sản phẩm");
		txtSearch.setForeground(new Color(191, 191, 191));
		txtSearch.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtSearch.setCaretColor(new Color(252, 252, 252));
		txtSearch.setBorder(null);
		txtSearch.setBackground(new Color(39, 43, 48));
		GroupLayout gl_panelFind = new GroupLayout(panelFind);
		gl_panelFind.setHorizontalGroup(
			gl_panelFind.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 416, Short.MAX_VALUE)
				.addGroup(gl_panelFind.createSequentialGroup()
					.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelFind.setVerticalGroup(
			gl_panelFind.createParallelGroup(Alignment.LEADING)
				.addGap(0, 45, Short.MAX_VALUE)
				.addGroup(gl_panelFind.createSequentialGroup()
					.addGroup(gl_panelFind.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelFind.setLayout(gl_panelFind);
		
		JLabel lblSnPhm = new JLabel("Sản phẩm");
		lblSnPhm.setForeground(new Color(150, 150, 150));
		lblSnPhm.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setForeground(new Color(150, 150, 150));
		lblTrngThi.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setForeground(new Color(150, 150, 150));
		lblGi.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblLtThch = new JLabel("Lượt thích");
		lblLtThch.setForeground(new Color(150, 150, 150));
		lblLtThch.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setForeground(new Color(150, 150, 150));
		lblSLng.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("_________________________________________________________________________________________________________________________________________________________________");
		lblNewLabel_1.setForeground(new Color(150, 150, 150));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblSnPhm, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblTrngThi, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblSLng, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblLtThch, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDanhSchSn)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 778, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblDanhSchSn, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSnPhm, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTrngThi, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLtThch, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSLng, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		
	}
}
