package componentTableScore;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.ScoreStudentDAO;
import model.ModelScoreStudent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class PanelTableScoreStudents extends JPanel {

	
	private TableScoreStudent table;
	private JLabel lblTextCourse;
	private String email ;

	
	
	public PanelTableScoreStudents(String email) {
		this.email = email;
		setOpaque(false);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		
		JPanel panelTableScore = new JPanel();
		panelTableScore.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelTableScore, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
						.addComponent(panelNorth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelTableScore, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new TableScoreStudent(email);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		table.addTableStyle(scrollPane);
		
		GroupLayout gl_panelTableScore = new GroupLayout(panelTableScore);
		gl_panelTableScore.setHorizontalGroup(
			gl_panelTableScore.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
		);
		gl_panelTableScore.setVerticalGroup(
			gl_panelTableScore.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTableScore.createSequentialGroup()
					.addGap(2)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
		);
		panelTableScore.setLayout(gl_panelTableScore);
		
		JLabel lblTableScore = new JLabel("Bảng điểm");
		lblTableScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableScore.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTableScore.setForeground(new Color(200,200,200));
		
		JLabel lblCourse = new JLabel("Khóa học:");
		lblCourse.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCourse.setForeground(new Color(191,191,191));
		
		lblTextCourse = new JLabel("Lập trình C#");
		lblTextCourse.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblTextCourse.setForeground(new Color(191,191,191));
		
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNorth.createSequentialGroup()
							.addGap(10)
							.addComponent(lblCourse)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTextCourse))
						.addGroup(gl_panelNorth.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTableScore, GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addComponent(lblTableScore, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTextCourse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCourse, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panelNorth.setLayout(gl_panelNorth);
		setLayout(groupLayout);	
		
		setSubject();
	}
	
	public void setSubject() {
		lblTextCourse.setText(table.subject);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(60,60,60));
		g2.fillRect(0, 0, getWidth(), getHeight());
		
		super.paintComponent(g);
	}
}
