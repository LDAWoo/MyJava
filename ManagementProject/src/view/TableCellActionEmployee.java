package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


import model.ModelActionEmployee;

public class TableCellActionEmployee extends DefaultCellEditor{
	private ModelActionEmployee data;
	
	public TableCellActionEmployee(){
		super(new JCheckBox());
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		data = (ModelActionEmployee) value;
		ActionEmployee cell = new ActionEmployee(data);
		cell.setBackground(new Color(239,244,255));
		return cell;
	}
	
	@Override
	public Object getCellEditorValue() {
		return data;
	}
}
