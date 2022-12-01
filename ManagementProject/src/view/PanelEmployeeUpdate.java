package view;

import java.awt.Color;
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.EmployeeDAO;
import img.img;
import model.ModelEmployee;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEmployeeUpdate extends JPanel {
	private ArrayList<ModelEmployee> datas = new ArrayList<ModelEmployee>();

	private JComboBox cbbDayDate;
	private JComboBox cbbMonthDate;
	private JComboBox cbbYearDate;
	private JComboBox cbbDay;
	private JComboBox cbbMonth;
	private JComboBox cbbYear;
	private img img = new img();
	private DefaultComboBoxModel cbbModelDay;
	private DefaultComboBoxModel cbbModelMonth;
	private DefaultComboBoxModel cbbModelYear;

	private DefaultComboBoxModel cbbModelDayCreate;
	private DefaultComboBoxModel cbbModelMonthCreate;
	private DefaultComboBoxModel cbbModelYearCreate;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JTextField txtRole;
	private JTextField txtCodeEmplo;
	private EmployeeDAO dao = new EmployeeDAO();

	private int index;

	private JButton btnAdd;

	private JButton btnUpdate;

	private JButton btnDelete;

	private JButton btnNew;

	private JButton btnLast;

	private JButton btnNext;

	private JButton btnPrev;

	private JButton btnFirst;

	private JRadioButton rdbtnFemale;

	private JRadioButton rdbtnMale;

	private JTextArea textAreaNote;

	private ButtonGroup buttonGroup;
	
	public PanelEmployeeUpdate(int index) {
		this.index = index;
	}

	public PanelEmployeeUpdate() {

		setOpaque(false);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(93, 58, 196));

		JLabel lbldescribe = new JLabel("Ghi chú:\r\n\r\n");
		lbldescribe.setBounds(479, 230, 126, 22);
		lbldescribe.setForeground(SystemColor.menu);
		lbldescribe.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setBounds(479, 82, 68, 22);
		lblPassword.setForeground(SystemColor.menu);
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblCodeEmplo = new JLabel("Mã nhân viên:\r\n");
		lblCodeEmplo.setBounds(20, 8, 118, 22);
		lblCodeEmplo.setForeground(SystemColor.menu);
		lblCodeEmplo.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblName = new JLabel("Họ và tên:");
		lblName.setBounds(20, 82, 72, 22);
		lblName.setForeground(SystemColor.menu);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblRole = new JLabel("Vai trò:");
		lblRole.setBounds(480, 8, 49, 22);
		lblRole.setForeground(SystemColor.menu);
		lblRole.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblPerson = new JLabel("Giới tính:");
		lblPerson.setBounds(20, 230, 66, 22);
		lblPerson.setForeground(SystemColor.menu);
		lblPerson.setFont(new Font("SansSerif", Font.BOLD, 15));

		txtRole = new JTextField();
		txtRole.setBounds(509, 36, 357, 28);
		txtRole.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtRole.setColumns(10);

		txtCodeEmplo = new JTextField();
		txtCodeEmplo.setBounds(52, 36, 357, 28);
		txtCodeEmplo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtCodeEmplo.setColumns(10);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(60, 511, 0, 0);

		JLabel lblDay = new JLabel("Ngày sinh:");
		lblDay.setBounds(20, 156, 73, 22);
		lblDay.setForeground(SystemColor.menu);
		lblDay.setFont(new Font("SansSerif", Font.BOLD, 15));

		cbbDayDate = new JComboBox();
		cbbDayDate.setBounds(54, 184, 50, 26);
		cbbDayDate.setForeground(new Color(60, 22, 173));
		cbbDayDate.setFont(new Font("SansSerif", Font.BOLD, 13));
		cbbDayDate.setBorder(null);
		cbbDayDate.setBackground(Color.WHITE);

		cbbMonthDate = new JComboBox();
		cbbMonthDate.setBounds(113, 184, 69, 26);
		cbbMonthDate.setForeground(new Color(60, 22, 173));
		cbbMonthDate.setFont(new Font("SansSerif", Font.BOLD, 13));

		cbbYearDate = new JComboBox();
		cbbYearDate.setBounds(192, 184, 55, 26);
		cbbYearDate.setForeground(new Color(60, 22, 173));
		cbbYearDate.setFont(new Font("SansSerif", Font.BOLD, 13));

		JLabel lblTimeOpening = new JLabel("Ngày tham gia:");
		lblTimeOpening.setBounds(479, 156, 102, 22);
		lblTimeOpening.setForeground(SystemColor.menu);
		lblTimeOpening.setFont(new Font("SansSerif", Font.BOLD, 15));

		cbbDay = new JComboBox();
		cbbDay.setBounds(512, 184, 50, 26);
		cbbDay.setForeground(new Color(60, 22, 173));
		cbbDay.setFont(new Font("SansSerif", Font.BOLD, 13));
		cbbDay.setBorder(null);
		cbbDay.setBackground(Color.WHITE);

		cbbMonth = new JComboBox();
		cbbMonth.setBounds(572, 184, 69, 26);
		cbbMonth.setForeground(new Color(60, 22, 173));
		cbbMonth.setFont(new Font("SansSerif", Font.BOLD, 13));

		cbbYear = new JComboBox();
		cbbYear.setBounds(651, 184, 55, 26);
		cbbYear.setForeground(new Color(60, 22, 173));
		cbbYear.setFont(new Font("SansSerif", Font.BOLD, 13));

		txtName = new JTextField();
		txtName.setBounds(52, 108, 357, 28);
		txtName.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtName.setColumns(10);

		 buttonGroup = new ButtonGroup();
		
		rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setBounds(57, 258, 55, 27);
		rdbtnMale.setForeground(Color.WHITE);
		rdbtnMale.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnMale.setBackground(new Color(93, 58, 196));

		rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setBounds(114, 258, 55, 27);
		rdbtnFemale.setForeground(Color.WHITE);
		rdbtnFemale.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnFemale.setBackground(new Color(93, 58, 196));

		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(512, 110, 354, 24);
		txtPassword.setFont(new Font("SansSerif", Font.PLAIN, 11));

		JLabel lblImg = new JLabel("Hình:\r\n\r\n");
		lblImg.setBounds(714, 156, 49, 22);
		lblImg.setForeground(SystemColor.menu);
		lblImg.setFont(new Font("SansSerif", Font.BOLD, 15));

		JPanel panelImg = new JPanel();
		panelImg.setBounds(736, 184, 130, 162);

		JPanel panelNote = new JPanel();
		panelNote.setBounds(512, 258, 214, 88);
		textAreaNote = new JTextArea();
		textAreaNote.setFont(new Font("SansSerif",Font.PLAIN,13));
		
		JScrollPane scrollPane = new JScrollPane(textAreaNote);
		GroupLayout gl_panelNote = new GroupLayout(panelNote);
		gl_panelNote.setHorizontalGroup(gl_panelNote.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE));
		gl_panelNote.setVerticalGroup(gl_panelNote.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE));
		panelNote.setLayout(gl_panelNote);
		panelImg.setLayout(null);

		JLabel lblimg = new JLabel("");
		lblimg.setIcon(img.ImageWhite());

		lblimg.setBounds(0, 0, 130, 162);
		panelImg.add(lblimg);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setBackground(SystemColor.control);

		btnNew = new JButton("New");
		btnNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNew.setForeground(SystemColor.menu);
		btnNew.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNew.setBorder(null);
		btnNew.setBackground(new Color(60, 22, 173));

		btnDelete = new JButton("Delete");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setForeground(SystemColor.menu);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(60, 22, 173));

		btnUpdate = new JButton("Update");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setForeground(SystemColor.menu);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(60, 22, 173));

		btnAdd = new JButton("Add");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setForeground(SystemColor.menu);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(60, 22, 173));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup().addGap(12).addComponent(panel,
												GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(30)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(59, Short.MAX_VALUE)));
		panel.setLayout(null);
		panel.add(rdbtnMale);
		panel.add(rdbtnFemale);
		panel.add(lbldescribe);
		panel.add(panelNote);
		panel.add(panelImg);
		panel.add(lblCodeEmplo);
		panel.add(lblName);
		panel.add(lblDay);
		panel.add(lblRole);
		panel.add(lblPassword);
		panel.add(lblImg);
		panel.add(lblTimeOpening);
		panel.add(lblPerson);
		panel.add(lblLogo);
		panel.add(txtCodeEmplo);
		panel.add(cbbDayDate);
		panel.add(cbbMonthDate);
		panel.add(cbbYearDate);
		panel.add(txtName);
		panel.add(txtPassword);
		panel.add(cbbDay);
		panel.add(cbbMonth);
		panel.add(cbbYear);
		panel.add(txtRole);

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
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING).addGroup(gl_layeredPane
				.createSequentialGroup().addGap(158)
				.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING).addGroup(gl_layeredPane
						.createSequentialGroup()
						.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE).addGap(28)
						.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE).addGap(29)
						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE).addGap(28)
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
				.addGroup(gl_layeredPane.createSequentialGroup().addGap(11)
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
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))));
		layeredPane.setLayout(gl_layeredPane);
		setLayout(groupLayout);
		initFillComboboxDate();
		initData();
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
		cbbDayDate.setModel(cbbModelDay);

		cbbModelMonth = new DefaultComboBoxModel();
		String[] comboboxMonth = new String[] { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12" };
		for (String string : comboboxMonth) {
			cbbModelMonth.addElement(string);
		}
		cbbMonthDate.setModel(cbbModelMonth);

		cbbModelYear = new DefaultComboBoxModel();
		String[] comboboxYear = new String[] { "Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997",
				"1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010",
				"2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022" };
		for (String string : comboboxYear) {
			cbbModelYear.addElement(string);
		}
		cbbYearDate.setModel(cbbModelYear);

		cbbModelDayCreate = new DefaultComboBoxModel();
		String[] comboboxDayCreate = new String[] { "Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31" };
		for (String string : comboboxDayCreate) {
			cbbModelDayCreate.addElement(string);
		}
		cbbDay.setModel(cbbModelDayCreate);

		cbbModelMonthCreate = new DefaultComboBoxModel();
		String[] comboboxMonthCreate = new String[] { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12" };
		for (String string : comboboxMonthCreate) {
			cbbModelMonthCreate.addElement(string);
		}
		cbbMonth.setModel(cbbModelMonthCreate);

		cbbModelYearCreate = new DefaultComboBoxModel();
		String[] comboboxYearCreate = new String[] { "Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996",
				"1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
				"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021",
				"2022" };
		for (String string : comboboxYearCreate) {
			cbbModelYearCreate.addElement(string);
		}
		cbbYear.setModel(cbbModelYearCreate);

	}

	public void initData() {
		for (ModelEmployee data : dao.SellectALlDayMonthYear()) {
			datas.add(data);
		}

	}

	public void Display(int index) {
		String Code = datas.get(index).getCodeEmployee();
		String Name = datas.get(index).getName();
		boolean Sex = datas.get(index).isSex(); 
		String Role = datas.get(index).getRole();
		String Password = datas.get(index).getPassword();
		String Note = datas.get(index).getNote();
		
		txtCodeEmplo.setText(Code);
		txtName.setText(Name);
		txtRole.setText(Role);
		txtPassword.setText(Password);
		textAreaNote.setText(Note);
		
		if(Sex) {
			rdbtnMale.setSelected(true);
		}else {
			rdbtnFemale.setSelected(true);
		}
		
		String DayOfBirth = datas.get(index).getDayOfBirth();
		String MonthOfBirth = datas.get(index).getMonthOfBirth();
		String YearOfBirth = datas.get(index).getYearOfBirth();

		cbbDayDate.setSelectedIndex(Integer.parseInt(DayOfBirth));
		cbbMonthDate.setSelectedIndex(Integer.parseInt(MonthOfBirth));

		int comboboxSizeDate = cbbModelYear.getSize();

		for (int i = 1; i < comboboxSizeDate; i++) {
			String item = cbbModelYearCreate.getElementAt(i).toString();
			if (item.equals(YearOfBirth)) {
				cbbYearDate.setSelectedIndex(i);
			}
		}
		
		String DayOpening = datas.get(index).getDayOpening();
		String MonthOpening = datas.get(index).getMonthOpening();
		String YearOpening = datas.get(index).getYearOpening();

		cbbDay.setSelectedIndex(Integer.parseInt(DayOpening));
		cbbMonth.setSelectedIndex(Integer.parseInt(MonthOpening));

		int comboboxSize = cbbModelYearCreate.getSize();

		for (int i = 1; i < comboboxSize; i++) {
			String item = cbbModelYearCreate.getElementAt(i).toString();
			if (item.equals(YearOpening)) {
				cbbYear.setSelectedIndex(i);
			}
		}

	}
	

	
	public void ActionButton() {
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
		txtCodeEmplo.setText("");
		txtName.setText("");
		txtRole.setText("");
		txtPassword.setText("");
		textAreaNote.setText("");
		
		cbbDay.setSelectedIndex(0);
		cbbMonth.setSelectedIndex(0);
		cbbYear.setSelectedIndex(0);
		
		cbbDayDate.setSelectedIndex(0);
		cbbMonthDate.setSelectedIndex(0);
		cbbYearDate.setSelectedIndex(0);
	}

	public void First() {
		index = 0;
		Display(index);
	}

	public void Prev() {
		if (index > 0) {
			index--;
		}
		Display(index);
	}

	public void Next() {
		if (index < datas.size()-1) {
			index++;
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

	
	public void setCbbModelYearCreate(DefaultComboBoxModel cbbModelYearCreate) {
		this.cbbModelYearCreate = cbbModelYearCreate;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JTextField getTxtRole() {
		return txtRole;
	}

	public void setTxtRole(JTextField txtRole) {
		this.txtRole = txtRole;
	}

	public JTextField getTxtCodeEmplo() {
		return txtCodeEmplo;
	}

	public void setTxtCodeEmplo(JTextField txtCodeEmplo) {
		this.txtCodeEmplo = txtCodeEmplo;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
