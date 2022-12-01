package view2;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellAction extends DefaultCellEditor{
	

	private ModelAction data;

	
	public TableCellAction() {
		super(new JCheckBox());
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		data = (ModelAction)value;
		Action cell = new Action(data);
		cell.setBackground(new Color(239,244,255));
	
		return cell;
	}
	
	@Override
	public Object getCellEditorValue() {
		return data;
	}
	
	

}
