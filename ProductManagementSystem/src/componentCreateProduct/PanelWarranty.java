package componentCreateProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import componentHeader.ButtonShowAllNotification;

public class PanelWarranty extends JPanel {
	private Color color1 = new Color(252, 252, 252);
	private Color color = new Color(26, 29, 31);
	private Color colorBackgroundButton = new Color(42, 133, 255);
	private Color color2 = new Color(0,0,0);
	private JTextArea txtDescriber;
	private ButtonShowAllNotification btnAddProduct;
	private PanelComboboxManufacturer comboBoxWarranty;
	private DefaultComboBoxModel comboBoxModel;
	
	private ButtonCheckedSizeAndColor btnYes;
	private ButtonCheckedSizeAndColor btnNo;
	
	private int index = 1;
	private int indexButtonYes =1;
	private int indexButtonNo =1;
	
	
	public PanelWarranty() {
		setOpaque(false);
		
		JLabel lblBoHnh = new JLabel("Bảo Hành & Thuế & Chi Tiết Sản Phẩm");
		lblBoHnh.setForeground(new Color(252, 252, 252));
		lblBoHnh.setFont(new Font("Roboto", Font.BOLD, 18));
		
		JLabel lblBoHnh_1 = new JLabel("Bảo hành");
		lblBoHnh_1.setForeground(color1);
		lblBoHnh_1.setFont(new Font("Roboto", Font.BOLD, 14));
		
		comboBoxWarranty = new PanelComboboxManufacturer();
		
		JLabel lblBoHnh_1_1 = new JLabel("Thuế (VAT 10%)");
		lblBoHnh_1_1.setForeground(color1);
		lblBoHnh_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		
		btnYes = new ButtonCheckedSizeAndColor(1);
		
		JLabel lblYes = new JLabel("Có");
		lblYes.setFont(new Font("Roboto", Font.BOLD, 14));
		lblYes.setForeground(color1);
		
		btnNo = new ButtonCheckedSizeAndColor(1);
		
		JLabel lblNo = new JLabel("Không");
		lblNo.setForeground(color1);
		lblNo.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblBoHnh_1_1_1 = new JLabel("Chi tiết");
		lblBoHnh_1_1_1.setForeground(color1);
		lblBoHnh_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		
		PanelTitle panelDescriber = new PanelTitle();
		
		ButtonPont btnBold = new ButtonPont();
		btnBold.setIcon(new ImageIcon(PanelWarranty.class.getResource("/icon/bold-white.png")));
		
		ButtonPont btnItalic = new ButtonPont();
		btnItalic.setIcon(new ImageIcon(PanelWarranty.class.getResource("/icon/italic-white.png")));
		
		ButtonPont btnIUnderline = new ButtonPont();
		btnIUnderline.setIcon(new ImageIcon(PanelWarranty.class.getResource("/icon/underline-white.png")));
		
		txtDescriber = new JTextArea();
		txtDescriber.setLineWrap(true);
		txtDescriber.setWrapStyleWord(true);
		txtDescriber.setMargin(new Insets(2, 20, 2, 2));
		txtDescriber.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JScrollPane scrollPane = new JScrollPane(txtDescriber);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		
		txtDescriber.setBorder(null);
		txtDescriber.setCaretColor(color1);
		txtDescriber.setForeground(color1);
		txtDescriber.setBackground(color2);
		
		GroupLayout gl_panelDescriber = new GroupLayout(panelDescriber);
		gl_panelDescriber.setHorizontalGroup(
			gl_panelDescriber.createParallelGroup(Alignment.LEADING)
				.addGap(0, 844, Short.MAX_VALUE)
				.addGroup(gl_panelDescriber.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBold, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnItalic, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnIUnderline, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(709, Short.MAX_VALUE))
				.addComponent(scrollPane, Alignment.TRAILING)
		);
		gl_panelDescriber.setVerticalGroup(
			gl_panelDescriber.createParallelGroup(Alignment.LEADING)
				.addGap(0, 182, Short.MAX_VALUE)
				.addGroup(gl_panelDescriber.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panelDescriber.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBold, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnItalic, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIUnderline, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
		);
		panelDescriber.setLayout(gl_panelDescriber);
		
		btnAddProduct = new ButtonShowAllNotification("Save");
		btnAddProduct.setIcon(new ImageIcon(PanelWarranty.class.getResource("/icon/plus-white.png")));
		btnAddProduct.setText("Lưu Sản Phẩm");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblBoHnh, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
								.addComponent(comboBoxWarranty, Alignment.LEADING, 0, 844, Short.MAX_VALUE)
								.addComponent(lblBoHnh_1, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
								.addComponent(lblBoHnh_1_1, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
								.addComponent(lblBoHnh_1_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(btnNo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNo))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(btnYes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblYes))
								.addComponent(panelDescriber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(675, Short.MAX_VALUE)
							.addComponent(btnAddProduct, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblBoHnh, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblBoHnh_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(comboBoxWarranty, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBoHnh_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblYes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnYes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addComponent(lblBoHnh_1_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelDescriber, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(btnAddProduct, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
		);
		setLayout(groupLayout);
		initComboBox();
		actionButton();
	}
	
	public void initComboBox() {
		comboBoxModel = new DefaultComboBoxModel();
		String[] month = new String[] {"Tháng","1","2","3","4","5","6","7","8","9","10","11","12"};
		for (String string : month) {
			comboBoxModel.addElement(string);
		}
		comboBoxWarranty.setModel(comboBoxModel);
		
	}

	public void actionButton() {
		actionButtonChecked(btnYes,btnNo,indexButtonYes);
		actionButtonChecked(btnNo,btnYes,indexButtonNo);
	}
	
	public void actionButtonChecked(ButtonCheckedSizeAndColor button1,ButtonCheckedSizeAndColor button2, int indexButon) {
		index = indexButon;
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				index ++;
				if(index % 2== 0) {
					button1.setIcon(new ImageIcon(PanelWarranty.class.getResource("/icon/check-white.png")));
					button1.setColorBackground(colorBackgroundButton);
					
					button2.setColorBackground(color);
					button2.setIcon(null);
					index =1;
				}
				
			}
		});
	}
	
	public void addActionButton(ActionListener event) {
		btnAddProduct.addActionListener(event);
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
