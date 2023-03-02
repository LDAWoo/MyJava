package componentProduct;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import color.ColorBackground;
import componentCustomers.LablePurchase;
import componentHeader.DialogProfile;
import componentLogin.MainLogin;
import dao.DAOProducts;
import icon.ImageAvatar;
import model.ModelProductList;
import view.MainForm;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import net.miginfocom.swing.MigLayout;

public class ButtonProductList extends JPanel {

	private Color color = ColorBackground.colorDark;

	private Color color1 = ColorBackground.colorGRB239239239;

	private Color color2 = new Color(111, 118, 113);

	private Color color4 = new Color(51, 56, 63);

	private Icon iconEdit = new ImageIcon(ButtonProductList.class.getResource("/icon/pencil-ModeDark.png"));
	private Icon iconEditBlue = new ImageIcon(ButtonProductList.class.getResource("/icon/pencil-Blue.png"));
	
	private Icon iconDelete = new ImageIcon(ButtonProductList.class.getResource("/icon/delete-ModeDark.png"));
	private Icon iconDeleteBlue = new ImageIcon(ButtonProductList.class.getResource("/icon/delete-Blue.png"));
	
	ImageIcon imgProduct = new ImageIcon(new ImageIcon(ButtonProductList.class.getResource("/icon/vulee.jpg"))
			.getImage().getScaledInstance(89, 89, Image.SCALE_SMOOTH));
	private IconEditProduct btnEdit;
	private IconEditProduct btnDelete;
	private JPanel panelProfile;
	private JLabel lblProductName;

	public int indexProductCode;
	private String image;
	private String productName;
	private String manufacturer;
	private String status;
	private double price;
	private int amount;
	private int likes;
	public LablePurchase lblStatus;
	
	private DAOProducts dao = new DAOProducts();

	public ButtonProductList(int productcode, String image, String productName, String manufacturer, String status,
			double price, int amount, int likes) {
		setOpaque(false);

		this.indexProductCode = productcode;
		this.image = image;
		this.productName = productName;
		this.manufacturer = manufacturer;
		this.status = status;
		this.price = price;
		this.amount = amount;
		this.likes = likes;

		LablePurchase lblLike = new LablePurchase("");
		lblLike.setText("48500");
		lblLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblLike.setForeground(color4);
		lblLike.setFont(new Font("Roboto", Font.BOLD, 14));
		lblLike.setText(likes + "");

		lblStatus = new LablePurchase("");
		lblStatus.setText("Hoạt động");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(new Color(131, 181, 74));
		lblStatus.setFont(new Font("Roboto", Font.BOLD, 14));
		lblStatus.setColor(new Color(70, 112, 59));
		lblStatus.setText(status + "");

		LablePurchase lblAmount = new LablePurchase("");
		lblAmount.setText("2000");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setForeground(new Color(51, 56, 63));
		lblAmount.setFont(new Font("Roboto", Font.BOLD, 14));
		lblAmount.setText(amount + "");

		LablePurchase lblPrice = new LablePurchase("");
		lblPrice.setText("100000000 VND");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setForeground(new Color(51, 56, 63));
		lblPrice.setFont(new Font("Roboto", Font.BOLD, 14));
		lblPrice.setText(price + "");

		JPanel panel = new JPanel();
		panel.setOpaque(false);

		panelProfile = new JPanel();
		panelProfile.setOpaque(false);
		panelProfile.setCursor(new Cursor(Cursor.HAND_CURSOR));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panelProfile, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel, 0, 0, Short.MAX_VALUE)
								.addComponent(lblStatus, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
						.addGap(18).addComponent(lblPrice, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE).addGap(18)
						.addComponent(lblAmount, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblLike, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup()
												.addComponent(panelProfile, GroupLayout.DEFAULT_SIZE, 97,
														Short.MAX_VALUE)
												.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblPrice, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31,
														Short.MAX_VALUE)
												.addComponent(lblAmount, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														31, Short.MAX_VALUE)
												.addComponent(lblLike, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31,
														Short.MAX_VALUE)
												.addComponent(lblStatus, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														31, Short.MAX_VALUE))
										.addGap(18)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addGap(19)))));

		Avatar lblImg = new Avatar();
		lblImg.setForeground(new Color(51, 56, 63));
		lblImg.setFont(new Font("Roboto", Font.BOLD, 14));
		lblImg.setImage(imgProduct);

		JLabel lblManufacturer = new JLabel("Space Ver29");
		lblManufacturer.setForeground(color2);
		lblManufacturer.setFont(new Font("Roboto", Font.BOLD, 14));
		lblManufacturer.setText(manufacturer);

		lblProductName = new JLabel();
		lblProductName.setOpaque(false);
		lblProductName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblProductName.setForeground(color1);
		lblProductName.setFont(new Font("Roboto", Font.BOLD, 14));
		lblProductName.setText(productName);

		GroupLayout gl_panelProfile = new GroupLayout(panelProfile);
		gl_panelProfile.setHorizontalGroup(
			gl_panelProfile.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProfile.createSequentialGroup()
					.addComponent(lblImg, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelProfile.createParallelGroup(Alignment.LEADING)
						.addComponent(lblManufacturer, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
						.addComponent(lblProductName, GroupLayout.PREFERRED_SIZE, 280, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelProfile.setVerticalGroup(
			gl_panelProfile.createParallelGroup(Alignment.LEADING)
				.addComponent(lblImg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_panelProfile.createSequentialGroup()
					.addGap(18)
					.addComponent(lblProductName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblManufacturer)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panelProfile.setLayout(gl_panelProfile);

		btnEdit = new IconEditProduct(iconEdit);

		btnDelete = new IconEditProduct(iconDelete);

		btnEdit.setVisible(false);
		btnDelete.setVisible(false);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(181, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnEdit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40,
										Short.MAX_VALUE))
						.addContainerGap()));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		action();
	}

	public void action() {
		
		lblProductName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				color = color4;
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				lblProductName.setForeground(ColorBackground.colorGRB43122222);
				repaint();
			}
			
			
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				color = color4;
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);

				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				color = new Color(26, 29, 31);
				repaint();
				btnEdit.setVisible(false);
				btnDelete.setVisible(false);

			}
		});

		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				color = color4;
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				btnEdit.setIcon(iconEditBlue);
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnEdit.setIcon(iconEdit);
			}

		});

		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				color = color4;
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				btnDelete.setIcon(iconDeleteBlue);
				repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDelete.setIcon(iconDelete);
			}

		});

		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// showFormEditProduct
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				dao.delete(indexProductCode);
				PanelProductList.initData();
			}
		});

		panelProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				color = color4;
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				lblProductName.setForeground(ColorBackground.colorGRB43122222);
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				color = new Color(26, 29, 31);
				repaint();
				btnEdit.setVisible(false);
				btnDelete.setVisible(false);
				lblProductName.setForeground(color1);
			}

		});


		
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintComponent(g);
	}

}
