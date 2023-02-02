package componentsStudent;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.raven.table.TableCustom;

import view.ScrollBarCustom;
import view.ScrollBarEmployee;

public class Table extends TableCustom{
	public static DefaultTableModel tableModel;
	public Table() {
	
		
		setModel(new DefaultTableModel(new Object[][] {
		}, new String[] {"MÃ HỌC VIÊN","MÃ KHÓA HỌC", "MÃ NGƯỜI HỌC", "HỌ VÀ TÊN","GIỚI TÍNH","TUỔI","ĐIỂM",
				"CHỈNH SỬA"
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
	        setRowHeight(47);
	        setShowHorizontalLines(true);
	        setGridColor(new Color(50, 50, 50));
	        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {	
		Component com = super.prepareRenderer(renderer, row, column);
		
		if(!isCellSelected(row, column)) {
			com.setBackground(new Color(60,60,60));
		}
		
		return com;
	}
	

}
