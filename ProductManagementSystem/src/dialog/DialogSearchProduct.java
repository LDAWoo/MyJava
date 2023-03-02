package dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import componentProduct.PanelCustomers;
import animation.TextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogSearchProduct extends JDialog {
	private PanelSearchProduct panel;
	private TextField txtSearch;
	
	public DialogSearchProduct(JFrame parent) {
		super(parent,false);
		init();
		setBackground(new Color(0, 0, 0, 0));
		setPreferredSize(new Dimension(1050, 240));
	}
	
	public void init() {
		setUndecorated(true);
		panel = new PanelSearchProduct();
		
		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1015, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(44)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		
		JLabel lblProductName = new JLabel("Sản phẩm");
		lblProductName.setForeground(new Color(252, 252, 252));
		lblProductName.setFont(new Font("Roboto", Font.BOLD, 18));
		
		PanelCustomers panelFind = new PanelCustomers();
		panelFind.setOpaque(false);
		panelFind.setColorCustomers(new Color(39, 43, 48));
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(DialogSearchProduct.class.getResource("/icon/search.png")));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtSearch = new TextField();
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblProductName)
					.addGap(10)
					.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(lblProductName))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(layout);
		pack();
		
	}

	public TextField getTxtSearch() {
		return txtSearch;
	}

	public void setTxtSearch(TextField txtSearch) {
		this.txtSearch = txtSearch;
	}
	
	
}
