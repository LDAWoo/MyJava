package view;

import javax.swing.JPanel;

import img.img;
import model.ModelActionCourses;
import model.ModelCourse;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Color;

public class ActionCourses extends JPanel{
	
	private img img = new img();
	
	public ActionCourses(ModelActionCourses data) {
		setLayout(null);
		
		JButton btnEdit = new JButton("");
		btnEdit.setBorder(null);
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.getEvent().Update(data.getCourse());
			}
		});
		btnEdit.setBounds(0, 0, 39, 39);
		btnEdit.setIcon(img.iconEdit());
		add(btnEdit);
		
		JButton btnDelete = new JButton("");
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setBorder(null);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.getEvent().Delete(data.getCourse());
			}
		});
		btnDelete.setBounds(40, 0, 39, 39);
		btnDelete.setIcon(img.iconDelete());
		add(btnDelete);
		
	}
}
