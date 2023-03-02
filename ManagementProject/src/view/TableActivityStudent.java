package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.NotificationDAO;
import model.ModelNotification;
import view.ScrollBarCustom;

public class TableActivityStudent extends JTable {
	private DefaultTableModel tableModel;
	private JTextArea textArea;
	
	public TableActivityStudent() {
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setOpaque(false);
		textArea.setBorder(null);
		textArea.setFont(new Font("SansSerif", Font.BOLD, 18));

		
		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Thông tin hoạt động" }));
		tableModel = (DefaultTableModel) getModel();
		getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(new CenterRenderer());
		getTableHeader().setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(new TableCellRenderer());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(new CenterRenderer());
			}
		});

		setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				table.setShowGrid(false);
				
				if (isSelected) {
					textArea.setForeground(new Color(220, 20, 20));
				} else {
					textArea.setForeground(new Color(191, 191, 191));
				}
				textArea.setText(value.toString());
				int rowHeight = 100;
				table.setRowHeight(row, rowHeight);
				return textArea;
			}
		});

	}

	public void addTableStyle(JScrollPane scroll) {
		scroll.getViewport().setOpaque(false);
		scroll.setViewportBorder(null);
		setBorder(null);
		scroll.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBar(new ScrollBarCustom());
		setIntercellSpacing(new Dimension(0, 0));
		setBackground(new Color(50, 50, 50));
		setFocusable(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		initData();
	}

	public void initData() {

	

	}
	
}
