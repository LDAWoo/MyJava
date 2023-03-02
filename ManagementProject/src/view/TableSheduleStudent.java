package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.ScrollBarCustom;

public class TableSheduleStudent extends JTable {
	public static DefaultTableModel tableModel;
	
	
	public TableSheduleStudent() {
		setOpaque(false);
		
		setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"STT","Ngày","Phòng","Giảng đường","Mã môn","Môn","Lớp","Giảng viên","Ca","Thời gian","Link học Online","Chi tiết"
		}));
		tableModel = (DefaultTableModel) getModel();
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
        
	}

}
