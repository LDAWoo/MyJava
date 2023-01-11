package componentHeader;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import componentButton.Button;
import componentButton.ButtonProfile;

import java.awt.Font;
import java.sql.PreparedStatement;

public class DialogProfile extends JDialog {

	private Color color1 = new Color(78,79,81);
	
	public DialogProfile(JFrame parent) {
		super(parent, false);
		setUndecorated(true);
		init();
		setBackground(new Color(17,19,21, 0));
		setPreferredSize(new Dimension(300, 420));
		pack();
	}
	
	public void init() {
		PanelDialogProfile panelDialog = new PanelDialogProfile();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelDialog, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelDialog, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		ButtonProfile btnProfile = new ButtonProfile(1);
		btnProfile.setBorder(null);
		btnProfile.setFont(new Font("Roboto", Font.BOLD, 17));
		btnProfile.setHorizontalAlignment(SwingConstants.LEFT);
		btnProfile.setForeground(color1);
		btnProfile.setText("Hồ sơ");
		
		ButtonProfile btnEditProfile = new ButtonProfile(2);
		btnEditProfile.setText("Chỉnh sửa hồ sơ");
		btnEditProfile.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditProfile.setForeground(new Color(78, 79, 81));
		btnEditProfile.setFont(new Font("Roboto", Font.BOLD, 17));
		btnEditProfile.setBorder(null);
		
		JLabel lbl1 = new JLabel("___________________________________");
		lbl1.setForeground(color1);
		
		ButtonProfile btnCalendar = new ButtonProfile(3);
		btnCalendar.setText("Calendar");
		btnCalendar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCalendar.setForeground(new Color(78, 79, 81));
		btnCalendar.setFont(new Font("Roboto", Font.BOLD, 17));
		btnCalendar.setBorder(null);
		
		ButtonProfile btnSetting = new ButtonProfile(4);
		btnSetting.setText("Cài đặt tài khoản");
		btnSetting.setHorizontalAlignment(SwingConstants.LEFT);
		btnSetting.setForeground(new Color(78, 79, 81));
		btnSetting.setFont(new Font("Roboto", Font.BOLD, 17));
		btnSetting.setBorder(null);
		
		ButtonProfile btnLogout = new ButtonProfile(5);
		btnLogout.setText("Đăng Xuất");
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setForeground(new Color(78, 79, 81));
		btnLogout.setFont(new Font("Roboto", Font.BOLD, 17));
		btnLogout.setBorder(null);
		GroupLayout gl_panelDialog = new GroupLayout(panelDialog);
		gl_panelDialog.setHorizontalGroup(
			gl_panelDialog.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelDialog.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelDialog.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalendar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addComponent(btnSetting, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addComponent(btnLogout, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addComponent(btnProfile, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addComponent(btnEditProfile, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addComponent(lbl1, GroupLayout.PREFERRED_SIZE, 252, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelDialog.setVerticalGroup(
			gl_panelDialog.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDialog.createSequentialGroup()
					.addGap(45)
					.addComponent(btnProfile, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEditProfile, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lbl1)
					.addGap(30)
					.addComponent(btnCalendar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSetting, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panelDialog.setLayout(gl_panelDialog);
		getContentPane().setLayout(groupLayout);
	}
}
