package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ManagerStudentController;
import dao.ManagerStudentDAO;
import img.img;
import model.ManagerStudentModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class ManagerStudentView extends JFrame {
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
	private ManagerStudentDAO managerStudentDAO = new ManagerStudentDAO(this);
	private ManagerStudentController controller = new ManagerStudentController(this);
	private img img = new img(this);
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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ManagerStudentView frame = new ManagerStudentView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManagerStudentView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý Sinh Viên");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBounds(347, 25, 225, 25);
		contentPane.add(lblNewLabel);

		JLabel lblCode = new JLabel("Mã SV:");
		lblCode.setForeground(SystemColor.window);
		lblCode.setBackground(SystemColor.window);
		lblCode.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCode.setBounds(152, 66, 57, 14);
		contentPane.add(lblCode);

		JLabel lblHTn = new JLabel("Họ Tên:");
		lblHTn.setForeground(SystemColor.window);
		lblHTn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblHTn.setBounds(146, 115, 57, 17);
		contentPane.add(lblHTn);

		JLabel lblCode_1_1 = new JLabel("Email:");
		lblCode_1_1.setForeground(SystemColor.window);
		lblCode_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCode_1_1.setBounds(159, 159, 46, 14);
		contentPane.add(lblCode_1_1);

		JLabel lblCode_1_2 = new JLabel("Số ĐT:");
		lblCode_1_2.setForeground(SystemColor.window);
		lblCode_1_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCode_1_2.setBounds(158, 205, 46, 14);
		contentPane.add(lblCode_1_2);

		JLabel lblCode_1_3 = new JLabel("Giới Tính:");
		lblCode_1_3.setForeground(SystemColor.window);
		lblCode_1_3.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCode_1_3.setBounds(136, 257, 67, 14);
		contentPane.add(lblCode_1_3);

		JLabel lblCode_1_3_1 = new JLabel("Địa Chỉ:");
		lblCode_1_3_1.setForeground(SystemColor.window);
		lblCode_1_3_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCode_1_3_1.setBounds(149, 295, 57, 14);
		contentPane.add(lblCode_1_3_1);

		textFieldCode = new JTextField();
		textFieldCode.setBorder(new LineBorder(new Color(0, 0, 139)));
		textFieldCode.setBounds(221, 60, 239, 25);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);

		textFieldName = new JTextField();
		textFieldName.setBorder(new LineBorder(new Color(0, 0, 139)));
		textFieldName.setColumns(10);
		textFieldName.setBounds(221, 107, 239, 25);
		contentPane.add(textFieldName);

		textFieldEmail = new JTextField();
		textFieldEmail.setBorder(new LineBorder(new Color(0, 0, 139)));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(221, 152, 239, 25);
		contentPane.add(textFieldEmail);

		textFieldPhone = new JTextField();
		textFieldPhone.setBorder(new LineBorder(new Color(0, 0, 139)));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(221, 198, 239, 25);
		contentPane.add(textFieldPhone);

		rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setForeground(SystemColor.window);
		rdbtnMale.setBackground(new Color(255, 140, 0));
		rdbtnMale.setFont(new Font("Segoe UI", Font.BOLD, 15));
		rdbtnMale.setBounds(221, 252, 65, 25);
		contentPane.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setForeground(SystemColor.window);
		rdbtnFemale.setBackground(new Color(255, 140, 0));
		rdbtnFemale.setFont(new Font("Segoe UI", Font.BOLD, 15));
		rdbtnFemale.setBounds(288, 252, 55, 25);
		contentPane.add(rdbtnFemale);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);

		jTextAreaAddress = new JTextArea();
		jTextAreaAddress.setBorder(new LineBorder(new Color(0, 0, 139)));
		jTextAreaAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane(jTextAreaAddress);
		scrollPane.setBounds(221, 296, 240, 77);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(controller);
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBorder(new LineBorder(new Color(0, 0, 139)));
		scrollPane_1.setBounds(136, 401, 648, 150);
		contentPane.add(scrollPane_1);

		JPanel panelmg = new JPanel();
		panelmg.setBackground(Color.WHITE);
		panelmg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelmg.setBounds(546, 60, 135, 189);
		panelmg.setLayout(null);
		jLabelImg = new JLabel();
		jLabelImg.setBorder(new LineBorder(new Color(0, 0, 139)));
		jLabelImg.setBounds(0, 0, 135, 189);
		panelmg.add(jLabelImg);
		jLabelImg.setIcon(this.img.ImageWhite());
		contentPane.add(panelmg);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 139)));
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(491, 296, 233, 77);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 2, 5, 5));

		btnNew = new JButton("New", this.img.ImageNew());
		btnNew.setFont(new Font("Segoe UI", Font.BOLD, 15));
		panel.add(btnNew);

		btnSave = new JButton("Save", this.img.ImageSave());
		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 15));
		panel.add(btnSave);

		btnDelete = new JButton("Delete", this.img.ImageDelete());
		btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 15));
		panel.add(btnDelete);

		btnUpdate = new JButton("Update", this.img.ImageUpdate());
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 15));
		panel.add(btnUpdate);

		lblCode1 = new JLabel("");
		lblCode1.setForeground(Color.RED);
		lblCode1.setBackground(Color.WHITE);
		lblCode1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCode1.setBounds(221, 88, 238, 18);
		contentPane.add(lblCode1);

		lblName = new JLabel("");
		lblName.setForeground(Color.RED);
		lblName.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblName.setBackground(Color.WHITE);
		lblName.setBounds(221, 134, 239, 18);
		contentPane.add(lblName);

		lblEmail = new JLabel("");
		lblEmail.setForeground(Color.RED);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(221, 179, 239, 18);
		contentPane.add(lblEmail);

		lblPhone = new JLabel("");
		lblPhone.setForeground(Color.RED);
		lblPhone.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblPhone.setBackground(Color.WHITE);
		lblPhone.setBounds(221, 227, 239, 18);
		contentPane.add(lblPhone);

		lblAddress = new JLabel("");
		lblAddress.setForeground(Color.RED);
		lblAddress.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblAddress.setBackground(Color.WHITE);
		lblAddress.setBounds(221, 378, 239, 18);
		contentPane.add(lblAddress);

		lblSex = new JLabel("");
		lblSex.setForeground(Color.RED);
		lblSex.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblSex.setBackground(Color.WHITE);
		lblSex.setBounds(221, 276, 239, 18);
		contentPane.add(lblSex);
		
		lblExit = new JLabel("X");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblExit.setHorizontalTextPosition(SwingConstants.CENTER);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblExit.setBounds(926, 0, 39, 39);
		contentPane.add(lblExit);
		
		lblRoleAdmin = new JLabel("Người Đăng Nhập:");
		lblRoleAdmin.setForeground(new Color(0, 0, 128));
		lblRoleAdmin.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblRoleAdmin.setBounds(10, 590, 152, 24);
		contentPane.add(lblRoleAdmin);
		
		lblRole = new JLabel("");
		lblRole.setForeground(Color.RED);
		lblRole.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblRole.setBounds(169, 590, 218, 24);
		contentPane.add(lblRole);

		btnNew.addActionListener(controller);
		btnSave.addActionListener(controller);
		btnDelete.addActionListener(controller);
		btnUpdate.addActionListener(controller);

		this.Init();
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
		this.btnSave.setEnabled(false);
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
		} else if(img.equals("user.png")){
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
				&& this.lblSex.getText().equals("") && this.lblAddress.getText().equals("")
				) {
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
		if(this.managerStudentDAO.Insert(msm)) {
			JOptionPane.showMessageDialog(this, "Insert Succesfully");
			FillTable();
			this.lblCode1.setText("");
			index = this.table.getRowCount()-1;
			this.btnSave.setEnabled(false);
			this.btnDelete.setEnabled(true);
			this.btnUpdate.setEnabled(true);
			FocusTable(index);
			
		}else {
			JOptionPane.showMessageDialog(this, "Insert Failed");
			this.lblCode1.setText("<Mã sinh viên không được trùng>");
			this.textFieldCode.requestFocus();
		}
		}

	}

	public void Delete() {
		index = this.table.getSelectedRow();
		String Code = this.table.getValueAt(index, 0).toString();
		if (this.managerStudentDAO.Delete(Code) > 0) {
			JOptionPane.showMessageDialog(this, "Delete Succesfully");
			FillTable();
			ClearForm();
		} else {
			JOptionPane.showMessageDialog(this, "Delete Succesfully");
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
		if(lblRole.getText().equals("Admin")) {
			this.btnSave.setEnabled(false);
			this.btnDelete.setEnabled(true);
			this.btnUpdate.setEnabled(true);
		}else if(lblRole.getText().equals("User")) {
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
	
	
}
