package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import img.img;
import model.ModelActionLearner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ActionLearner extends JPanel{
	
	private JButton btnEdit;
	private JButton btnDelete;
	private img img = new img();
	
	public ActionLearner(ModelActionLearner data) {
		setBackground(SystemColor.window);
		
		btnEdit = new JButton("",this.img.iconEdit());
		btnEdit.setBackground(SystemColor.window);
		btnEdit.setBorder(null);
		btnEdit.setBounds(0, 0, 39, 39);
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				data.getEvent().update(data.getLearner());
			
			}
		});
			
		btnDelete = new JButton("",this.img.iconDelete());
		btnDelete.setBackground(SystemColor.window);
		btnDelete.setBorder(null);
		btnDelete.setBounds(40, 0, 39, 39);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				data.getEvent().delete(data.getLearner());
				
			}
		});
		setLayout(null);
		add(btnEdit);
		add(btnDelete);
		
		
	}
}
