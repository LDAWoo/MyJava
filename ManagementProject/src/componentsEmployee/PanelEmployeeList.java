package componentsEmployee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.Caret;

import animation.TextField;
import dao.EmployeeDAO;
import img.img;
import interfaces.IEvent;
import model.ModelEmployee;
import view.ScrollBarEmployee;
import view.SearchStudent;

import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class PanelEmployeeList extends JPanel {
	private TableEmployee table;
	private img img = new img();
	private TextField find;
	private int index = -1;
	private Employee employee;

	public int IndexSelectedEmployee =-1;
	public PanelEmployeeList(Employee employee) {
		setBorder(null);
		setOpaque(false);

		
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		
		find = new TextField();
		find.setHint("Tìm kiếm nhân viên ...");
		find.setFont(new Font("SansSerif",Font.PLAIN, 15));
		find.setCaretColor(new Color(200,200,200));
		find.setForeground(new Color(200,200,200));
		
		table = new TableEmployee(employee);
		table.setBorder(null);
		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		table.addTableStyle(scrollPane);

		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
		);
		panelCenter.setLayout(gl_panelCenter);
		panelCenter.setBackground(new Color(60,60,60));
		panelCenter.setBorder(null);
		

		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(60,60,60));
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panelCenter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
				.addComponent(panelNorth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
		);
		
		JLabel lblIconFind = new JLabel(img.iconSearch());
		lblIconFind.setBorder(null);
		lblIconFind.setBackground(Color.WHITE);
		
		
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNorth.createSequentialGroup()
							.addGap(38)
							.addComponent(find, GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE))
						.addComponent(lblIconFind, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGap(2)
					.addComponent(find, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
				.addComponent(lblIconFind, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
		);
		panelNorth.setLayout(gl_panelNorth);
		setLayout(groupLayout);
		Action();	
	}

		
	public void addFindCaretListener(CaretListener event) {
		find.addCaretListener(event);
	}
	
	public void Action() {
		table.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mousePressed(MouseEvent e) {
				index = table.getSelectedRow();	
				IndexSelectedEmployee =index;

				
			}
		});
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(60,60,60));
		g2.fillRect(0, 20, getSize().width, getSize().height-20);
		g2.fillRect(255, 1, 142, 19);
		super.paintComponent(g);
	}

	
	
	public TextField getFind() {
		return find;
	}

	public void setFind(TextField find) {
		this.find = find;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}


	public void setSelectedRowEmployee(int index) {
		table.setRowSelectionInterval(index, index);
	}

}
