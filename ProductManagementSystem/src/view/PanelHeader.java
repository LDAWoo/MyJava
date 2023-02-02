package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import animation.TextField;
import color.ColorBackground;
import componentHeader.ButtonShowAllNotification;
import componentProduct.PanelCustomers;
import icon.ImageAvatar;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PanelHeader extends JPanel {
	private Color colorHeader = new Color(26,29,31);
	private TextField txtSearch;
	private Color color1 = new Color(191,191,191);
	private Color color2 = ColorBackground.colorGRB394348;
	private Color color3 = new Color(252,252,252);
	private PanelCustomers panelFind;
	private JLabel lblIcon;
	private JLabel lblMessage;
	private JLabel lblNotification;
	private ImageAvatar avatar;
	private ButtonShowAllNotification btnAddProduct;
	
	Icon iconMessageB = new ImageIcon(PanelHeader.class.getResource("/icon/message-black.png"));
	Icon iconMessageW = new ImageIcon(PanelHeader.class.getResource("/icon/notification-white.png"));
	
	Icon iconNotificationB = new ImageIcon(PanelHeader.class.getResource("/icon/notification-black.png"));
	Icon iconNotificationW = new ImageIcon(PanelHeader.class.getResource("/icon/notification-white.png"));
	
	public PanelHeader() {
		setOpaque(false);
		panelFind = new PanelCustomers();
		panelFind.setColorCustomers(color2);
		panelFind.setOpaque(false);
		avatar = new ImageAvatar();
		avatar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		avatar.setBorderSize(3);
		avatar.setBorderSpace(2);

		avatar.setGradientColor1(new java.awt.Color(63, 109, 217));
		avatar.setGradientColor2(new java.awt.Color(199, 42, 42));
		
		lblMessage = new JLabel("");
		lblMessage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setIcon(new ImageIcon(PanelHeader.class.getResource("/icon/notification-white.png")));
		
		lblNotification = new JLabel("");
		lblNotification.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNotification.setIcon(new ImageIcon(PanelHeader.class.getResource("/icon/message-white.png")));
		lblNotification.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnAddProduct = new ButtonShowAllNotification("Thêm sản phẩm");
		btnAddProduct.setIcon(new ImageIcon(PanelHeader.class.getResource("/icon/plus-white.png")));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
					.addComponent(btnAddProduct, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNotification, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(avatar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(avatar, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(panelFind, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
								.addComponent(lblMessage, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
							.addGap(94))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnAddProduct, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNotification, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
							.addContainerGap())))
		);
		
		txtSearch = new TextField();
		txtSearch.setBorder(null);
		txtSearch.setCaretColor(color3);
		txtSearch.setHint("Tìm kiếm hoặc nhập lệnh");
		txtSearch.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtSearch.setBackground(color2);
		txtSearch.setForeground(color1);
		
		
		lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setIcon(new ImageIcon(PanelHeader.class.getResource("/icon/search.png")));
		GroupLayout gl_panelFind = new GroupLayout(panelFind);
		gl_panelFind.setHorizontalGroup(
			gl_panelFind.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelFind.createSequentialGroup()
					.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelFind.setVerticalGroup(
			gl_panelFind.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFind.createSequentialGroup()
					.addGroup(gl_panelFind.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelFind.setLayout(gl_panelFind);
		setLayout(groupLayout);
		actionTextField();
		actionButtonMode();
	}
	
	public void actionTextField(){
		
	}
	public void addActionNotification(MouseListener event) {
		lblMessage.addMouseListener(event);
	}
	
	public void addActionAvatar(MouseListener event) {
		avatar.addMouseListener(event);
	}
	
	public void addActionAddProduct(ActionListener event) {
		btnAddProduct.addActionListener(event);
	}
	
	public void actionButtonMode() {
		PanelMode.btnLight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorHeader = ColorBackground.colorLight;
				panelFind.setColorCustomers(ColorBackground.colorGRB244244244);
				lblMessage.setIcon(iconMessageB);
				lblNotification.setIcon(iconNotificationB);
				repaint();
			}
		});
		
		PanelMode.btnDark.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorHeader = ColorBackground.colorDark;
				panelFind.setColorCustomers(ColorBackground.colorGRB394348);
				lblMessage.setIcon(iconMessageW);
				lblNotification.setIcon(iconNotificationW);
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorHeader);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
