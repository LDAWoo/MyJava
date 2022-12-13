package componentsEmployee;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import animation.AnimationButton;
import dao.EmployeeDAO;
import img.ImageHelper;
import img.img;
import interfaces.IEvent;
import model.ModelEmployee;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Cursor;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	private byte[] personalImage = null;
	private ImageHelper image = new ImageHelper();

	private AnimationButton btnAdd;

	private AnimationButton btnUpdate;

	private AnimationButton btnDelete;

	private AnimationButton btnNew;

	private AnimationButton btnLast;

	private AnimationButton btnNext;

	private AnimationButton btnPrev;

	private AnimationButton btnFirst;

	private JRadioButton rdbtnFemale;

	private JRadioButton rdbtnMale;

	private JTextArea textAreaNote;

	private ButtonGroup buttonGroup;

	private JLabel lblimg;

	public int IndexSelectedEmployee = -1;

	private Employee employee;

	private String Note;

	private String MonthOfOpening;

	private String Code;

	private String Name;

	private String DayOfBirth;

	private String MonthOfBirth;

	private String YearOfBirth;

	private String DayBirth;

	private boolean sex;

	private String Role;

	private String Password;

	private String DayOfOpening;

	private String YearOfOpening;

	private String DayOpening;

	public PanelEmployeeUpdate(Employee employee) {

		this.employee = employee;
		setOpaque(false);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(93, 58, 196));

		JLabel lbldescribe = new JLabel("Ghi chú:\r\n\r\n");
		lbldescribe.setBounds(10, 258, 126, 22);
		lbldescribe.setForeground(SystemColor.menu);
		lbldescribe.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setBounds(400, 291, 68, 22);
		lblPassword.setForeground(SystemColor.menu);
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblCodeEmplo = new JLabel("Mã nhân viên:\r\n");
		lblCodeEmplo.setBounds(400, 8, 118, 22);
		lblCodeEmplo.setForeground(SystemColor.menu);
		lblCodeEmplo.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblName = new JLabel("Họ và tên:");
		lblName.setBounds(400, 57, 72, 22);
		lblName.setForeground(SystemColor.menu);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblRole = new JLabel("Vai trò:");
		lblRole.setBounds(400, 172, 49, 22);
		lblRole.setForeground(SystemColor.menu);
		lblRole.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblPerson = new JLabel("Giới tính:");
		lblPerson.setBounds(643, 105, 66, 22);
		lblPerson.setForeground(SystemColor.menu);
		lblPerson.setFont(new Font("SansSerif", Font.BOLD, 15));

		txtRole = new JTextField();
		txtRole.setBounds(444, 194, 393, 28);
		txtRole.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtRole.setColumns(10);

		txtCodeEmplo = new JTextField();
		txtCodeEmplo.setBounds(444, 30, 393, 28);
		txtCodeEmplo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtCodeEmplo.setColumns(10);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(60, 511, 0, 0);

		JLabel lblDay = new JLabel("Ngày sinh:");
		lblDay.setBounds(400, 105, 73, 22);
		lblDay.setForeground(SystemColor.menu);
		lblDay.setFont(new Font("SansSerif", Font.BOLD, 15));

		cbbDayDate = new JComboBox();
		cbbDayDate.setOpaque(false);
		cbbDayDate.setBounds(444, 128, 50, 26);
		cbbDayDate.setForeground(new Color(60, 22, 173));
		cbbDayDate.setFont(new Font("SansSerif", Font.BOLD, 13));
		cbbDayDate.setBorder(null);
		cbbDayDate.setBackground(Color.WHITE);

		cbbMonthDate = new JComboBox();
		cbbMonthDate.setBorder(null);
		cbbMonthDate.setOpaque(false);
		cbbMonthDate.setBounds(498, 128, 69, 26);
		cbbMonthDate.setForeground(new Color(60, 22, 173));
		cbbMonthDate.setFont(new Font("SansSerif", Font.BOLD, 13));

		cbbYearDate = new JComboBox();
		cbbYearDate.setBackground(Color.WHITE);
		cbbYearDate.setBorder(null);
		cbbYearDate.setOpaque(false);
		cbbYearDate.setBounds(570, 128, 55, 26);
		cbbYearDate.setForeground(new Color(60, 22, 173));
		cbbYearDate.setFont(new Font("SansSerif", Font.BOLD, 13));

		JLabel lblTimeOpening = new JLabel("Ngày tham gia:");
		lblTimeOpening.setBounds(400, 223, 102, 22);
		lblTimeOpening.setForeground(SystemColor.menu);
		lblTimeOpening.setFont(new Font("SansSerif", Font.BOLD, 15));

		cbbDay = new JComboBox();
		cbbDay.setBounds(444, 245, 50, 26);
		cbbDay.setForeground(new Color(60, 22, 173));
		cbbDay.setFont(new Font("SansSerif", Font.BOLD, 13));
		cbbDay.setBorder(null);
		cbbDay.setBackground(Color.WHITE);

		cbbMonth = new JComboBox();
		cbbMonth.setBounds(498, 245, 69, 26);
		cbbMonth.setForeground(new Color(60, 22, 173));
		cbbMonth.setFont(new Font("SansSerif", Font.BOLD, 13));

		cbbYear = new JComboBox();
		cbbYear.setBounds(570, 245, 55, 26);
		cbbYear.setForeground(new Color(60, 22, 173));
		cbbYear.setFont(new Font("SansSerif", Font.BOLD, 13));

		txtName = new JTextField();
		txtName.setBounds(444, 78, 393, 28);
		txtName.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtName.setColumns(10);

		buttonGroup = new ButtonGroup();

		rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setBounds(685, 128, 55, 27);
		rdbtnMale.setForeground(Color.WHITE);
		rdbtnMale.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnMale.setBackground(new Color(93, 58, 196));

		rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setBounds(742, 128, 55, 27);
		rdbtnFemale.setForeground(Color.WHITE);
		rdbtnFemale.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnFemale.setBackground(new Color(93, 58, 196));

		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(444, 314, 393, 28);
		txtPassword.setFont(new Font("SansSerif", Font.PLAIN, 11));

		JLabel lblImg = new JLabel("Hình:\r\n\r\n");
		lblImg.setBounds(10, 8, 49, 22);
		lblImg.setForeground(SystemColor.menu);
		lblImg.setFont(new Font("SansSerif", Font.BOLD, 15));

		JPanel panelImg = new JPanel();
		panelImg.setBounds(20, 30, 178, 220);

		JPanel panelNote = new JPanel();
		panelNote.setBounds(20, 279, 300, 67);
		textAreaNote = new JTextArea();
		textAreaNote.setFont(new Font("SansSerif", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane(textAreaNote);
		GroupLayout gl_panelNote = new GroupLayout(panelNote);
		gl_panelNote.setHorizontalGroup(gl_panelNote.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE));
		gl_panelNote.setVerticalGroup(gl_panelNote.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE));
		panelNote.setLayout(gl_panelNote);
		panelImg.setLayout(null);

		lblimg = new JLabel("");
		lblimg.setBounds(0, 0, 178, 220);

		lblimg.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileFilter(new FileFilter() {

						@Override
						public String getDescription() {

							return "Image File (*.jpg)";
						}

						@Override
						public boolean accept(File f) {
							if (f.isDirectory()) {
								return true;
							} else {
								return f.getName().toLowerCase().endsWith(".jpg");
							}

						}
					});

					if (fileChooser.showOpenDialog(employee) == JFileChooser.CANCEL_OPTION) {
						return;
					}

					File file = fileChooser.getSelectedFile();
					try {

						ImageIcon icon = new ImageIcon(file.getPath());
						Image img = image.resize(icon.getImage(), 178, 220);

						ImageIcon resizedIcon = new ImageIcon(img);
						lblimg.setIcon(resizedIcon);

						personalImage = image.toByteArray(img, "jpg");

					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			};
		});

		panelImg.add(lblimg);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setBackground(SystemColor.control);

		btnNew = new AnimationButton(img.iconNew(),"New");
		btnNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNew.setForeground(SystemColor.menu);
		btnNew.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNew.setBorder(null);
		btnNew.setBackground(new Color(60, 22, 173));

		btnDelete = new AnimationButton(img.iconDeleteWhite(),"Delete");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setForeground(SystemColor.menu);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(60, 22, 173));

		btnUpdate = new AnimationButton(img.iconEditWhite(),"Update");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setForeground(SystemColor.menu);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(60, 22, 173));

		btnAdd = new AnimationButton(img.iconAdd(),"Add");
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

		btnFirst = new AnimationButton(img.iconFisrt(),"");
		btnFirst.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFirst.setForeground(SystemColor.menu);
		btnFirst.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnFirst.setBorder(null);
		btnFirst.setBackground(new Color(60, 22, 173));

		btnPrev = new AnimationButton(img.iconPrev1(),"");
		btnPrev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPrev.setForeground(SystemColor.menu);
		btnPrev.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnPrev.setBorder(null);
		btnPrev.setBackground(new Color(60, 22, 173));

		btnNext = new AnimationButton(img.iconNext1(),"");
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.setForeground(SystemColor.menu);
		btnNext.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNext.setBorder(null);
		btnNext.setBackground(new Color(60, 22, 173));

		btnLast = new AnimationButton(img.iconLast(),"");
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

		IEvent<ArrayList<ModelEmployee>> event = this::OnModelEmployeeChanged;
		employee.ModelEmployeeChanged.subscribe(event);

	}

	public void OnModelEmployeeChanged(Object source, ArrayList<ModelEmployee> eventArgs) {
		datas = eventArgs;
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

		if (Sex) {
			rdbtnMale.setSelected(true);
		} else {
			rdbtnFemale.setSelected(true);
		}

		String DayOfBirth = datas.get(index).getDayOfBirth();
		String MonthOfBirth = datas.get(index).getMonthOfBirth();
		String YearOfBirth = datas.get(index).getYearOfBirth();

		cbbDayDate.setSelectedItem(DayOfBirth);
		cbbMonthDate.setSelectedItem(MonthOfBirth);
		cbbYearDate.setSelectedItem(YearOfBirth);
		

		String DayOpening = datas.get(index).getDayOpening();
		String MonthOpening = datas.get(index).getMonthOpening();
		String YearOpening = datas.get(index).getYearOpening();

		cbbDay.setSelectedItem(DayOpening);
		cbbMonth.setSelectedItem(MonthOpening);
		cbbYear.setSelectedItem(YearOpening);
		
		
		if (datas.get(index).getImg() != null) {
			byte[] img = datas.get(index).getImg();

			try {
				Image icon = image.createImageFromByteArray(img, "jpg");
				lblimg.setIcon(new ImageIcon(icon));
				personalImage = datas.get(index).getImg();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			lblimg.setIcon(img.ImageWhite());
		}
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

		lblimg.setIcon(img.ImageWhite());
	}

	public void getTextField() {
		Code = txtCodeEmplo.getText();
		Name = txtName.getText();
		DayOfBirth = cbbDayDate.getSelectedItem().toString();
		MonthOfBirth = cbbMonthDate.getSelectedItem().toString();
		YearOfBirth = cbbYearDate.getSelectedItem().toString();
		DayBirth = YearOfBirth + MonthOfBirth + DayOfBirth;
		sex = true;
		if (rdbtnMale.isSelected()) {
			sex = true;
		} else if (rdbtnFemale.isSelected()) {
			sex = false;
		}
		Role = txtRole.getText();
		Password = new String(txtPassword.getPassword());
		DayOfOpening = cbbDay.getSelectedItem().toString();
		MonthOfOpening = cbbMonth.getSelectedItem().toString();
		YearOfOpening = cbbYear.getSelectedItem().toString();
		DayOpening = YearOfOpening + MonthOfOpening + DayOfOpening;
		Note = textAreaNote.getText();
	}

	public void Update() {
		getTextField();
		byte[] Img = personalImage;

		if (dao.Update(new ModelEmployee(Code, Name, DayBirth, sex, Role, Password, DayOpening, Img, Note)) > 0) {
			JOptionPane.showMessageDialog(employee, "Update Successfully","Update",JOptionPane.INFORMATION_MESSAGE,img.iconEdit32x32());

		} else {
			JOptionPane.showMessageDialog(employee, "Update Faied","Update",JOptionPane.WARNING_MESSAGE,img.iconEdit32x32());
		}
		employee.getModelEmployees();
	}

	public void Add() {
		getTextField();
		byte[] Img = personalImage;

		if (lblimg == null) {
			try {
				ImageIcon icon = new ImageIcon(getClass().getResource("default-user.png"));

				Image ig = image.resize(icon.getImage(), 130, 162);
				Img = image.toByteArray(ig, "jpg");

				if (dao.Insert(new ModelEmployee(Code, Name, DayBirth, sex, Role, Password, DayOpening, Img, Note))>0) {
					JOptionPane.showMessageDialog(employee, "Insert Successfully","Insert",JOptionPane.INFORMATION_MESSAGE,img.iconAdd32x32());

				}
			} catch (Exception errorImg) {
				System.out.println("Error: " + errorImg.toString());
			}
		} else {
			if (dao.Insert(new ModelEmployee(Code, Name, DayBirth, sex, Role, Password, DayOpening, Img, Note))>0) {
				JOptionPane.showMessageDialog(employee, "Insert Successfully","Insert",JOptionPane.INFORMATION_MESSAGE,img.iconAdd32x32());

			}
		}
		employee.getModelEmployees();
	}

	public void Delete() {
		String CodeEmployee = txtCodeEmplo.getText();
		if (CodeEmployee.equals("")) {
			JOptionPane.showMessageDialog(employee, "Chưa Nhập Mã Nhân Viên Để Xóa !", "Message",
					JOptionPane.WARNING_MESSAGE, img.iconDelete32x32());
			return;
		}

		int choice = JOptionPane.showConfirmDialog(employee, "Bạn Có Chắc Chắn Muốn Xóa Không?", "Choose Option",
				JOptionPane.YES_NO_OPTION, 0, img.iconDelete32x32());

		if (choice == JOptionPane.YES_OPTION) {
			if (dao.Delete(CodeEmployee) > 0) {
				JOptionPane.showMessageDialog(employee, "Delete Successfully","Delete",JOptionPane.INFORMATION_MESSAGE,img.iconDelete32x32());
				ClearForm();
			} else {
				JOptionPane.showMessageDialog(employee, "Delete Failed","Delete",JOptionPane.WARNING_MESSAGE,img.iconDelete32x32());
			}
			employee.getModelEmployees();
		}
	}

	public void First() {
		btnPrev.setEnabled(false);
		btnNext.setEnabled(true);
		IndexSelectedEmployee = 0;
		Display(IndexSelectedEmployee);
	}

	public void Prev() {
		if (IndexSelectedEmployee > 0) {
			IndexSelectedEmployee--;
			if (IndexSelectedEmployee == 0) {
				btnPrev.setEnabled(false);
				btnNext.setEnabled(true);
			} else {
				btnPrev.setEnabled(true);
				btnNext.setEnabled(true);
			}
		}
		Display(IndexSelectedEmployee);
	}

	public void Next() {
		if (IndexSelectedEmployee < datas.size() - 1) {
			IndexSelectedEmployee++;
			if (IndexSelectedEmployee == datas.size() - 1) {
				btnNext.setEnabled(false);
				btnPrev.setEnabled(true);
			} else {
				btnNext.setEnabled(true);
				btnPrev.setEnabled(true);
			}
		}
		Display(IndexSelectedEmployee);
	}

	public void Last() {
		btnNext.setEnabled(false);
		btnPrev.setEnabled(true);
		IndexSelectedEmployee = datas.size() - 1;
		Display(IndexSelectedEmployee);
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
		return IndexSelectedEmployee;
	}

	public void setIndex(int index) {
		this.IndexSelectedEmployee = index;
	}
}
