package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
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

import dao.LearnerDAO;
import img.img;
import model.ModelLearner;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Cursor;

public class PanelLearnerUpdate extends JPanel {
	private ArrayList<ModelLearner> datas = new ArrayList<ModelLearner>();
	private LearnerDAO DAO = new LearnerDAO();
	private JTextField txtEmail;
	private JComboBox cbbDay;
	private JComboBox cbbMonth;
	private JComboBox cbbYear;

	private DefaultComboBoxModel cbbModelDay;
	private DefaultComboBoxModel cbbModelMonth;
	private DefaultComboBoxModel cbbModelYear;

	private DefaultComboBoxModel cbbModelDayCreate;
	private DefaultComboBoxModel cbbModelMonthCreate;
	private DefaultComboBoxModel cbbModelYearCreate;
	private JTextField txtName;
	private JTextField txtPersonCode;
	private img img = new img();
	private int index = -1;

	private JComboBox cbbYearOfRegister;
	private JComboBox cbbMonthOfRegister;
	private JComboBox cbbDayOfRegister;
	private ButtonGroup buttonGroup;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JTextField txtNumberPhone;
	private JTextArea textAreaNote;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnAdd;
	private JButton btnNew;
	private JButton btnLast;
	private JButton btnNext;
	private JButton btnPrev;
	private JButton btnFirst;

	public PanelLearnerUpdate() {
		setOpaque(false);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(93, 58, 196));

		JLabel lbldescribe = new JLabel("Ghi chú:\r\n\r\n");
		lbldescribe.setBounds(478, 228, 126, 22);
		lbldescribe.setForeground(SystemColor.menu);
		lbldescribe.setFont(new Font("SansSerif", Font.BOLD, 15));

		txtNumberPhone = new JTextField();
		txtNumberPhone.setBounds(509, 36, 357, 28);
		txtNumberPhone.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtNumberPhone.setColumns(10);

		textAreaNote = new JTextArea();
		textAreaNote.setFont(new Font("SansSerif", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane(textAreaNote);
		scrollPane.setBounds(509, 257, 357, 84);

		JLabel lblLogo = new JLabel("");

		JLabel lblDate = new JLabel("Ngày sinh:");
		lblDate.setBounds(20, 156, 73, 22);
		lblDate.setForeground(SystemColor.menu);
		lblDate.setFont(new Font("SansSerif", Font.BOLD, 15));

		cbbDay = new JComboBox();
		cbbDay.setBounds(54, 184, 55, 26);
		cbbDay.setForeground(new Color(60, 22, 173));
		cbbDay.setFont(new Font("SansSerif", Font.BOLD, 13));
		cbbDay.setBorder(null);
		cbbDay.setBackground(Color.WHITE);

		cbbMonth = new JComboBox();
		cbbMonth.setBounds(119, 184, 69, 26);
		cbbMonth.setForeground(new Color(60, 22, 173));
		cbbMonth.setFont(new Font("SansSerif", Font.BOLD, 13));

		cbbYear = new JComboBox();
		cbbYear.setBounds(198, 184, 55, 26);
		cbbYear.setForeground(new Color(60, 22, 173));
		cbbYear.setFont(new Font("SansSerif", Font.BOLD, 13));

		txtEmail = new JTextField();
		txtEmail.setBounds(509, 110, 357, 28);
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtEmail.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Số điện thoại:");
		lblPhoneNumber.setBounds(478, 8, 97, 22);
		lblPhoneNumber.setForeground(SystemColor.menu);
		lblPhoneNumber.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(478, 82, 50, 22);
		lblEmail.setForeground(SystemColor.menu);
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblSex = new JLabel("Giới tính:");
		lblSex.setBounds(20, 228, 73, 22);
		lblSex.setForeground(SystemColor.menu);
		lblSex.setFont(new Font("SansSerif", Font.BOLD, 15));

		buttonGroup = new ButtonGroup();

		rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setBounds(56, 260, 47, 19);
		rdbtnMale.setForeground(SystemColor.menu);
		rdbtnMale.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnMale.setBorder(null);
		rdbtnMale.setBackground(new Color(93, 58, 196));

		rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setBounds(109, 256, 55, 27);
		rdbtnFemale.setForeground(SystemColor.menu);
		rdbtnFemale.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnFemale.setBorder(null);
		rdbtnFemale.setBackground(new Color(93, 58, 196));

		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);

		JLabel lblName = new JLabel("Họ và tên:");
		lblName.setBounds(20, 82, 72, 22);
		lblName.setForeground(SystemColor.menu);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 15));

		txtName = new JTextField();
		txtName.setBounds(53, 110, 357, 28);
		txtName.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtName.setColumns(10);

		txtPersonCode = new JTextField();
		txtPersonCode.setBounds(53, 36, 357, 28);
		txtPersonCode.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtPersonCode.setColumns(10);

		JLabel lblCodePerson = new JLabel("Mã người đăng kí:");
		lblCodePerson.setBounds(20, 8, 140, 22);
		lblCodePerson.setForeground(SystemColor.menu);
		lblCodePerson.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		layeredPane.setOpaque(true);
		layeredPane.setBackground(SystemColor.menu);

		btnFirst = new JButton("", img.iconFisrt());
		btnFirst.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFirst.setForeground(SystemColor.menu);
		btnFirst.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnFirst.setBorder(null);
		btnFirst.setBackground(new Color(60, 22, 173));

		btnPrev = new JButton("", img.iconPrev1());
		btnPrev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPrev.setForeground(SystemColor.menu);
		btnPrev.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnPrev.setBorder(null);
		btnPrev.setBackground(new Color(60, 22, 173));

		btnNext = new JButton("", img.iconNext1());
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.setForeground(SystemColor.menu);
		btnNext.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNext.setBorder(null);
		btnNext.setBackground(new Color(60, 22, 173));

		btnLast = new JButton("", img.iconLast());
		btnLast.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLast.setForeground(SystemColor.menu);
		btnLast.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnLast.setBorder(null);
		btnLast.setBackground(new Color(60, 22, 173));

		btnNew = new JButton("New");
		btnNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNew.setForeground(SystemColor.menu);
		btnNew.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNew.setBorder(null);
		btnNew.setBackground(new Color(60, 22, 173));

		btnAdd = new JButton("Add");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setForeground(SystemColor.menu);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(60, 22, 173));

		btnUpdate = new JButton("Update");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setForeground(SystemColor.menu);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(60, 22, 173));

		btnDelete = new JButton("Delete");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setForeground(SystemColor.menu);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(60, 22, 173));
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 900, Short.MAX_VALUE)
				.addGroup(gl_layeredPane.createSequentialGroup().addGap(158).addGroup(gl_layeredPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
								.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 125,
										GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_layeredPane.createSequentialGroup()
								.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(28).addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 125,
										GroupLayout.PREFERRED_SIZE)))));
		gl_layeredPane.setVerticalGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 103, Short.MAX_VALUE)
				.addGroup(gl_layeredPane.createSequentialGroup().addGap(11).addGroup(gl_layeredPane
						.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)).addGap(11)
						.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))));
		layeredPane.setLayout(gl_layeredPane);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
										.addContainerGap()))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(23)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(68, Short.MAX_VALUE)));
		panel.setLayout(null);
		panel.add(lblCodePerson);
		panel.add(lblPhoneNumber);
		panel.add(txtPersonCode);
		panel.add(txtNumberPhone);
		panel.add(lblName);
		panel.add(lblEmail);
		panel.add(txtName);
		panel.add(txtEmail);
		panel.add(lblDate);
		panel.add(cbbDay);
		panel.add(cbbMonth);
		panel.add(cbbYear);
		panel.add(lblSex);
		panel.add(rdbtnMale);
		panel.add(rdbtnFemale);
		panel.add(lbldescribe);
		panel.add(scrollPane);

		JLabel lblDateCreate = new JLabel("Ngày đăng kí:");
		lblDateCreate.setForeground(SystemColor.menu);
		lblDateCreate.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblDateCreate.setBounds(478, 162, 97, 22);
		panel.add(lblDateCreate);

		cbbDayOfRegister = new JComboBox();
		cbbDayOfRegister.setForeground(new Color(60, 22, 173));
		cbbDayOfRegister.setFont(new Font("SansSerif", Font.BOLD, 13));
		cbbDayOfRegister.setBounds(509, 185, 55, 26);
		panel.add(cbbDayOfRegister);

		cbbMonthOfRegister = new JComboBox();
		cbbMonthOfRegister.setForeground(new Color(60, 22, 173));
		cbbMonthOfRegister.setFont(new Font("SansSerif", Font.BOLD, 13));
		cbbMonthOfRegister.setBounds(574, 185, 69, 26);
		panel.add(cbbMonthOfRegister);

		cbbYearOfRegister = new JComboBox();
		cbbYearOfRegister.setForeground(new Color(60, 22, 173));
		cbbYearOfRegister.setFont(new Font("SansSerif", Font.BOLD, 13));
		cbbYearOfRegister.setBounds(653, 185, 55, 26);
		panel.add(cbbYearOfRegister);
		setLayout(groupLayout);
		initFillComboboxDate();
		initData();
		Action();
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
		cbbDayOfRegister.setModel(cbbModelDayCreate);

		cbbModelMonthCreate = new DefaultComboBoxModel();
		String[] comboboxMonthCreate = new String[] { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12" };
		for (String string : comboboxMonthCreate) {
			cbbModelMonthCreate.addElement(string);
		}
		cbbMonthOfRegister.setModel(cbbModelMonthCreate);

		cbbModelYearCreate = new DefaultComboBoxModel();
		String[] comboboxYearCreate = new String[] { "Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996",
				"1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
				"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021",
				"2022" };
		for (String string : comboboxYearCreate) {
			cbbModelYearCreate.addElement(string);
		}
		cbbYearOfRegister.setModel(cbbModelYearCreate);

	}

	public void initData() {
		for (ModelLearner data : DAO.SellectALlDayMonthYear()) {
			datas.add(data);
		}
	}

	public void Display(int index) {
		String Code = datas.get(index).getPersonCode();
		String Name = datas.get(index).getName();
		String Phone = datas.get(index).getPhoneNumber();
		String Note = datas.get(index).getNote();
		boolean Sex = datas.get(index).isSex();
		String Email = datas.get(index).getEmail();

		txtPersonCode.setText(Code);
		txtName.setText(Name);
		txtNumberPhone.setText(Phone);
		txtEmail.setText(Email);
		textAreaNote.setText(Note);

		if (Sex) {
			rdbtnMale.setSelected(true);
		} else {
			rdbtnFemale.setSelected(true);
		}

		String DayOfBirth = datas.get(index).getDayOfBirth();
		String MonthOfBirth = datas.get(index).getMonthOfBirth();
		String YearOfBirth = datas.get(index).getYearOfBirth();

		cbbDay.setSelectedIndex(Integer.parseInt(DayOfBirth));
		cbbMonth.setSelectedIndex(Integer.parseInt(MonthOfBirth));

		int comboboxDate = cbbModelYear.getSize();
		for (int i = 0; i < comboboxDate; i++) {
			Object item = cbbModelYear.getElementAt(i);
			if (item.equals(YearOfBirth)) {
				cbbYear.setSelectedIndex(i);
			}
		}

		String DayOfRegister = datas.get(index).getDayOfRegister();
		String MonthOfRegister = datas.get(index).getMonthOfRegister();
		String YearOfRegister = datas.get(index).getYearOfRegister();

		cbbDayOfRegister.setSelectedIndex(Integer.parseInt(DayOfRegister));
		cbbMonthOfRegister.setSelectedIndex(Integer.parseInt(MonthOfRegister));

		int comboboxRegisterSize = cbbModelYearCreate.getSize();
		for (int i = 0; i < comboboxRegisterSize; i++) {
			Object item = cbbModelYearCreate.getElementAt(i);
			if (item.equals(YearOfRegister)) {
				cbbYearOfRegister.setSelectedIndex(i);
			}
		}

	}

	public void Action() {
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

		btnNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClearForm();
			}
		});
	}
	
	public void ClearForm() {
		buttonGroup.clearSelection();
		txtPersonCode.setText("");
		txtName.setText("");
		txtNumberPhone.setText("");
		txtEmail.setText("");
		textAreaNote.setText("");
		
		cbbDay.setSelectedIndex(0);
		cbbMonth.setSelectedIndex(0);
		cbbYear.setSelectedIndex(0);
		
		cbbDayOfRegister.setSelectedIndex(0);
		cbbMonthOfRegister.setSelectedIndex(0);
		cbbYearOfRegister.setSelectedIndex(0);
	}

	public void First() {
		index = 0;
		Display(index);
	}

	public void Prev() {
		if (index > 0) {
			index--;
		}else {
			index=0;
		}
		Display(index);
	}

	public void Next() {
		if (index < datas.size() - 1) {
			index++;
		}else {
			index = datas.size()-1;
		}
		Display(index);
	}

	public void Last() {
		index = datas.size() - 1;
		Display(index);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new Color(93, 58, 196));
		g2.fillRect(0, 20, getSize().width, getSize().height - 20);

		g2.fillRect(45, 1, 142, 19);

		super.paintComponent(g);
	}
}
