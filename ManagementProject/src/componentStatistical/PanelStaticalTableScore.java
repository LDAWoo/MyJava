package componentStatistical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.GetCourseStaticalTableScoreDAO;
import model.ModelStaticalTableScore;
import model.ModelStaticalTableScoreGetCourse;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class PanelStaticalTableScore extends JPanel {

	private ArrayList<ModelStaticalTableScoreGetCourse> datas = new ArrayList<ModelStaticalTableScoreGetCourse>();
	private ArrayList<ModelStaticalTableScore> listDatas = new ArrayList<ModelStaticalTableScore>();
	
	private GetCourseStaticalTableScoreDAO dao = new GetCourseStaticalTableScoreDAO();
	private DefaultComboBoxModel cbbModel;
	
	private TableStaticalTableScore table;
	private JComboBox cbbCourse;
	
	public PanelStaticalTableScore() {
		setOpaque(false);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		
		JLabel lblTableScore = new JLabel("BẢNG ĐIỂM");
		lblTableScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableScore.setForeground(SystemColor.scrollbar);
		lblTableScore.setFont(new Font("SansSerif", Font.BOLD, 20));
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1181, Short.MAX_VALUE)
				.addComponent(lblTableScore, GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE)
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGap(0, 49, Short.MAX_VALUE)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTableScore, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelNorth.setLayout(gl_panelNorth);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCenter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
						.addComponent(panelNorth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblCourse = new JLabel("KHÓA HỌC");
		lblCourse.setFont(new Font("SansSerif",Font.PLAIN, 15));
		lblCourse.setForeground(new Color(191,191,191));
		
		cbbCourse = new JComboBox();
		cbbCourse.setOpaque(false);
		cbbCourse.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cbbCourse.setForeground(new Color(60,60,60));
		cbbCourse.setFocusable(false);
		cbbCourse.setMaximumRowCount(10);
		
		table = new TableStaticalTableScore();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		table.addTableStyle(scrollPane);
		
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
						.addGroup(gl_panelCenter.createSequentialGroup()
							.addComponent(lblCourse)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbbCourse, 0, 1150, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourse)
						.addComponent(cbbCourse, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelCenter.setLayout(gl_panelCenter);
		setLayout(groupLayout);
		initComboxBox();
		action();
	}
	
	public void initComboxBox() {
		cbbModel = new DefaultComboBoxModel();
		datas = dao.SelectAllCourse();
		cbbModel.addElement("");
		for (ModelStaticalTableScoreGetCourse data : datas) {
			cbbModel.addElement(data.getCodeTopic()+" ("+data.getDayOpening()+")");
		}
		
		cbbCourse.setModel(cbbModel);
	}
	
	public void action() {
		cbbCourse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int atIndex = cbbCourse.getSelectedIndex() -1;				
				String codeCourse = datas.get(atIndex).getCodeCourse();
				
				listDatas = dao.SelectByCodeCourse(codeCourse);
				table.tableModel.setRowCount(0);
				for (ModelStaticalTableScore data : listDatas) {
					Object[] rows = new Object[4];
					rows[0] = data.getCodeLearner();
					rows[1] = data.getFullName();
					rows[2] = data.getPoint();
					rows[3] = data.getClassification();
					table.tableModel.addRow(rows);
				}
			}
		});
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
