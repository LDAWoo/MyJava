package componentsStudent;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import img.img;
import view.Main;
import view.MainEmployee;
import view.MainStudent;
import view.ScrollBarEmployee;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.raven.table.TableCustom;
import com.raven.table.model.TableRowData;

import animation.AnimationButtonAction;
import animation.TextField;
import componentsForgot.DialogQuestion;
import dao.ManagerLearnerCourseDAO;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;

public class PanelTableStudents extends JPanel {
	Table table;
	private JScrollPane scrollPane;
	private TextField find;
	private JLabel lblFind;
	private img img = new img();
	private JPanel panelNorth2;
	private JComboBox cbbLearnerNoCourse;
	private AnimationButtonAction btnAdd;

	private int indexSelectedCombobox = -1;
	
	private DefaultComboBoxModel cbbModelLearner;

	ArrayList<ModelStudents> datas = new ArrayList<ModelStudents>();

	ArrayList<ModelLearnerNoCourse> datasCombobox = new ArrayList<ModelLearnerNoCourse>();

	ManagerLearnerCourseDAO dao = new ManagerLearnerCourseDAO();
	public static JRadioButton rdbtnAll;
	public static JRadioButton rdbtnScoreEntered;
	public static JRadioButton rdbtnScoreHasNotBeenEntered;
	private ButtonGroup buttonGroup;

	private String codeCourse;
	
	private DialogQuestion question = new DialogQuestion(null);
	
	public PanelTableStudents(String codeCourse) {
		this.codeCourse =codeCourse;
		setOpaque(false);
		setBackground(SystemColor.infoText);
		setBorder(null);
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		panelCenter.setBorder(null);

		table = new Table();
		table.setBorder(null);

		scrollPane = new JScrollPane(table);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		table.addTableStyle(scrollPane);

		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(190);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
				gl_panelCenter.createParallelGroup(Alignment.LEADING).addGroup(gl_panelCenter.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE).addContainerGap()));
		gl_panelCenter.setVerticalGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE));
		panelCenter.setLayout(gl_panelCenter);

		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(60, 60, 60));

		panelNorth2 = new JPanel();
		panelNorth2.setBorder(null);
		panelNorth2.setBackground(new Color(60, 60, 60));

		cbbLearnerNoCourse = new JComboBox();
		cbbLearnerNoCourse.setFont(new Font("SansSerif", Font.PLAIN, 15));

		btnAdd = new AnimationButtonAction("Thêm");
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(230, 230, 230));
		btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 15));
		GroupLayout gl_panelNorth2 = new GroupLayout(panelNorth2);
		gl_panelNorth2.setHorizontalGroup(gl_panelNorth2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelNorth2.createSequentialGroup().addGap(40)
						.addComponent(cbbLearnerNoCourse, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panelNorth2.setVerticalGroup(gl_panelNorth2.createParallelGroup(Alignment.LEADING).addGroup(gl_panelNorth2
				.createSequentialGroup()
				.addGroup(gl_panelNorth2.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbbLearnerNoCourse, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelNorth2.setLayout(gl_panelNorth2);

		JPanel panelSouth = new JPanel();
		panelSouth.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panelNorth, GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
				.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panelSouth, GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE).addContainerGap())
				.addComponent(panelNorth2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelNorth2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelSouth, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		buttonGroup = new ButtonGroup();

		rdbtnAll = new JRadioButton("Tất cả");
		rdbtnAll.setBackground(new Color(60, 60, 60));
		rdbtnAll.setFont(new Font("SansSerif", Font.PLAIN, 15));
		rdbtnAll.setForeground(new Color(200, 200, 200));
		rdbtnAll.setFocusPainted(false);

		rdbtnScoreEntered = new JRadioButton("Đã nhập điểm");
		rdbtnScoreEntered.setBackground(new Color(60, 60, 60));
		rdbtnScoreEntered.setFont(new Font("SansSerif", Font.PLAIN, 15));
		rdbtnScoreEntered.setForeground(new Color(200, 200, 200));
		rdbtnScoreEntered.setFocusPainted(false);

		rdbtnScoreHasNotBeenEntered = new JRadioButton("Chưa nhập điểm");
		rdbtnScoreHasNotBeenEntered.setBackground(new Color(60, 60, 60));
		rdbtnScoreHasNotBeenEntered.setFont(new Font("SansSerif", Font.PLAIN, 15));
		rdbtnScoreHasNotBeenEntered.setForeground(new Color(200, 200, 200));
		rdbtnScoreHasNotBeenEntered.setFocusPainted(false);

		buttonGroup.add(rdbtnAll);
		buttonGroup.add(rdbtnScoreEntered);
		buttonGroup.add(rdbtnScoreHasNotBeenEntered);
		GroupLayout gl_panelSouth = new GroupLayout(panelSouth);
		gl_panelSouth.setHorizontalGroup(gl_panelSouth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSouth.createSequentialGroup().addContainerGap().addComponent(rdbtnAll).addGap(2)
						.addComponent(rdbtnScoreEntered).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(rdbtnScoreHasNotBeenEntered).addContainerGap(684, Short.MAX_VALUE)));
		gl_panelSouth.setVerticalGroup(gl_panelSouth.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panelSouth.createSequentialGroup().addContainerGap(21, Short.MAX_VALUE)
						.addGroup(gl_panelSouth.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnScoreEntered)
								.addComponent(rdbtnScoreHasNotBeenEntered).addComponent(rdbtnAll))
						.addGap(17)));
		panelSouth.setLayout(gl_panelSouth);
		find = new TextField();
		find.setHint("Tìm kiếm học viên ...");
		find.setFont(new Font("SansSerif",Font.PLAIN, 15));
		find.setCaretColor(new Color(200,200,200));
		find.setForeground(new Color(200,200,200));
		
		
		lblFind = new JLabel("");
		lblFind.setIcon(img.iconSearch());
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth
				.setHorizontalGroup(gl_panelNorth.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_panelNorth.createSequentialGroup().addContainerGap().addComponent(lblFind)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(find, GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE).addContainerGap()));
		gl_panelNorth
				.setVerticalGroup(
						gl_panelNorth.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelNorth.createSequentialGroup().addContainerGap(14, Short.MAX_VALUE)
										.addGroup(gl_panelNorth.createParallelGroup(Alignment.BASELINE)
												.addComponent(find, GroupLayout.PREFERRED_SIZE, 25,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblFind))
										.addContainerGap()));
		panelNorth.setLayout(gl_panelNorth);
		setLayout(groupLayout);
		cbbModelLearner = new DefaultComboBoxModel();
		initCombobox();
		datas = dao.SelectAll(this.codeCourse);
		initDataTable();
		Action();
	}

	public void initCombobox() {
		
		cbbModelLearner.addElement("");

		datasCombobox = dao.addLearnerNoCourse();
		for (ModelLearnerNoCourse data : datasCombobox) {
			cbbModelLearner.addElement(data.getName());
		}

		cbbLearnerNoCourse.setModel(cbbModelLearner);

	}

	public void Action() {
		find.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				String Name = find.getText();

				if (Name.equals("")) {
					cbbModelLearner.removeAllElements();
					initCombobox();
				} else if (Name.length() > 0) {
					datasCombobox = dao.FindNameLearnerNoCourse(Name);
					if (datasCombobox.isEmpty()) {
						cbbLearnerNoCourse.setSelectedIndex(0);
					} else {
						
						for (ModelLearnerNoCourse data : datasCombobox) {
							cbbLearnerNoCourse.setSelectedItem(data.getName());
						}
					}
				}

			}
		});

		rdbtnAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.stopCellEditing();
				table.removeAllRows();
				datas = dao.SelectAll(getCodeCourse());
				initData();
			}
		});

		rdbtnScoreHasNotBeenEntered.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.stopCellEditing();
				table.removeAllRows();
				datas = dao.SelectAllNoGrade(getCodeCourse());
				initData();
			}
		});

		rdbtnScoreEntered.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.stopCellEditing();
				table.removeAllRows();
				datas = dao.SelectAllGrade(getCodeCourse());
				initData();
			}
		});

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				datas = dao.SelectAll();

				String student = datas.get(datas.size() - 1).getCodeStudent().toString();
				String code = student.substring(0, 2);
				int number = Integer.parseInt(student.substring(2, student.length()));
				indexSelectedCombobox = cbbLearnerNoCourse.getSelectedIndex() - 1;

				String codeStudent = String.format("%s%04d", code, number + 1);
				
				String codeLearner = datasCombobox.get(indexSelectedCombobox).getCodeStudent();
				
				double grade = -1;
				
				String codeCourse = getCodeCourse();
				
				ModelStudents st = new ModelStudents();
				
				if(dao.Insert(new ModelStudents(st.getID(), new ModelStudent(codeStudent), new ModelCourse(codeCourse), new ModelLearner(codeLearner), new ModelName(), new ModelSex(), new ModelAge(), new ModelGrade(grade)))>0){	
					getDialogPosition();
					question.lblQuestion.setText("Thêm học viên");
					question.lblTextMessage.setText("\"Thành công\"");
					
					cbbModelLearner.removeAllElements();
					initCombobox();
					cbbLearnerNoCourse.setSelectedIndex(0);
					
					table.stopCellEditing();
					table.removeAllRows();
					datas = dao.SelectAll(getCodeCourse());
					initData();

				}else {
					getDialogPosition();
					question.lblQuestion.setText("Thêm học viên");
					question.lblTextMessage.setText("\"Thất bại\"");
				}

			}
		});

	}
	
	public void getDialogPosition() {
		if(MainEmployee.role == "Employee") {
			question.setLocation(MainEmployee.xScreen, MainEmployee.yScreen);
			question.setVisible(true);
		}else if(Main.role == "Manager") {
			question.setLocation(Main.xScreen, Main.yScreen);
			question.setVisible(true);
		}	
	}

	public void initDataTable() {
		table.addTableCell(new CellStudent(), 0);
		table.addTableCell(new CellCourse(), 1);
		table.addTableCell(new CellLearner(), 2);
		table.addTableCell(new CellName(), 3);
		table.addTableCell(new CellSex(), 4);
		table.addTableCell(new CellAge(), 5);
		table.addTableCell(new CellGrade(), 6);
		table.addTableCell(new CellAction(), 7);
		initData();
	}

	public void initData() {
		for (ModelStudents data : datas) {
			table.addRow(new ModelStudents(data.getID(), new ModelStudent(data.getCodeStudent().getCodeStudent()),
					new ModelCourse(data.getCodeCourse().getCodeCourse()),
					new ModelLearner(data.getCodeLearner().getCodeLerner()),
					new ModelName(data.getName().getFullName()), new ModelSex(data.isGender().isSex()),
					new ModelAge(data.getAge().getAge()), new ModelGrade(data.getGrade().getGrade())), false);
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, 0, new Color(60, 60, 60), 250, 0, new Color(60, 60, 60));
		g2.setPaint(gra);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintComponent(g);
	}

	public String getCodeCourse() {
		return codeCourse;
	}

	public void setCodeCourse(String codeCourse) {
		this.codeCourse = codeCourse;
	}
	
	
}
