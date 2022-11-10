package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import view.GradeStudentView;

public class GradeStudentController implements ActionListener,MouseListener,CaretListener{
	private GradeStudentView view;
	
	public GradeStudentController(GradeStudentView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		
		if(button.equals("Save")) {
			this.view.Save();
		}else if(button.equals("Delete")) {
			this.view.Delete();
		}else if(button.equals("Search")) {
			this.view.Find();
		}else if(button.equals("New")) {
			this.view.ClearForm();
		}else if(button.equals("Update")) {
			this.view.Update();
		}else if(button.equals("TOP 3")) {
			this.view.TopThree();
		}else if(button.equals("ALL")) {
			this.view.ALL();
		}
			
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		this.view.ShowOutLine();
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.view.Click();
		
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

	

}
