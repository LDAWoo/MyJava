package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellRenderer extends DefaultTableCellRenderer {


	public TableCellRenderer() {
		setPreferredSize(new Dimension(0,35));
		setBackground(new Color(50,50,50));
		setForeground(new Color(200,200,200));
		setHorizontalAlignment(CENTER);
		setBorder(null);
		setPreferredSize(new Dimension(getWidth(), 50));
		setForeground(new Color(191,191,191));
	}

	@Override
	protected void setValue(Object value) {
		setText("<html><u>" + value.toString() + "</u></html>");
		setFont(new Font("Tahoma",Font.BOLD,22));
		setForeground(new Color(255,255,255));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(100, 100, 100));
		g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
	}

}
