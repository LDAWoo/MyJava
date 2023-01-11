package componentsCourse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import componentsStudent.TableHeaderCustom;
import interfaces.IEvent;
import model.ModelCourse;
import view.ScrollBarCustom;

public class TableCourse extends JTable {
	public static DefaultTableModel tableModel;


	private ArrayList<ModelCourse> datas = new ArrayList<ModelCourse>();
	public TableCourse(Course course) {
		setOpaque(false);
		
		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MÃ KHÓA HỌC", "MÃ CHUYÊN ĐỀ", "HỌC PHÍ",
				"THỜI LƯỢNG", "NGÀY KHAI GIẢNG","NGÀY TẠO", "NGƯỜI TẠO", "GHI CHÚ"}));
		tableModel = (DefaultTableModel) getModel();
	
		
	
		IEvent<ArrayList<ModelCourse>> event = this::OnModelCourseChanged;
		course.ModelCourseChanged.subscribe(event);
	}
	
	public void addTableStyle(JScrollPane scroll) {
		scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        setBorder(null);
        scroll.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(60, 60, 60));
        
        setForeground(new Color(214, 214, 214));
        setSelectionForeground(new Color(214, 214, 214));
        setSelectionBackground(new Color(50, 50, 50));
        getTableHeader().setDefaultRenderer(new TableHeaderCustom());
        setRowHeight(45);
     
        getTableHeader().setReorderingAllowed(false);
		getTableHeader().setFont(new Font("SanSerif", Font.PLAIN, 15));
		getTableHeader().setForeground(Color.decode("#84817a"));

		setIntercellSpacing(new Dimension(0, 0));
		setBackground(new Color(60,60,60));
		setFocusable(false);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        

		getColumnModel().getColumn(0).setPreferredWidth(20);
		getColumnModel().getColumn(1).setPreferredWidth(20);
		getColumnModel().getColumn(2).setPreferredWidth(30);
		getColumnModel().getColumn(3).setPreferredWidth(20);
		getColumnModel().getColumn(4).setPreferredWidth(20);
		getColumnModel().getColumn(5).setPreferredWidth(20);
		getColumnModel().getColumn(6).setPreferredWidth(20);
		getColumnModel().getColumn(7).setPreferredWidth(200);
		
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
			
			double value = data.getTuition();
			long roundValue = Math.round(value);
			
			rows[2] = Long.toString(roundValue);
			rows[3] = data.getTime();
			rows[4] = data.getDayOpening();
			rows[5] = data.getDayCreate();
			rows[6] = data.getCreatePerson();
			rows[7] = data.getNote();	
			addRow(rows);
		}
	}

}
