package view2;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellAction2 extends DefaultCellEditor{

	private ModelManagerAction data;
	
	public TableCellAction2() {
		super(new JCheckBox());
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		data = (ModelManagerAction)value;
		Action2 cell = new Action2(data);
		cell.setBackground(new Color(239,244,255));
		return cell;
	}
	
	@Override
	public Object getCellEditorValue() {
		return data;
	}
	
	

}
