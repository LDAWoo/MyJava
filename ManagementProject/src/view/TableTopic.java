package view;

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
import interfaces.IEvent;
import model.ModelTopic;
import view.ScrollBarCustom;

public class TableTopic extends JTable {
	public static DefaultTableModel tableModel;
	
	private ArrayList<ModelTopic> datas = new ArrayList<ModelTopic>();

	public TableTopic(Topic topic) {
		setOpaque(false);

		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MÃ CHUYÊN ĐỀ", "TÊN CHUYÊN ĐỀ", "HỌC PHÍ",
				"THỜI LƯỢNG", "MÔ TẢ CHUYÊN ĐỀ" }));
		tableModel = (DefaultTableModel) getModel();

		IEvent<ArrayList<ModelTopic>> event = this::OnModelTopicChange;	
		topic.ModelTopicChanged.subscribe(event);
	
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
        
        
       getColumnModel().getColumn(0).setPreferredWidth(10);
       getColumnModel().getColumn(1).setPreferredWidth(200);
       getColumnModel().getColumn(2).setPreferredWidth(10);
       getColumnModel().getColumn(3).setPreferredWidth(10);
       getColumnModel().getColumn(4).setPreferredWidth(300);
      	
	}
	
	public void OnModelTopicChange(Object source, ArrayList<ModelTopic> eventArgs) {
		datas = eventArgs;
		initData();
		
	}

	public void addRow(Object[] row) {
		tableModel.addRow(row);
	}
	
	
	public void initData() {
		tableModel.getDataVector().removeAllElements();
		for (ModelTopic data : datas) {
			Object[] rows = new Object[6];
			rows[0] = data.getCodeTopic();
			rows[1] = data.getNameTopic();
			
			double value = data.getTuition();
			long roundValue = Math.round(value);
			
			rows[2] = Long.toString(roundValue);
			rows[3] = data.getTime();
			rows[4] = data.getDescriber();
			addRow(rows);
		}
	}
	


}
