package view;

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
import java.awt.Dialog.ModalityType;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import animation.AnimationButton;
import dao.EmployeeDAO;
import img.ImageHelper;
import img.img;
import interfaces.IEvent;
import model.ModelEmployee;
import view.DialogMessage;
import view.Main;
import view.MainEmployee;
import view.PanelMessage;

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

public class PanelEmployeeUpdate extends JPanel{

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

	String Note;

	String MonthOfOpening;

	String Code;

	String Name;

	String DayOfBirth;

	String MonthOfBirth;

	String YearOfBirth;

	String DayBirth;

	boolean sex;

	String Role;

	String Password;

	String DayOfOpening;

	String YearOfOpening;

	String DayOpening;

	private Color colorTextForeground = new Color(191, 191, 191);
	private Color colorTextBackground = new Color(50, 50, 50);
	private Color colorLabel = new Color(200, 200, 200);
	private Color colorCaret = new Color(255, 255, 255);
	private Font fontText13 = new Font("SansSerif", Font.PLAIN, 13);

	private Font fontText13Italic = new Font("SansSerif", Font.ITALIC, 13);
	private Color colorTextForegroundRed = new Color(220, 20, 20);

	private Font fontText13Bold = new Font("SansSerif", Font.BOLD, 13);

	private Font fontText15Plain = new Font("SansSerif", Font.PLAIN, 15);

	private Font fontText15 = new Font("SansSerif", Font.BOLD, 15);
	private Font fontText18 = new Font("SansSerif", Font.BOLD, 18);
	private JPanel panelCenter;

	private boolean isSelected = true;

	private String employee_code_pattern = "^[N]{1}[V]{1}[0-9]{5}$";

	private String password_pattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
	
	private String email_pattern = "^([a-z0-9_\\.-]){2,}+@([\\da-z]){2,}\\.([a-z]){2,}(\\.|[a-z]{2,}){0,}$";
	
	private  DialogQuestion question = new DialogQuestion(null);
	
	private JLabel lblEmail;
	private JTextField txtEmail;

	private String email;

	private String CodeEmployee;

	private static DialogConfirm confirm;

	
	public PanelEmployeeUpdate(Employee employee) {

		this.employee = employee;
		setOpaque(false);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 60, 60));

		JLabel lbldescribe = new JLabel("Ghi chú:");
		lbldescribe.setForeground(colorLabel);
		lbldescribe.setFont(fontText15);

		JLabel lblLogo = new JLabel("");

		buttonGroup = new ButtonGroup();

		JLabel lblImg = new JLabel("Hình:\r\n\r\n");
		lblImg.setForeground(colorLabel);
		lblImg.setFont(fontText15);

		JPanel panelImg = new JPanel();

		JPanel panelNote = new JPanel();
		textAreaNote = new JTextArea();
		textAreaNote.setBorder(null);
		textAreaNote.setForeground(colorTextForeground);
		textAreaNote.setBackground(new Color(50, 50, 50));
		textAreaNote.setFont(fontText13);
		textAreaNote.setCaretColor(colorCaret);
		JScrollPane scrollPane = new JScrollPane(textAreaNote);
		scrollPane.setOpaque(false);
		scrollPane.setViewportBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);

		GroupLayout gl_panelNote = new GroupLayout(panelNote);
		gl_panelNote.setHorizontalGroup(gl_panelNote.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE));
		gl_panelNote.setVerticalGroup(gl_panelNote.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE));
		panelNote.setLayout(gl_panelNote);
		panelImg.setLayout(null);

		lblimg = new JLabel("");
		lblimg.setBounds(0, 0, 217, 257);
		lblimg.setOpaque(true);

		lblimg.setIcon(img.ImageWhite());
		lblimg.setBackground(new Color(55, 55, 55));

		panelImg.add(lblimg);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(panel,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(false);
		layeredPane.setBackground(getBackground());

		btnNew = new AnimationButton(img.iconNew(), "New");
		btnNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNew.setForeground(SystemColor.menu);
		btnNew.setFont(fontText18);
		btnNew.setBorder(null);

		btnDelete = new AnimationButton(img.iconDeleteWhite(), "Delete");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setForeground(SystemColor.menu);
		btnDelete.setFont(fontText18);
		btnDelete.setBorder(null);

		btnUpdate = new AnimationButton(img.iconEditWhite(), "Update");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setForeground(SystemColor.menu);
		btnUpdate.setFont(fontText18);
		btnUpdate.setBorder(null);

		btnAdd = new AnimationButton(img.iconAdd(), "Add");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setForeground(SystemColor.menu);
		btnAdd.setFont(fontText18);
		btnAdd.setBorder(null);

		btnFirst = new AnimationButton(img.iconFisrt(), "");
		btnFirst.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFirst.setForeground(SystemColor.menu);
		btnFirst.setFont(fontText18);
		btnFirst.setBorder(null);

		btnPrev = new AnimationButton(img.iconPrev1(), "");
		btnPrev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPrev.setForeground(SystemColor.menu);
		btnPrev.setFont(fontText18);
		btnPrev.setBorder(null);

		btnNext = new AnimationButton(img.iconNext1(), "");
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.setForeground(SystemColor.menu);
		btnNext.setFont(fontText18);
		btnNext.setBorder(null);

		btnLast = new AnimationButton(img.iconLast(), "");
		btnLast.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLast.setForeground(SystemColor.menu);
		btnLast.setFont(fontText18);
		btnLast.setBorder(null);
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup().addGap(188)
						.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGap(35)
						.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING, false).addGroup(gl_layeredPane
								.createSequentialGroup()
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layeredPane.createSequentialGroup()
										.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE)
										.addGap(36).addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(31)
						.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_layeredPane.setVerticalGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup().addGap(11)
						.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		layeredPane.setLayout(gl_layeredPane);

		panelCenter = new JPanel();
		panelCenter.setOpaque(false);

		JLabel lblCodeEmplo = new JLabel("Mã nhân viên:");
		lblCodeEmplo.setForeground(colorLabel);
		lblCodeEmplo.setFont(fontText15);

		txtCodeEmplo = new JTextField();

		txtCodeEmplo.setFont(fontText13);
		txtCodeEmplo.setBorder(null);
		txtCodeEmplo.setForeground(colorTextForeground);
		txtCodeEmplo.setBackground(colorTextBackground);
		txtCodeEmplo.setCaretColor(colorCaret);

		JLabel lblName = new JLabel("Họ và tên:");
		lblName.setForeground(colorLabel);
		lblName.setFont(fontText15);

		txtName = new JTextField();
		txtName.setFont(fontText13);
		txtName.setBorder(null);
		txtName.setForeground(colorTextForeground);
		txtName.setBackground(colorTextBackground);
		txtName.setCaretColor(colorCaret);

		JLabel lblDay = new JLabel("Ngày sinh:");
		lblDay.setForeground(colorLabel);
		lblDay.setFont(fontText15);

		cbbDayDate = new JComboBox();
		cbbDayDate.setForeground(new Color(60, 60, 60));
		cbbDayDate.setFont(fontText15Plain);
		cbbDayDate.setFocusable(false);
		cbbDayDate.setMaximumRowCount(10);

		cbbMonthDate = new JComboBox();
		cbbMonthDate.setForeground(new Color(60, 60, 60));
		cbbMonthDate.setFont(fontText15Plain);
		cbbMonthDate.setFocusable(false);
		cbbMonthDate.setMaximumRowCount(10);

		cbbYearDate = new JComboBox();
		cbbYearDate.setForeground(new Color(60, 60, 60));
		cbbYearDate.setFont(fontText15Plain);
		cbbYearDate.setFocusable(false);
		cbbYearDate.setMaximumRowCount(10);

		JLabel lblPerson = new JLabel("Giới tính:");
		lblPerson.setForeground(colorLabel);
		lblPerson.setFont(fontText15);

		rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setOpaque(false);
		rdbtnMale.setForeground(colorLabel);
		rdbtnMale.setFont(fontText13Bold);
		rdbtnMale.setBackground(getBackground());

		buttonGroup.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setOpaque(false);
		rdbtnFemale.setForeground(colorLabel);
		rdbtnFemale.setFont(fontText13Bold);
		rdbtnFemale.setBackground(getBackground());
		buttonGroup.add(rdbtnFemale);

		JLabel lblRole = new JLabel("Vai trò:");
		lblRole.setForeground(colorLabel);
		lblRole.setFont(fontText15);

		txtRole = new JTextField();
		txtRole.setFont(fontText13);
		txtRole.setBorder(null);
		txtRole.setForeground(colorTextForeground);
		txtRole.setBackground(new Color(50, 50, 50));
		txtRole.setCaretColor(new Color(200, 200, 200));

		JLabel lblTimeOpening = new JLabel("Ngày tham gia:");
		lblTimeOpening.setForeground(colorLabel);
		lblTimeOpening.setFont(fontText15);

		cbbDay = new JComboBox();
		cbbDay.setForeground(new Color(60, 60, 60));
		cbbDay.setFont(fontText15Plain);
		cbbDay.setFocusable(false);
		cbbDay.setMaximumRowCount(10);

		cbbMonth = new JComboBox();
		cbbMonth.setForeground(new Color(60, 60, 60));
		cbbMonth.setFont(fontText15Plain);
		cbbMonth.setFocusable(false);
		cbbMonth.setMaximumRowCount(10);

		cbbYear = new JComboBox();
		cbbYear.setForeground(new Color(60, 60, 60));
		cbbYear.setFont(fontText15Plain);
		cbbYear.setFocusable(false);
		cbbYear.setMaximumRowCount(10);

		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setForeground(colorLabel);
		lblPassword.setFont(fontText15);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBorder(null);
		txtPassword.setForeground(colorTextForeground);
		txtPassword.setBackground(colorTextBackground);
		txtPassword.setCaretColor(colorCaret);

		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(SystemColor.scrollbar);
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 15));

		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(191, 191, 191));
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtEmail.setCaretColor(Color.WHITE);
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(50, 50, 50));
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup().addGap(84)
						.addComponent(cbbDayDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbbMonthDate, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbbYearDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(81).addComponent(rdbtnMale).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(307, Short.MAX_VALUE))
				.addGroup(gl_panelCenter.createSequentialGroup().addGap(83)
						.addComponent(cbbDay, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbbMonth, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbbYear, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(444, Short.MAX_VALUE))
				.addGroup(gl_panelCenter.createSequentialGroup().addGap(39).addGroup(gl_panelCenter
						.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCodeEmplo, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
						.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
						.addComponent(txtRole, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
						.addGroup(gl_panelCenter.createSequentialGroup()
								.addGroup(gl_panelCenter.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblEmail, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 68,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPassword, Alignment.LEADING)
										.addComponent(lblTimeOpening, Alignment.LEADING)
										.addComponent(lblRole, Alignment.LEADING)
										.addGroup(Alignment.LEADING,
												gl_panelCenter.createSequentialGroup().addComponent(lblDay).addGap(234)
														.addComponent(lblPerson))
										.addComponent(lblName, Alignment.LEADING)
										.addComponent(lblCodeEmplo, Alignment.LEADING))
								.addContainerGap(325, Short.MAX_VALUE))
						.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
						.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))));
		gl_panelCenter.setVerticalGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup().addContainerGap().addComponent(lblCodeEmplo)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtCodeEmplo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPerson, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCenter.createParallelGroup(Alignment.BASELINE)
										.addComponent(cbbDayDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cbbMonthDate, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbbYearDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelCenter.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnMale)
										.addComponent(rdbtnFemale)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE).addGap(1)
						.addComponent(txtRole, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblTimeOpening, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbbMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbbYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panelCenter.setLayout(gl_panelCenter);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(87).addComponent(lblImg,
										GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addGap(20).addComponent(panelImg,
										GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lbldescribe,
										GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(panelNote,
								GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE))
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 984, Short.MAX_VALUE))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(9)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addComponent(lblImg, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE).addGap(3)
						.addComponent(panelImg, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
						.addComponent(lbldescribe, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGap(11))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panelNote, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		initFillComboboxDate();
		ActionButton();

	}

	public void initFillComboboxDate() {
		cbbModelDay = new DefaultComboBoxModel();
		String[] comboboxDay = new String[] { "Ngày", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
				"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
				"29", "30", "31" };
		for (String string : comboboxDay) {
			cbbModelDay.addElement(string);
		}
		cbbDayDate.setModel(cbbModelDay);

		cbbModelMonth = new DefaultComboBoxModel();
		String[] comboboxMonth = new String[] { "Tháng", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12" };
		for (String string : comboboxMonth) {
			cbbModelMonth.addElement(string);
		}
		cbbMonthDate.setModel(cbbModelMonth);

		cbbModelYear = new DefaultComboBoxModel();
		String[] comboboxYear = new String[] { "Năm", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997",
				"1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010",
				"2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022" };
		for (String string : comboboxYear) {
			cbbModelYear.addElement(string);
		}

		cbbYearDate.setModel(cbbModelYear);

		cbbModelDayCreate = new DefaultComboBoxModel();
		String[] comboboxDayCreate = new String[] { "Ngày", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31" };
		for (String string : comboboxDayCreate) {
			cbbModelDayCreate.addElement(string);
		}
		cbbDay.setModel(cbbModelDayCreate);

		cbbModelMonthCreate = new DefaultComboBoxModel();
		String[] comboboxMonthCreate = new String[] { "Tháng", "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12" };
		for (String string : comboboxMonthCreate) {
			cbbModelMonthCreate.addElement(string);
		}
		cbbMonth.setModel(cbbModelMonthCreate);

		cbbModelYearCreate = new DefaultComboBoxModel();
		String[] comboboxYearCreate = new String[] { "Năm", "1990", "1991", "1992", "1993", "1994", "1995", "1996",
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

	public void getDialogPosition() {
		question.setLocation(Main.xScreen, Main.yScreen);
		question.setVisible(true);
	}
	
	public void getDialogConfirmPosition() {
		confirm = new DialogConfirm(null);
		confirm.setLocation(Main.xScreen, Main.yScreen);
		confirm.setModalityType(ModalityType.APPLICATION_MODAL);
		confirm.setVisible(true);
	}

	public boolean Validate() {
		if (txtCodeEmplo.getText().equals("")) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Mã nhân viên\"");
			return false;
		}
		if (!txtCodeEmplo.getText().matches(employee_code_pattern)) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Mã nhân viên đúng định dạng\"");
			return false;
		}

		if (txtName.getText().equals("")) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Tên nhân viên\"");
			return false;
		}

		if (cbbDayDate.getSelectedIndex() == 0) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Ngày sinh\"");
			return false;
		}

		if (cbbMonthDate.getSelectedIndex() == 0) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Tháng sinh\"");
			return false;
		}

		if (cbbYearDate.getSelectedIndex() == 0) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Năm sinh\"");
			return false;
		}

		if (!rdbtnMale.isSelected() && !rdbtnFemale.isSelected()) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Giới tính\"");
			return false;
		}

		if (txtRole.getText().equals("")) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Vai trò\"");
			return false;
		}

		if (!txtRole.getText().equals("Manager") && !txtRole.getText().equals("Employee")) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Vai trò là Manager hoặc Employee\"");
			return false;
		}

		if (cbbDay.getSelectedIndex() == 0) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Ngày tham gia\"");
			return false;
		}

		if (cbbMonth.getSelectedIndex() == 0) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Tháng tham gia\"");
			return false;
		}

		if (cbbYear.getSelectedIndex() == 0) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Năm tham gia\"");
			return false;
		}

		if (txtEmail.getText().equals("")) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Email nhân viên\"");
			return false;
		}

		if (!txtEmail.getText().matches(email_pattern)) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Email đúng định dạng\"");
			return false;
		}

		if (txtPassword.getText().equals("")) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Mật khẩu nhân viên\"");
			return false;
		}

		if (!txtPassword.getText().matches(password_pattern)) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Mật khẩu đúng định dạng\"");
			return false;
		}

		return true;
	}

	public void Display(int index) {
		String Code = datas.get(index).getCodeEmployee();
		String Name = datas.get(index).getName();

		boolean Sex = datas.get(index).isSex();
		String Role = datas.get(index).getRole();
		String Password = datas.get(index).getPassword();
		String Note = datas.get(index).getNote();
		String email = datas.get(index).getEmail();
		txtCodeEmplo.setText(Code);
		txtName.setText(Name);
		txtRole.setText(Role);
		txtEmail.setText(email);
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
		cbbMonthDate.setSelectedIndex(Integer.parseInt(MonthOfBirth));
		cbbYearDate.setSelectedItem(YearOfBirth);

		String DayOpening = datas.get(index).getDayOpening();
		String MonthOpening = datas.get(index).getMonthOpening();
		String YearOpening = datas.get(index).getYearOpening();

		cbbDay.setSelectedItem(DayOpening);
		cbbMonth.setSelectedIndex(Integer.parseInt(MonthOpening));
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
						Image img = image.resize(icon.getImage(), 217, 257);

						ImageIcon resizedIcon = new ImageIcon(img);
						lblimg.setIcon(resizedIcon);

						personalImage = image.toByteArray(img, "jpg");

					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			};
		});

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
		if (Validate()) {
			Code = txtCodeEmplo.getText();
			Name = txtName.getText();
			DayOfBirth = cbbDayDate.getSelectedItem().toString();
			MonthOfBirth = cbbMonthDate.getSelectedItem().toString();
			YearOfBirth = cbbYearDate.getSelectedItem().toString();
			DayBirth = YearOfBirth + MonthOfBirth + DayOfBirth;

			email = txtEmail.getText();
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
	}

	public void Update() {
		getTextField();
		byte[] Img = personalImage;
		if (personalImage == null) {
			Img = datas.get(IndexSelectedEmployee).getImg();
		}

		if (dao.Update(new ModelEmployee(Code, Name, DayBirth, sex, email, Role, Password, DayOpening, Img, Note)) > 0) {
			getDialogPosition();
			question.lblQuestion.setText("Cập nhật");
			question.lblTextMessage.setText("\"Thành công\"");

		} else {
			getDialogPosition();
			question.lblQuestion.setText("Cập nhật");
			question.lblTextMessage.setText("\"Thất bại\"");
		}
		employee.getModelEmployees();
	}

	public void Add() {
		getTextField();
		byte[] Img = personalImage;

		if (lblimg == null) {
			try {
				File file = new File("C:\\Users\\LDAVu\\OneDrive\\Pictures\\default-user.png");
				ImageIcon icon = new ImageIcon(file.getPath());
				Image ig = image.resize(icon.getImage(), 217, 257);
				
				personalImage = image.toByteArray(ig, "jpg");

				if (dao.Insert(new ModelEmployee(Code, Name, DayBirth, sex, email, Role, Password, DayOpening, Img,
						Note)) > 0) {
					getDialogPosition();
					question.lblQuestion.setText("Thêm nhân viên");
					question.lblTextMessage.setText("\"Thành công\"");

				} else {
					getDialogPosition();
					question.lblQuestion.setText("Không thể thêm nhân viên");
					question.lblTextMessage.setText("\"Mã nhân viên đã tồn tại\"");
				}
			} catch (Exception errorImg) {
				System.out.println("Error: " + errorImg.toString());
			}
		} else {
			if (dao.Insert(
					new ModelEmployee(Code, Name, DayBirth, sex, email, Role, Password, DayOpening, Img, Note)) > 0) {
				getDialogPosition();
				question.lblQuestion.setText("Thêm nhân viên");
				question.lblTextMessage.setText("\"Thành công\"");

			} else {
				getDialogPosition();
				question.lblQuestion.setText("Không thể thêm nhân viên");
				question.lblTextMessage.setText("\"Mã nhân viên đã tồn tại\"");
			}
		}
		employee.getModelEmployees();
	}

	public void Delete() {
		CodeEmployee = txtCodeEmplo.getText();
		if (CodeEmployee.equals("")) {
			getDialogPosition();
			question.lblQuestion.setText("Không thể xóa nhân viên");
			question.lblTextMessage.setText("\"Chưa Nhập Mã Nhân Viên Để Xóa\"");
			return;
		}

		getDialogConfirmPosition();
		
		if(confirm.option == 1) {
			for (ModelEmployee data : datas) {
				if(!data.getCodeEmployee().equals(CodeEmployee)) {
					getDialogPosition();
					question.lblQuestion.setText("Xóa nhân viên");
					question.lblTextMessage.setText("\"Mã nhân viên không tồn tại\"");
					
				}else {
					dao.Delete(CodeEmployee);
					getDialogPosition();
					question.lblQuestion.setText("Xóa nhân viên");
					question.lblTextMessage.setText("\"Nhân viên đã được xóa\"");
					ClearForm();
					
				}
			}
		}

		employee.getModelEmployees();
		
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
		g2.setPaint(new Color(60, 60, 60));
		g2.fillRect(0, 20, getSize().width, getSize().height - 20);
		g2.fillRect(45, 1, 142, 19);
		super.paintComponent(g);
	}

	

}
