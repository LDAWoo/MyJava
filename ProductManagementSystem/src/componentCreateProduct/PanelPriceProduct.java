package componentCreateProduct;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import event.EventHandler;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class PanelPriceProduct extends JPanel {
	private Color color = new Color(26, 29, 31);
	private JTextField txtPrice;
	private PanelTitle panePrice;
	private JTextField txtAmount;
	private PanelTitle panelAmount;
	private JLabel lblLoiSnPhm;
	public PanelComboboxManufacturer comboBox;
	private DefaultComboBoxModel cbbModel;
	
	EventHandler<ArrayList<Integer>> eventHandler = new EventHandler<ArrayList<Integer>>();
	
	public int indexSelectedComboBox = 0;
	
	public PanelPriceProduct() {
		setOpaque(false);
		
		JLabel lblGiSnPhm = new JLabel("Giá & Số Lượng Sản Phẩm");
		lblGiSnPhm.setForeground(new Color(252, 252, 252));
		lblGiSnPhm.setFont(new Font("Roboto", Font.BOLD, 18));
		
		JLabel lblPrice = new JLabel("Đơn Giá");
		lblPrice.setForeground(new Color(252, 252, 252));
		lblPrice.setFont(new Font("Roboto", Font.BOLD, 14));
		
		panePrice = new PanelTitle();
		panePrice.setBackground(color);
		
		txtPrice = new JTextField();
		txtPrice.setOpaque(false);
		txtPrice.setForeground(Color.WHITE);
		txtPrice.setFont(new Font("Roboto", Font.BOLD, 14));
		txtPrice.setCaretColor(Color.WHITE);
		txtPrice.setBorder(null);
		GroupLayout gl_panePrice = new GroupLayout(panePrice);
		gl_panePrice.setHorizontalGroup(
			gl_panePrice.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panePrice.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtPrice, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panePrice.setVerticalGroup(
			gl_panePrice.createParallelGroup(Alignment.LEADING)
				.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
		);
		panePrice.setLayout(gl_panePrice);
		
		JLabel lblAmount = new JLabel("Số Lượng");
		lblAmount.setForeground(new Color(252, 252, 252));
		lblAmount.setFont(new Font("Roboto", Font.BOLD, 14));
		
		panelAmount = new PanelTitle();
		panelAmount.setBackground(color);
		
		txtAmount = new JTextField();
		txtAmount.setOpaque(false);
		txtAmount.setForeground(Color.WHITE);
		txtAmount.setFont(new Font("Roboto", Font.BOLD, 14));
		txtAmount.setCaretColor(Color.WHITE);
		txtAmount.setBorder(null);
		GroupLayout gl_panelAmount = new GroupLayout(panelAmount);
		gl_panelAmount.setHorizontalGroup(
			gl_panelAmount.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 846, Short.MAX_VALUE)
				.addGroup(gl_panelAmount.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtAmount, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelAmount.setVerticalGroup(
			gl_panelAmount.createParallelGroup(Alignment.LEADING)
				.addGap(0, 49, Short.MAX_VALUE)
				.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
		);
		panelAmount.setLayout(gl_panelAmount);
		
		lblLoiSnPhm = new JLabel("Loại Sản Phẩm");
		lblLoiSnPhm.setForeground(new Color(252, 252, 252));
		lblLoiSnPhm.setFont(new Font("Roboto", Font.BOLD, 14));
		
		comboBox = new PanelComboboxManufacturer();
		
		cbbModel = new DefaultComboBoxModel();
		cbbModel.addElement("");
		cbbModel.addElement("Quần Áo");
		cbbModel.addElement("Giày Dép");
		comboBox.setModel(cbbModel);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPrice, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
								.addComponent(lblGiSnPhm, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
								.addComponent(panelAmount, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
								.addComponent(lblAmount, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
								.addComponent(panePrice, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLoiSnPhm, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
								.addComponent(comboBox, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,846, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblGiSnPhm, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panePrice, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblAmount, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelAmount, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblLoiSnPhm, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		action();
	}
	
	public void action() {
		txtPrice.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if(txtPrice.isFocusable()) {
					panePrice.setColorBackground(new Color(0,0,0));
					panePrice.setColorClick(new Color(100,100,100));
				}	
			}
			
		});
		
		txtAmount.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if(txtPrice.isFocusable()) {
					panelAmount.setColorBackground(new Color(0,0,0));
					panelAmount.setColorClick(new Color(100,100,100));
				}	
			}
			
		});
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				indexSelectedComboBox = comboBox.getSelectedIndex();
				if(indexSelectedComboBox == 0) {
					PanelManufacturerProduct.setEnableButton(false);
				}else if(indexSelectedComboBox == 1){
					PanelManufacturerProduct.showButtonSizeChar(false,true);
					
				}else if(indexSelectedComboBox == 2) {
					PanelManufacturerProduct.showButtonSizeNumber(false,true);
				}
				
				else {
					PanelManufacturerProduct.setEnableButton(true);
				}
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		
		super.paintComponent(g);
	}
}
