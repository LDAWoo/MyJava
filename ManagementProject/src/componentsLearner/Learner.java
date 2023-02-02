package componentsLearner;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import animation.AnimationButton;
import animation.AnimationButtonList;
import componentsCourse.PanelCourseList;
import componentsCourse.PanelCourseUpdate;
import dao.LearnerDAO;
import event.EventHandler;
import img.img;
import model.ModelLearner;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.SwingConstants;

public class Learner extends JPanel {
	private PanelLearnerUpdate panelUpdate;
	private PanelLearnerList panelList;
	
	private JPanel panelCenter;
	private img img = new img();
	
	private LearnerDAO dao = new LearnerDAO();
	ArrayList<ModelLearner> modelLearner;
	public EventHandler<ArrayList<ModelLearner>> ModelLearnerChanged = new EventHandler<ArrayList<ModelLearner>>();
	
	private String role;
	
	public Learner(String role) {
		this.role = role;
		setOpaque(false);
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		panelCenter = new JPanel();
		panelCenter.setBackground(new Color(50,50,50));

		panelUpdate = new PanelLearnerUpdate(this,role);

		panelList = new PanelLearnerList(this);	
		
		JLabel lblManagerCourse = new JLabel("QUẢN LÝ NGƯỜI ĐĂNG KÝ HỌC");
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
		
		AnimationButtonList btnUpdate = new AnimationButtonList(img.iconEditWhite(), "Cập nhật");
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
				panelUpdate.indexSelectedLearner = panelList.indexSelectedLearner;
				panelUpdate.Display(panelList.indexSelectedLearner);
			} catch (Exception error) {
			}
		}
	});

		AnimationButtonList btnList = new AnimationButtonList(img.iconLibrary(), "Danh sách");
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
					panelList.setSelectedTableLearner(panelUpdate.indexSelectedLearner);
					panelList.indexSelectedLearner = panelUpdate.indexSelectedLearner;
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
		getModelLearner();
		FindStudentAction();
	}
	
	
	public void getModelLearner() {
		modelLearner = dao.SelectAll();
		ModelLearnerChanged.invoke(this, modelLearner);
	}
	
	public void FindStudentAction() {
		panelList.addCaretListener(new CaretListener() {		
			@Override
			public void caretUpdate(CaretEvent e) {
				String Name = panelList.find.getText();		
				if(Name.equals("")) {
					getModelLearner();
				}else if(Name.length()>0) {
					modelLearner = dao.FindById(Name);
					if(modelLearner.isEmpty()) {
						TableLearner.tableModel.setRowCount(0);
					}else{
						ModelLearnerChanged.invoke(this, modelLearner);
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
