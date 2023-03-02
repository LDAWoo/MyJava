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
public class PanelNewStudentEnterSchool extends JPanel {
	
	private ButtonHelp btnCalendarLearner;
	private ButtonHelp btnPointStudent;
	
	public PanelNewStudentEnterSchool() {
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
		
		btnCalendarLearner = new ButtonHelp("Học viên muốn xem lịch học ở đâu ?");
		btnCalendarLearner.setOpaque(true);

		btnCalendarLearner.setHorizontalAlignment(JLabel.LEFT);
		btnCalendarLearner.setFont(new Font("SansSerif",Font.PLAIN,14));
		btnCalendarLearner.setForeground(new Color(191,191,191));
		btnCalendarLearner.setBackground(new Color(70,70,70));
		
		btnPointStudent = new ButtonHelp("Học viên muốn xem điểm ở đâu ?");
		btnPointStudent.setOpaque(true);
		btnPointStudent.setHorizontalAlignment(SwingConstants.LEFT);
		btnPointStudent.setForeground(new Color(191, 191, 191));
		btnPointStudent.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnPointStudent.setBackground(new Color(70,70,70));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblQuestion, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
				.addComponent(btnPointStudent, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
				.addComponent(btnCalendarLearner, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblQuestion, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(btnCalendarLearner, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPointStudent, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(247, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		action();
	}

	public void action() {
		btnCalendarLearner.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainStudent.showForm(new PanelTableSheduleStudent());
				
			}
		});
		
		btnPointStudent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainStudent.showForm(new PanelTableScoreStudents(MainStudent.email));
				
			}
		});
	}
}
