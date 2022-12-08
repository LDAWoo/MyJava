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
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import img.img;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Cursor;

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
	
	private DefaultComboBoxModel cbbModelDay;
	private DefaultComboBoxModel cbbModelMonth;
	private DefaultComboBoxModel cbbModelYear;
	
	private DefaultComboBoxModel cbbModelDayCreate;
	private DefaultComboBoxModel cbbModelMonthCreate;
	private DefaultComboBoxModel cbbModelYearCreate;
	
	private img img = new img();
	
	public PanelCourseUpdate() {
		setOpaque(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(93, 58, 196));
		
		JLabel lbldescribe = new JLabel("Ghi chú:\r\n\r\n");
		lbldescribe.setBounds(472, 230, 126, 22);
		lbldescribe.setForeground(SystemColor.menu);
		lbldescribe.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		JLabel lblTime = new JLabel("Thời lượng (giờ):");
		lblTime.setBounds(472, 82, 124, 22);
		lblTime.setForeground(SystemColor.menu);
		lblTime.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		JLabel lblCodeCourse = new JLabel("Mã khóa học:\r\n");
		lblCodeCourse.setBounds(20, 8, 118, 22);
		lblCodeCourse.setForeground(SystemColor.menu);
		lblCodeCourse.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		JLabel lblTopic = new JLabel("Chuyên đề:");
		lblTopic.setBounds(20, 82, 80, 22);
		lblTopic.setForeground(SystemColor.menu);
		lblTopic.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		JLabel lblTuition = new JLabel("Học phí:");
		lblTuition.setBounds(472, 8, 58, 22);
		lblTuition.setForeground(SystemColor.menu);
		lblTuition.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		JLabel lblPerson = new JLabel("Người tạo:");
		lblPerson.setBounds(20, 230, 76, 22);
		lblPerson.setForeground(SystemColor.menu);
		lblPerson.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		txtTuition = new JTextField();
		txtTuition.setBounds(502, 36, 357, 28);
		txtTuition.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtTuition.setColumns(10);
		
		txtCodeCourse = new JTextField();
		txtCodeCourse.setBounds(60, 36, 357, 28);
		txtCodeCourse.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtCodeCourse.setColumns(10);
		
		
		JTextArea textAreaNote = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(textAreaNote);
		scrollPane.setBounds(502, 255, 357, 97);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(60, 501, 0, 0);
		
		cbbTopic = new JComboBox();
		cbbTopic.setBounds(61, 111, 357, 28);
		
		JLabel lblDay = new JLabel("Ngày khai giảng:");
		lblDay.setBounds(20, 156, 115, 22);
		lblDay.setForeground(SystemColor.menu);
		lblDay.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		cbbDay = new JComboBox();
		cbbDay.setBounds(54, 184, 55, 26);
		cbbDay.setForeground(SystemColor.controlShadow);
		cbbDay.setFont(new Font("SansSerif", Font.BOLD, 13));
		cbbDay.setBorder(null);
		cbbDay.setBackground(Color.WHITE);
		
		cbbMonth = new JComboBox();
		cbbMonth.setBounds(119, 184, 65, 26);
		cbbMonth.setForeground(SystemColor.controlShadow);
		cbbMonth.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		cbbYear = new JComboBox();
		cbbYear.setBounds(194, 184, 55, 26);
		cbbYear.setForeground(SystemColor.controlShadow);
		cbbYear.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		txtTime = new JTextField();
		txtTime.setBounds(502, 110, 357, 28);
		txtTime.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtTime.setColumns(10);
		
		txtCreatePerson = new JTextField();
		txtCreatePerson.setBounds(54, 253, 357, 28);
		txtCreatePerson.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtCreatePerson.setColumns(10);
		
		JLabel lblDayCreate = new JLabel("Ngày tạo:");
		lblDayCreate.setBounds(472, 156, 80, 22);
		lblDayCreate.setForeground(SystemColor.menu);
		lblDayCreate.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		cbbDayCreate = new JComboBox();
		cbbDayCreate.setBounds(502, 184, 50, 26);
		cbbDayCreate.setForeground(SystemColor.controlShadow);
		cbbDayCreate.setFont(new Font("SansSerif", Font.BOLD, 13));
		cbbDayCreate.setBorder(null);
		cbbDayCreate.setBackground(Color.WHITE);
		
		cbbMonthCreate = new JComboBox();
		cbbMonthCreate.setBounds(562, 184, 65, 26);
		cbbMonthCreate.setForeground(SystemColor.controlShadow);
		cbbMonthCreate.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		cbbYearCreate = new JComboBox();
		cbbYearCreate.setBounds(637, 184, 55, 26);
		cbbYearCreate.setForeground(SystemColor.controlShadow);
		cbbYearCreate.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setBackground(SystemColor.menu);
		
		JButton btnFirst = new JButton("", img.iconFisrt());
		btnFirst.setForeground(SystemColor.menu);
		btnFirst.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnFirst.setBorder(null);
		btnFirst.setBackground(new Color(60, 22, 173));
		
		JButton btnPrev = new JButton("", img.iconPrev1());
		btnPrev.setForeground(SystemColor.menu);
		btnPrev.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnPrev.setBorder(null);
		btnPrev.setBackground(new Color(60, 22, 173));
		
		JButton btnNext = new JButton("", img.iconNext1());
		btnNext.setForeground(SystemColor.menu);
		btnNext.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNext.setBorder(null);
		btnNext.setBackground(new Color(60, 22, 173));
		
		JButton btnLast = new JButton("", img.iconLast());
		btnLast.setForeground(SystemColor.menu);
		btnLast.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnLast.setBorder(null);
		btnLast.setBackground(new Color(60, 22, 173));
		
		JButton btnNew = new JButton("New",img.iconNew());
		btnNew.setForeground(SystemColor.menu);
		btnNew.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNew.setBorder(null);
		btnNew.setBackground(new Color(60, 22, 173));
		
		JButton btnAdd = new JButton("Add",img.iconAdd());
		btnAdd.setForeground(SystemColor.menu);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(60, 22, 173));
		
		JButton btnUpdate = new JButton("Update",img.iconEditWhite());
		btnUpdate.setForeground(SystemColor.menu);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(60, 22, 173));
		
		JButton btnDelete = new JButton("Delete",img.iconDeleteWhite());
		btnDelete.setForeground(SystemColor.menu);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(60, 22, 173));
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 900, Short.MAX_VALUE)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(158)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))))
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 103, Short.MAX_VALUE)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		layeredPane.setLayout(gl_layeredPane);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		panel.add(lblLogo);
		panel.add(lblCodeCourse);
		panel.add(lblTopic);
		panel.add(lblDay);
		panel.add(lblDayCreate);
		panel.add(lblTuition);
		panel.add(lblTime);
		panel.add(lblPerson);
		panel.add(lbldescribe);
		panel.add(txtCodeCourse);
		panel.add(txtCreatePerson);
		panel.add(cbbTopic);
		panel.add(cbbDay);
		panel.add(cbbMonth);
		panel.add(cbbYear);
		panel.add(cbbDayCreate);
		panel.add(cbbMonthCreate);
		panel.add(cbbYearCreate);
		panel.add(txtTuition);
		panel.add(txtTime);
		panel.add(scrollPane);
		setLayout(groupLayout);
		initFillComboboxDate();
	}
	
	public void initFillComboboxDate() {
		cbbModelDay = new DefaultComboBoxModel();
		String[] comboboxDay = new String[] {"Day","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		for (String string : comboboxDay) {
			cbbModelDay.addElement(string);
		}
		cbbDay.setModel(cbbModelDay);
		
		
		cbbModelMonth = new DefaultComboBoxModel();
		String[] comboboxMonth = new String[] {"Month","01","02","03","04","05","06","07","08","09","10","11","12"};
		for (String string : comboboxMonth) {
			cbbModelMonth.addElement(string);
		}
		cbbMonth.setModel(cbbModelMonth);
		
		cbbModelYear = new DefaultComboBoxModel();
		String[] comboboxYear = new String[] {"Year","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022"};
		for (String string : comboboxYear) {
			cbbModelYear.addElement(string);
		}
		cbbYear.setModel(cbbModelYear);
		
		cbbModelDayCreate = new DefaultComboBoxModel();
		String[] comboboxDayCreate = new String[] {"Day","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		for (String string : comboboxDayCreate) {
			cbbModelDayCreate.addElement(string);
		}
		cbbDayCreate.setModel(cbbModelDayCreate);
		
		cbbModelMonthCreate = new DefaultComboBoxModel();
		String[] comboboxMonthCreate = new String[] {"Month","01","02","03","04","05","06","07","08","09","10","11","12"};
		for (String string : comboboxMonthCreate) {
			cbbModelMonthCreate.addElement(string);
		}
		cbbMonthCreate.setModel(cbbModelMonthCreate);
		
		cbbModelYearCreate = new DefaultComboBoxModel();
		String[] comboboxYearCreate = new String[] {"Year","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022"};
		for (String string : comboboxYearCreate) {
			cbbModelYearCreate.addElement(string);
		}
		cbbYearCreate.setModel(cbbModelYearCreate);
		
	}
	
	

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new Color(93,58,196));
		g2.fillRect(0, 20, getSize().width, getSize().height - 20);
		
		g2.fillRect(45, 1, 142, 19);
		
		super.paintComponent(g);
	}
}
