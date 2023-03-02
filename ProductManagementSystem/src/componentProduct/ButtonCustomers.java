package componentProduct;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import color.ColorBackground;
import dao.DAOCustomers;
import model.ModelCustomerList;
import view.MainForm;
import view.PanelMode;

public class ButtonCustomers extends JButton {

	private Color colorCustomers = new Color(39, 43, 48);
	private Color color1 = new Color(191, 191, 191);
	private Color color2 = new Color(252, 252, 252);
	private JLabel lblIcon;
	private JLabel lblCustomers;
	private JLabel lblCountCustomers;
	private DAOCustomers dao = new DAOCustomers();
	private int countCustomers = -1;
	private ArrayList<ModelCustomerList> datas = new ArrayList<ModelCustomerList>();
	
	Icon iconShoppingWhite = new ImageIcon(ButtonCustomers.class.getResource("/icon/shopping-white.png"));
	Icon iconShoppingGray = new ImageIcon(ButtonCustomers.class.getResource("/icon/shopping-gray.png"));

	public ButtonCustomers() {
		setOpaque(false);
		setBorder(null);
		setFocusPainted(false);
		setFont(new Font("Roboto", Font.PLAIN, 15));
		setCursor(new Cursor(Cursor.HAND_CURSOR));

		lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCustomers = new JLabel("Khách hàng");
		lblCustomers.setFont(new Font("Roboto", Font.BOLD, 13));
		lblCustomers.setForeground(color1);

		lblCountCustomers = new JLabel("1000");
		lblCountCustomers.setForeground(color2);
		lblCountCustomers.setFont(new Font("Roboto", Font.BOLD, 35));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblCustomers)
								.addComponent(lblCountCustomers, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblIcon,
								GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(22).addComponent(lblCustomers)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblCountCustomers, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
				.addContainerGap()));
		setLayout(groupLayout);

		if(MainForm.mode == "Dark") {
			lblIcon.setIcon(iconShoppingWhite);
			lblCountCustomers.setForeground(ColorBackground.colorLight);
		}else {
			lblIcon.setIcon(iconShoppingGray);
			lblCountCustomers.setForeground(ColorBackground.colorDark);
		}
		init();
		action();
	}
	
	public void init() {
		datas = dao.SelectCustomer();
		countCustomers = datas.size();
		lblCountCustomers.setText(countCustomers+"");
	}

	public void action() {
		PanelMode.actionButonModeDark(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblIcon.setIcon(iconShoppingWhite);
				lblCountCustomers.setForeground(ColorBackground.colorLight);
			}
		});
		PanelMode.actionButonModeLight(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblIcon.setIcon(iconShoppingGray);
				lblCountCustomers.setForeground(ColorBackground.colorDark);
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorCustomers);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
		super.paintComponent(g);
	}

	public Color getColorCustomers() {
		return colorCustomers;
	}

	public void setColorCustomers(Color colorCustomers) {
		this.colorCustomers = colorCustomers;
		repaint();
	}
}
