package view2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.GradeStudentController;
import controller.PanelGradeStudentController;
import dao.GradeStudentDAO;
import dao.PanelGradeStudentDAO;
import img.img;
import model.GradeStudentModel;

public class PanelGrade extends JPanel{
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JPanel panel2;
	private JButton btnFirst;
	private JButton btnPrev;
	private JButton btnNext;
	private JButton btnLast;
	private JPanel panel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_2_1;
	private JLabel lblNewLabel_2_2_1_1;
	private JTextField textFieldCodeText;
	private JTextField textFieldEnglish;
	private JTextField textFieldTechnology;
	private JTextField textFieldPysical;
	private JLabel lblScore;
	private JLabel lblMediumScore;
	private JLabel textFieldName;
	private JPanel panel3;
	private JButton btnNew;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnAll;
	private JButton btnTopThree;
	private JPanel panel1;
	private JLabel lblNewLabel;
	private JTextField textFieldCodeFind;
	private JButton btnFind;
	private JLabel lblNewLabel_1;
	private JTable table;
	private img img = new img(this);
	private PanelGradeStudentDAO gradeStudentDAO = new PanelGradeStudentDAO(this);
	private PanelGradeStudentController controller = new PanelGradeStudentController(this);
	private boolean _cal=true;
	private int index = -1;
	private JLabel lblTallScore;
	private Object rows[];
	private String Role ;
	
	
	public PanelGrade(String role) {
		this.Role = role;
		this.setPreferredSize(new Dimension(984,668));
		this.setVisible(false);
		this.setBackground(SystemColor.control);
		this.setBorder(null);
		this.setForeground(new Color(0, 0, 128));
		this.setBounds(215, 32, 984, 668);
	
		this.setLayout(null);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		table.setForeground(SystemColor.controlShadow);
		table.setBorder(null);
		
		
		scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setBounds(29, 449, 945, 208);
		scrollPane.setVerticalScrollBar(new JScrollBar());

		this.add(scrollPane);
		
		panel2 = new JPanel();
		panel2.setBorder(null);
		panel2.setBackground(SystemColor.controlHighlight);
		panel2.setBounds(294, 385, 338, 38);
		this.add(panel2);
		panel2.setLayout(new GridLayout(1, 4, 10, 10));
		
		btnFirst = new JButton("", null);
		btnFirst.setBackground(SystemColor.activeCaptionBorder);
		btnFirst.setIcon(this.img.ImageFirst());
		btnFirst.setBorder(null);
		panel2.add(btnFirst);
		btnFirst.addActionListener(controller);
		
		btnPrev = new JButton("", null);
		btnPrev.setBackground(SystemColor.activeCaptionBorder);
		btnPrev.setIcon(this.img.ImagePrev());
		btnPrev.setBorder(null);
		btnPrev.addActionListener(controller);
		panel2.add(btnPrev);
		
		btnNext = new JButton(" ", null);
		btnNext.setBackground(SystemColor.activeCaptionBorder);
		btnNext.setIcon(this.img.ImageNext());
		btnNext.setBorder(null);
		btnNext.addActionListener(controller);
		panel2.add(btnNext);
		
		btnLast = new JButton("", null);
		btnLast.setBackground(SystemColor.activeCaptionBorder);
		btnLast.setIcon(this.img.ImageLast());
		btnLast.setBorder(null);
		btnLast.addActionListener(controller);
		panel2.add(btnLast);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBounds(294, 160, 338, 207);
		this.add(panel);
		
		lblNewLabel_2 = new JLabel("Họ tên SV:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(32, 27, 62, 14);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_2_1 = new JLabel("MÃ SV:");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(50, 64, 43, 14);
		panel.add(lblNewLabel_2_1);
		
		lblNewLabel_2_2 = new JLabel("Tiếng anh:");
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(32, 97, 62, 21);
		panel.add(lblNewLabel_2_2);
		
		lblNewLabel_2_2_1 = new JLabel("Tin học:");
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(47, 137, 52, 21);
		panel.add(lblNewLabel_2_2_1);
		
		lblNewLabel_2_2_1_1 = new JLabel("Giáo dục TC:");
		lblNewLabel_2_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2_2_1_1.setBounds(20, 173, 74, 21);
		panel.add(lblNewLabel_2_2_1_1);
		
		textFieldCodeText = new JTextField();
		textFieldCodeText.setColumns(10);
		textFieldCodeText.setBounds(103, 60, 99, 25);
		textFieldCodeText.addCaretListener(controller);
		panel.add(textFieldCodeText);
		
		textFieldEnglish = new JTextField();
		textFieldEnglish.setColumns(10);
		textFieldEnglish.setBounds(104, 96, 98, 25);
		textFieldEnglish.addCaretListener(controller);
		panel.add(textFieldEnglish);
		
		textFieldTechnology = new JTextField();
		textFieldTechnology.setColumns(10);
		textFieldTechnology.setBounds(104, 137, 98, 25);
		textFieldTechnology.addCaretListener(controller);
		panel.add(textFieldTechnology);
		
		textFieldPysical = new JTextField();
		textFieldPysical.setColumns(10);
		textFieldPysical.setBounds(104, 171, 99, 25);
		textFieldPysical.addCaretListener(controller);
		panel.add(textFieldPysical);
		
		lblScore = new JLabel("Điểm TB:");
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
		
		panel3 = new JPanel();
		panel3.setBorder(null);
		panel3.setBackground(SystemColor.controlHighlight);
		panel3.setBounds(686, 160, 110, 207);
		this.add(panel3);
		panel3.setLayout(new GridLayout(6, 1, 5, 5));
		
		btnNew = new JButton("New");
		btnNew.setForeground(Color.BLACK);
		btnNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNew.setIcon(this.img.ImageNew());
		btnNew.addActionListener(controller);
		panel3.add(btnNew);
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setIcon(this.img.ImageSave());
		btnSave.setEnabled(false);
		btnSave.addActionListener(controller);
		panel3.add(btnSave);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setIcon(this.img.ImageDelete());
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(controller);
		panel3.add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setIcon(this.img.ImageEdit());
		btnUpdate.addActionListener(controller);
		btnUpdate.setEnabled(false);
		panel3.add(btnUpdate);
		
		btnAll = new JButton("ALL");
		btnAll.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAll.setIcon(this.img.ImageAll());
		btnAll.addActionListener(controller);
		panel3.add(btnAll);
		
		btnTopThree = new JButton("TOP 3");
		btnTopThree.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTopThree.setIcon(this.img.ImageTop());
		btnTopThree.addActionListener(controller);
		panel3.add(btnTopThree);
		
		panel1 = new JPanel();
		panel1.setBackground(SystemColor.textHighlightText);
		panel1.setLayout(null);
		panel1.setBorder(null);
		panel1.setBounds(235, 58, 458, 91);
		this.add(panel1);
		
		lblNewLabel = new JLabel("MÃ SV:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel.setBounds(48, 39, 46, 14);
		panel1.add(lblNewLabel);
		
		textFieldCodeFind = new JTextField();
		textFieldCodeFind.setColumns(10);
		textFieldCodeFind.setBounds(104, 33, 197, 25);
		textFieldCodeFind.addCaretListener(controller);
		panel1.add(textFieldCodeFind);
		
		btnFind = new JButton("Search");
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFind.setEnabled(false);
		btnFind.setIcon(this.img.ImageFind());
		btnFind.setBounds(326, 34, 101, 25);
		btnFind.addActionListener(controller);
		panel1.add(btnFind);
		
		lblNewLabel_1 = new JLabel("QUẢN LÝ ĐIỂM SINH VIÊN");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1.setBounds(332, 11, 278, 29);
		this.add(lblNewLabel_1);
		
		lblTallScore = new JLabel("Danh Sách Tất Cả Sinh Viên");
		lblTallScore.setBackground(SystemColor.control);
		lblTallScore.setForeground(new Color(0, 0, 128));
		lblTallScore.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTallScore.setBounds(29, 422, 462, 18);
		add(lblTallScore);
		
		table();
			
	}
	
	

	public void table() {
		table.addMouseListener(controller);
		table.setShowHorizontalLines(true);
		table.setRowHeight(30);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setFont(new Font("SanSerif",Font.BOLD,14));
		Init();
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
					Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
							column);
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
		ActionButton();
		tableModel = new DefaultTableModel();
		String[] col = new String[] { "ID", "Mã SV", "Họ Tên", "Tiếng Anh", "Tin Học", "GDTC", "Điểm TB" };
		tableModel.setColumnIdentifiers(col);
		table.setModel(tableModel);
		this.btnDelete.setEnabled(false);
		this.btnUpdate.setEnabled(false);
		this.btnSave.setEnabled(false);
		this.btnFind.setEnabled(false);
		
		if(Role == "Admin") {
			this.textFieldEnglish.setEnabled(false);
			this.textFieldTechnology.setEnabled(false);
			this.textFieldPysical.setEnabled(false);
		}
		
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
				if (Role.equals("Admin")) {
					this.btnSave.setEnabled(true);
				} else if (Role.equals("User")) {
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
		_cal=true;
		GradeStudentModel gsm = new GradeStudentModel(this.textFieldCodeText.getText(),
				Double.parseDouble(0+""),
				Double.parseDouble(0+""),
				Double.parseDouble(0+""));
			if (this.gradeStudentDAO.Insert(gsm)) {
				JOptionPane.showMessageDialog(this, "Insert Succesfully");
				this.btnSave.setEnabled(false);
				index = this.table.getRowCount();			
				FillTableAll();
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
			int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Chắn Muốn Xóa Không", "Message",
					JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
			
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


	public JButton getBtnNew() {
		return btnNew;
	}

	public void setBtnNew(JButton btnNew) {
		this.btnNew = btnNew;
	}

	public JButton getBtnAll() {
		return btnAll;
	}

	public void setBtnAll(JButton btnAll) {
		this.btnAll = btnAll;
	}
	
	
}
