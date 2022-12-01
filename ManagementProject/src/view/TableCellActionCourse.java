package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import model.ModelActionCourses;

public class TableCellActionCourse extends DefaultCellEditor{
	private ModelActionCourses data;
	
	public TableCellActionCourse() {
		super(new JCheckBox());
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		data = (ModelActionCourses) value;
		ActionCourses cell = new ActionCourses(data);
		cell.setBackground(new Color(239,244,255));
		return cell;
	}
	
	@Override
	public Object getCellEditorValue() {
		return data;
	}
}
