package componentCreateProduct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import componentProduct.PanelCustomers;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PanelTitleProduct extends JPanel {

	private Color color = new Color(26, 29, 31);
	private Color color1 = new Color(0,0,0);
	private Color color2 = new Color(252,252,252);
	
	
	private JTextField txtNameProduct;
	private PanelTitle panelTitle;
	private JLabel lblMTSn;
	private JTextArea txtDescriber;
	private ButtonPont btnBold;
	private ButtonPont btnItalic;
	private ButtonPont btnIUnderline;
	
	
	public PanelTitleProduct() {
		setBorder(null);
		setOpaque(false);
		
		JLabel lblTitle = new JLabel("Tên & Mô tả");
		lblTitle.setForeground(new Color(252, 252, 252));
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 18));
		
		JLabel lblNameProduct = new JLabel("Tên sản phẩm");
		lblNameProduct.setForeground(new Color(252, 252, 252));
		lblNameProduct.setFont(new Font("Roboto", Font.BOLD, 14));
		
		panelTitle = new PanelTitle();
		
		lblMTSn = new JLabel("Mô tả sản phẩm");
		lblMTSn.setForeground(new Color(252, 252, 252));
		lblMTSn.setFont(new Font("Roboto", Font.BOLD, 14));
		
		PanelTitle panelDescriber = new PanelTitle();
		
		
		txtDescriber = new JTextArea();
		txtDescriber.setLineWrap(true);
		txtDescriber.setWrapStyleWord(true);
		txtDescriber.setMargin(new Insets(2, 20, 2, 2));
		
	
	
		txtDescriber.setFont(new Font("Roboto", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane(txtDescriber);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		txtDescriber.setBorder(null);
		txtDescriber.setCaretColor(color2);
		txtDescriber.setForeground(color2);
		
		txtDescriber.setBackground(color1);
			
		btnBold = new ButtonPont();
		btnBold.setIcon(new ImageIcon(PanelTitleProduct.class.getResource("/icon/bold-white.png")));
		
		btnItalic = new ButtonPont();
		btnItalic.setIcon(new ImageIcon(PanelTitleProduct.class.getResource("/icon/italic-white.png")));
		
		btnIUnderline = new ButtonPont();
		btnIUnderline.setIcon(new ImageIcon(PanelTitleProduct.class.getResource("/icon/underline-white.png")));
		GroupLayout gl_panelDescriber = new GroupLayout(panelDescriber);
		gl_panelDescriber.setHorizontalGroup(
			gl_panelDescriber.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDescriber.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBold, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnItalic, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnIUnderline, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(478, Short.MAX_VALUE))
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
		);
		gl_panelDescriber.setVerticalGroup(
			gl_panelDescriber.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDescriber.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panelDescriber.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBold, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnItalic, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIUnderline, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
		);
		panelDescriber.setLayout(gl_panelDescriber);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelDescriber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
						.addComponent(panelTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
						.addComponent(lblNameProduct, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
						.addComponent(lblTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
						.addComponent(lblMTSn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNameProduct, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblMTSn, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelDescriber, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(167, Short.MAX_VALUE))
		);
		
		txtNameProduct = new JTextField();
		txtNameProduct.setCaretColor(Color.WHITE);
		txtNameProduct.setForeground(Color.WHITE);
		txtNameProduct.setFont(new Font("Roboto", Font.BOLD, 14));
		txtNameProduct.setBorder(null);
		txtNameProduct.setOpaque(false);
		
		GroupLayout gl_panelTitle = new GroupLayout(panelTitle);
		gl_panelTitle.setHorizontalGroup(
			gl_panelTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTitle.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtNameProduct, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelTitle.setVerticalGroup(
			gl_panelTitle.createParallelGroup(Alignment.LEADING)
				.addComponent(txtNameProduct, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
		);
		panelTitle.setLayout(gl_panelTitle);
		setLayout(groupLayout);
		
		action();
	}
	
	public void action() {
		txtNameProduct.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if(txtNameProduct.isFocusable()) {
					panelTitle.setColorBackground(new Color(0,0,0));
					panelTitle.setColorClick(new Color(100,100,100));
				}	
			}
			
		});
		
		
		btnBold.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtDescriber.setFont(new Font("Roboto", Font.BOLD, 14));
			}
		});
		
		btnItalic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				txtDescriber.setFont(new Font("Roboto", Font.ITALIC, 14));
					
			}
			
		});
		
		btnIUnderline.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtDescriber.setText("<html><u>" + txtDescriber.getText() + "</u></html>");
				
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
