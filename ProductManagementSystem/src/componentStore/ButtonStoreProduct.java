package componentStore;

import javax.swing.JPanel;

import componentProduct.ButtonProductList;
import view.PanelMode;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import color.ColorBackground;
import componentCustomers.LablePurchase;

import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class ButtonStoreProduct extends JPanel {
	ImageIcon imgProduct = new ImageIcon(new ImageIcon(ButtonProductList.class.getResource("/icon/vulee.jpg"))
			.getImage().getScaledInstance(89, 89, Image.SCALE_SMOOTH));
	private AvatarStoreProduct avatarProduct;
	private JTextArea txtProductName;

	private Icon icon;
	private String productName;
	private String productPrice;

	public ButtonStoreProduct(Icon icon, String productName, String productPrice) {
		this.icon = icon;
		this.productName = productName;
		this.productPrice = productPrice;
		setOpaque(false);
		avatarProduct = new AvatarStoreProduct();
		avatarProduct.setImage(icon);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(avatarProduct, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 362,
										Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(avatarProduct, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE).addContainerGap()));

		LablePurchase lblProductPrice = new LablePurchase("   300   ");
		lblProductPrice.setText("   " + productPrice + "   ");
		lblProductPrice.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblProductPrice.setForeground(ColorBackground.colorGRB171921);
		lblProductPrice.setColor(ColorBackground.colorGRB181228202);

		txtProductName = new JTextArea();
		txtProductName.setOpaque(false);
		txtProductName.setLineWrap(true);
		txtProductName.setFont(new Font("SansSerif", Font.BOLD, 15));
		txtProductName.setText(productName);
		txtProductName.setForeground(ColorBackground.colorLight);
		txtProductName.setFocusable(false);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(txtProductName, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE).addGap(18)
						.addComponent(lblProductPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(11)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtProductName, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProductPrice, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(12, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		action();
	}

	public void action() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				avatarProduct.setAlpha(0.3f);
				avatarProduct.getBtnEdit().setVisible(true);
				avatarProduct.getBtnDelete().setVisible(true);
				avatarProduct.getBtnMoreProduct().setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				avatarProduct.setAlpha(1.0f);
				avatarProduct.getBtnEdit().setVisible(false);
				avatarProduct.getBtnDelete().setVisible(false);
				avatarProduct.getBtnMoreProduct().setVisible(false);

			}
		});

		txtProductName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				avatarProduct.setAlpha(0.3f);
				avatarProduct.getBtnEdit().setVisible(true);
				avatarProduct.getBtnDelete().setVisible(true);
				avatarProduct.getBtnMoreProduct().setVisible(true);
			}

		});

		PanelMode.actionButonModeLight(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtProductName.setForeground(ColorBackground.colorDark);
				
			}
		});

		PanelMode.actionButonModeDark(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtProductName.setForeground(ColorBackground.colorLight);
			}
		});

	}
}
