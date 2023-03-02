package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretListener;

import animation.TextField;
import img.img;
import view.ScrollBarEmployee;
import view.ScrollBarLearner;
import view.SearchStudent;

import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class PanelLearnerList extends JPanel {
	private TableLearner table;
	private img img = new img();
	public TextField find;
	
	private int index = -1;
	public int indexSelectedLearner = -1;

	public PanelLearnerList(Learner learner) {
		setBorder(null);
		setOpaque(false);
		JPanel panelCenter = new JPanel();
		
		find = new TextField();
		find.setHint("Tìm kiếm người học ...");
		find.setFont(new Font("SansSerif",Font.PLAIN, 15));
		find.setCaretColor(new Color(200,200,200));
		find.setForeground(new Color(200,200,200));
		
		
		
		table = new TableLearner(learner);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		table.addTableStyle(scrollPane);
		
		
		scrollPane.setVerticalScrollBar(new ScrollBarEmployee());
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
		);
		panelCenter.setLayout(gl_panelCenter);
	
		panelCenter.setBackground(new Color(60,60,60));
		panelCenter.setBorder(null);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(60,60,60));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panelNorth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
				.addComponent(panelCenter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
		);
		
		JLabel lblIconFind = new JLabel(img.iconSearch());
		lblIconFind.setBorder(null);
		lblIconFind.setBackground(Color.WHITE);
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addComponent(lblIconFind, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(89))
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGap(38)
					.addComponent(find, GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIconFind, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelNorth.createSequentialGroup()
							.addGap(2)
							.addComponent(find, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panelNorth.setLayout(gl_panelNorth);
		setLayout(groupLayout);
		Action();
	}

	public void Action() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				index = table.getSelectedRow();
				indexSelectedLearner = index;
			}
		});
		
	}
	
	public void addCaretListener(CaretListener event) {
		find.addCaretListener(event);
	}
	
	public void setSelectedTableLearner(int index) {
		table.setRowSelectionInterval(index, index);
		
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
}
