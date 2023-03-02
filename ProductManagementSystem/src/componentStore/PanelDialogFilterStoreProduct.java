package componentStore;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import color.ColorBackground;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCreateProduct.PanelManufacturerProduct;
import componentHeader.ButtonShowAllNotification;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

import componentProduct.ButtonProductList;
import componentProduct.IconEditProduct;
import componentProduct.PanelCustomers;
import view.MainForm;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import animation.TextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDialogFilterStoreProduct extends JPanel {
	private Color colorBackground = ColorBackground.colorGRB000;

	private Icon iconDeleteBlue = new ImageIcon(ButtonProductList.class.getResource("/icon/close.png"));

	private IconEditProduct btnClose;

	private ButtonCheckedSizeAndColor btnAllProduct;

	private ButtonCheckedSizeAndColor btnNewProduct;

	private ButtonCheckedSizeAndColor btnLastProduct;

	private static Color color = new Color(26, 29, 31);

	private Color colorBackgroundButton = new Color(42, 133, 255);

	private int index = 1;

	RangeSlider rangeSlider = new RangeSlider();
	private JLabel rangeSliderLabel1 = new JLabel();
	private JLabel rangeSliderValue1 = new JLabel();
	private JLabel rangeSliderLabel2 = new JLabel();
	private JLabel rangeSliderValue2 = new JLabel();

	
	int firstValue = 0;
	int secondValue = 0;
	
	boolean dialogShown = false;
	
	int x = MainForm.xScreenFilterProduct;
	int y = MainForm.yScreenFilterProduct;

	public PanelDialogFilterStoreProduct() {
		setOpaque(false);

		JLabel lblBLcTm = new JLabel("Bộ lọc tìm kiếm");
		lblBLcTm.setForeground(new Color(252, 252, 252));
		lblBLcTm.setFont(new Font("SansSerif", Font.BOLD, 16));

		PanelCustomers panelFind = new PanelCustomers();
		panelFind.setOpaque(false);
		panelFind.setColorCustomers(new Color(39, 43, 48));

		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(PanelDialogFilterStoreProduct.class.getResource("/icon/search.png")));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);

		TextField txtSearch = new TextField();
		txtSearch.setHint("Tìm kiếm sản phẩm");
		txtSearch.setForeground(new Color(191, 191, 191));
		txtSearch.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtSearch.setCaretColor(new Color(252, 252, 252));
		txtSearch.setBorder(null);
		txtSearch.setBackground(new Color(39, 43, 48));
		GroupLayout gl_panelFind = new GroupLayout(panelFind);
		gl_panelFind
				.setHorizontalGroup(
						gl_panelFind.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelFind.createSequentialGroup()
										.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtSearch,
												GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		gl_panelFind.setVerticalGroup(gl_panelFind.createParallelGroup(Alignment.LEADING)
				.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
				.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));
		panelFind.setLayout(gl_panelFind);

		rangeSliderLabel1.setText("Lower value:");
		rangeSliderLabel2.setText("Upper value:");
		rangeSliderValue1.setHorizontalAlignment(JLabel.LEFT);
		rangeSliderValue2.setHorizontalAlignment(JLabel.LEFT);

		rangeSlider.setPreferredSize(new Dimension(240, rangeSlider.getPreferredSize().height));
		rangeSlider.setMinimum(0);
		rangeSlider.setMaximum(100);

		int value = 50;
		rangeSlider.addChangeListener(new ChangeListener() {
			private DialogShowPriceProduct dialog;

			public void stateChanged(ChangeEvent e) {

				RangeSlider slider = (RangeSlider) e.getSource();
				rangeSliderValue1.setText(String.valueOf(slider.getValue()));
				rangeSliderValue2.setText(String.valueOf(slider.getUpperValue()));
				
				int priceLength = rangeSliderValue2.getText().length();
				
				
				firstValue = Integer.parseInt(rangeSliderValue1.getText());
				secondValue = Integer.parseInt(rangeSliderValue2.getText());
				
				
				
//				if (slider.getUpperValue() > value || slider.getUpperValue() < value) {
//
//					if (priceLength >= 1 && priceLength <= 8) {
//						width = 70 + priceLength * 10;
//						if (!dialogShown) {
//							dialog = new DialogShowPriceProduct(null, width, price);
//							dialog.setLocation(x, y);
//							dialog.setVisible(true);
//							dialogShown = true;
//						}
//
//						if (dialogShown) {
////							dialog.setVisible(false);
//						}
//					}
//
//				}
				
				

			}

		});

		rangeSlider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
		});

		// Initialize values.
		rangeSlider.setValue(0);
		rangeSlider.setUpperValue(10);

		// Initialize value display.
		rangeSliderValue1.setText(String.valueOf(rangeSlider.getValue()));
		rangeSliderValue2.setText(String.valueOf(rangeSlider.getUpperValue()));

		JLabel lblShow = new JLabel("Đang hiển thị");
		lblShow.setForeground(new Color(100, 100, 100));
		lblShow.setFont(new Font("SansSerif", Font.BOLD, 14));

		JLabel lblAllProduct = new JLabel("Tất cả sản phẩm");
		lblAllProduct.setForeground(new Color(252, 252, 252));
		lblAllProduct.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblNewProduct = new JLabel("Mới");
		lblNewProduct.setForeground(new Color(252, 252, 252));
		lblNewProduct.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblLastProduct = new JLabel("Cuối cùng");
		lblLastProduct.setForeground(new Color(252, 252, 252));
		lblLastProduct.setFont(new Font("SansSerif", Font.BOLD, 15));

		btnAllProduct = new ButtonCheckedSizeAndColor(1);

		btnNewProduct = new ButtonCheckedSizeAndColor(2);

		btnLastProduct = new ButtonCheckedSizeAndColor(3);

		JLabel lblGi = new JLabel("Giá");
		lblGi.setForeground(SystemColor.windowBorder);
		lblGi.setFont(new Font("SansSerif", Font.BOLD, 14));

		ButtonShowAllNotification btnApply = new ButtonShowAllNotification("Áp dụng");

		ButtonCheckedSizeAndColor btnReset = new ButtonCheckedSizeAndColor(4);
		btnReset.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnReset.setForeground(new Color(252, 252, 252));
		btnReset.setText("Đặt lại");

		btnClose = new IconEditProduct(iconDeleteBlue);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblBLcTm)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(btnAllProduct, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(panelFind, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 253,
										Short.MAX_VALUE)
								.addComponent(btnNewProduct, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLastProduct, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblShow).addComponent(lblAllProduct).addComponent(lblNewProduct)
								.addComponent(lblLastProduct).addComponent(lblGi)).addContainerGap(17, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 90,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnApply,
														GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
										.addComponent(rangeSlider, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
								.addGap(17)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBLcTm, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblShow, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAllProduct, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAllProduct, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewProduct, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblLastProduct,
												GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnNewProduct, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnLastProduct,
												GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGap(18).addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(rangeSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(55)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
								.addComponent(btnApply, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(139, Short.MAX_VALUE)));
		setLayout(groupLayout);
		action();
	}

	public void action() {
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelStoreHeader.dialog.setVisible(false);

			}

		});

		ButtonCheckedSizeAndColor[] btn1 = { btnNewProduct, btnLastProduct };
		addActionButtonChecked(btnAllProduct, btn1);

		ButtonCheckedSizeAndColor[] btn2 = { btnAllProduct, btnLastProduct };
		addActionButtonChecked(btnNewProduct, btn2);

		ButtonCheckedSizeAndColor[] btn3 = { btnAllProduct, btnNewProduct };
		addActionButtonChecked(btnLastProduct, btn3);

	}

	public void addActionButtonChecked(ButtonCheckedSizeAndColor button, ButtonCheckedSizeAndColor[] buttons) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				button.setIcon(new ImageIcon(PanelManufacturerProduct.class.getResource("/icon/check-white.png")));
				button.setColorBackground(colorBackgroundButton);

				buttons[0].setIcon(null);
				buttons[0].setColorBackground(color);

				buttons[1].setIcon(null);
				buttons[1].setColorBackground(color);

			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorBackground);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintComponent(g);
	}
}
