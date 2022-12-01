package view2;

import javax.swing.JPanel;

import img.img;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Action2 extends JPanel{
	
	img img = new img(this);
	private JButton btnDelete;
	
	public Action2(ModelManagerAction data) {
		setLayout(null);
		
		JButton btnEdit = new JButton("");
		btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdit.setBorder(null);
		btnEdit.setBackground(SystemColor.window);
		btnEdit.setOpaque(true);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.getEvent().update(data.getManager());
			}
		});
		btnEdit.setBounds(0, 5, 29, 29);
		btnEdit.setIcon(this.img.ImageEdit());
		add(btnEdit);
		
		btnDelete = new JButton("");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setBorder(null);
		btnDelete.setBackground(Color.WHITE);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.getEvent().delete(data.getManager());
			}
		});
		btnDelete.setBounds(35, 5, 29, 29);
		btnDelete.setIcon(this.img.ImageDelet());
		add(btnDelete);
	}
	

}
