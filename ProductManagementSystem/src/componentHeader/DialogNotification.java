package componentHeader;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import componentButton.Button;
import componentButton.ButtonNotification;
import componentButton.ButtonProfile;
import componentScrollPane.ScrollBarMenu;
import componentsCurve.DatabaseConnection;
import model.ModelData;
import model.ModelMessage;

import java.awt.Font;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import view.PanelProfile;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogNotification extends JDialog {

	private Color color1 = new Color(78, 79, 81);
	private Color color2 = new Color(252, 252, 252);
	ArrayList<ModelMessage> lists = new ArrayList<>();
	
	ImageIcon image = new ImageIcon(new ImageIcon(DialogNotification.class.getResource("/icon/logo-shop.png"))
			.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));

	
	
	private PanelDialogNotification panel;
	private MigLayout layout;
	private ButtonNotificationOption header;
	private JPanel panelBody;

	public DialogNotification(JFrame parent) {
		super(parent, false);
		setUndecorated(true);
		init();
		setBackground(new Color(17, 19, 21, 0));
		setPreferredSize(new Dimension(470, 550)); // 465
		pack();
	}

	public void init() {

		panel = new PanelDialogNotification();
		panel.setOpaque(false);

		layout = new MigLayout("fill,wrap, inset 1", "[fill]", "[50!,fill][fill,100%][::60%,shrink 0]");
		panel.setLayout(layout);

		JPanel header = createPanelHeader();

		JPanel body = createPanelBody();

		JPanel bottom = createBottom();

		body.setOpaque(false);

		getContentPane().setLayout(new MigLayout("fill"));

		panel.add(header);
		panel.add(body);
		panel.add(bottom);

		getContentPane().add(panel, "push,grow");

	}

	public JPanel createPanelHeader() {
		JPanel panelHeader = new JPanel();
		panelHeader.setOpaque(false);

		JLabel lblNotification = new JLabel("Thông báo");
		lblNotification.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotification.setForeground(color2);
		lblNotification.setFont(new Font("Roboto", Font.BOLD, 22));
		header = new ButtonNotificationOption();

		GroupLayout gl_panelHeader = new GroupLayout(panelHeader);
		gl_panelHeader.setHorizontalGroup(gl_panelHeader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHeader.createSequentialGroup().addGap(42).addComponent(lblNotification)
						.addPreferredGap(ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
						.addComponent(header, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panelHeader.setVerticalGroup(gl_panelHeader.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelHeader
				.createSequentialGroup()
				.addGroup(gl_panelHeader.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelHeader.createSequentialGroup().addContainerGap().addComponent(lblNotification,
								GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addComponent(header, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
				.addContainerGap()));
		panelHeader.setLayout(gl_panelHeader);
		return panelHeader;
	}

	public JPanel createPanelBody() {
		panelBody = new JPanel();
		panelBody.setOpaque(false);
		panelBody.setLayout(new MigLayout("wrap,fillx"));
		panelBody.setBorder(null);

		initData();

		panelBody.repaint();
		panelBody.revalidate();
		return panelBody;
	}

	public JPanel createBottom() {
		JPanel panelBottom = new JPanel();
		panelBottom.setOpaque(false);

		ButtonShowAllNotification button = new ButtonShowAllNotification("Tất cả thông báo");

		GroupLayout gl_panelBottom = new GroupLayout(panelBottom);
		gl_panelBottom.setHorizontalGroup(gl_panelBottom.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBottom.createSequentialGroup().addGap(41)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(41, Short.MAX_VALUE)));
		gl_panelBottom.setVerticalGroup(gl_panelBottom.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBottom.createSequentialGroup().addGap(2)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelBottom.setLayout(gl_panelBottom);

		return panelBottom;
	}

	public void initData() {
		try {

			DatabaseConnection.getInstance().connectToDatabase();
			String sql = "SELECT TOP(4)* FROM MESSAGE ORDER BY TIME DESC";
			PreparedStatement p;

			p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);

			ResultSet r = p.executeQuery();

			while (r.next()) {
				ModelMessage data = new ModelMessage(r.getString("ICON"), r.getString("NAME"), r.getString("COMMENT"),
						r.getString("BIEUTUONG"), r.getString("EMAIL"), r.getString("TIME"));
				lists.add(data);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fillPanelBody();
	}

	public void fillPanelBody() {
		
		int i = 1;
		for (ModelMessage modelMessage : lists) {

			int comment = modelMessage.getComment().length() + 1;
			int bieuTuong = modelMessage.getBieuTuong().length() + 1;

			String bTuong = modelMessage.getBieuTuong();

			int sum = comment + bieuTuong;

			String bT = "";

			if (sum > 40) {
				bT = bTuong.substring(0, 40 - comment) + "...";

			} else {
				bT = modelMessage.getBieuTuong();
			}

			ButtonNotification button1 = new ButtonNotification(image, modelMessage.getName(),
					modelMessage.getComment(), bT, modelMessage.getEmail(), modelMessage.getTime(), i);
			button1.setBorder(null);
			button1.setFont(new Font("Roboto", Font.BOLD, 17));
			button1.setHorizontalAlignment(SwingConstants.LEFT); // 33
			panelBody.add(button1, "wrap");
			i++;
		}

	}

	public void deleteNotification() {
		try {
			DatabaseConnection.getInstance().connectToDatabase();
			String sql = "DELETE dbo.MESSAGE";
			PreparedStatement p;
			p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
			p.executeUpdate();
			panelBody.removeAll();
			panelBody.repaint();
			panelBody.revalidate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionButton(ActionListener event) {
		header.addActionButtonOption(event);
	}
}
