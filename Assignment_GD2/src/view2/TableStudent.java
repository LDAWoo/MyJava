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
import javax.swing.table.TableColumn;

import dao.DataStudentDAO;
import img.img;
import model.GradeStudentModel;

public class TableStudent extends JTable {
	private PanelTableStudent student ;
	private DataStudentDAO dataStudentDAO = new DataStudentDAO(this);
	private int index = -1;
	private EventAction eventAction;
	private DefaultTableModel mod;
	private Action action;
	FrameView view;
	private String role;

	public TableStudent(String role) {
		setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Mã SV", "Họ Tên", "Tiếng Anh", "Tin Học", "GDTC", "Điểm TB", "Edit/Delete" }

		));
		this.role = role;
		
		this.setOpaque(false);
		setLayout(null);
		setBounds(0, 0, 980, 480);

		setRowHeight(40);
		setGridColor(Color.white);
		getTableHeader().setReorderingAllowed(false);
		getTableHeader().setFont(new Font("SanSerif", Font.PLAIN, 15));
		getTableHeader().setForeground(Color.decode("#84817a"));
		setShowGrid(true);
		setShowHorizontalLines(false);
		Font f = new Font("SanSerif", Font.PLAIN, 12);
		setFont(f);

		
		
		setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				if (value instanceof ModelAction) {
					ModelAction datas = (ModelAction) value;
					Action cells = new Action(datas);

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
		if (col == 7) {
			return new TableCellAction();
		} else {
			return super.getCellEditor(row, col);
		}
	}

	public void addRow(Object[] row) {
		mod = (DefaultTableModel) getModel();
		mod.addRow(row);
	}

	public void initTableData() {

		eventAction = new EventAction() {
			@Override
			public void delete(ModelStudent student) {
				try {
					index = getSelectedRow();
					int Id = Integer.parseInt(getValueAt(index, 0).toString());
					int choice = JOptionPane.showConfirmDialog(view, "Bạn Có Chắc Chắn Muốn Xóa Không!", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {
						if (dataStudentDAO.Delete(Id) > 0) {
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
			public void update(ModelStudent student) {
				try {	
					index = getSelectedRow();
					int Id = Integer.parseInt(getValueAt(index, 0).toString());
					String Code = getValueAt(index, 1).toString();
					double English = Double.parseDouble(getValueAt(index, 3).toString());
					double Technology = Double.parseDouble(getValueAt(index, 4).toString());
					double Pysical = Double.parseDouble(getValueAt(index, 5).toString());
					int choice = JOptionPane.showConfirmDialog(view, "Bạn Có Chắc Chắn Muốn Cập Nhật Không!", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {
						if (dataStudentDAO.Update(Id, Code, English, Technology, Pysical) > 0) {
							JOptionPane.showMessageDialog(view, "Update Succesfully");
							mod.setRowCount(0);
							Init();
						} else {
							JOptionPane.showMessageDialog(view, "Update Faied!", "Erro",
									JOptionPane.WARNING_MESSAGE);
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
		if(this.role == "User") {
			this.getColumnModel().getColumn(7).setWidth(0);
			this.getColumnModel().getColumn(7).setMinWidth(0);
			this.getColumnModel().getColumn(7).setMaxWidth(0);
		}
		
		for (ModelStudent datas : this.dataStudentDAO.SelectAll()) {
			Object rows[] = new Object[9];
			rows[0] = datas.getID();
			rows[1] = datas.getCode();
			rows[2] = datas.getName();
			rows[3] = datas.getEnglish();
			rows[4] = datas.getInForTechnology();
			rows[5] = datas.getPysical();
			rows[6] = datas.getMediumScore();

			addRow(new ModelStudent(Integer.parseInt(rows[0].toString()), rows[1].toString(), rows[2].toString(),
					Double.parseDouble(rows[3].toString()), Double.parseDouble(rows[4].toString()),
					Double.parseDouble(rows[5].toString()), Double.parseDouble(rows[6].toString()))
					.toRowTable(eventAction));
		}	
	}

}
