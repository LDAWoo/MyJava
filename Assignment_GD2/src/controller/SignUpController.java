package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import view.SignUpView;

public class SignUpController implements MouseListener,CaretListener,ActionListener{
	private SignUpView view;

	public SignUpController(SignUpView view) {

		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.view.Exit();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		this.view.ShowEyes();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("REGISTER")) {
			this.view.Register();
		}
		
	}

}
