package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ManagerUserAndGradeView;

public class ManagerStudentAndGradeController implements ActionListener{
	private ManagerUserAndGradeView view;
	

	public ManagerStudentAndGradeController(ManagerUserAndGradeView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		
		if(button.equals("Log Out")) {
			this.view.LogOut();
		}else if(button.equals("Exit")) {
			this.view.Exit();
		}else if(button.equals("ManagerStudent")) {
			this.view.ManagerStudent();
		}else if(button.equals("ManagerGrade")) {
			this.view.ManagerGrade();
		}
		
		
		
	}

}
