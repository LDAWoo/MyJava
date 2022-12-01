package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import interfaces.EventActionCourses;
import model.ModelActionCourses;
import model.ModelCourse;

public class TableCourse extends JTable {
	private DefaultTableModel tableModel;
	private EventActionCourses event;

	public TableCourse() {
		init();
	}

	public void init() {
		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MÃ KHÓA HỌC", "CHUYÊN ĐỀ", "HỌC PHÍ",
				"THỜI LƯỢNG", "NGÀY KHAI GIẢNG", "NGƯỜI TẠO", "Edit/Delete" }));

		setRowHeight(40);
		getTableHeader().setReorderingAllowed(false);
		getTableHeader().setFont(new Font("SanSerif", Font.PLAIN, 15));
		getTableHeader().setForeground(Color.decode("#84817a"));
		setShowGrid(false);
		setShowHorizontalLines(true);

		setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				if (value instanceof ModelActionCourses) {
					ModelActionCourses data = (ModelActionCourses) value;
					ActionCourses cells = new ActionCourses(data);
					if (isSelected) {
						cells.setBackground(new Color(239, 244, 255));
					} else {
						cells.setBackground(new Color(255, 255, 255));
					}
					return cells;
				}

				Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				table.setBorder(noFocusBorder);
				com.setForeground(new Color(102, 102, 102));
				if (isSelected) {
					com.setBackground(Color.decode("#d1ccc0"));
				} else {
					com.setBackground(new Color(250, 250, 250));
				}
				return com;
			}

		});

	}

	@Override
	public TableCellEditor getCellEditor(int row, int column) {
		if (column == 6) {
			return new TableCellActionCourse();
		} else {
			return super.getCellEditor(row, column);
		}
	}

	public void addRow(Object[] row) {
		tableModel = (DefaultTableModel) getModel();
		tableModel.addRow(row);
	}

	public void initTable() {
		event = new EventActionCourses() {

			@Override
			public void Update(ModelCourse course) {
				System.out.println("Edit");

			}

			@Override
			public void Delete(ModelCourse course) {
				System.out.println("Delete");

			}
		};
		initData();
	}

	public void initData() {
		addRow(new ModelCourse("KH001", "CD001", 500.0, 60, "11/11/2003", "VULEE").toRowTable(event));
		addRow(new ModelCourse("KH001", "CD001", 500.0, 60, "11/11/2003", "VULEE").toRowTable(event));
		addRow(new ModelCourse("KH001", "CD001", 500.0, 60, "11/11/2003", "VULEE").toRowTable(event));
		addRow(new ModelCourse("KH001", "CD001", 500.0, 60, "11/11/2003", "VULEE").toRowTable(event));
		addRow(new ModelCourse("KH001", "CD001", 500.0, 60, "11/11/2003", "VULEE").toRowTable(event));
	}

}
