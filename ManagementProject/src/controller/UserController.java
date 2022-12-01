package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.LoginUserView;
import view.SignUpView;



public class UserController implements ActionListener,MouseListener{
	private LoginUserView view ;
	
	public UserController(LoginUserView View) {
		view = View ;
	}
	

	


	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("LOGIN")) {
			this.view.Login();
		}
		
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
	
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
