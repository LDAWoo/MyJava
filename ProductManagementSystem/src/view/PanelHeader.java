package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import animation.TextField;
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
	private Color color2 = new Color(39,43,48);
	private Color color3 = new Color(252,252,252);
	private PanelCustomers panelFind;
	private JLabel lblIcon;
	private JLabel lblNotification;
	private JLabel lblNotification_1;
	private ImageAvatar avatar;
	private ButtonShowAllNotification btnNewButton;
	
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
		
		lblNotification = new JLabel("");
		lblNotification.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNotification.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotification.setIcon(new ImageIcon(PanelHeader.class.getResource("/icon/notification-white.png")));
		
		lblNotification_1 = new JLabel("");
		lblNotification_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNotification_1.setIcon(new ImageIcon(PanelHeader.class.getResource("/icon/message-white.png")));
		lblNotification_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnNewButton = new ButtonShowAllNotification("Thêm sản phẩm");
		btnNewButton.setIcon(new ImageIcon(PanelHeader.class.getResource("/icon/plus-white.png")));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNotification_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblNotification, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
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
								.addComponent(lblNotification, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
							.addGap(94))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNotification_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
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
	}
	
	public void actionTextField(){
		
	}
	public void addActionNotification(MouseListener event) {
		lblNotification.addMouseListener(event);
	}
	
	public void addActionAvatar(MouseListener event) {
		avatar.addMouseListener(event);
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
