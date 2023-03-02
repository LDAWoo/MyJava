package view;

import javax.swing.*;
import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import date.CurrendarCustom;

public class DialogSettingEmployee extends JDialog {

	private Button btnCalendar;
	private Button btnExit;
	private Button btnProfile;
	private int height = 614;
	
	public DialogSettingEmployee(JFrame parent, int height) {
		
		super(parent,false);
		this.height = height;
		init();
		setBackground(new Color(0,0,0,0));
		setPreferredSize(new Dimension(200, height));
		
		
	}
	
	public void init() {
		setUndecorated(true);
		PanelSettingEmployee panel = new PanelSettingEmployee();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, height, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblSetting = new JLabel("Setting");
		lblSetting.setOpaque(false);
		lblSetting.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetting.setForeground(SystemColor.scrollbar);
		lblSetting.setFont(new Font("SansSerif", Font.BOLD, 16));
		
		btnProfile = new Button();
		btnProfile.setText("Thông tin cá nhân");
		
		btnExit = new Button();
		btnExit.setText("Thoát");
		
		Button btnForgotPassword = new Button();
		btnForgotPassword.setText("Quên mật khẩu");
		
		Button btnLogout = new Button();
		btnLogout.setText("Đăng xuất");
		
		btnCalendar = new Button();
		btnCalendar.setText("Calendar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnProfile, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
						.addComponent(lblSetting, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
						.addComponent(btnForgotPassword, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
						.addComponent(btnLogout, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
						.addComponent(btnCalendar, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addComponent(lblSetting, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnProfile, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCalendar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 385, Short.MAX_VALUE)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnForgotPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		pack();
		action();
	}
	
	public void action() {
		btnProfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainEmployee.showForm(new PanelInformationEmployee());

			}
		});
		
		btnCalendar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainEmployee.showForm(new CurrendarCustom());
			}
		});
		
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DialogConfirmMessage confirm = new DialogConfirmMessage(null);
				confirm.setLocation(MainEmployee.xScreenExit, MainEmployee.yScreenExit);
				confirm.setModalityType(ModalityType.APPLICATION_MODAL);
				confirm.lblTitle.setText("THOÁT NGAY?");
				confirm.lblTextMessage.setText("Bạn có chắc chắn muốn thoát không ?");
				confirm.setVisible(true);
				if (confirm.option == 1) {
					System.exit(0);
				}
			}
		});
	}
}
