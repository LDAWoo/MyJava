package componentCustomers;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import color.ColorBackground;
import componentHeader.DialogProfile;
import componentLogin.MainLogin;
import icon.ImageAvatar;
import view.MainForm;
import view.PanelMode;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import net.miginfocom.swing.MigLayout;

public class ButtonCustomerList extends JButton {

	private int indexSelected;
	private Color color1 = ColorBackground.colorLight;
	private Color color2 = new Color(111, 118, 113);

	
	private int option = -1;
	
	private Icon icon;
	private String username;
	private String email;
	private String phone;
	private String buys;
	private String total;
	private String comment;
	private String like;
	private JLabel lblUsername;
	private JLabel lblLikes;
	private JLabel lblComment;
	private JLabel lblBuys;

	public ButtonCustomerList(Icon icon, String username, String email, String phone, String buys, String total,
			String comment, String like) {
		this.icon = icon;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.buys = buys;
		this.total = total;
		this.comment = comment;
		this.like = like;

		setOpaque(false);
		setFocusPainted(false);
		setContentAreaFilled(false);

		setHorizontalAlignment(SwingConstants.LEFT);
		setCursor(new Cursor(Cursor.HAND_CURSOR));

		ImageAvatar avatar = new ImageAvatar();

		avatar.setImage(icon);

		lblUsername = new JLabel(username);
		lblUsername.setForeground(color1);
		lblUsername.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblEmail = new JLabel(email);
		lblEmail.setForeground(color2);
		lblEmail.setFont(new Font("Roboto", Font.PLAIN, 14));

		lblBuys = new JLabel(buys);
		lblBuys.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuys.setForeground(color1);
		lblBuys.setFont(new Font("Roboto", Font.BOLD, 14));

		LablePurchase lblTotal = new LablePurchase("$" + total);
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setForeground(ColorBackground.colorGRB585961);
		lblTotal.setFont(new Font("Roboto", Font.PLAIN, 14));

		lblComment = new JLabel(comment);
		lblComment.setHorizontalAlignment(SwingConstants.LEFT);
		lblComment.setForeground(color1);
		lblComment.setFont(new Font("Roboto", Font.BOLD, 14));

		lblLikes = new JLabel(like);
		lblLikes.setHorizontalAlignment(SwingConstants.LEFT);
		lblLikes.setForeground(color1);
		lblLikes.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblPhone = new JLabel(phone);
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setForeground(color2);
		lblPhone.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel lblUsername_1 = new JLabel("");
		lblUsername_1.setForeground(new Color(103, 118, 126));
		lblUsername_1.setFont(new Font("Roboto", Font.PLAIN, 14));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(avatar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblBuys, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblComment, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblLikes, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblUsername_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblUsername)
								.addComponent(lblBuys, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLikes, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblComment, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail)
								.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblUsername_1, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE).addGap(13))
				.addComponent(avatar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE));
		setLayout(groupLayout);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setOpaque(true);
				if(option < 0) {
					setBackground(ColorBackground.colorGRB585961);
				}else {
					setBackground(ColorBackground.colorGRB239239239);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setOpaque(false);
			}
		});

//		addActionListener(new ActionListener() {		
//			@Override
//			public void actionPerformed(ActionEvent e) {
//						
//	
//			}
//		});
		
		if(MainForm.mode == "Light") {
			setColorModeLight();
		}else {
			setColorModeDark();
		}

		action();
	}

	public void action() {
		PanelMode.actionButonModeLight(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeLight();

			}
		});

		PanelMode.actionButonModeDark(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeDark();
			}
		});
	}
	
	private void setColorModeDark() {
		option = -1;
		lblUsername.setForeground(ColorBackground.colorLight);
		lblBuys.setForeground(ColorBackground.colorLight);
		lblComment.setForeground(ColorBackground.colorLight);
		lblLikes.setForeground(ColorBackground.colorLight);
	}
	
	private void setColorModeLight() {
		option = 1;
		lblUsername.setForeground(ColorBackground.colorGRB147147147);
		lblBuys.setForeground(ColorBackground.colorGRB147147147);
		lblComment.setForeground(ColorBackground.colorGRB147147147);
		lblLikes.setForeground(ColorBackground.colorGRB147147147);
	}
	
	public int getIndexSelected() {
		return indexSelected;
	}

	public void setIndexSelected(int indexSelected) {
		this.indexSelected = indexSelected;
	}
}
