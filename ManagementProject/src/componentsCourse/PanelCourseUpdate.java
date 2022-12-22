package componentsCourse;

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
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import animation.AnimationButton;
import componentsStudent.PanelTableStudents;
import dao.CourseDAO;
import img.img;
import interfaces.IEvent;
import model.ModelCodeTopic;
import model.ModelCourse;
import model.ModelEmployee;
import view.Main;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.Icon;

public class PanelCourseUpdate extends JPanel {
	private JTextField txtTuition;
	private JTextField txtCodeCourse;
	private JTextField txtTime;
	private JTextField txtCreatePerson;
	private JComboBox cbbTopic;
	private JComboBox cbbDay;
	private JComboBox cbbMonth;
	private JComboBox cbbYear;
	private JComboBox cbbDayCreate;
	private JComboBox cbbMonthCreate;
	private JComboBox cbbYearCreate;

	public int IndexSelectedCourse = -1;

	private DefaultComboBoxModel cbbModelDay;
	private DefaultComboBoxModel cbbModelMonth;
	private DefaultComboBoxModel cbbModelYear;

	private DefaultComboBoxModel cbbModelDayCreate;
	private DefaultComboBoxModel cbbModelMonthCreate;
	private DefaultComboBoxModel cbbModelYearCreate;

	private DefaultComboBoxModel cbbModelTopic;

	private img img = new img();
	private AnimationButton btnFirst;
	private AnimationButton btnPrev;
	private AnimationButton btnNext;
	private AnimationButton btnLast;
	private AnimationButton btnNew;
	private AnimationButton btnAdd;
	private AnimationButton btnUpdate;
	private AnimationButton btnDelete;

	private ArrayList<ModelCourse> datas = new ArrayList<ModelCourse>();
	private ArrayList<ModelCodeTopic> datasCodeTopic = new ArrayList<ModelCodeTopic>();

	private CourseDAO dao = new CourseDAO();
	private Course course;
	private JTextArea textAreaNote;
	private AnimationButton btnStudent;

	public PanelCourseUpdate(Course course) {
		this.course = course;
		setOpaque(false);

		JPanel panel = new JPanel();
		panel.setBorder(null);

		panel.setBackground(new Color(60, 60, 60));

		JLabel lbldescribe = new JLabel("Ghi chú:\r\n\r\n");
		lbldescribe.setForeground(new Color(200, 200, 200));
		lbldescribe.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblTime = new JLabel("Thời lượng (giờ):");
		lblTime.setForeground(new Color(200, 200, 200));
		lblTime.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblCodeCourse = new JLabel("Mã khóa học:\r\n");
		lblCodeCourse.setForeground(new Color(200, 200, 200));
		lblCodeCourse.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblTopic = new JLabel("Chuyên đề:");
		lblTopic.setForeground(new Color(200, 200, 200));
		lblTopic.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblTuition = new JLabel("Học phí:");
		lblTuition.setForeground(new Color(200, 200, 200));
		lblTuition.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblPerson = new JLabel("Người tạo:");
		lblPerson.setForeground(new Color(200, 200, 200));
		lblPerson.setFont(new Font("SansSerif", Font.BOLD, 15));

		txtTuition = new JTextField();
		txtTuition.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtTuition.setBorder(null);
		txtTuition.setForeground(new Color(191, 191, 191));
		txtTuition.setBackground(new Color(50, 50, 50));
		txtTuition.setCaretColor(new Color(200, 200, 200));

		txtCodeCourse = new JTextField();
		txtCodeCourse.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtCodeCourse.setBorder(null);
		txtCodeCourse.setForeground(new Color(191, 191, 191));
		txtCodeCourse.setBackground(new Color(50, 50, 50));
		txtCodeCourse.setCaretColor(new Color(200, 200, 200));

		textAreaNote = new JTextArea();
		textAreaNote.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textAreaNote.setBorder(null);
		textAreaNote.setForeground(new Color(191, 191, 191));
		textAreaNote.setBackground(new Color(50, 50, 50));
		textAreaNote.setCaretColor(new Color(200, 200, 200));

		JScrollPane scrollPane = new JScrollPane(textAreaNote);
		scrollPane.setBorder(null);

		JLabel lblLogo = new JLabel("");

		cbbTopic = new JComboBox();
		cbbTopic.setForeground(new Color(60, 60, 60));
		cbbTopic.setFont(new Font("SansSerif", Font.BOLD, 13));

		JLabel lblDay = new JLabel("Ngày khai giảng:");
		lblDay.setForeground(new Color(200, 200, 200));
		lblDay.setFont(new Font("SansSerif", Font.BOLD, 15));

		cbbDay = new JComboBox();
		cbbDay.setForeground(new Color(60, 60, 60));
		cbbDay.setFont(new Font("SansSerif", Font.BOLD, 13));
		cbbDay.setBorder(null);

		cbbMonth = new JComboBox();
		cbbMonth.setForeground(new Color(60, 60, 60));
		cbbMonth.setFont(new Font("SansSerif", Font.BOLD, 13));

		cbbYear = new JComboBox();
		cbbYear.setForeground(new Color(60, 60, 60));
		cbbYear.setFont(new Font("SansSerif", Font.BOLD, 13));

		txtTime = new JTextField();
		txtTime.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtTime.setBorder(null);
		txtTime.setForeground(new Color(191, 191, 191));
		txtTime.setBackground(new Color(50, 50, 50));
		txtTime.setCaretColor(new Color(200, 200, 200));

		txtCreatePerson = new JTextField();
		txtCreatePerson.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtCreatePerson.setBorder(null);
		txtCreatePerson.setForeground(new Color(191, 191, 191));
		txtCreatePerson.setBackground(new Color(50, 50, 50));
		txtCreatePerson.setCaretColor(new Color(200, 200, 200));

		JLabel lblDayCreate = new JLabel("Ngày tạo:");
		lblDayCreate.setForeground(new Color(200, 200, 200));
		lblDayCreate.setFont(new Font("SansSerif", Font.BOLD, 15));

		cbbDayCreate = new JComboBox();
		cbbDayCreate.setForeground(new Color(60, 60, 60));
		cbbDayCreate.setFont(new Font("SansSerif", Font.BOLD, 13));
		cbbDayCreate.setBorder(null);
		cbbDayCreate.setBackground(Color.WHITE);

		cbbMonthCreate = new JComboBox();
		cbbMonthCreate.setForeground(new Color(60, 60, 60));
		cbbMonthCreate.setFont(new Font("SansSerif", Font.BOLD, 13));

		cbbYearCreate = new JComboBox();
		cbbYearCreate.setForeground(new Color(60, 60, 60));
		cbbYearCreate.setFont(new Font("SansSerif", Font.BOLD, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(23)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(47, Short.MAX_VALUE)));

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(false);

		btnFirst = new AnimationButton(img.iconFisrt(), "");
		btnFirst.setForeground(SystemColor.menu);
		btnFirst.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnFirst.setBorder(null);
		btnFirst.setBackground(new Color(60, 22, 173));

		btnPrev = new AnimationButton(img.iconPrev1(), "");
		btnPrev.setForeground(SystemColor.menu);
		btnPrev.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnPrev.setBorder(null);
		btnPrev.setBackground(new Color(60, 22, 173));

		btnNext = new AnimationButton(img.iconNext1(), "");
		btnNext.setForeground(SystemColor.menu);
		btnNext.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNext.setBorder(null);
		btnNext.setBackground(new Color(60, 22, 173));

		btnLast = new AnimationButton(img.iconLast(), "");
		btnLast.setForeground(SystemColor.menu);
		btnLast.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnLast.setBorder(null);
		btnLast.setBackground(new Color(60, 22, 173));

		btnNew = new AnimationButton(img.iconNew(), "New");
		btnNew.setForeground(SystemColor.menu);
		btnNew.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNew.setBorder(null);
		btnNew.setBackground(new Color(60, 22, 173));

		btnAdd = new AnimationButton(img.iconAdd(), "Add");
		btnAdd.setForeground(SystemColor.menu);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(60, 22, 173));

		btnUpdate = new AnimationButton(img.iconEditWhite(), "Update");
		btnUpdate.setForeground(SystemColor.menu);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(60, 22, 173));

		btnDelete = new AnimationButton(img.iconDeleteWhite(), "Delete");
		btnDelete.setForeground(SystemColor.menu);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(60, 22, 173));

		btnStudent = new AnimationButton((Icon) null, "Delete");
		btnStudent.setText("Student");
		btnStudent.setForeground(SystemColor.menu);
		btnStudent.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnStudent.setBorder(null);
		btnStudent.setBackground(new Color(60, 22, 173));
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane
				.setHorizontalGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup().addGap(187)
								.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnFirst, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNew, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE))
								.addGap(28)
								.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE))
								.addGap(29)
								.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE))
								.addGap(29)
								.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
								.addComponent(btnStudent, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_layeredPane.setVerticalGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup().addGap(11)
						.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(
								gl_layeredPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_layeredPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNew,
														GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_layeredPane.createSequentialGroup().addGap(6)
												.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
														.addComponent(btnStudent, GroupLayout.PREFERRED_SIZE, 35,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 35,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 35,
																		GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap()));
		layeredPane.setLayout(gl_layeredPane);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(60).addComponent(lblLogo).addGap(890))
				.addGroup(gl_panel.createSequentialGroup().addGap(61)
						.addComponent(cbbDay, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbbMonth, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbbYear, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE).addGap(338)
						.addComponent(cbbDayCreate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbbMonthCreate, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbbYearCreate, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(188, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addGap(62)
						.addComponent(txtTuition, GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_panel.createSequentialGroup().addGap(61)
						.addComponent(txtCreatePerson, GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup().addGap(62)
						.addComponent(txtTime, GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_panel.createSequentialGroup().addGap(33)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(28)
										.addComponent(cbbTopic, 0, 890, Short.MAX_VALUE).addContainerGap())
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblTime).addContainerGap())
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblDay)
										.addPreferredGap(ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
										.addComponent(lblDayCreate, GroupLayout.PREFERRED_SIZE, 80,
												GroupLayout.PREFERRED_SIZE)
										.addGap(333))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblPerson).addContainerGap())
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lbldescribe, GroupLayout.PREFERRED_SIZE, 126,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblTuition).addContainerGap())
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCodeCourse, GroupLayout.PREFERRED_SIZE, 118,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTopic))
										.addGap(810))))
				.addGroup(gl_panel.createSequentialGroup().addGap(60)
						.addComponent(txtCodeCourse, GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_panel.createSequentialGroup().addGap(61)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE).addContainerGap())
				.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(8)
						.addComponent(lblCodeCourse, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtCodeCourse, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblTopic, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbbTopic, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDayCreate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbbMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbbYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbbDayCreate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbbMonthCreate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbbYearCreate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblTuition, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTuition, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblTime, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTime, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addGap(15)
						.addComponent(lblPerson, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtCreatePerson, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lbldescribe, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addGap(53).addComponent(lblLogo).addGap(19)));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		initFillComboboxDate();
		ActionButton();
		
	}

	public void initFillComboboxDate() {
		cbbModelDay = new DefaultComboBoxModel();
		String[] comboboxDay = new String[] { "Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
				"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
				"29", "30", "31" };
		for (String string : comboboxDay) {
			cbbModelDay.addElement(string);
		}
		cbbDay.setModel(cbbModelDay);

		cbbModelMonth = new DefaultComboBoxModel();
		String[] comboboxMonth = new String[] { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12" };
		for (String string : comboboxMonth) {
			cbbModelMonth.addElement(string);
		}
		cbbMonth.setModel(cbbModelMonth);

		cbbModelYear = new DefaultComboBoxModel();
		String[] comboboxYear = new String[] { "Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997",
				"1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010",
				"2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022" };
		for (String string : comboboxYear) {
			cbbModelYear.addElement(string);
		}
		cbbYear.setModel(cbbModelYear);

		cbbModelDayCreate = new DefaultComboBoxModel();
		String[] comboboxDayCreate = new String[] { "Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31" };
		for (String string : comboboxDayCreate) {
			cbbModelDayCreate.addElement(string);
		}
		cbbDayCreate.setModel(cbbModelDayCreate);

		cbbModelMonthCreate = new DefaultComboBoxModel();
		String[] comboboxMonthCreate = new String[] { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12" };
		for (String string : comboboxMonthCreate) {
			cbbModelMonthCreate.addElement(string);
		}
		cbbMonthCreate.setModel(cbbModelMonthCreate);

		cbbModelYearCreate = new DefaultComboBoxModel();
		String[] comboboxYearCreate = new String[] { "Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996",
				"1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
				"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021",
				"2022" };
		for (String string : comboboxYearCreate) {
			cbbModelYearCreate.addElement(string);
		}
		cbbYearCreate.setModel(cbbModelYearCreate);

		cbbModelTopic = new DefaultComboBoxModel();
		cbbModelTopic.addElement("");

		for (ModelCodeTopic data : dao.SelectCodeTopicAddCombobox()) {
			cbbModelTopic.addElement(data.getCodeTopic() + " - " + data.getNameTopic());
		}
		cbbTopic.setModel(cbbModelTopic);

		IEvent<ArrayList<ModelCourse>> event = this::OnModelCourseChanged;
		course.ModelCourseChanged.subscribe(event);

	}

	public void OnModelCourseChanged(Object source, ArrayList<ModelCourse> eventArgs) {
		datas = eventArgs;
	}

	public void Display(int index) {
		txtCodeCourse.setText(datas.get(index).getCodeCourse());
		cbbModelTopic.setSelectedItem(datas.get(index).getCodeTopic() + " - " + datas.get(index).getNameTopic());

		cbbDay.setSelectedItem(datas.get(index).getDayOfOpening());
		cbbMonth.setSelectedIndex(Integer.parseInt(datas.get(index).getMonthOfOpening()));
		cbbYear.setSelectedItem(datas.get(index).getYearOfOpening());

		txtCreatePerson.setText(datas.get(index).getCreatePerson());
		txtTuition.setText(datas.get(index).getTuition() + "");
		txtTime.setText(datas.get(index).getTime() + "");

		cbbDayCreate.setSelectedItem(datas.get(index).getDayOfCreatePerson());
		cbbMonthCreate.setSelectedIndex(Integer.parseInt(datas.get(index).getMonthOfCreatePerson()));
		cbbYearCreate.setSelectedItem(datas.get(index).getYearOfCreatePerson());

		textAreaNote.setText(datas.get(index).getNote());
	}

	public void ActionButton() {
		btnNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClearForm();

			}
		});

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Add();
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Update();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Delete();

			}
		});

		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				First();
			}
		});

		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prev();
			}
		});

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Next();
			}
		});

		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Last();
			}
		});
		
		
		txtCodeCourse.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				if(txtCodeCourse.getText().equals("")) {
					btnStudent.setEnabled(false);
				}else {
					btnStudent.setEnabled(true);
				}
				
			}
		});
		
		btnStudent.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String codeCourse = txtCodeCourse.getText();
				Main.showForm(new PanelTableStudents(codeCourse));
				
			}
		});

	}

	public void ClearForm() {
		txtCodeCourse.setText("");
		cbbTopic.setSelectedIndex(0);

		cbbDay.setSelectedIndex(0);
		cbbMonth.setSelectedIndex(0);
		cbbYear.setSelectedIndex(0);

		txtCreatePerson.setText("");
		txtTuition.setText("");
		txtTime.setText("");

		cbbDayCreate.setSelectedIndex(0);
		cbbMonthCreate.setSelectedIndex(0);
		cbbYearCreate.setSelectedIndex(0);

		textAreaNote.setText("");
	}

	public void Add() {
		String CodeCourse = txtCodeCourse.getText().trim();
		String EmlementCodeTopic = cbbTopic.getSelectedItem().toString();

		String CodeTopic = EmlementCodeTopic.substring(0, EmlementCodeTopic.indexOf(" "));

		String CreatePerson = txtCreatePerson.getText().trim();
		double Tuition = Double.parseDouble(txtTuition.getText().trim());
		int Time = Integer.parseInt(txtTime.getText().trim());

		String DayOpening = cbbYear.getSelectedItem().toString() + cbbMonth.getSelectedItem().toString()
				+ cbbDay.getSelectedItem().toString();
		String DayCreate = cbbYearCreate.getSelectedItem().toString() + cbbMonthCreate.getSelectedItem().toString()
				+ cbbDayCreate.getSelectedItem().toString();

		String Note = textAreaNote.getText();

		if (dao.Insert(
				new ModelCourse(CodeCourse, CodeTopic, CreatePerson, Tuition, Time, DayOpening, DayCreate, Note)) > 0) {
			JOptionPane.showMessageDialog(course, "Insert Successfully", "Insert", JOptionPane.INFORMATION_MESSAGE,
					img.iconAdd32x32());

		} else if (dao.Insert(
				new ModelCourse(CodeCourse, CodeTopic, CreatePerson, Tuition, Time, DayOpening, DayCreate, Note)) > 0) {
			JOptionPane.showMessageDialog(course, "Insert Successfully", "Insert", JOptionPane.INFORMATION_MESSAGE,
					img.iconAdd32x32());

		}
		course.getModelCourseChanged();

	}

	public void Delete() {
		String CodeCourse = txtCodeCourse.getText();
		if (CodeCourse.equals("")) {
			JOptionPane.showMessageDialog(course, "Chưa Nhập Mã Khóa Học Để Xóa !", "Message",
					JOptionPane.WARNING_MESSAGE, img.iconDelete32x32());
			return;
		}
		int choice = JOptionPane.showConfirmDialog(course, "Bạn Có Chắc Chắn Muốn Xóa Không?", "Choose Option",
				JOptionPane.YES_NO_OPTION, 0, img.iconDelete32x32());

		if (choice == JOptionPane.YES_OPTION) {
			if (dao.Delete(CodeCourse) > 0) {
				JOptionPane.showMessageDialog(course, "Delete Successfully", "Delete", JOptionPane.INFORMATION_MESSAGE,
						img.iconDelete32x32());
				ClearForm();
			} else {
				JOptionPane.showMessageDialog(course, "Delete Failed", "Delete", JOptionPane.WARNING_MESSAGE,
						img.iconDelete32x32());
			}

		}
		course.getModelCourseChanged();
	}

	public void Update() {
		String CodeCourse = txtCodeCourse.getText();
		String CodeTopic = cbbTopic.getSelectedItem().toString();

		String CreatePerson = txtCreatePerson.getText();
		double Tuition = Double.parseDouble(txtTuition.getText());
		int Time = Integer.parseInt(txtTime.getText());

		String DayOpening = cbbYear.getSelectedItem().toString() + cbbMonth.getSelectedItem().toString()
				+ cbbDay.getSelectedItem().toString();
		String DayCreate = cbbYearCreate.getSelectedItem().toString() + cbbMonthCreate.getSelectedItem().toString()
				+ cbbDayCreate.getSelectedItem().toString();

		String Note = textAreaNote.getText();

		if (dao.Update(
				new ModelCourse(CodeCourse, CodeTopic, CreatePerson, Tuition, Time, DayOpening, DayCreate, Note)) > 0) {
			JOptionPane.showMessageDialog(course, "Update Successfully", "Update", JOptionPane.INFORMATION_MESSAGE,
					img.iconEdit32x32());

		} else {
			JOptionPane.showMessageDialog(course, "Update Faied", "Update", JOptionPane.WARNING_MESSAGE,
					img.iconEdit32x32());
		}
		course.getModelCourseChanged();
	}

	public void First() {
		btnPrev.setEnabled(false);
		btnNext.setEnabled(true);
		IndexSelectedCourse = 0;
		Display(IndexSelectedCourse);
	}

	public void Prev() {
		if (IndexSelectedCourse > 0) {
			IndexSelectedCourse--;
			if (IndexSelectedCourse == 0) {
				btnPrev.setEnabled(false);
				btnNext.setEnabled(true);
			} else {
				btnPrev.setEnabled(true);
				btnNext.setEnabled(true);
			}
		}
		Display(IndexSelectedCourse);
	}

	public void Next() {
		if (IndexSelectedCourse < datas.size() - 1) {
			IndexSelectedCourse++;
			if (IndexSelectedCourse == datas.size() - 1) {
				btnNext.setEnabled(false);
				btnPrev.setEnabled(true);
			} else {
				btnNext.setEnabled(true);
				btnPrev.setEnabled(true);
			}
		}
		Display(IndexSelectedCourse);
	}

	public void Last() {
		btnNext.setEnabled(false);
		btnPrev.setEnabled(true);
		IndexSelectedCourse = datas.size() - 1;
		Display(IndexSelectedCourse);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new Color(60, 60, 60));
		g2.fillRect(0, 20, getSize().width, getSize().height - 20);

		g2.fillRect(45, 1, 142, 19);

		super.paintComponent(g);
	}
}
