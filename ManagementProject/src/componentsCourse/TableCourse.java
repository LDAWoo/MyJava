package componentsCourse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import interfaces.IEvent;
import model.ModelCourse;

public class TableCourse extends JTable {
	public static DefaultTableModel tableModel;

	private Course course;
	private ArrayList<ModelCourse> datas = new ArrayList<ModelCourse>();
	public TableCourse(Course course) {
		this.course = course;
		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MÃ KHÓA HỌC", "CHUYÊN ĐỀ", "HỌC PHÍ",
				"THỜI LƯỢNG", "NGÀY KHAI GIẢNG", "NGƯỜI TẠO", "GHI CHÚ"}));
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

				Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				table.setBorder(noFocusBorder);
				com.setForeground(new Color(102, 102, 102));
				if (isSelected) {
					com.setBackground(Color.decode("#d1ccc0"));
				} else {
					com.setBackground(new Color(250, 250, 250));
				}
				return com;
			}

		});
		IEvent<ArrayList<ModelCourse>> event = this::OnModelCourseChanged;
		course.ModelCourseChanged.subscribe(event);
	}
	
	public void OnModelCourseChanged(Object cource, ArrayList<ModelCourse> eventArgs) {
		datas = eventArgs;
		initData();
	}


	public void addRow(Object[] row) {
		tableModel.addRow(row);
	}


	public void initData() {
		tableModel.getDataVector().removeAllElements();
		for (ModelCourse data : datas) {
			Object[] rows = new Object[8];
			rows[0] = data.getCodeCourse();
			rows[1] = data.getCodeTopic();
			rows[2] = data.getTuition();
			rows[3] = data.getTime();
			rows[4] = data.getDayOpening();
			rows[5] = data.getDayCreate();
			rows[6] = data.getCreatePerson();
			rows[7] = data.getNote();
			
			addRow(rows);
		}
	}

}
