package view2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.ManagerStudentController;
import controller.PanelManagerStudentController;
import dao.ManagerStudentDAO;
import dao.PanelManagerStudentDAO;
import img.img;
import model.ManagerStudentModel;

public class PanelStudent extends JPanel {
	private DefaultTableModel tableModel;
	private JPanel contentPane;
	private JTextField textFieldCode;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTable table;
	private JTextArea jTextAreaAddress;
	private int index = -1;
	private boolean _cal = true;
	private ButtonGroup buttonGroup;
	private img img = new img(this);
	private PanelManagerStudentDAO managerStudentDAO = new PanelManagerStudentDAO(this);
	private PanelManagerStudentController controller = new PanelManagerStudentController(this);
	private String PhoneNumber = "^0[1-9]{1}[\\d]{8}$";
	private String Email = "^([a-z0-9_\\.-]){2,}+@([\\da-z]){2,}\\.([a-z]){2,}(\\.|[a-z]{2,}){0,}$";
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnMale;
	private JLabel jLabelImg;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JLabel lblAddress;
	private JLabel lblCode1;
	private JLabel lblName;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblSex;
	private JLabel lblExit;
	private JLabel lblRoleAdmin;
	private JLabel lblRole;
	private JButton btnNew;
	private JLabel Roles;
	private String Role;

	public PanelStudent(String role) {
		this.Role = role;
		this.setPreferredSize(new Dimension(984, 668));
		this.setVisible(false);
		this.setBackground(SystemColor.control);
		this.setBorder(null);
		this.setForeground(new Color(0, 0, 128));
		this.setBounds(215, 32, 984, 668);

		this.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý Sinh Viên");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBounds(332, 11, 225, 25);
		this.add(lblNewLabel);

		textFieldPhone = new JTextField();
		textFieldPhone.setBorder(new LineBorder(SystemColor.windowBorder));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(221, 201, 239, 25);
		this.add(textFieldPhone);

		buttonGroup = new ButtonGroup();

		table = new JTable();
		table.setShowGrid(false);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		table.setForeground(SystemColor.controlShadow);

		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(29, 449, 945, 208);
		this.add(scrollPane_1);

		JPanel panelmg = new JPanel();
		panelmg.setBackground(Color.WHITE);
		panelmg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelmg.setBounds(546, 60, 135, 189);
		panelmg.setLayout(null);
		jLabelImg = new JLabel();
		jLabelImg.setBorder(new LineBorder(SystemColor.windowBorder));
		jLabelImg.setBounds(0, 0, 135, 189);
		panelmg.add(jLabelImg);

		this.add(panelmg);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(SystemColor.control);
		panel.setBounds(491, 330, 233, 77);
		this.add(panel);
		panel.setLayout(new GridLayout(2, 2, 5, 5));

		btnNew = new JButton("New");
		btnNew.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNew.setIcon(this.img.ImageNew());
		btnNew.addActionListener(controller);
		panel.add(btnNew);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnSave.setIcon(this.img.ImageSave());
		btnSave.addActionListener(controller);
		panel.add(btnSave);

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDelete.setIcon(this.img.ImageDelete());
		btnDelete.addActionListener(controller);
		panel.add(btnDelete);

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnUpdate.setIcon(this.img.ImageEdit());
		btnUpdate.addActionListener(controller);
		panel.add(btnUpdate);

		lblCode1 = new JLabel("");
		lblCode1.setForeground(Color.RED);
		lblCode1.setBackground(Color.WHITE);
		lblCode1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCode1.setBounds(221, 90, 238, 20);
		this.add(lblCode1);

		lblName = new JLabel("");
		lblName.setForeground(Color.RED);
		lblName.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblName.setBackground(Color.WHITE);
		lblName.setBounds(221, 135, 239, 20);
		this.add(lblName);

		lblEmail = new JLabel("");
		lblEmail.setForeground(Color.RED);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(221, 180, 239, 20);
		this.add(lblEmail);

		lblPhone = new JLabel("");
		lblPhone.setForeground(Color.RED);
		lblPhone.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblPhone.setBackground(Color.WHITE);
		lblPhone.setBounds(221, 227, 239, 20);
		this.add(lblPhone);

		lblAddress = new JLabel("");
		lblAddress.setForeground(Color.RED);
		lblAddress.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblAddress.setBackground(Color.WHITE);
		lblAddress.setBounds(221, 378, 239, 20);
		this.add(lblAddress);

		lblSex = new JLabel("");
		lblSex.setForeground(Color.RED);
		lblSex.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblSex.setBackground(Color.WHITE);
		lblSex.setBounds(221, 276, 239, 20);
		this.add(lblSex);

		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(SystemColor.window);
		panelCenter.setBounds(113, 46, 368, 361);
		add(panelCenter);
		panelCenter.setLayout(null);

		JLabel lblCode = new JLabel("Mã SV:");
		lblCode.setBounds(40, 27, 57, 14);
		panelCenter.add(lblCode);
		lblCode.setForeground(new Color(105, 105, 105));
		lblCode.setBackground(SystemColor.window);
		lblCode.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		textFieldCode = new JTextField();
		textFieldCode.setBounds(107, 20, 239, 25);
		panelCenter.add(textFieldCode);
		textFieldCode.setBorder(new LineBorder(SystemColor.windowBorder));
		textFieldCode.setColumns(10);

		JLabel lblHTn = new JLabel("Họ Tên:");
		lblHTn.setBounds(32, 70, 57, 17);
		panelCenter.add(lblHTn);
		lblHTn.setForeground(new Color(105, 105, 105));
		lblHTn.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		textFieldName = new JTextField();
		textFieldName.setBounds(107, 65, 239, 25);
		panelCenter.add(textFieldName);
		textFieldName.setBorder(new LineBorder(SystemColor.windowBorder));
		textFieldName.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(107, 110, 239, 25);
		panelCenter.add(textFieldEmail);
		textFieldEmail.setBorder(new LineBorder(SystemColor.windowBorder));
		textFieldEmail.setColumns(10);

		JLabel lblCode_1_1 = new JLabel("Email:");
		lblCode_1_1.setBounds(42, 108, 46, 14);
		panelCenter.add(lblCode_1_1);
		lblCode_1_1.setForeground(new Color(105, 105, 105));
		lblCode_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JLabel lblCode_1_2 = new JLabel("Số ĐT:");
		lblCode_1_2.setBounds(40, 158, 46, 14);
		panelCenter.add(lblCode_1_2);
		lblCode_1_2.setForeground(new Color(105, 105, 105));
		lblCode_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JLabel lblCode_1_3 = new JLabel("Giới Tính:");
		lblCode_1_3.setBounds(19, 212, 67, 14);
		panelCenter.add(lblCode_1_3);
		lblCode_1_3.setForeground(new Color(105, 105, 105));
		lblCode_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setBounds(107, 208, 65, 25);
		panelCenter.add(rdbtnMale);
		rdbtnMale.setForeground(new Color(105, 105, 105));
		rdbtnMale.setBackground(SystemColor.window);
		rdbtnMale.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonGroup.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setBounds(177, 208, 55, 25);
		panelCenter.add(rdbtnFemale);
		rdbtnFemale.setForeground(new Color(105, 105, 105));
		rdbtnFemale.setBackground(SystemColor.window);
		rdbtnFemale.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonGroup.add(rdbtnFemale);

		JLabel lblCode_1_3_1 = new JLabel("Địa Chỉ:");
		lblCode_1_3_1.setBounds(29, 256, 57, 14);
		panelCenter.add(lblCode_1_3_1);
		lblCode_1_3_1.setBackground(UIManager.getColor("Button.disabledForeground"));
		lblCode_1_3_1.setForeground(new Color(105, 105, 105));
		lblCode_1_3_1.setFont(new Font("SansSerif", Font.PLAIN, 15));

		jTextAreaAddress = new JTextArea();
		jTextAreaAddress.setBorder(new LineBorder(SystemColor.windowBorder));
		jTextAreaAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane(jTextAreaAddress);
		scrollPane.setBounds(106, 255, 240, 77);
		panelCenter.add(scrollPane);

		table();

	}

	public void table() {
		table.setShowHorizontalLines(true);
		table.setRowHeight(30);
		table.addMouseListener(controller);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setFont(new Font("SanSerif", Font.BOLD, 14));
		Init();
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setBorder(noFocusBorder);
				com.setForeground(new Color(102, 102, 102));
				if (isSelected) {
					com.setBackground(Color.decode("#d1ccc0"));

				} else {
					com.setBackground(Color.white);
				}

				return com;
			}

		});
	}

	public void Init() {
		tableModel = new DefaultTableModel();
		String[] cols = new String[] { "MÃ SV", "HỌ TÊN", "EMAIL", "SỐ ĐT", "GIỚI TÍNH", "ĐỊA CHỈ", "HÌNH" };
		tableModel.setColumnIdentifiers(cols);
		table.setModel(tableModel);
		FillTable();
		index = 0;
		FocusTable(index);
		String Code = this.table.getValueAt(index, 0).toString();
		this.managerStudentDAO.LoadData(Code);
		this.btnSave.setEnabled(true);
		setImage();
	}

	public void setImage() {
		index = this.table.getSelectedRow();
		String Img = this.table.getValueAt(index, 6).toString();
		String img = this.managerStudentDAO.LoadImage(Img);

		if (img.equals("hoang.png")) {
			this.jLabelImg.setIcon(this.img.ImageHoang());
		} else if (img.equals("ha.png")) {
			this.jLabelImg.setIcon(this.img.ImageHa());
		} else if (img.equals("linh.png")) {
			this.jLabelImg.setIcon(this.img.ImageLinh());
		} else if (img.equals("nhan.png")) {
			this.jLabelImg.setIcon(this.img.ImageNhan());
		} else if (img.equals("hieu.png")) {
			this.jLabelImg.setIcon(this.img.ImageHieu());
		} else if (img.equals("user.png")) {
			this.jLabelImg.setIcon(this.img.ImageUser());
		}

	}

	public void ClearForm() {
		this.textFieldCode.setText("");
		this.textFieldName.setText("");
		this.textFieldEmail.setText("");
		this.textFieldPhone.setText("");
		this.buttonGroup.clearSelection();
		this.jTextAreaAddress.setText("");
		this.lblCode1.setText("");
		this.lblName.setText("");
		this.lblEmail.setText("");
		this.lblPhone.setText("");
		this.lblSex.setText("");
		this.lblAddress.setText("");
		this.table.setRowSelectionAllowed(false);
		this.btnDelete.setEnabled(false);
		this.btnUpdate.setEnabled(false);
		this.btnSave.setEnabled(true);
		this.jLabelImg.setIcon(this.img.ImageWhite());
		this.textFieldCode.requestFocus();
		_cal = false;
	}

	public boolean Validate() {
		String Code = this.textFieldCode.getText();
		String Name = this.textFieldName.getText();
		String email = this.textFieldEmail.getText();
		String Phone = this.textFieldPhone.getText();
		boolean Male = this.rdbtnMale.isSelected();
		boolean Female = this.rdbtnFemale.isSelected();
		String Address = this.jTextAreaAddress.getText();
		if (Code.equals("")) {
			this.lblCode1.setText("<Chưa nhập mã sinh viên>");
		} else {
			this.lblCode1.setText("");
		}
		if (Name.equals("")) {
			this.lblName.setText("<Chưa nhập tên sinh viên>");
		} else {
			this.lblName.setText("");
		}
		if (email.equals("")) {
			this.lblEmail.setText("<Chưa nhập Email>");
		} else if (email.length() > 0 && !email.matches(Email)) {
			this.lblEmail.setText("<Email nhập sai định dạng>");
		} else {
			this.lblEmail.setText("");
		}
		if (Phone.equals("")) {
			this.lblPhone.setText("<Chưa nhập số điện thoại>");
		} else if (Phone.length() > 0 && !Phone.matches(PhoneNumber)) {
			this.lblPhone.setText("<Điện thoại nhập sai định dạng>");
		} else {
			this.lblPhone.setText("");
		}
		if (Male == false && Female == false) {
			this.lblSex.setText("<Chưa chọn giới tính>");
		} else {
			this.lblSex.setText("");
		}
		if (Address.equals("")) {
			this.lblAddress.setText("<Chưa nhập địa chỉ>");
		} else {
			this.lblAddress.setText("");
		}
		if (this.lblCode1.getText().equals("") && this.lblName.getText().equals("")
				&& this.lblEmail.getText().equals("") && this.lblPhone.getText().equals("")
				&& this.lblSex.getText().equals("") && this.lblAddress.getText().equals("")) {
			return true;
		}

		return false;
	}

	public void FillTable() {
		this.tableModel.setRowCount(0);
		for (ManagerStudentModel datas : this.managerStudentDAO.SelectAll()) {
			Object[] rows = new Object[7];
			rows[0] = datas.getCode();
			rows[1] = datas.getName();
			rows[2] = datas.getEmail();
			rows[3] = datas.getPhoneNumber();
			rows[4] = datas.isSex();
			rows[5] = datas.getAddress();
			rows[6] = datas.getImg();
			for (int i = 0; i < rows.length; i++) {
				if (i == 4) {
					if (datas.isSex()) {
						rows[4] = "Nam";
					} else {
						rows[4] = "Nữ";
					}
				}
			}
			this.tableModel.addRow(rows);
		}
	}

	public void Save() {
		if (Validate()) {
			String Code = this.textFieldCode.getText();
			String Name = this.textFieldName.getText();
			String Email = this.textFieldEmail.getText();
			String Phone = this.textFieldPhone.getText();
			boolean Choose = this.rdbtnMale.isSelected();
			String Address = this.jTextAreaAddress.getText();
			String img = "user.png";
			ManagerStudentModel msm = new ManagerStudentModel(Code, Name, Email, Phone, Choose, Address, img);
			if (this.managerStudentDAO.Insert(msm)) {
				JOptionPane.showMessageDialog(this, "Insert Succesfully");
				FillTable();
				this.lblCode1.setText("");
				index = this.table.getRowCount() - 1;
				this.btnSave.setEnabled(false);
				this.btnDelete.setEnabled(true);
				this.btnUpdate.setEnabled(true);
				FocusTable(index);

			} else {
				JOptionPane.showMessageDialog(this, "Insert Failed");
				this.lblCode1.setText("<Mã sinh viên không được trùng>");
				this.textFieldCode.requestFocus();
			}
		}

	}

	public void Delete() {
		index = this.table.getSelectedRow();
		String Code = this.table.getValueAt(index, 0).toString();

		int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Chắn Muốn Xóa Không", "Message",
				JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			if (this.managerStudentDAO.Delete(Code) > 0) {
				JOptionPane.showMessageDialog(this, "Delete Succesfully");
				FillTable();
				ClearForm();
			} else {
				JOptionPane.showMessageDialog(this, "Delete Succesfully");
			}
		}

	}

	public void Update() {
		index = this.table.getSelectedRow();
		String Code = this.table.getValueAt(index, 0).toString();
		String Name = this.textFieldName.getText().trim();
		String Email = this.textFieldEmail.getText().trim();
		String PhoneNumber = this.textFieldPhone.getText().trim();
		boolean Sex = this.rdbtnMale.isSelected();
		String Address = this.jTextAreaAddress.getText().trim();
		String Img = this.table.getValueAt(index, 6).toString().trim();
		if (this.managerStudentDAO.Update(Code, Name, Email, PhoneNumber, Sex, Address, Img) > 0) {
			JOptionPane.showMessageDialog(this, "Update Succesfully");
			FillTable();
			FocusTable(index);
		} else {
			JOptionPane.showMessageDialog(this, "Update Failed");
		}

	}

	public void Click() {
		index = this.table.getSelectedRow();
		String Code = this.table.getValueAt(index, 0).toString();
		this.managerStudentDAO.LoadData(Code);
		setImage();
		_cal = true;
		if (Role.equals("Admin")) {
			this.btnSave.setEnabled(false);
			this.btnDelete.setEnabled(true);
			this.btnUpdate.setEnabled(true);
		} else if (Role.equals("User")) {
			this.btnSave.setEnabled(false);
			this.btnDelete.setEnabled(false);
			this.btnUpdate.setEnabled(false);
		}

		this.table.setRowSelectionAllowed(true);
	}

	public void FocusTable(int index) {
		this.table.setRowSelectionAllowed(true);
		this.table.setRowSelectionInterval(index, index);
		setImage();
	}

	public JTextField getTextFieldCode() {
		return textFieldCode;
	}

	public void setTextFieldCode(JTextField textFieldCode) {
		this.textFieldCode = textFieldCode;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public void setTextFieldName(JTextField textFieldName) {
		this.textFieldName = textFieldName;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public void setTextFieldEmail(JTextField textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}

	public JTextField getTextFieldPhone() {
		return textFieldPhone;
	}

	public void setTextFieldPhone(JTextField textFieldPhone) {
		this.textFieldPhone = textFieldPhone;
	}

	public JTextArea getjTextAreaAddress() {
		return jTextAreaAddress;
	}

	public void setjTextAreaAddress(JTextArea jTextAreaAddress) {
		this.jTextAreaAddress = jTextAreaAddress;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public void setButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}

	public JRadioButton getRdbtnFemale() {
		return rdbtnFemale;
	}

	public void setRdbtnFemale(JRadioButton rdbtnFemale) {
		this.rdbtnFemale = rdbtnFemale;
	}

	public JLabel getjLabelImg() {
		return jLabelImg;
	}

	public void setjLabelImg(JLabel jLabelImg) {
		this.jLabelImg = jLabelImg;
	}

	public JRadioButton getRdbtnMale() {
		return rdbtnMale;
	}

	public void setRdbtnMale(JRadioButton rdbtnMale) {
		this.rdbtnMale = rdbtnMale;
	}

	public JLabel getLblRole() {
		return lblRole;
	}

	public void setLblRole(JLabel lblRole) {
		this.lblRole = lblRole;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public JButton getBtnNew() {
		return btnNew;
	}

	public void setBtnNew(JButton btnNew) {
		this.btnNew = btnNew;
	}

	public JLabel getRoles() {
		return Roles;
	}

	public void setRoles(JLabel roles) {
		Roles = roles;
	}

}
