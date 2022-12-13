package componentsLearner;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import dao.LearnerDAO;
import interfaces.IEvent;
import model.ModelLearner;

public class TableLearner extends JTable {
	public static DefaultTableModel tableModel;
	
	private Learner learner;
	
	private ArrayList<ModelLearner> datas = new ArrayList<ModelLearner>();
	
	public TableLearner(Learner learner) {
		this.learner = learner;
		
		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MÃ NGƯỜI ĐK", "HỌ VÀ TÊN", "NGÀY SINH",
				"GIỚI TÍNH", "SỐ ĐIỆN THOẠI", "EMAIL","NGÀY ĐĂNG KÝ", "GHI CHÚ"}));
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
					Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
							column);
					table.setBorder(noFocusBorder);
					com.setForeground(new Color(102, 102, 102));
					if (isSelected) {
						com.setBackground(Color.decode("#d1ccc0"));
					} else {
						com.setBackground(Color.WHITE);
					}

					return com;
				}
			
		});

		IEvent<ArrayList<ModelLearner>> event = this::OnModelChangedLearner;
		learner.ModelLearnerChanged.subscribe(event);
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
