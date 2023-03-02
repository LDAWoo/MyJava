package componentButton;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import componentHeader.DialogProfile;
import componentLogin.MainLogin;
import icon.ImageAvatar;
import view.MainForm;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import net.miginfocom.swing.MigLayout;

public class ButtonNotification extends JButton {

	private int indexSelected;
	private Color color1 = new Color(103,118,126);
	private Color color2 = new Color(252,252,252);
	private Color color3 = new Color(17,19,21);
	private Color color4 = new Color(51,56,63);
	
	private Icon icon;
	private String name;
	private String comment;
	private String bieuTuong;
	private String email;
	private String time;
	
	public ButtonNotification(Icon icon,String name,String comment,String bieuTuong, String email,String Time,int index) {
		this.icon = icon;
		this.indexSelected = index;
		this.name = name;
		this.comment = comment;
		this.bieuTuong = bieuTuong;
		this.email = email;
		this.time = time;
		setOpaque(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		
		
		setHorizontalAlignment(SwingConstants.LEFT);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		ImageAvatar avatar = new ImageAvatar();
		avatar.setImage(icon);
		
		JLabel lblComment = new JLabel(comment);
		lblComment.setForeground(color1);
		lblComment.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JLabel lblCommentAbount = new JLabel(bieuTuong);
		lblCommentAbount.setForeground(color2);
		lblCommentAbount.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblTime = new JLabel(Time+"giờ");
		lblTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblTime.setForeground(color1);
		lblTime.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		
		JLabel lblUsername = new JLabel(name);
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setForeground(color2);
		lblUsername.setFont(new Font("Roboto", Font.BOLD, 14));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(avatar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblComment)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCommentAbount))
						.addComponent(lblTime)
						.addComponent(lblUsername))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblComment)
								.addComponent(lblCommentAbount))
							.addGap(5)
							.addComponent(lblTime, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(avatar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(13))
		);
		setLayout(groupLayout);
		
		
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setOpaque(true);
				setBackground(color4);
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
	}

	public int getIndexSelected() {
		return indexSelected;
	}

	public void setIndexSelected(int indexSelected) {
		this.indexSelected = indexSelected;
	}
}
