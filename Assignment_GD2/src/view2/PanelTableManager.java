package view2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelTableManager extends JPanel{
	
	TableManager table;
	String role;
	
	public PanelTableManager(String role) {
		this.role = role;
		this.setForeground(new Color(0, 0, 128));
		this.setBackground(SystemColor.window);
		this.setPreferredSize(new Dimension(946, 480));
		this.setLayout(null);
		this.setBounds(235, 260, 950, 480); 
		
		JLabel lblNewLabel = new JLabel("Data Student");
		lblNewLabel.setForeground(SystemColor.textInactiveText);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 116, 24);
		this.add(lblNewLabel);
		
		table = new TableManager(role);
		table.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 46, 915, 400);
		this.add(scrollPane);
		table.initTableData();
	}

}
