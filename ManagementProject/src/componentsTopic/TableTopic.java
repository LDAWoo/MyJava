package componentsTopic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import interfaces.IEvent;
import model.ModelTopic;

public class TableTopic extends JTable {
	public static DefaultTableModel tableModel;
	
	private ArrayList<ModelTopic> datas = new ArrayList<ModelTopic>();

	public TableTopic(Topic topic) {
		

		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MÃ CHUYÊN ĐỀ", "TÊN CHUYÊN ĐỀ", "HỌC PHÍ",
				"THỜI LƯỢNG", "MÔ TẢ CĐ" }));
		tableModel = (DefaultTableModel) getModel();
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
			
		});
		IEvent<ArrayList<ModelTopic>> event = this::OnModelTopicChange;	
		topic.ModelTopicChanged.subscribe(event);
	
	}
	
	public void OnModelTopicChange(Object source, ArrayList<ModelTopic> eventArgs) {
		datas = eventArgs;
		initData();
		
	}

	public void addRow(Object[] row) {
		tableModel.addRow(row);
	}
	
	
	public void initData() {
		tableModel.getDataVector().removeAllElements();
		for (ModelTopic data : datas) {
			Object[] rows = new Object[6];
			rows[0] = data.getCodeTopic();
			rows[1] = data.getNameTopic();
			rows[2] = data.getTuition();
			rows[3] = data.getTime();
			rows[4] = data.getDescriber();
			addRow(rows);
		}
	}
	


}
