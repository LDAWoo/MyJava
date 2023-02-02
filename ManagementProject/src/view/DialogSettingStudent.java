package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import componentTableScore.PanelTableScoreStudents;
import componentTableShedule.PanelTableSheduleStudent;
import componentsForgot.DialogForgotPassword;
import componetInformation.PanelInformation;
import date.CurrendarCustom;

import javax.swing.JLabel;

public class DialogSettingStudent extends JDialog {

	PanelSettingStudent panel;

	private int heightPanel = 614;

	private Button btnHelp;

	private Button btnLogout;

	private Button btnForgotPassword;

	private Button btnExit;

	private Button btnCalendar;

	private Button btnPoint;

	private Button btnStudentCalendar;

	private Button btnAttendance;

	private Button btnProfile;

	private DialogForgotPassword forgot = new DialogForgotPassword(null);

	public DialogSettingStudent(JFrame parent, int height) {
		super(parent, false);
		heightPanel = height;
		init();
		setBackground(new Color(0, 0, 0, 0));
		setPreferredSize(new Dimension(200, height));

	}

	public void init() {
		btnProfile = new Button();
		btnProfile.setText("Thông tin cá nhân");

		panel = new PanelSettingStudent();
		panel.setBorder(new EmptyBorder(5, 0, 0, 0));
		setUndecorated(true);

		btnAttendance = new Button();
		btnAttendance.setText("Điểm danh");

		btnStudentCalendar = new Button();
		btnStudentCalendar.setText("Lịch học");

		btnPoint = new Button();
		btnPoint.setText("Điểm");

		btnCalendar = new Button();
		btnCalendar.setText("Calendar");

		btnExit = new Button();
		btnExit.setText("Thoát");

		btnForgotPassword = new Button();
		btnForgotPassword.setText("Quên mật khẩu");

		btnLogout = new Button();
		btnLogout.setText("Đăng xuất");

		JLabel lblSetting = new JLabel("Setting");
		lblSetting.setOpaque(false);
		lblSetting.setForeground(new Color(200, 200, 200));
		lblSetting.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSetting.setHorizontalAlignment(JLabel.CENTER);

		btnHelp = new Button();
		btnHelp.setText("Trợ giúp");

		GroupLayout panelLayout = new GroupLayout(panel);
		panelLayout.setHorizontalGroup(panelLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblSetting, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnProfile, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnAttendance, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnStudentCalendar, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnPoint, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnCalendar, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnLogout, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnForgotPassword, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnHelp, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE));
		panelLayout.setVerticalGroup(panelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(panelLayout.createSequentialGroup().addGap(22)
						.addComponent(lblSetting, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnProfile, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAttendance, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnStudentCalendar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnPoint, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnCalendar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnForgotPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel.setLayout(panelLayout);

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, heightPanel, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		getContentPane().setLayout(layout);
		pack();
		action();
	}

	public void action() {
		btnProfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainStudent.showForm(new PanelInformation());

			}
		});

		btnAttendance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnStudentCalendar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainStudent.showForm(new PanelTableSheduleStudent());

			}
		});

		btnPoint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainStudent.showForm(new PanelTableScoreStudents(MainStudent.email));

			}
		});

		btnCalendar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainStudent.showForm(new CurrendarCustom());

			}
		});

		btnForgotPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				forgot.setLocation(MainStudent.xScreenForgot, MainStudent.yScreenForgot);
				forgot.setVisible(true);
			}
		});

		btnHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainStudent.showForm(new PanelStudentHelp());
			}
		});

		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DialogConfirmMessage confirm = new DialogConfirmMessage(null);
				confirm.setLocation(MainStudent.xScreenExit, MainStudent.yScreenExit);
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
	
	public void addActionButtonLogout(ActionListener event) {
		btnLogout.addActionListener(event);
	}
}
