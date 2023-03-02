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

import animation.AnimationButton;
import dao.LearnerDAO;
import img.img;
import interfaces.IEvent;
import model.ModelLearner;
import view.DialogMessage;
import view.Main;
import view.MainEmployee;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.Dialog.ModalityType;

public class PanelLearnerUpdate extends JPanel {
	private ArrayList<ModelLearner> datas = new ArrayList<ModelLearner>();
	private LearnerDAO dao = new LearnerDAO();
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
	public int indexSelectedLearner = -1;

	private JComboBox cbbYearOfRegister;
	private JComboBox cbbMonthOfRegister;
	private JComboBox cbbDayOfRegister;
	private ButtonGroup buttonGroup;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JTextField txtNumberPhone;
	private JTextArea textAreaNote;
	private AnimationButton btnDelete;
	private AnimationButton btnUpdate;
	private AnimationButton btnAdd;
	private AnimationButton btnNew;
	private AnimationButton btnLast;
	private AnimationButton btnNext;
	private AnimationButton btnPrev;
	private AnimationButton btnFirst;
	private Learner learner;

	private Font fontText15Plain = new Font("SansSerif", Font.PLAIN, 15);
	
	private String code_student_pattern = "^[P]{1}[S]{1}[0-9]{5}$";
	private String name_pattern = "^[a-zA-Z]{3,}$";
	
	private String email_pattern ="^([a-z0-9_\\.-]){2,}+@([\\da-z]){2,}\\.([a-z]){2,}(\\.|[a-z]{2,}){0,}$";
	private String phone_pattern = "^0+[1-9]{1}[0-9]{8}$";
	

	
	private DialogQuestion question = new DialogQuestion(null);
	private DialogConfirm confirm = new DialogConfirm(null);
	
	private JTextField txtCodeEmployee;
	private JLabel lblCodeEmployee;
	private String role;
	
	public PanelLearnerUpdate(Learner learner,String role) {
		this.role = role;
		setOpaque(false);
		this.learner = learner;
		JPanel panel = new JPanel();

		panel.setBackground(new Color(60, 60, 60));

		txtNumberPhone = new JTextField();
		txtNumberPhone.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtNumberPhone.setBorder(null);
		txtNumberPhone.setForeground(new Color(191, 191, 191));
		txtNumberPhone.setBackground(new Color(50, 50, 50));
		txtNumberPhone.setCaretColor(new Color(200, 200, 200));

		textAreaNote = new JTextArea();
		textAreaNote.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textAreaNote.setBorder(null);
		textAreaNote.setForeground(new Color(191, 191, 191));
		textAreaNote.setBackground(new Color(50, 50, 50));
		textAreaNote.setCaretColor(new Color(200, 200, 200));

		JScrollPane scrollPane = new JScrollPane(textAreaNote);
		scrollPane.setOpaque(false);
		scrollPane.setViewportBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);

		JLabel lblLogo = new JLabel("");

		JLabel lblDate = new JLabel("Ngày sinh:");
		lblDate.setForeground(new Color(191, 191, 191));
		lblDate.setFont(new Font("SansSerif", Font.BOLD, 15));

		cbbDay = new JComboBox();
		cbbDay.setBorder(null);
		cbbDay.setOpaque(false);
		cbbDay.setForeground(new Color(60, 60, 60));
		cbbDay.setFont(fontText15Plain);
		cbbDay.setMaximumRowCount(10);

		cbbMonth = new JComboBox();
		cbbMonth.setBorder(null);
		cbbMonth.setOpaque(false);
		cbbMonth.setForeground(new Color(60, 60, 60));
		cbbMonth.setFont(fontText15Plain);
		cbbMonth.setMaximumRowCount(10);

		cbbYear = new JComboBox();
		cbbYear.setBorder(null);
		cbbYear.setOpaque(false);
		cbbYear.setForeground(new Color(60, 60, 60));
		cbbYear.setFont(fontText15Plain);
		cbbYear.setMaximumRowCount(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtEmail.setBorder(null);
		txtEmail.setForeground(new Color(191, 191, 191));
		txtEmail.setBackground(new Color(50, 50, 50));
		txtEmail.setCaretColor(new Color(200, 200, 200));

		JLabel lblPhoneNumber = new JLabel("Số điện thoại:");
		lblPhoneNumber.setForeground(new Color(191, 191, 191));
		lblPhoneNumber.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(191, 191, 191));
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblSex = new JLabel("Giới tính:");
		lblSex.setForeground(new Color(191, 191, 191));
		lblSex.setFont(new Font("SansSerif", Font.BOLD, 15));

		buttonGroup = new ButtonGroup();

		rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setForeground(new Color(191, 191, 191));
		rdbtnMale.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnMale.setBorder(null);
		rdbtnMale.setBackground(new Color(60, 60, 60));

		rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setForeground(new Color(191, 191, 191));
		rdbtnFemale.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnFemale.setBorder(null);
		rdbtnFemale.setBackground(new Color(60, 60, 60));

		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);

		JLabel lblName = new JLabel("Họ và tên:");
		lblName.setForeground(new Color(191, 191, 191));
		lblName.setFont(new Font("SansSerif", Font.BOLD, 15));

		txtName = new JTextField();
		txtName.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtName.setBorder(null);
		txtName.setForeground(new Color(191, 191, 191));
		txtName.setBackground(new Color(50, 50, 50));
		txtName.setCaretColor(new Color(200, 200, 200));

		txtPersonCode = new JTextField();
		txtPersonCode.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtPersonCode.setBorder(null);
		txtPersonCode.setForeground(new Color(191, 191, 191));
		txtPersonCode.setBackground(new Color(50, 50, 50));
		txtPersonCode.setCaretColor(new Color(200, 200, 200));

		JLabel lblCodePerson = new JLabel("Mã người đăng kí:");
		lblCodePerson.setForeground(new Color(191, 191, 191));
		lblCodePerson.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblDateCreate = new JLabel("Ngày đăng kí:");
		lblDateCreate.setForeground(new Color(191, 191, 191));
		lblDateCreate.setFont(new Font("SansSerif", Font.BOLD, 15));

		cbbDayOfRegister = new JComboBox();
		cbbDayOfRegister.setBorder(null);
		cbbDayOfRegister.setOpaque(false);
		cbbDayOfRegister.setForeground(new Color(60, 60, 60));
		cbbDayOfRegister.setFont(fontText15Plain);
		cbbDayOfRegister.setMaximumRowCount(10);
		
		cbbMonthOfRegister = new JComboBox();
		cbbMonthOfRegister.setBorder(null);
		cbbMonthOfRegister.setOpaque(false);
		cbbMonthOfRegister.setForeground(new Color(60, 60, 60));
		cbbMonthOfRegister.setFont(fontText15Plain);
		cbbMonthOfRegister.setMaximumRowCount(10);

		cbbYearOfRegister = new JComboBox();
		cbbYearOfRegister.setBorder(null);
		cbbYearOfRegister.setOpaque(false);
		cbbYearOfRegister.setForeground(new Color(60, 60, 60));
		cbbYearOfRegister.setFont(fontText15Plain);
		cbbYearOfRegister.setMaximumRowCount(10);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		layeredPane.setOpaque(true);
		layeredPane.setBackground(new Color(60, 60, 60));

		btnFirst = new AnimationButton(img.iconFisrt(), "");
		btnFirst.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFirst.setForeground(SystemColor.menu);
		btnFirst.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnFirst.setBorder(null);
		btnFirst.setBackground(new Color(60, 22, 173));

		btnPrev = new AnimationButton(img.iconPrev1(), "");
		btnPrev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPrev.setForeground(SystemColor.menu);
		btnPrev.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnPrev.setBorder(null);
		btnPrev.setBackground(new Color(60, 22, 173));

		btnNext = new AnimationButton(img.iconNext1(), "");
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.setForeground(SystemColor.menu);
		btnNext.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNext.setBorder(null);
		btnNext.setBackground(new Color(60, 22, 173));

		btnLast = new AnimationButton(img.iconLast(), "");
		btnLast.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLast.setForeground(SystemColor.menu);
		btnLast.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnLast.setBorder(null);
		btnLast.setBackground(new Color(60, 22, 173));

		btnNew = new AnimationButton(img.iconNew(), "New");
		btnNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNew.setForeground(SystemColor.menu);
		btnNew.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNew.setBorder(null);
		btnNew.setBackground(new Color(60, 22, 173));

		btnAdd = new AnimationButton(img.iconAdd(), "Add");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setForeground(SystemColor.menu);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(60, 22, 173));

		btnUpdate = new AnimationButton(img.iconEditWhite(), "Update");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setForeground(SystemColor.menu);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(60, 22, 173));

		btnDelete = new AnimationButton(img.iconDeleteWhite(), "Delete");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setForeground(SystemColor.menu);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(60, 22, 173));
		
		if(role == "Employee") {
			btnDelete.setVisible(false);
		}
		
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addContainerGap(225, Short.MAX_VALUE)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNext, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdate, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(221, Short.MAX_VALUE))
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(41))
		);
		layeredPane.setLayout(gl_layeredPane);
		
		JLabel lbldescribe = new JLabel("Ghi chú:");
		lbldescribe.setForeground(new Color(191, 191, 191));
		lbldescribe.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		txtCodeEmployee = new JTextField();
		txtCodeEmployee.setForeground(new Color(191, 191, 191));
		txtCodeEmployee.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtCodeEmployee.setCaretColor(SystemColor.scrollbar);
		txtCodeEmployee.setBorder(null);
		txtCodeEmployee.setBackground(new Color(50, 50, 50));
		
		lblCodeEmployee = new JLabel("Mã nhân viên");
		lblCodeEmployee.setForeground(new Color(191, 191, 191));
		lblCodeEmployee.setFont(new Font("SansSerif", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblSex, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDate)
												.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
											.addGap(385))
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(rdbtnMale)
												.addGroup(gl_panel.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(cbbDay, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
													.addGap(4)
													.addComponent(cbbMonth, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(cbbYear, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
												.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
											.addGap(224)))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(31)
											.addComponent(cbbDayOfRegister, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cbbMonthOfRegister, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cbbYearOfRegister, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblDateCreate, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
								.addComponent(lblName)
								.addComponent(lblCodePerson, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
							.addGap(307))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(53)
							.addComponent(txtPersonCode, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(53)
							.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(53)
							.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(54)
							.addComponent(txtNumberPhone, GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lbldescribe, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPhoneNumber)
								.addComponent(lblCodeEmployee, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
							.addGap(869)))
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addComponent(txtCodeEmployee, GroupLayout.PREFERRED_SIZE, 974, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(42, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 973, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(8)
					.addComponent(lblCodePerson, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPersonCode, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateCreate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbDayOfRegister, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbYearOfRegister, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbMonthOfRegister, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSex, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnMale)
						.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNumberPhone, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addComponent(lblCodeEmployee, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCodeEmployee, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbldescribe, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1025, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 587, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		initFillComboboxDate();
		Action();
	}

	public void initFillComboboxDate() {
		cbbModelDay = new DefaultComboBoxModel();
		String[] comboboxDay = new String[] { "Ngày", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
				"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
				"29", "30", "31" };
		for (String string : comboboxDay) {
			cbbModelDay.addElement(string);
		}
		cbbDay.setModel(cbbModelDay);

		cbbModelMonth = new DefaultComboBoxModel();
		String[] comboboxMonth = new String[] { "Tháng", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12" };
		for (String string : comboboxMonth) {
			cbbModelMonth.addElement(string);
		}
		cbbMonth.setModel(cbbModelMonth);

		cbbModelYear = new DefaultComboBoxModel();
		String[] comboboxYear = new String[] { "Năm", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997",
				"1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010",
				"2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022",
				"2023" };
		for (String string : comboboxYear) {
			cbbModelYear.addElement(string);
		}
		cbbYear.setModel(cbbModelYear);

		cbbModelDayCreate = new DefaultComboBoxModel();
		String[] comboboxDayCreate = new String[] { "Ngày", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31" };
		for (String string : comboboxDayCreate) {
			cbbModelDayCreate.addElement(string);
		}
		cbbDayOfRegister.setModel(cbbModelDayCreate);

		cbbModelMonthCreate = new DefaultComboBoxModel();
		String[] comboboxMonthCreate = new String[] { "Tháng", "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12" };
		for (String string : comboboxMonthCreate) {
			cbbModelMonthCreate.addElement(string);
		}
		cbbMonthOfRegister.setModel(cbbModelMonthCreate);

		cbbModelYearCreate = new DefaultComboBoxModel();
		String[] comboboxYearCreate = new String[] { "Năm", "1990", "1991", "1992", "1993", "1994", "1995", "1996",
				"1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
				"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022",
				"2023" };
		for (String string : comboboxYearCreate) {
			cbbModelYearCreate.addElement(string);
		}
		cbbYearOfRegister.setModel(cbbModelYearCreate);

		IEvent<ArrayList<ModelLearner>> event = this::OnModelLearnerChanged;
		learner.ModelLearnerChanged.subscribe(event);
	}

	public void OnModelLearnerChanged(Object source, ArrayList<ModelLearner> eventArgs) {
		datas = eventArgs;
	}

	public void Display(int index) {
		String Code = datas.get(index).getPersonCode();
		String Name = datas.get(index).getName();
		String Phone = datas.get(index).getPhoneNumber();
		String Note = datas.get(index).getNote();
		boolean Sex = datas.get(index).isSex();
		String Email = datas.get(index).getEmail();
		String codeEmployee = datas.get(index).getEmployeeCode();
		
		
		txtPersonCode.setText(Code);
		txtName.setText(Name);
		txtNumberPhone.setText(Phone);
		txtEmail.setText(Email);
		
		txtCodeEmployee.setText(codeEmployee);
		
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
		cbbYear.setSelectedItem(YearOfBirth);

		String DayOfRegister = datas.get(index).getDayOfRegister();
		String MonthOfRegister = datas.get(index).getMonthOfRegister();
		String YearOfRegister = datas.get(index).getYearOfRegister();

		cbbDayOfRegister.setSelectedIndex(Integer.parseInt(DayOfRegister));
		cbbMonthOfRegister.setSelectedIndex(Integer.parseInt(MonthOfRegister));
		cbbYearOfRegister.setSelectedItem(YearOfRegister);

	}
	
	public void getDialogPosition() {
		if(Main.role == "Manager") {
			question.setLocation(Main.xScreen, Main.yScreen);
			question.setVisible(true);
		}else if(MainEmployee.role == "Employee") {
			question.setLocation(MainEmployee.xScreen, MainEmployee.yScreen);
			question.setVisible(true);
		}
	}

	public void getDialogConfirmPostiton() {
		if(Main.role == "Manager") {
			confirm.setLocation(Main.xScreen, Main.yScreen);
			confirm.setModalityType(ModalityType.APPLICATION_MODAL);
			confirm.setVisible(true);
		}else if(MainEmployee.role == "Employee") {
			confirm.setLocation(MainEmployee.xScreen, MainEmployee.yScreen);
			confirm.setModalityType(ModalityType.APPLICATION_MODAL);
			confirm.setVisible(true);
		}
	}
	
	
	
	public boolean Validate() {
		if(txtPersonCode.getText().equals("")) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Mã người học\"");
			return false;
		}
		
		if(!txtPersonCode.getText().matches(code_student_pattern)) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Mã người học đúng định dạng\"");
			return false;
		}
	
		
		if(txtName.getText().equals("")) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Tên người học\"");
			return false;
		}
		
	
		if(!txtName.getText().matches(name_pattern)) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Tên người học không phải số\"");
			return false;
		}
		
		if(cbbDay.getSelectedIndex() == 0) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Ngày sinh\"");
			return false;
		}
		
		if(cbbMonth.getSelectedIndex() == 0) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Tháng sinh\"");
			return false;
		}
		
		if(cbbYear.getSelectedIndex() == 0) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Năm sinh\"");
			return false;
		}
		
		if(cbbDayOfRegister.getSelectedIndex() == 0) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Ngày đăng kí\"");
			return false;
		}
		
		if(cbbMonthOfRegister.getSelectedIndex() == 0) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Tháng đăng kí\"");
			return false;
		}
		
		if(cbbYearOfRegister.getSelectedIndex() == 0) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Năm đăng kí\"");
			return false;
		}
		
		if(!rdbtnMale.isSelected() && !rdbtnFemale.isSelected()) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng chọn");
			question.lblTextMessage.setText("\"Giới tính\"");
			return false;
		}
		
		if(txtEmail.getText().equals("")) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Email người học\"");
			return false;
		}
		
		if(!txtEmail.getText().matches(email_pattern)) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Email đúng định dạng\"");
			return false;
		}
		
		String mail = txtEmail.getText();
		int atIndex = mail.indexOf("@")+1;

		if(!mail.substring(atIndex, mail.length()).equals("tt.edu.vn")) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Email đúng định dạng\"");
			return false;
		}
		
		
		if(txtNumberPhone.getText().equals("")) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Số điện thoại\"");
			return false;
		}
		
		if(!txtNumberPhone.getText().matches(phone_pattern)) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Số điện thoại đúng định dạng\"");
			return false;
		}
		
		if(txtCodeEmployee.getText().equals("")) {
			getDialogPosition();
			question.lblQuestion.setText("Vui lòng nhập");
			question.lblTextMessage.setText("\"Mã nhân viên\"");
			return false;
		}
		
		return true;
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
	}

	public void Add() {
		if(Validate()) {
			String personCode = txtPersonCode.getText();
			String name = txtName.getText();
			
			String dayOfBirth = cbbYear.getSelectedItem().toString() + cbbMonth.getSelectedItem().toString() + cbbDay.getSelectedItem().toString();
			
			String dayOfRegister = cbbYearOfRegister.getSelectedItem().toString() + cbbMonthOfRegister.getSelectedItem().toString() + cbbDayOfRegister.getSelectedItem().toString();
			
			boolean gender =true;
			
			if(rdbtnMale.isSelected()) {
				gender = true;
			}else {
				gender = false;
			}
			
			String email = txtEmail.getText();
			String phoneNumber = txtNumberPhone.getText();
			String employeeCode = txtCodeEmployee.getText();
			
			String note = textAreaNote.getText();
			
			if(dao.Insert(new ModelLearner(personCode, name, dayOfBirth, gender, phoneNumber, email, dayOfRegister,employeeCode, note))>0){
				getDialogPosition();
				question.lblQuestion.setText("Thêm người học");
				question.lblTextMessage.setText("\"Thành công\"");
			}else {
				question.lblQuestion.setText("Thêm người học");
				question.lblTextMessage.setText("\"Thất bại vui lòng kiểm tra lại\"");
			}
			learner.getModelLearner();
			
		}
	}
	
	public void Update() {
		if(Validate()) {
			String personCode = txtPersonCode.getText();
			String name = txtName.getText();
			
			String dayOfBirth = cbbYear.getSelectedItem().toString() + cbbMonth.getSelectedItem().toString() + cbbDay.getSelectedItem().toString();
			
			String dayOfRegister = cbbYearOfRegister.getSelectedItem().toString() + cbbMonthOfRegister.getSelectedItem().toString() + cbbDayOfRegister.getSelectedItem().toString();
			
			boolean gender =true;
			
			if(rdbtnMale.isSelected()) {
				gender = true;
			}else {
				gender = false;
			}
			
			String email = txtEmail.getText();
			String phoneNumber = txtNumberPhone.getText();
			String employeeCode = txtCodeEmployee.getText();
			
			String note = textAreaNote.getText();
			
			
			if(dao.Update(new ModelLearner(personCode, name, dayOfBirth, gender, phoneNumber, email, dayOfRegister, employeeCode, note))>0) {
				getDialogPosition();
				question.lblQuestion.setText("Cập nhật người học");
				question.lblTextMessage.setText("\"Thành công\"");
			}else {
				question.lblQuestion.setText("Cập nhật người học");
				question.lblTextMessage.setText("\"Thất bại\"");
			}
			learner.getModelLearner();
		}
		
	}
	
	public void Delete() {
		String personCode = txtPersonCode.getText();
		if(personCode.equals("")) {
			getDialogPosition();
			question.lblQuestion.setText("Không thể xóa người học");
			question.lblTextMessage.setText("\"Chưa Nhập Mã Người Học Để Xóa\"");
			return;		
		}
		getDialogConfirmPostiton();
		
		if(confirm.option ==1) {
			for (ModelLearner data : datas) {
				if(data.getPersonCode().equals(personCode)) {
					dao.Delete(personCode);
					getDialogPosition();
					question.lblQuestion.setText("Xóa người học");
					question.lblTextMessage.setText("\"Thành công\"");
					ClearForm();			
					break;
				}else {
					getDialogPosition();
					question.lblQuestion.setText("Không thể xóa người học");
					question.lblTextMessage.setText("\"Mã người học không tồn tại\"");
				}
			}
		}
		learner.getModelLearner();
	}
	
	public void ClearForm() {
		buttonGroup.clearSelection();
		txtPersonCode.setText("");
		txtName.setText("");
		txtNumberPhone.setText("");
		txtEmail.setText("");
		txtCodeEmployee.setText("");
		textAreaNote.setText("");

		cbbDay.setSelectedIndex(0);
		cbbMonth.setSelectedIndex(0);
		cbbYear.setSelectedIndex(0);

		cbbDayOfRegister.setSelectedIndex(0);
		cbbMonthOfRegister.setSelectedIndex(0);
		cbbYearOfRegister.setSelectedIndex(0);
	}

	public void First() {
		btnNext.setEnabled(true);
		btnPrev.setEnabled(false);
		indexSelectedLearner = 0;
		Display(indexSelectedLearner);
	}

	public void Prev() {
		if (indexSelectedLearner > 0) {
			indexSelectedLearner--;
			if (indexSelectedLearner == 0) {
				btnNext.setEnabled(true);
				btnPrev.setEnabled(false);
			} else {
				btnNext.setEnabled(true);
				btnPrev.setEnabled(true);
			}
		}
		Display(indexSelectedLearner);
	}

	public void Next() {
		if (indexSelectedLearner < datas.size() - 1) {
			indexSelectedLearner++;
			if (indexSelectedLearner == datas.size() - 1) {
				btnNext.setEnabled(false);
				btnPrev.setEnabled(true);
			} else {
				btnNext.setEnabled(true);
				btnPrev.setEnabled(true);
			}
		}
		Display(indexSelectedLearner);
	}

	public void Last() {
		btnNext.setEnabled(false);
		btnPrev.setEnabled(true);
		indexSelectedLearner = datas.size() - 1;
		Display(indexSelectedLearner);
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
