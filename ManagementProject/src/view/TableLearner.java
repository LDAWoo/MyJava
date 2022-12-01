package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import dao.LearnerDAO;
import interfaces.EventActionLeaner;
import model.ModelActionLearner;
import model.ModelLearner;

public class TableLearner extends JTable {
	private DefaultTableModel tableModel;
	private EventActionLeaner eventAction;
	private LearnerDAO dao = new LearnerDAO();

	public TableLearner() {
		init();

	}

	public void init() {
		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MÃ NGƯỜI ĐK", "HỌ VÀ TÊN", "NGÀY SINH",
				"GIỚI TÍNH", "SỐ ĐIỆN THOẠI", "EMAIL","NGÀY ĐĂNG KÝ", "GHI CHÚ", "Edit/Delete" }));

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

				if (value instanceof ModelActionLearner) {
					ModelActionLearner datas = (ModelActionLearner) value;
					ActionLearner cells = new ActionLearner(datas);

					if (isSelected) {
						cells.setBackground(new Color(239, 244, 255));
					} else {
						cells.setBackground(Color.white);
					}
					return cells;
				} else {
					Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
							column);
					table.setBorder(noFocusBorder);
					com.setForeground(new Color(102, 102, 102));
					if (isSelected) {
						com.setBackground(Color.decode("#d1ccc0"));
					} else {
						com.setBackground(Color.WHITE);
					}

					return com;
				}
			}
		});

	}

	@Override
	public TableCellEditor getCellEditor(int row, int col) {
		if (col == 8) {
			return new TableCellActionLearner();
		} else {
			return super.getCellEditor(row, col);
		}
	}

	public void addRow(Object[] row) {
		tableModel = (DefaultTableModel) getModel();
		tableModel.addRow(row);
	}

	public void initTableData() {
		eventAction = new EventActionLeaner() {

			@Override
			public void update(ModelLearner learner) {
				System.out.println("Edit");

			}

			@Override
			public void delete(ModelLearner learner) {
				System.out.println("Delete");

			}
		};
		initData();
	}

	public void initData() {

		for (ModelLearner data : dao.SelectAll()) {
			Object[] rows = new Object[8];
			rows[0] = data.getPersonCode();
			rows[1] = data.getName();
			rows[2] = data.getDate();
			rows[3] = data.isSex();
			rows[4] = data.getPhoneNumber();
			rows[5] = data.getEmail();
			rows[6] = data.getDateOfRegister();
			rows[7] = data.getNote();

			addRow(new ModelLearner(rows[0].toString(), rows[1].toString(), rows[2].toString(),
					Boolean.parseBoolean(rows[3].toString()), rows[4].toString(), rows[5].toString(),
					rows[6].toString(),rows[7].toString()).toRowTable(eventAction));

		}
	}

}
