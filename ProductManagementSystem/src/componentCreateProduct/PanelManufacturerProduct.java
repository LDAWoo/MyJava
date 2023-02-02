package componentCreateProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PanelManufacturerProduct extends JPanel {
	private static Color color = new Color(26, 29, 31);
	private Color colorBackground = new Color(39, 43, 48);
	private Color colorBackground1 = new Color(252, 252, 252);

	private int indexSelectedButtonSizeS = 1;
	private int indexSelectedButtonSizeM = 1;
	private int indexSelectedButtonSizeL = 1;
	private int indexSelectedButtonSizeXL = 1;
	private int indexSelectedButtonSize38 = 1;
	private int indexSelectedButtonSize39 = 1;
	private int indexSelectedButtonSize40 = 1;
	private int indexSelectedButtonSize41 = 1;

	private int indexSelectedButtonWhite = 1;
	private int indexSelectedButtonBlack = 1;

	private Color colorBackgroundButton = new Color(42, 133, 255);
	private ButtonCheckedSizeAndColor btnWhite;
	private ButtonCheckedSizeAndColor btnBlack;
	private int index;

	private ButtonGroup buttonGroup;

	public static ButtonCheckedSizeAndColor btnSizeS;
	public static ButtonCheckedSizeAndColor btnSizeL;
	public static ButtonCheckedSizeAndColor btnSizeM;
	public static ButtonCheckedSizeAndColor btnSize38;
	public static ButtonCheckedSizeAndColor btnSize39;
	public static ButtonCheckedSizeAndColor btnSize40;
	public static ButtonCheckedSizeAndColor btnSizeXL;
	public static ButtonCheckedSizeAndColor btnSize41;

	public PanelManufacturerProduct() {
		setOpaque(false);

		JLabel lblHngSnXut = new JLabel("Hãng Sản Xuất & Kích Cỡ & Màu Sản Phẩm");
		lblHngSnXut.setForeground(new Color(252, 252, 252));
		lblHngSnXut.setFont(new Font("Roboto", Font.BOLD, 18));

		JLabel lblTnHngSn = new JLabel("Tên hãng sản xuất");
		lblTnHngSn.setForeground(new Color(252, 252, 252));
		lblTnHngSn.setFont(new Font("Roboto", Font.BOLD, 14));

		PanelComboboxManufacturer comboBox = new PanelComboboxManufacturer();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Space Ver29");
		model.addElement("The Blue Exchange");
		model.addElement("Canifa");
		comboBox.setModel(model);

		JLabel lblKchCSn = new JLabel("Kích cỡ sản phẩm");
		lblKchCSn.setForeground(new Color(252, 252, 252));
		lblKchCSn.setFont(new Font("Roboto", Font.BOLD, 14));

		btnSizeS = new ButtonCheckedSizeAndColor(1);

		btnSizeM = new ButtonCheckedSizeAndColor(2);

		btnSizeL = new ButtonCheckedSizeAndColor(3);

		btnSizeXL = new ButtonCheckedSizeAndColor(4);

		btnSize38 = new ButtonCheckedSizeAndColor(5);

		btnSize39 = new ButtonCheckedSizeAndColor(6);

		btnSize40 = new ButtonCheckedSizeAndColor(7);

		btnSize41 = new ButtonCheckedSizeAndColor(8);

		JLabel lblSizeS = new JLabel("Size S");
		lblSizeS.setForeground(new Color(252, 252, 252));
		lblSizeS.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblSizeL = new JLabel("Size L");
		lblSizeL.setForeground(new Color(252, 252, 252));
		lblSizeL.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblSizeM = new JLabel("Size M");
		lblSizeM.setForeground(new Color(252, 252, 252));
		lblSizeM.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblSizeXl = new JLabel("Size XL");
		lblSizeXl.setForeground(new Color(252, 252, 252));
		lblSizeXl.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblSize38 = new JLabel("Size 38");
		lblSize38.setForeground(new Color(252, 252, 252));
		lblSize38.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblSize39 = new JLabel("Size 39");
		lblSize39.setForeground(new Color(252, 252, 252));
		lblSize39.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblSize40 = new JLabel("Size 40");
		lblSize40.setForeground(new Color(252, 252, 252));
		lblSize40.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblSize41 = new JLabel("Size 41");
		lblSize41.setForeground(new Color(252, 252, 252));
		lblSize41.setFont(new Font("Roboto", Font.BOLD, 14));
		buttonGroup = new ButtonGroup();
		btnWhite = new ButtonCheckedSizeAndColor(9);

		JLabel lblWhite = new JLabel("Màu trắng");
		lblWhite.setForeground(new Color(252, 252, 252));
		lblWhite.setFont(new Font("Roboto", Font.BOLD, 14));

		btnBlack = new ButtonCheckedSizeAndColor(10);

		buttonGroup.add(btnWhite);
		buttonGroup.add(btnBlack);

		JLabel lblBlack = new JLabel("Màu đen");
		lblBlack.setForeground(new Color(252, 252, 252));
		lblBlack.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblProductColor = new JLabel("Màu sản phẩm");
		lblProductColor.setForeground(new Color(252, 252, 252));
		lblProductColor.setFont(new Font("Roboto", Font.BOLD, 14));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProductColor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
						.addComponent(comboBox, 0, 796, Short.MAX_VALUE)
						.addComponent(lblTnHngSn, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
						.addComponent(lblHngSnXut, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
						.addComponent(lblKchCSn, GroupLayout.PREFERRED_SIZE, 796, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSizeS, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSizeM, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSizeL, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSizeS)
										.addComponent(lblSizeL)
										.addComponent(lblSizeM)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnSizeXL, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblSizeXl))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnWhite, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblWhite)))
							.addGap(99)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnBlack, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblBlack, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnSize41, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblSize41, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnSize40, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblSize40, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnSize39, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblSize39, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnSize38, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblSize38))))
							.addGap(37)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblHngSnXut, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTnHngSn, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblKchCSn, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSizeS, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSizeS, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSizeM, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSizeM, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSizeL, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSizeL, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSize38, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSize38, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSize39, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSize39, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSize40, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSize40, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSizeXL, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSize41, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSizeXl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSize41, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblProductColor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnWhite, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWhite, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBlack, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBlack, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		action();
	}

	public void action() {
		ButtonCheckedSizeAndColor[] btn1 = new ButtonCheckedSizeAndColor[] { btnSizeM, btnSizeL, btnSizeXL };
		actionButtonSize(btnSizeS, btn1, indexSelectedButtonSizeS);

		ButtonCheckedSizeAndColor[] btn2 = new ButtonCheckedSizeAndColor[] { btnSizeS, btnSizeL, btnSizeXL };
		actionButtonSize(btnSizeM, btn2, indexSelectedButtonSizeM);

		ButtonCheckedSizeAndColor[] btn3 = new ButtonCheckedSizeAndColor[] { btnSizeS, btnSizeM, btnSizeXL };
		actionButtonSize(btnSizeL, btn3, indexSelectedButtonSizeL);

		ButtonCheckedSizeAndColor[] btn4 = new ButtonCheckedSizeAndColor[] { btnSizeS, btnSizeM, btnSizeL };
		actionButtonSize(btnSizeXL, btn4, indexSelectedButtonSizeXL);

		ButtonCheckedSizeAndColor[] btn5 = new ButtonCheckedSizeAndColor[] { btnSize39, btnSize40, btnSize41 };
		actionButtonSize(btnSize38, btn5, indexSelectedButtonSize38);

		ButtonCheckedSizeAndColor[] btn6 = new ButtonCheckedSizeAndColor[] { btnSize38, btnSize40, btnSize41 };
		actionButtonSize(btnSize39, btn6, indexSelectedButtonSize39);

		ButtonCheckedSizeAndColor[] btn7 = new ButtonCheckedSizeAndColor[] { btnSize38, btnSize39, btnSize41 };
		actionButtonSize(btnSize40, btn7, indexSelectedButtonSize40);

		ButtonCheckedSizeAndColor[] btn8 = new ButtonCheckedSizeAndColor[] { btnSize38, btnSize39, btnSize40 };
		actionButtonSize(btnSize41, btn8, indexSelectedButtonSize41);

		actionButtonColor(btnWhite, btnBlack, indexSelectedButtonWhite);
		actionButtonColor(btnBlack, btnWhite, indexSelectedButtonBlack);

	}

	public static void setEnableButton(boolean option) {
		btnSizeS.setEnabled(option);
		btnSizeM.setEnabled(option);
		btnSizeL.setEnabled(option);
		btnSizeXL.setEnabled(option);

		btnSize38.setEnabled(option);
		btnSize39.setEnabled(option);
		btnSize40.setEnabled(option);
		btnSize41.setEnabled(option);

		if (option == false) {
			btnSizeS.setIcon(null);
			btnSizeM.setIcon(null);
			btnSizeL.setIcon(null);
			btnSizeXL.setIcon(null);

			btnSize38.setIcon(null);
			btnSize39.setIcon(null);
			btnSize40.setIcon(null);
			btnSize41.setIcon(null);

			btnSizeS.setColorBackground(color);
			btnSizeM.setColorBackground(color);
			btnSizeL.setColorBackground(color);
			btnSizeXL.setColorBackground(color);

			btnSize38.setColorBackground(color);
			btnSize39.setColorBackground(color);
			btnSize40.setColorBackground(color);
			btnSize41.setColorBackground(color);
		}

	}

	public static void showButtonSizeChar(boolean option1, boolean option2) {
		btnSize38.setEnabled(option1);
		btnSize39.setEnabled(option1);
		btnSize40.setEnabled(option1);
		btnSize41.setEnabled(option1);

		btnSize38.setIcon(null);
		btnSize39.setIcon(null);
		btnSize40.setIcon(null);
		btnSize41.setIcon(null);

		btnSize38.setColorBackground(color);
		btnSize39.setColorBackground(color);
		btnSize40.setColorBackground(color);
		btnSize41.setColorBackground(color);

		btnSizeS.setEnabled(option2);
		btnSizeM.setEnabled(option2);
		btnSizeL.setEnabled(option2);
		btnSizeXL.setEnabled(option2);

	}

	public static void showButtonSizeNumber(boolean option1, boolean option2) {
		btnSizeS.setEnabled(option1);
		btnSizeM.setEnabled(option1);
		btnSizeL.setEnabled(option1);
		btnSizeXL.setEnabled(option1);

		btnSizeS.setIcon(null);
		btnSizeM.setIcon(null);
		btnSizeL.setIcon(null);
		btnSizeXL.setIcon(null);

		btnSizeS.setColorBackground(color);
		btnSizeM.setColorBackground(color);
		btnSizeL.setColorBackground(color);
		btnSizeXL.setColorBackground(color);

		btnSize38.setEnabled(option2);
		btnSize39.setEnabled(option2);
		btnSize40.setEnabled(option2);
		btnSize41.setEnabled(option2);

	}

	public void actionButtonSize(ButtonCheckedSizeAndColor button, ButtonCheckedSizeAndColor[] buttons,
			int indexButton) {
		index = indexButton;
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				index++;
				if (index % 2 == 0) {
					button.setIcon(new ImageIcon(PanelManufacturerProduct.class.getResource("/icon/check-white.png")));
					button.setColorBackground(colorBackgroundButton);

					buttons[0].setIcon(null);
					buttons[0].setColorBackground(color);

					buttons[1].setIcon(null);
					buttons[1].setColorBackground(color);

					buttons[2].setIcon(null);
					buttons[2].setColorBackground(color);

					index = 1;
				}
//				else {
//					button.setIcon(null);
//					button.setColorBackground(color);
//
//				}

			}
		});

	}

	public void actionButtonColor(ButtonCheckedSizeAndColor button1, ButtonCheckedSizeAndColor button2,
			int indexButton) {
		index = indexButton;

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				index++;

				if (index % 2 == 0) {
					button1.setIcon(new ImageIcon(PanelManufacturerProduct.class.getResource("/icon/check-white.png")));
					button1.setColorBackground(colorBackgroundButton);

					button2.setIcon(null);
					button2.setColorBackground(color);
					index = 1;
				} else {
					button1.setIcon(null);
					button1.setColorBackground(color);

				}

			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

		super.paintComponent(g);
	}
}
