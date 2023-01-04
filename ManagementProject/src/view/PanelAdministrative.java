package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import componentTableScore.PanelTableScoreStudents;
import componentTableShedule.PanelTableSheduleStudent;

public class PanelAdministrative extends JPanel {
	private ButtonHelp btnTuition;
	
	public PanelAdministrative() {
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
		
		btnTuition = new ButtonHelp("Học viên muốn tra cứu học phí ?");
		btnTuition.setOpaque(true);

		btnTuition.setHorizontalAlignment(JLabel.LEFT);
		btnTuition.setFont(new Font("SansSerif",Font.PLAIN,14));
		btnTuition.setForeground(new Color(191,191,191));
		btnTuition.setBackground(new Color(70,70,70));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblQuestion, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
				.addComponent(btnTuition, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblQuestion, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(btnTuition, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(158, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		action();
	}

	public void action() {
		btnTuition.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainStudent.showForm(new PanelTuitionStudent());
			}
		});
	}
}
