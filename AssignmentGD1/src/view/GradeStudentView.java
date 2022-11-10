package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.GradeStudentController;
import dao.GradeStudentDAO;
import img.img;
import model.GradeStudentModel;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GradeStudentView extends JFrame {
	private DefaultTableModel tableModel;
	private JPanel contentPane;
	private JTextField textFieldCodeFind;
	private JTextField textFieldCodeText;
	private JTextField textFieldEnglish;
	private JTextField textFieldTechnology;
	private JTextField textFieldPysical;
	private JTable table;
	private GradeStudentDAO gradeStudentDAO = new GradeStudentDAO(this);
	private GradeStudentController controller = new GradeStudentController(this);
	private LoginUserView view = new LoginUserView();
	private img img = new img(this);
	private int index = -1;
	private JLabel lblMediumScore;
	private JLabel textFieldName;
	private Object[] rows;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnNew;
	private boolean _cal = true;
	private JButton btnAll;
	private JButton btnTopThree;
	private JLabel lblTallScore;
	private JButton btnFind;
	private JLabel lblRoleAdmin;
	private JButton btnFirst;
	private JButton btnPrev;
	private JButton btnNext;
	private JButton btnLast;
	private JLabel lblRole2;
	private JLabel lblRole;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private GradeStudentView frame;

			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new GradeStudentView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GradeStudentView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ ĐIỂM SINH VIÊN");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel.setBounds(347, 11, 278, 29);
		contentPane.add(lblNewLabel);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel1.setBounds(261, 60, 458, 91);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("MÃ SV:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(48, 39, 46, 14);
		panel1.add(lblNewLabel_2);

		textFieldCodeFind = new JTextField();
		textFieldCodeFind.setBounds(104, 33, 197, 25);
		panel1.add(textFieldCodeFind);
		textFieldCodeFind.setColumns(10);
		textFieldCodeFind.addCaretListener(controller);

		btnFind = new JButton("Search");
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFind.setBounds(326, 34, 101, 25);
		panel1.add(btnFind);
		btnFind.addActionListener(controller);
		btnFind.setIcon(this.img.ImageFind());

		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(261, 43, 70, 18);
		contentPane.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(261, 162, 338, 207);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("Họ tên SV:");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(32, 27, 62, 14);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("MÃ SV:");
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(50, 64, 43, 14);
		panel.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_2_1 = new JLabel("Tiếng anh:");
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(32, 97, 62, 21);
		panel.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Tin học:");
		lblNewLabel_2_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2_2_1_1.setBounds(47, 137, 52, 21);
		panel.add(lblNewLabel_2_2_1_1);

		JLabel lblNewLabel_2_2_1_2 = new JLabel("Giáo dục TC:");
		lblNewLabel_2_2_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2_2_1_2.setBounds(20, 173, 74, 21);
		panel.add(lblNewLabel_2_2_1_2);

		textFieldCodeText = new JTextField();
		textFieldCodeText.setColumns(10);
		textFieldCodeText.setBounds(103, 60, 99, 25);
		panel.add(textFieldCodeText);
		textFieldCodeText.addCaretListener(controller);

		textFieldEnglish = new JTextField();
		textFieldEnglish.setColumns(10);
		textFieldEnglish.setBounds(104, 96, 98, 25);
		panel.add(textFieldEnglish);
		textFieldEnglish.addCaretListener(controller);

		textFieldTechnology = new JTextField();
		textFieldTechnology.setColumns(10);
		textFieldTechnology.setBounds(104, 137, 98, 25);
		panel.add(textFieldTechnology);
		textFieldTechnology.addCaretListener(controller);

		textFieldPysical = new JTextField();
		textFieldPysical.setColumns(10);
		textFieldPysical.setBounds(104, 171, 99, 25);
		panel.add(textFieldPysical);
		textFieldPysical.addCaretListener(controller);

		JLabel lblScore = new JLabel("Điểm TB:");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScore.setBounds(238, 78, 63, 25);
		panel.add(lblScore);

		lblMediumScore = new JLabel("");
		lblMediumScore.setForeground(Color.BLUE);
		lblMediumScore.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblMediumScore.setBounds(250, 107, 52, 44);
		panel.add(lblMediumScore);

		textFieldName = new JLabel("");
		textFieldName.setForeground(Color.BLUE);
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldName.setBounds(104, 24, 224, 20);
		panel.add(textFieldName);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 140, 0));
		panel2.setBorder(null);
		panel2.setBounds(261, 380, 338, 38);
		contentPane.add(panel2);
		panel2.setLayout(new GridLayout(1, 4, 10, 10));

		btnFirst = new JButton("", this.img.ImageFirst());
		panel2.add(btnFirst);

		btnPrev = new JButton("", this.img.ImagePrev());
		panel2.add(btnPrev);

		btnNext = new JButton(" ", this.img.ImageNext());
		panel2.add(btnNext);

		btnLast = new JButton("", this.img.ImageLast());
		panel2.add(btnLast);

		JPanel panel3 = new JPanel();
		panel3.setBorder(null);
		panel3.setBackground(new Color(255, 140, 0));
		panel3.setBounds(609, 162, 110, 207);
		contentPane.add(panel3);
		panel3.setLayout(new GridLayout(6, 1, 5, 5));

		btnNew = new JButton("New");
		btnNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNew.setForeground(Color.BLACK);
		panel3.add(btnNew);
		btnNew.addActionListener(controller);
		btnNew.setIcon(this.img.ImageNew());

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel3.add(btnSave);
		btnSave.addActionListener(controller);
		btnSave.setIcon(this.img.ImageSave());

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel3.add(btnDelete);
		btnDelete.addActionListener(controller);
		btnDelete.setIcon(this.img.ImageDelete());

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel3.add(btnUpdate);
		btnUpdate.addActionListener(controller);
		btnUpdate.setIcon(this.img.ImageUpdate());

		btnAll = new JButton("ALL");
		btnAll.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel3.add(btnAll);
		btnAll.addActionListener(controller);
		btnAll.setIcon(this.img.ImageAll());

		btnTopThree = new JButton("TOP 3");
		btnTopThree.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel3.add(btnTopThree);
		btnTopThree.addActionListener(controller);
		btnTopThree.setIcon(this.img.ImageTop());

		JPanel panel5 = new JPanel();
		panel5.setBorder(null);
		panel5.setBounds(163, 446, 648, 140);
		contentPane.add(panel5);
		panel5.setLayout(null);

		table = new JTable();
		table.addMouseListener(controller);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 648, 140);
		panel5.add(scrollPane);

		lblTallScore = new JLabel("");
		lblTallScore.setForeground(new Color(0, 0, 128));
		lblTallScore.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTallScore.setBounds(163, 426, 462, 18);
		contentPane.add(lblTallScore);

		lblRoleAdmin = new JLabel("Người Đăng Nhập:");
		lblRoleAdmin.setForeground(Color.BLUE);
		lblRoleAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRoleAdmin.setBounds(10, 591, 129, 24);
		contentPane.add(lblRoleAdmin);

		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);

			}
		});
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(926, 1, 39, 39);
		contentPane.add(lblNewLabel_3);

		lblRole = new JLabel("");
		lblRole.setForeground(Color.RED);
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRole.setBounds(150, 590, 239, 24);
		contentPane.add(lblRole);

		this.Init();
	}

	public void Init() {
		ActionButton();
		tableModel = new DefaultTableModel();
		String[] col = new String[] { "ID", "Mã SV", "Họ Tên", "Tiếng Anh", "Tin Học", "GDTC", "Điểm TB" };
		tableModel.setColumnIdentifiers(col);
		table.setModel(tableModel);
		this.btnDelete.setEnabled(false);
		this.btnUpdate.setEnabled(false);
		this.btnSave.setEnabled(false);
		this.btnFind.setEnabled(false);
		ALL();
		_cal = false;

	}

	public void ALL() {
		try {
			FillTableAll();
			index = 0;
			FocusTable(index);
			this.btnSave.setEnabled(false);
			this.lblTallScore.setText("Danh Sách Tất Cả Sinh Viên");
			this.btnFind.setEnabled(true);
		} catch (Exception e) {
			_cal = true;
		}
	}

	public void TopThree() {
		try {
			FillTableTopThree();
			index = 0;
			FocusTable(index);
			this.btnSave.setEnabled(false);
			this.lblTallScore.setText("Top 3 Sinh Viên Có Điểm Cao Nhất");
			this.btnFind.setEnabled(true);
		} catch (Exception e) {
			_cal = true;
		}
	}

	public void ClearForm() {
		this.textFieldName.setText("");
		this.textFieldCodeText.setText("");
		this.textFieldEnglish.setText("");
		this.textFieldTechnology.setText("");
		this.textFieldPysical.setText("");
		this.lblMediumScore.setText("");
		this.table.setRowSelectionAllowed(false);
		this.btnDelete.setEnabled(false);
		this.btnUpdate.setEnabled(false);
		this.btnSave.setEnabled(false);
		this.textFieldCodeText.requestFocus();
		_cal = false;
		String Role = lblRole.getText();
		if (Role.equals("Admin")) {
			textFieldEnglish.setEnabled(false);
			textFieldTechnology.setEnabled(false);
			textFieldPysical.setEnabled(false);
			this.btnSave.setEnabled(true);
		} else if (Role.equals("User")) {
			textFieldEnglish.setEnabled(true);
			textFieldTechnology.setEnabled(true);
			textFieldPysical.setEnabled(true);
			this.btnSave.setEnabled(false);
		}

	}

	public void FillTableAll() {
		this.tableModel.setRowCount(0);
		for (GradeStudentModel st : this.gradeStudentDAO.SelectAll()) {
			rows = new Object[7];
			rows[0] = st.getID();
			rows[1] = st.getCode();
			rows[2] = st.getName();
			rows[3] = st.getEnglish();
			rows[4] = st.getInForTechnology();
			rows[5] = st.getPysical();
			rows[6] = st.getMediumScore();
			this.tableModel.addRow(rows);
		}
		_cal = true;
	}

	public void FillTableTopThree() {
		this.tableModel.setRowCount(0);
		for (GradeStudentModel st : this.gradeStudentDAO.SelectTopThree()) {
			rows = new Object[7];
			rows[0] = st.getID();
			rows[1] = st.getCode();
			rows[2] = st.getName();
			rows[3] = st.getEnglish();
			rows[4] = st.getInForTechnology();
			rows[5] = st.getPysical();
			rows[6] = st.getMediumScore();
			this.tableModel.addRow(rows);
		}
		_cal = true;
	}

	public void ShowOutLine() {
		if (_cal == false) {
			int Code = this.textFieldCodeText.getText().length();
			if (Code > 0) {
				if (lblRole.getText().equals("Admin")) {
					this.btnSave.setEnabled(true);
				} else if (lblRole.getText().equals("User")) {
					this.btnSave.setEnabled(false);
				}

			} else {
				this.btnSave.setEnabled(false);

			}
		} else {
			this.btnSave.setEnabled(false);
		}

	}
	public boolean Validate() {
		String GradeEnglish = this.textFieldEnglish.getText();
		String GradeTech = this.textFieldTechnology.getText();
		String GradePysical = this.textFieldPysical.getText();
		if(GradeEnglish.equals("")) {
			JOptionPane.showMessageDialog(this, "Không Được Để Trống Điểm","ERROR",JOptionPane.WARNING_MESSAGE);
			this.textFieldEnglish.requestFocus();
			return false;
		}
		
		if(GradeTech.equals("")) {
			JOptionPane.showMessageDialog(this, "Không Được Để Trống Điểm","ERROR",JOptionPane.WARNING_MESSAGE);
			this.textFieldTechnology.requestFocus();
			return false;
		}
		
		if(GradePysical.equals("")) {
			JOptionPane.showMessageDialog(this, "Không Được Để Trống Điểm","ERROR",JOptionPane.WARNING_MESSAGE);
			this.textFieldPysical.requestFocus();
			return false;
		}
		return true;
	}
	

	public void Save() {
		GradeStudentModel gsm = new GradeStudentModel(this.textFieldCodeText.getText(),
				Double.parseDouble(0+""),
				Double.parseDouble(0+""),
				Double.parseDouble(0+""));
			if (this.gradeStudentDAO.Insert(gsm)) {
				JOptionPane.showMessageDialog(this, "Insert Succesfully");
				this.btnSave.setEnabled(false);
				index = this.table.getRowCount();
				if (index > 3) {
					FillTableAll();
				} else {
					FillTableTopThree();
				}
				this.lblTallScore.setText("Danh Sách Tất Cả Sinh Viên");
				FocusTable(index);
			} else {
				JOptionPane.showMessageDialog(this, "Mã Sinh Viên Không Tồn Tại");
			}
		
	}

	public void Delete() {
		if (_cal) {
			index = this.table.getSelectedRow();
			String Code = this.table.getValueAt(index, 1).toString();
			if (this.gradeStudentDAO.Delete(Code) > 0) {
				JOptionPane.showMessageDialog(this, "Delete Succesfully");
				index = this.table.getRowCount();
				if (index > 3) {
					FillTableAll();
				} else {
					FillTableTopThree();
				}
				ClearForm();
			} else {
				JOptionPane.showMessageDialog(this, "Delete Failed");
			}
		}
	}

	public void Find() {
		String Code = this.textFieldCodeFind.getText();
		this.table.setRowSelectionAllowed(false);
		this.btnDelete.setEnabled(false);
		this.btnUpdate.setEnabled(false);
		_cal = true;
		for (GradeStudentModel st : this.gradeStudentDAO.Find(Code)) {
			this.textFieldCodeText.setText(st.getCode());
			this.textFieldName.setText(st.getName());
			this.textFieldEnglish.setText(st.getEnglish() + "");
			this.textFieldTechnology.setText(st.getInForTechnology() + "");
			this.textFieldPysical.setText(st.getPysical() + "");
			this.lblMediumScore.setText(st.getMediumScore() + "");

		}

	}

	public void Update() {
		if(Validate()) {
		try {
		double GradeEnglish = Double.parseDouble(this.textFieldEnglish.getText());
		double GradeTech = Double.parseDouble(this.textFieldTechnology.getText());
		double GradePysical = Double.parseDouble(this.textFieldPysical.getText());
		if (GradeEnglish > 10 || GradeEnglish < 0 || GradeTech > 10 || GradeTech < 0 || GradePysical > 10
				|| GradePysical < 0) {
			JOptionPane.showMessageDialog(this, "Điểm Không Được Dưới 0 Hoặc Trên 10","ERROR",JOptionPane.WARNING_MESSAGE);
				return;
		} else {
		
		if (_cal) {
			int ID = Integer.parseInt(this.table.getValueAt(index, 0).toString());
			String Code = this.textFieldCodeText.getText();
			double English = Double.parseDouble(this.textFieldEnglish.getText());
			double Technology = Double.parseDouble(this.textFieldTechnology.getText());
			double Pysical = Double.parseDouble(this.textFieldPysical.getText());
			if (this.gradeStudentDAO.Update(ID, Code, English, Technology, Pysical) > 0) {
				JOptionPane.showMessageDialog(this, "Update Succesfully");
				ClearForm();
				FillTableTopThree();
				this.lblTallScore.setText("Top 3 Sinh Viên Có Điểm Cao Nhất");
			} else {
				JOptionPane.showMessageDialog(this, "Update Failed");
			}
		}
		
		}
		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Điểm Không Được Nhập Chữ","ERROR",JOptionPane.WARNING_MESSAGE);
		}
		}
	}

	public void FocusTable(int index) {
		if (_cal) {
			this.table.setRowSelectionInterval(index, index);
			String Code = this.table.getValueAt(index, 1).toString();
			this.gradeStudentDAO.LoadData(Code);
			this.table.setRowSelectionAllowed(true);
			this.btnDelete.setEnabled(true);
			this.btnUpdate.setEnabled(true);
		}

	}

	public void Click() {
		_cal = true;
		index = this.table.getSelectedRow();
		String Code = this.table.getValueAt(index, 1).toString();
		this.gradeStudentDAO.LoadData(Code);
		this.table.setRowSelectionAllowed(true);
		this.btnDelete.setEnabled(true);
		this.btnUpdate.setEnabled(true);

	}

	public void First() {
		_cal = true;
		index = 0;
		FocusTable(index);

	}

	public void Prev() {
		_cal = true;
		if (index > 0) {
			index--;
		} else {
			index = this.table.getRowCount() - 1;
		}
		FocusTable(index);

	}

	public void Next() {
		_cal = true;
		if (index < this.table.getRowCount() - 1) {
			index++;
		} else {
			index = 0;
		}
		FocusTable(index);

	}

	public void Last() {
		_cal = true;
		index = this.table.getRowCount() - 1;
		FocusTable(index);
	}

	public void ActionButton() {
		btnFirst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				First();

			}
		});

		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Prev();

			}
		});

		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Next();

			}
		});

		btnLast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Last();

			}
		});
	}

	public JTextField getTextFieldCodeFind() {
		return textFieldCodeFind;
	}

	public void setTextFieldCodeFind(JTextField textFieldCodeFind) {
		this.textFieldCodeFind = textFieldCodeFind;
	}

	public JTextField getTextFieldCodeText() {
		return textFieldCodeText;
	}

	public void setTextFieldCodeText(JTextField textFieldCodeText) {
		this.textFieldCodeText = textFieldCodeText;
	}

	public JTextField getTextFieldEnglish() {
		return textFieldEnglish;
	}

	public void setTextFieldEnglish(JTextField textFieldEnglish) {
		this.textFieldEnglish = textFieldEnglish;
	}

	public JTextField getTextFieldTechnology() {
		return textFieldTechnology;
	}

	public void setTextFieldTechnology(JTextField textFieldTechnology) {
		this.textFieldTechnology = textFieldTechnology;
	}

	public JTextField getTextFieldPysical() {
		return textFieldPysical;
	}

	public void setTextFieldPysical(JTextField textFieldPysical) {
		this.textFieldPysical = textFieldPysical;
	}

	public JLabel getLblMediumScore() {
		return lblMediumScore;
	}

	public void setLblMediumScore(JLabel lblMediumScore) {
		this.lblMediumScore = lblMediumScore;
	}

	public JLabel getTextFieldName() {
		return textFieldName;
	}

	public void setTextFieldName(JLabel textFieldName) {
		this.textFieldName = textFieldName;
	}

	public boolean is_cal() {
		return _cal;
	}

	public void set_cal(boolean _cal) {
		this._cal = _cal;
	}

	public JButton getBtnFirst() {
		return btnFirst;
	}

	public void setBtnFirst(JButton btnFirst) {
		this.btnFirst = btnFirst;
	}

	public JButton getBtnPrev() {
		return btnPrev;
	}

	public void setBtnPrev(JButton btnPrev) {
		this.btnPrev = btnPrev;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	public JButton getBtnLast() {
		return btnLast;
	}

	public void setBtnLast(JButton btnLast) {
		this.btnLast = btnLast;
	}

	public JLabel getLblRoleAdmin() {
		return lblRoleAdmin;
	}

	public void setLblRoleAdmin(JLabel lblRoleAdmin) {
		this.lblRoleAdmin = lblRoleAdmin;
	}

	public JLabel getLblRole() {
		return lblRole;
	}

	public void setLblRole(JLabel lblRole) {
		this.lblRole = lblRole;
	}

	public JButton getBtnNew() {
		return btnNew;
	}

	public void setBtnNew(JButton btnNew) {
		this.btnNew = btnNew;
	}

	
}
