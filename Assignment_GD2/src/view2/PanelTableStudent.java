package view2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

public class PanelTableStudent extends JPanel {

	private TableStudent table;
	private JLabel isRole;

	Action student;
	private String role;
	
	
	public PanelTableStudent(String role) {
		this.setForeground(new Color(0, 0, 128));
		this.setBackground(SystemColor.window);
		this.setPreferredSize(new Dimension(946, 480));
		this.setLayout(null);
		this.setBounds(235, 260, 950, 480); 
		this.role = role;
		
		JLabel lblNewLabel = new JLabel("Data Grade");
		lblNewLabel.setForeground(SystemColor.textInactiveText);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 116, 24);
		this.add(lblNewLabel);

		table = new TableStudent(role);
		table.setBorder(null);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 46, 915, 400);
		
		this.add(scrollPane);
		table.initTableData();
		
	}
	
	public String setRole() {
		String Role = isRole.getText();
		return Role;
	}
	
	public JLabel getIsRole() {
		return isRole;
	}

	public void setIsRole(JLabel isRole) {
		this.isRole = isRole;
	}
}
