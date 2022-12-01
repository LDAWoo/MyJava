package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ForgotPasswordView;

public class ForgotPasswordController implements ActionListener{
	private ForgotPasswordView view;

	public ForgotPasswordController(ForgotPasswordView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Continue")) {
			this.view.Continue();
		}
		
	}
	
}
