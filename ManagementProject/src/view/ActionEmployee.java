package view;

import javax.swing.JPanel;

import img.img;
import model.ModelActionEmployee;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActionEmployee extends JPanel {

	private img img = new img();
	
	public ActionEmployee(ModelActionEmployee data) {
		setLayout(null);
		JButton btnEdit = new JButton("");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.getEvent().Update(data.getEmployee());
			}
		});
		btnEdit.setIcon(img.iconEdit());
		btnEdit.setBorder(null);
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBounds(0, 0, 39, 39);
		add(btnEdit);
		
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.getEvent().Delete(data.getEmployee());
			}
		});
		btnDelete.setIcon(img.iconDelete());
		btnDelete.setBorder(null);
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(40, 0, 39, 39);
		add(btnDelete);
		
	}
}
