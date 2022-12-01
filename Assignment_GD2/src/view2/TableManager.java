package view2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import dao.DataManagerDAO;
import img.img;

public class TableManager extends JTable {
	private PanelTableStudent table;
	private DataManagerDAO dataManagerDAO = new DataManagerDAO(this);
	private EventActionManager eventAction;
	private DefaultTableModel mod;
	private int index = -1;
	FrameView view;
	private String Role;
	
	public TableManager(String role) {
		setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã SV", "Họ Tên", "Email", "Phone", "Giới Tính", "Địa Chỉ", "Edit/Delete" }

		));
		this.Role = role;
		
		this.setOpaque(false);
		setLayout(null);
		setBounds(0, 0, 980, 480);

		setRowHeight(40);
		setGridColor(Color.white);
		getTableHeader().setReorderingAllowed(false);
		getTableHeader().setFont(new Font("SanSerif", Font.PLAIN, 15));
		getTableHeader().setForeground(Color.decode("#84817a"));
		setShowGrid(false);
		setShowHorizontalLines(false);
		Font f = new Font("SanSerif", Font.PLAIN, 12);
		setFont(f);

		setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				if (value instanceof ModelManagerAction) {
					ModelManagerAction datas = (ModelManagerAction) value;
					Action2 cells = new Action2(datas);
					if (isSelected) {
						cells.setBackground(new Color(239, 244, 255));
					} else {
						cells.setBackground(Color.white);
					}
					return cells;
				}

				else {
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

			}

		});
	}

	@Override
	public TableCellEditor getCellEditor(int row, int col) {
		if (col == 6) {
			return new TableCellAction2();
		} else {
			return super.getCellEditor(row, col);
		}
	}

	public void addRow(Object[] row) {
		mod = (DefaultTableModel) getModel();
		mod.addRow(row);
	}

	public void initTableData() {
		eventAction = new EventActionManager() {
			@Override
			public void delete(ModelManager manager) {
				try {
					index = getSelectedRow();
					String Code = getValueAt(index, 0).toString();
					int choice = JOptionPane.showConfirmDialog(view, "Bạn Có Chắc Chắn Muốn Xóa Không!", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {
						if (dataManagerDAO.Delete(Code) > 0) {
							JOptionPane.showMessageDialog(view, "Delete Succesfully");
							mod.setRowCount(0);
							Init();
						} else {
							JOptionPane.showMessageDialog(view, "Delete Faied!", "Erro", JOptionPane.WARNING_MESSAGE);
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(view, "Chưa Chọn Dòng Để Delete!", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			}

			@Override
			public void update(ModelManager manager) {
				try {
					index = getSelectedRow();
					String Code = getValueAt(index, 0).toString();
					String Name = getValueAt(index, 1).toString();
					String Email = getValueAt(index, 2).toString();
					String Phone = getValueAt(index, 3).toString();
					String Sex = getValueAt(index, 4).toString();
					String Address = getValueAt(index, 5).toString();
					boolean sex = true;
					if (Sex.equals("Nam")) {
						sex = true;
					} else if (Sex.equals("Nữ")) {
						sex = false;
					} else {
						JOptionPane.showMessageDialog(view, "Nhập Giới Tính Nam Hoặc Nữ!", "Erro",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
					int choice = JOptionPane.showConfirmDialog(view, "Bạn Có Chắc Chắn Muốn Cập Nhật Không!", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {
						if (dataManagerDAO.Update(Code, Name, Email, Phone, sex, Address) > 0) {
							JOptionPane.showMessageDialog(view, "Update Succesfully");
							mod.setRowCount(0);
							Init();
						} else {
							JOptionPane.showMessageDialog(view, "Update Faied!", "Erro", JOptionPane.WARNING_MESSAGE);
						}
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(view, "Chưa Chọn Dòng Để Update!", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		};
		Init();
	}

	public void Init() {
		if(this.Role == "User") {
			this.getColumnModel().getColumn(6).setWidth(0);
			this.getColumnModel().getColumn(6).setMinWidth(0);
			this.getColumnModel().getColumn(6).setMaxWidth(0);
		}
		
		
		for (ModelManager data : dataManagerDAO.SelectAll()) {
			Object[] rows = new Object[7];
			rows[0] = data.getCode();
			rows[1] = data.getName();
			rows[2] = data.getEmail();
			rows[3] = data.getPhone();
			rows[4] = data.getSex();
			rows[5] = data.getAddress();
			for (int i = 0; i < rows.length; i++) {
				if (i == 4) {
					if (data.getSex().equals("1")) {
						rows[4] = "Nam";
					} else {
						rows[4] = "Nữ";
					}
				}
			}

			addRow(new ModelManager(rows[0].toString(), rows[1].toString(), rows[2].toString(), rows[3].toString(),
					rows[4].toString(), rows[5].toString()).toRowTable(eventAction));
		}
	}

}
