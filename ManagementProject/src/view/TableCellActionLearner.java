package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import model.ModelActionLearner;

public class TableCellActionLearner extends DefaultCellEditor{
	private ModelActionLearner data;
	
	public TableCellActionLearner() {
		super(new JCheckBox());
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		data = (ModelActionLearner) value;
		ActionLearner cell = new ActionLearner(data);
		cell.setBackground(new Color(239,244,255));
		return cell;
	}
	
	@Override
	public Object getCellEditorValue() {
		return data;
	}
	
}
