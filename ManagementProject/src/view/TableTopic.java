package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import interfaces.EventActionTopic;
import model.ModelActionTopic;
import model.ModelTopic;

public class TableTopic extends JTable {
	private DefaultTableModel tableModel;
	private EventActionTopic eventAction;
	public TableTopic() {
		init();
		
	}

	public void init() {
		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MÃ CHUYÊN ĐỀ", "TÊN CHUYÊN ĐỀ", "HỌC PHÍ",
				"THỜI LƯỢNG", "MÔ TẢ CĐ", "LOGO", "Edit/Delete" }));

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

				if (value instanceof ModelActionTopic) {
					ModelActionTopic data = (ModelActionTopic) value;
					ActionTopic cell = new ActionTopic(data);
					if (isSelected) {
						cell.setBackground(new Color(239, 244, 255));
					} else {
						cell.setBackground(new Color(255, 255, 255));
					}
					return cell;
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

	public void addRow(Object[] row) {
		tableModel = (DefaultTableModel) getModel();
		tableModel.addRow(row);
	}
	
	@Override
	public TableCellEditor getCellEditor(int row, int col) {
		if(col==6) {
			return new TableCellActionTopic();
		}else {
			return super.getCellEditor(row, row);
		}
	}
	
	public void initTable() {
		eventAction = new EventActionTopic() {

			@Override
			public void Update(ModelTopic topic) {
				System.out.println("Edit");
				
			}

			@Override
			public void Delete(ModelTopic topic) {
				System.out.println("Delete");
				
			}
			
		};
		initData(); 
	}
	
	public void initData() {
		addRow(new ModelTopic("TP001","UDPM",500000.0,60,"Học Tốt","java.net").toRowTable(eventAction));
		addRow(new ModelTopic("TP001","UDPM",500000.0,60,"Học Tốt","java.net").toRowTable(eventAction));
		addRow(new ModelTopic("TP001","UDPM",500000.0,60,"Học Tốt","java.net").toRowTable(eventAction));
		addRow(new ModelTopic("TP001","UDPM",500000.0,60,"Học Tốt","java.net").toRowTable(eventAction));
		addRow(new ModelTopic("TP001","UDPM",500000.0,60,"Học Tốt","java.net").toRowTable(eventAction));
	}

}
