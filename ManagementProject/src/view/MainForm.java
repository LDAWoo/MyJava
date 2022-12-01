package view;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import date.CurrendarCustom;
import date.PanelDate;

import javax.swing.JLabel;

public class MainForm extends JPanel{
	CurrendarCustom date;
	
	public MainForm() {
		setBackground(SystemColor.window);

	}
	
	
	public void showForm(Component form) {
		removeAll();
		add(form);
		repaint();
		revalidate();
	}
	
}
