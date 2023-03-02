package componentProduct;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import color.ColorBackground;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCustomers.PanelCustomerlList;
import componentCustomers.PanelTableCustomer;
import componentsCurve.CurveLineChart;
import dao.DAOCustomers;
import icon.ImageAvatar;
import model.ModelCustomerList;
import view.MainForm;
import view.PanelBody;
import view.PanelMode;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class PanelViewAllCustomer extends JPanel {

	ImageIcon image = new ImageIcon(new ImageIcon(PanelTableCustomer.class.getResource("/icon/NgocAnh.jpg")).getImage()
			.getScaledInstance(70, 70, Image.SCALE_SMOOTH));

	private Icon iconMore = new ImageIcon(ButtonProductList.class.getResource("/icon/arrow-right.png"));
	private Icon iconMoreBlue = new ImageIcon(ButtonProductList.class.getResource("/icon/arrow-right-blue.png"));

	private ImageAvatar lblAvatar3;

	private ImageAvatar lblAvatar2;

	private ImageAvatar lblAvatar1;

	private IconEditProduct btnViewAll;

	private JTextArea lblCustomer3;

	private JTextArea lblCustomer2;

	private JTextArea lblCustomer1;

	private DAOCustomers dao = new DAOCustomers();
	private int countCustomers = -1;
	private ArrayList<ModelCustomerList> datas = new ArrayList<ModelCustomerList>();

	private JLabel lblCustomerCount;

	private JTextArea lblViewAll;

	private JLabel lblMessage;

	private JLabel lblHeart;

	private ButtonCheckedSizeAndColor btnSendMessage;
	private JPanel panelPerson2;
	private JPanel panelPerson1;
	private JPanel panelViewAll;

	private JPanel panelPerson3;

	public PanelViewAllCustomer() {
		setOpaque(false);

		btnSendMessage = new ButtonCheckedSizeAndColor(1);
		btnSendMessage.setForeground(ColorBackground.colorLight);

		btnSendMessage.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSendMessage.setText("Gửi tin nhắn");

		lblCustomerCount = new JLabel();
		lblCustomerCount.setText("Gửi 10 khách hàng");
		lblCustomerCount.setForeground(new Color(252, 252, 252));
		lblCustomerCount.setFont(new Font("SansSerif", Font.BOLD, 14));

		lblMessage = new JLabel();
		lblMessage.setText("bằng tin nhắn cá nhân");
		lblMessage.setForeground(ColorBackground.colorGRB147147147);
		lblMessage.setFont(new Font("SansSerif", Font.PLAIN, 14));

		lblHeart = new JLabel();
		lblHeart.setText("<3");
		lblHeart.setForeground(Color.RED);
		lblHeart.setFont(new Font("SansSerif", Font.BOLD, 18));

		panelPerson3 = new JPanel();
		panelPerson3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelPerson3.setOpaque(false);

		panelPerson2 = new JPanel();
		panelPerson2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelPerson2.setOpaque(false);

		lblAvatar2 = new ImageAvatar();
		lblAvatar2.setImage(image);

		lblCustomer2 = new JTextArea("Vũ Lee");
		lblCustomer2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCustomer2.setOpaque(false);
		lblCustomer2.setLineWrap(true);
		lblCustomer2.setFocusable(false);
		lblCustomer2.setWrapStyleWord(true);

		lblCustomer2.setForeground(new Color(252, 252, 252));
		lblCustomer2.setFont(new Font("SansSerif", Font.BOLD, 14));
		GroupLayout gl_panelPerson2 = new GroupLayout(panelPerson2);
		gl_panelPerson2.setHorizontalGroup(gl_panelPerson2.createParallelGroup(Alignment.LEADING)
				.addComponent(lblAvatar2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(lblCustomer2, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE));
		gl_panelPerson2.setVerticalGroup(gl_panelPerson2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPerson2.createSequentialGroup()
						.addComponent(lblAvatar2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblCustomer2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(201, Short.MAX_VALUE)));
		panelPerson2.setLayout(gl_panelPerson2);

		panelPerson1 = new JPanel();
		panelPerson1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelPerson1.setOpaque(false);

		lblAvatar1 = new ImageAvatar();
		lblAvatar1.setImage(image);

		lblCustomer1 = new JTextArea("Vũ Lee");
		lblCustomer1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCustomer1.setOpaque(false);
		lblCustomer1.setLineWrap(true);
		lblCustomer1.setFocusable(false);
		lblCustomer1.setWrapStyleWord(true);

		lblCustomer1.setForeground(new Color(252, 252, 252));
		lblCustomer1.setFont(new Font("SansSerif", Font.BOLD, 14));
		GroupLayout gl_panelPerson1 = new GroupLayout(panelPerson1);
		gl_panelPerson1.setHorizontalGroup(gl_panelPerson1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblAvatar1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
				.addComponent(lblCustomer1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE));
		gl_panelPerson1.setVerticalGroup(gl_panelPerson1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPerson1.createSequentialGroup()
						.addComponent(lblAvatar1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblCustomer1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(163, Short.MAX_VALUE)));
		panelPerson1.setLayout(gl_panelPerson1);

		panelViewAll = new JPanel();
		panelViewAll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelViewAll.setOpaque(false);

		btnViewAll = new IconEditProduct(iconMore);

		lblViewAll = new JTextArea("Xem tất cả");
		lblViewAll.setOpaque(false);
		lblViewAll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblViewAll.setLineWrap(true);
		lblViewAll.setFocusable(false);
		lblViewAll.setWrapStyleWord(true);
		lblViewAll.setForeground(new Color(252, 252, 252));
		lblViewAll.setFont(new Font("SansSerif", Font.BOLD, 14));
		GroupLayout gl_panelViewAll = new GroupLayout(panelViewAll);
		gl_panelViewAll.setHorizontalGroup(
			gl_panelViewAll.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelViewAll.createSequentialGroup()
					.addGroup(gl_panelViewAll.createParallelGroup(Alignment.LEADING)
						.addComponent(btnViewAll, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblViewAll, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelViewAll.setVerticalGroup(
			gl_panelViewAll.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelViewAll.createSequentialGroup()
					.addComponent(btnViewAll, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblViewAll, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(111, Short.MAX_VALUE))
		);
		panelViewAll.setLayout(gl_panelViewAll);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCustomerCount)
						.addComponent(panelPerson1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelPerson2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMessage))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelPerson3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHeart))
					.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSendMessage, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelViewAll, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSendMessage, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCustomerCount, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblHeart, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelPerson1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelPerson3, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelViewAll, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelPerson2, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);

		lblAvatar3 = new ImageAvatar();
		lblAvatar3.setImage(image);

		lblCustomer3 = new JTextArea("Vũ Lee");
		lblCustomer3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCustomer3.setOpaque(false);
		lblCustomer3.setLineWrap(true);
		lblCustomer3.setFocusable(false);
		lblCustomer3.setWrapStyleWord(true);

		lblCustomer3.setForeground(new Color(252, 252, 252));
		lblCustomer3.setFont(new Font("SansSerif", Font.BOLD, 14));
		GroupLayout gl_panelPerson3 = new GroupLayout(panelPerson3);
		gl_panelPerson3.setHorizontalGroup(gl_panelPerson3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPerson3.createSequentialGroup()
						.addGroup(gl_panelPerson3.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCustomer3, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(lblAvatar3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 80,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(0, Short.MAX_VALUE)));
		gl_panelPerson3.setVerticalGroup(gl_panelPerson3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPerson3.createSequentialGroup()
						.addComponent(lblAvatar3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblCustomer3, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelPerson3.setLayout(gl_panelPerson3);
		setLayout(groupLayout);

		if (MainForm.mode == "Dark") {
			lblCustomerCount.setForeground(ColorBackground.colorLight);
			lblCustomer1.setForeground(ColorBackground.colorLight);
			lblCustomer2.setForeground(ColorBackground.colorLight);
			lblCustomer3.setForeground(ColorBackground.colorLight);
			lblViewAll.setForeground(ColorBackground.colorLight);
			btnSendMessage.setColorBackground(ColorBackground.colorDark);
			btnSendMessage.setForeground(ColorBackground.colorLight);
			btnViewAll.setColor(ColorBackground.colorGRB394348);
		} else {
			lblCustomerCount.setForeground(ColorBackground.colorGRB147147147);
			lblCustomer1.setForeground(ColorBackground.colorGRB147147147);
			lblCustomer2.setForeground(ColorBackground.colorGRB147147147);
			lblCustomer3.setForeground(ColorBackground.colorGRB147147147);
			lblViewAll.setForeground(ColorBackground.colorGRB147147147);
			btnSendMessage.setColorBackground(ColorBackground.colorLight);
			btnSendMessage.setForeground(ColorBackground.colorGRB171921);
			btnViewAll.setColor(ColorBackground.colorGRB240242245);
		}

		init();
		action();

	}

	public void init() {
		datas = dao.SelectCustomer();
		countCustomers = datas.size();
		lblCustomerCount.setText("Gửi "+countCustomers + " khách hàng");
		initData();
	}

	public void initData() {
		lblAvatar1.setImage(
				new ImageIcon(new ImageIcon(PanelTableCustomer.class.getResource("/icon/" + datas.get(0).getImage()))
						.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));

		lblAvatar2.setImage(
				new ImageIcon(new ImageIcon(PanelTableCustomer.class.getResource("/icon/" + datas.get(1).getImage()))
						.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));

		lblAvatar3.setImage(
				new ImageIcon(new ImageIcon(PanelTableCustomer.class.getResource("/icon/" + datas.get(2).getImage()))
						.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));

		lblCustomer1.setText(datas.get(0).getName());
		lblCustomer2.setText(datas.get(1).getName());
		lblCustomer3.setText(datas.get(2).getName());

	}

	public void action() {
		btnViewAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnViewAll.setIcon(iconMoreBlue);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnViewAll.setIcon(iconMore);
			}
		});

		btnViewAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainForm.panelBody.showForm(new PanelCustomerlList());
			}
		});
		
		panelViewAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount() == 1) {
					MainForm.panelBody.showForm(new PanelCustomerlList());
				}
			}
		});
		
		lblViewAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount() == 1) {
					MainForm.panelBody.showForm(new PanelCustomerlList());
				}
			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCustomerCount.setForeground(ColorBackground.colorGRB147147147);
				lblCustomer1.setForeground(ColorBackground.colorGRB147147147);
				lblCustomer2.setForeground(ColorBackground.colorGRB147147147);
				lblCustomer3.setForeground(ColorBackground.colorGRB147147147);
				lblViewAll.setForeground(ColorBackground.colorGRB147147147);
				btnSendMessage.setColorBackground(ColorBackground.colorLight);
				btnSendMessage.setForeground(ColorBackground.colorGRB171921);
				btnViewAll.setColor(ColorBackground.colorGRB240242245);
			}
		});

		PanelMode.actionButonModeDark(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCustomerCount.setForeground(ColorBackground.colorLight);
				lblCustomer1.setForeground(ColorBackground.colorLight);
				lblCustomer2.setForeground(ColorBackground.colorLight);
				lblCustomer3.setForeground(ColorBackground.colorLight);
				lblViewAll.setForeground(ColorBackground.colorLight);
				btnSendMessage.setColorBackground(ColorBackground.colorDark);
				btnSendMessage.setForeground(ColorBackground.colorLight);
				btnViewAll.setColor(ColorBackground.colorGRB394348);
			}
		});

		mouseListenerPanel(panelPerson1, lblCustomer1);
		mouseListenerPanel(panelPerson2, lblCustomer2);
		mouseListenerPanel(panelPerson3, lblCustomer3);
		mouseListenerPanel(panelViewAll, lblViewAll);
		
		mouseListenerTextArea(lblCustomer1);
		mouseListenerTextArea(lblCustomer2);
		mouseListenerTextArea(lblCustomer3);
		mouseListenerTextArea(lblViewAll);
	}

	public void mouseListenerPanel(JPanel panel, JTextArea text) {
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				text.setForeground(new Color(82, 147, 252));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					text.setForeground(ColorBackground.colorLight);
				} else {
					text.setForeground(ColorBackground.colorGRB147147147);
				}
			}
		});
	}

	public void mouseListenerTextArea(JTextArea text) {
		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				text.setForeground(new Color(82, 147, 252));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					text.setForeground(ColorBackground.colorLight);
				} else {
					text.setForeground(ColorBackground.colorGRB147147147);
				}
			}
		});
	}
}
