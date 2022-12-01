package view;

import javax.swing.JPanel;

import img.img;
import model.ModelActionTopic;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActionTopic extends JPanel {
	private img img = new img();
	
	public ActionTopic(ModelActionTopic data) {
		setLayout(null);
		
		JButton lblEdit = new JButton("");
		lblEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.getEvent().Update(data.getTopic());
				
			}
		});
		lblEdit.setBorder(null);
		lblEdit.setBackground(Color.WHITE);
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setBounds(0, 0, 39, 39);
		lblEdit.setIcon(this.img.iconEdit());
		add(lblEdit);
		
		JButton lblDelete = new JButton("");
		lblDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.getEvent().Delete(data.getTopic());
			}
		});
		lblDelete.setBackground(Color.WHITE);
		lblDelete.setBorder(null);
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setBounds(40, 0, 39, 39);
		lblDelete.setIcon(this.img.iconDelete());
		add(lblDelete);
		
	}

}
