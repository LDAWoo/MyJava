package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Font;

public class PanelAttendanceStudent extends JPanel {
	
	private DefaultComboBoxModel cbbModel;
	private JComboBox cbbSemester;

	public PanelAttendanceStudent() {
		setOpaque(false);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelNorth, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addComponent(panelCenter, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addComponent(panelSouth, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSouth, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
		);
		
		JLabel lblLpTrnhC = new JLabel("Lập trình C#");
		lblLpTrnhC.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLpTrnhC.setForeground(new Color(200,200,200));
		
		TableAttendanceStudent tableAttendanceStudent = new TableAttendanceStudent();
		
		JScrollPane scrollPane = new JScrollPane(tableAttendanceStudent);
		scrollPane.setOpaque(false);
		tableAttendanceStudent.addTableStyle(scrollPane);
		
		GroupLayout gl_panelSouth = new GroupLayout(panelSouth);
		gl_panelSouth.setHorizontalGroup(
			gl_panelSouth.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSouth.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSouth.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
						.addComponent(lblLpTrnhC, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelSouth.setVerticalGroup(
			gl_panelSouth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSouth.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLpTrnhC, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelSouth.setLayout(gl_panelSouth);
		
		JLabel lblSemester = new JLabel("Học kỳ");
		lblSemester.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSemester.setForeground(new Color(200,200,200));
		
		cbbSemester = new JComboBox();
		cbbSemester.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cbbSemester.setFocusable(false);
		cbbSemester.setMaximumRowCount(10);
		cbbSemester.setForeground(new Color(55,55,55));
		
		JLabel lblLaChnHc = new JLabel("Lựa chọn học kỳ để hiển thị điểm danh");
		lblLaChnHc.setForeground(new Color(191,191,191));
		
		lblLaChnHc.setFont(new Font("SansSerif", Font.PLAIN, 13));
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSemester, GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
						.addComponent(cbbSemester, 0, 980, Short.MAX_VALUE)
						.addComponent(lblLaChnHc, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSemester, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbbSemester, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLaChnHc, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelCenter.setLayout(gl_panelCenter);
		
		JLabel lblAttendance = new JLabel("ĐIỂM DANH");
		lblAttendance.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblAttendance.setForeground(new Color(200,200,200));
		
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAttendance, GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addComponent(lblAttendance, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
		);
		panelNorth.setLayout(gl_panelNorth);
		setLayout(groupLayout);
		initComboBox();
	}
	
	public void initComboBox() {
		cbbModel = new DefaultComboBoxModel();
		
		String[] items = new String[] {"Spring 2023","Fall 2022","Summer 2022","Spring 2022"};
		
		for(String item : items) {
			cbbModel.addElement(item);
		}
		cbbSemester.setModel(cbbModel);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, 0, new Color(60,60,60), 0, 0, new Color(60,60,60));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
