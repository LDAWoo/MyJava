package componentsCourse;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import animation.AnimationButton;
import animation.AnimationButtonList;
import componentsEmployee.PanelEmployeeList;
import componentsEmployee.PanelEmployeeUpdate;
import dao.CourseDAO;
import event.EventHandler;
import img.img;
import model.ModelCourse;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Course extends JPanel {

	private JPanel panelCenter;
	private PanelCourseUpdate panelUpdate;
	private PanelCourseList panelList;
	private img img = new img();
	private ArrayList<ModelCourse> modelCourse = new ArrayList<ModelCourse>();
	public EventHandler<ArrayList<ModelCourse>> ModelCourseChanged = new EventHandler<ArrayList<ModelCourse>>();
	
	private CourseDAO dao = new CourseDAO();
	
	public Course() {
		setOpaque(false);
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		panelCenter = new JPanel();
		panelCenter.setBackground(new Color(50,50,50));

		panelUpdate = new PanelCourseUpdate(this);

		panelList = new PanelCourseList(this);	
		
		JLabel lblManagerCourse = new JLabel("QUẢN LÝ KHÓA HỌC");
		lblManagerCourse.setForeground(new Color(191,191,191));
		lblManagerCourse.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblManagerCourse.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelNorth, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
				.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
		);
		
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(panelUpdate, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(panelUpdate, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
		);
		
		AnimationButtonList btnUpdate = new AnimationButtonList(img.iconEditWhite(), "Update");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setForeground(new Color(191,191,191));
		btnUpdate.setFont(new Font("SansSerif", Font.PLAIN, 25));
		btnUpdate.setBorder(null);
		btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				gl_panelCenter.setHorizontalGroup(
						gl_panelCenter.createParallelGroup(Alignment.LEADING)
							.addComponent(panelUpdate, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
							.addComponent(panelList, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
					);
					gl_panelCenter.setVerticalGroup(
						gl_panelCenter.createParallelGroup(Alignment.LEADING)
							.addComponent(panelUpdate, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
							.addComponent(panelList, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
					);
				
				
				panelUpdate.setVisible(true);
				panelList.setVisible(false);
				panelUpdate.IndexSelectedCourse = panelList.indexSelectedCourse;
				panelUpdate.Display(panelList.indexSelectedCourse);
			} catch (Exception error) {
			}
		}
	});

		AnimationButtonList btnList = new AnimationButtonList(img.iconLibrary(), "List Employee");
		btnList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnList.setForeground(new Color(191,191,191));
		btnList.setFont(new Font("SansSerif", Font.PLAIN, 25));
		btnList.setBorder(null);
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					gl_panelCenter.setHorizontalGroup(
							gl_panelCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(panelUpdate, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
								.addComponent(panelList, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
						);
						gl_panelCenter.setVerticalGroup(
							gl_panelCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(panelUpdate, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
								.addComponent(panelList, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
						);
					
					
					panelList.setVisible(true);
					panelUpdate.setVisible(false);
					panelList.setRowSelectionInterval(panelUpdate.IndexSelectedCourse);
					panelList.indexSelectedCourse = panelUpdate.IndexSelectedCourse;
				} catch (Exception error) {
				}
			}
		});
		
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnList, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(lblManagerCourse, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addComponent(lblManagerCourse, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnList, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelNorth.setLayout(gl_panelNorth);
		add(panelCenter);
		
		panelCenter.setLayout(gl_panelCenter);
		setLayout(groupLayout);
		add(panelNorth);
		getModelCourseChanged();
		Action();
	}
	
	public void getModelCourseChanged() {
		modelCourse = dao.SelectAll();
		ModelCourseChanged.invoke(this, modelCourse);
	}
	
	public void Action() {
		panelList.addCaretListener(new CaretListener() {	
			@Override
			public void caretUpdate(CaretEvent e) {
				String txtFind = panelList.find.getText();
				if(txtFind.equals("")) {
					getModelCourseChanged();
				}else if(txtFind.length()>0) {
					modelCourse = dao.FindById(txtFind);
					if(modelCourse.isEmpty()) {
						TableCourse.tableModel.setRowCount(0);
					}else {
						ModelCourseChanged.invoke(this, modelCourse);
					}
				}
			}
		});
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
