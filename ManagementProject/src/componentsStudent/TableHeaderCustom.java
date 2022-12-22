package componentsStudent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.table.DefaultTableCellRenderer;

public class TableHeaderCustom extends DefaultTableCellRenderer{
	public TableHeaderCustom() {
		setPreferredSize(new Dimension(0,35));
		setBackground(new Color(60,60,60));
		setForeground(new Color(200,200,200));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(100, 100, 100));
		g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
	}
}