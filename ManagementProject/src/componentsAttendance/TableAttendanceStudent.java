package componentsAttendance;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import componentsStudent.TableHeaderCustom;

public class TableAttendanceStudent extends JTable {

	private DefaultTableModel tableModel;

	public TableAttendanceStudent() {
		setOpaque(false);
		setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Bài học", "Ngày", "Ca", "Người điểm danh", "Mô tả", "Trạng thái đi học", "Ghi chú" }));

		tableModel = (DefaultTableModel) getModel();

		getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
			@Override
			protected void setValue(Object value) {
				setText(value.toString());
				setFont(new Font("SansSerif",Font.PLAIN,15));
				setForeground(new Color(200,200,200));
			}
		});
	}

	

	public void addTableStyle(JScrollPane scrollPane) {
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setViewportBorder(null);
		setRowHeight(45);
		setBorder(null);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		getTableHeader().setDefaultRenderer(new TableHeaderCustom());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 60, 60));
		setForeground(new Color(214, 214, 214));
		setSelectionForeground(new Color(214, 214, 214));
		setSelectionBackground(new Color(50, 50, 50));

		setIntercellSpacing(new Dimension(0, 0));
		setBackground(new Color(60, 60, 60));
		setFocusable(false);
		scrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
		
		getColumnModel().getColumn(0).setPreferredWidth(50);
		getColumnModel().getColumn(1).setPreferredWidth(30);
		getColumnModel().getColumn(2).setPreferredWidth(20);
		getColumnModel().getColumn(3).setPreferredWidth(100);
		getColumnModel().getColumn(4).setPreferredWidth(50);
		getColumnModel().getColumn(5).setPreferredWidth(100);
		getColumnModel().getColumn(6).setPreferredWidth(150);
	}

}
