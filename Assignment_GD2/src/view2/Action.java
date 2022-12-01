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

public class Action extends JPanel{
	
	img img = new img(this);
	private JButton btnDelete;
	private JButton btnEdit;
	PanelTableStudent student;
	FrameView view;
	
	private JLabel lblRole;
	
	public Action(ModelAction data) {
		setLayout(null);   
		btnEdit = new JButton("");
		btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdit.setBorder(null);
		btnEdit.setBackground(SystemColor.window);
		btnEdit.setOpaque(true);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.getEvent().update(data.getStudent());
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
				data.getEvent().delete(data.getStudent());
			}
		});
		btnDelete.setBounds(35, 5, 29, 29);
		btnDelete.setIcon(this.img.ImageDelet());
		
		add(btnDelete);
		
		lblRole = new JLabel("");
		lblRole.setBounds(74, 5, 46, 29);
		add(lblRole);
		
		
		
	}
	
	public Action() {}
	
	public JLabel getLblRole() {
		return lblRole;
	}





	public void setLblRole(JLabel lblRole) {
		this.lblRole = lblRole;
	}





	public JButton getBtnDelete() {
		return btnDelete;
	}



	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	

	public JButton getBtnEdit() {
		return btnEdit;
	}



	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}
	
}
