package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableStudentScore extends JTable {

	public TableStudentScore() {
		setOpaque(false);
		
		setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"YEAR","COUNTSTUDENT","YEARFIRST","YEARLAST"
		}));
		
		
	}
	
	
	protected void paintComponent(Graphics2D g) {
		Graphics2D g2 = (Graphics2D)g;
		
	}

}
