package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import view.ChangePasswordView;

public class ChangepasswordController implements ActionListener,CaretListener{
	private ChangePasswordView view;
	
	public ChangepasswordController(ChangePasswordView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Change")) {
			this.view.Change();
		}
		
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		this.view.ChangeText();
		
	}

}
