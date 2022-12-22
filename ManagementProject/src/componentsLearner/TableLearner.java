package componentsLearner;

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
import javax.swing.table.TableCellEditor;

import componentsStudent.TableHeaderCustom;
import dao.LearnerDAO;
import interfaces.IEvent;
import model.ModelLearner;
import view.ScrollBarCustom;

public class TableLearner extends JTable {
	public static DefaultTableModel tableModel;
	
	private Learner learner;
	
	private ArrayList<ModelLearner> datas = new ArrayList<ModelLearner>();
	
	public TableLearner(Learner learner) {
		this.learner = learner;
		setOpaque(false);
		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MÃ NGƯỜI ĐK", "HỌ VÀ TÊN", "NGÀY SINH",
				"GIỚI TÍNH", "SỐ ĐIỆN THOẠI", "EMAIL","NGÀY ĐĂNG KÝ", "GHI CHÚ"}));
		tableModel = (DefaultTableModel) getModel();
		

		IEvent<ArrayList<ModelLearner>> event = this::OnModelChangedLearner;
		learner.ModelLearnerChanged.subscribe(event);
	}
	
	public void addTableStyle(JScrollPane scroll) {
		scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        setBorder(null);
        scroll.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
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
		
	}
	
	public void OnModelChangedLearner(Object sourse, ArrayList<ModelLearner> eventArgs) {
		datas = eventArgs;
		
		initData();
	}

	public void addRow(Object[] row) {
		tableModel.addRow(row);
	}


	public void initData() {
		tableModel.getDataVector().removeAllElements();
		for (ModelLearner data : datas) {
			Object[] rows = new Object[8];
			rows[0] = data.getPersonCode();
			rows[1] = data.getName();
			rows[2] = data.getDate();
			rows[3] = data.isSex();
			if(data.isSex()) {
				rows[3] = "Nam";
			}else {
				rows[3] = "Nữ";
			}
			rows[4] = data.getPhoneNumber();
			rows[5] = data.getEmail();
			rows[6] = data.getDateOfRegister();
			rows[7] = data.getNote();
			addRow(rows);

		}
	}
	
	

}
