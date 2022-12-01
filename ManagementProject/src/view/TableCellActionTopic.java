package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import model.ModelActionTopic;

public class TableCellActionTopic extends DefaultCellEditor{
	private ModelActionTopic data;
	
	
	public TableCellActionTopic() {
		super(new JCheckBox());
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		data = (ModelActionTopic) value;
		ActionTopic cell = new ActionTopic(data);
		cell.setBackground(new Color(239,244,255));
		return cell;
	}
	
	@Override
	public Object getCellEditorValue() {

		return data;
	}
	
}
