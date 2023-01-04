package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import componentsForgot.DialogForgotPassword;
import componentsForgot.DialogQuestion;
import date.CurrendarCustom;

import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelITHelp extends JPanel {

	private ButtonHelp btnForgotPassword;
	private ButtonHelp btnCalendar;
	private ButtonHelp btnForgotPasswordStudent;

	
	
	public PanelITHelp() {
		setOpaque(false);
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblQuestion = new JLabel("Câu hỏi thường gặp");
		lblQuestion.setOpaque(true);
		lblQuestion.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuestion.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblQuestion.setFont(new Font("SansSerif",Font.BOLD,15));
		lblQuestion.setForeground(new Color(70,70,70));
		lblQuestion.setBackground(new Color(191,191,191));
		
		btnForgotPassword = new ButtonHelp("Sinh viên muốn đổi mật khẩu email ?");
		btnForgotPassword.setOpaque(true);
		btnForgotPassword.setHorizontalAlignment(JLabel.LEFT);
		btnForgotPassword.setFont(new Font("SansSerif",Font.PLAIN,14));
		btnForgotPassword.setForeground(new Color(191,191,191));
		btnForgotPassword.setBackground(new Color(70,70,70));
		
		btnCalendar = new ButtonHelp("Sinh viên muốn xem lịch ?");
		btnCalendar.setOpaque(true);
		btnCalendar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCalendar.setForeground(new Color(191, 191, 191));
		btnCalendar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnCalendar.setBackground(new Color(70,70,70));
		
		btnForgotPasswordStudent = new ButtonHelp("Làm cách nào để lấy lại mật khẩu email ?");
		btnForgotPasswordStudent.setOpaque(true);
		btnForgotPasswordStudent.setHorizontalAlignment(SwingConstants.LEFT);
		btnForgotPasswordStudent.setForeground(new Color(191, 191, 191));
		btnForgotPasswordStudent.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnForgotPasswordStudent.setBackground(new Color(70, 70, 70));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblQuestion, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
				.addComponent(btnCalendar, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
				.addComponent(btnForgotPassword, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
				.addComponent(btnForgotPasswordStudent, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblQuestion, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(btnForgotPassword, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCalendar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnForgotPasswordStudent, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(209, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		action();
	}
	
	
	public void action() {
		DialogForgotPassword forgot = new DialogForgotPassword(null);
	
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
				forgot.setModalityType(ModalityType.APPLICATION_MODAL);
				forgot.setVisible(true);
				
				
			}
		});
		
	}
}
