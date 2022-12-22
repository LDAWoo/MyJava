package componentsTopic;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretListener;

import img.img;
import view.ScrollBarEmployee;
import view.SearchStudent;

import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.Icon;

public class PanelTopicList extends JPanel {
	private TableTopic table;
	private img img = new img();
	
	private int index = -1;
	public int indexSelectedTopic = -1;
	
	public static SearchStudent find;
	
	public PanelTopicList(Topic topic) {
		setBackground(SystemColor.infoText);
		setOpaque(false);
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		panelCenter.setBorder(null);
		
		table = new TableTopic(topic);
		table.setShowGrid(false);
		
		
		table.setBorder(null);
		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setOpaque(false);
		table.addTableStyle(scrollPane);
		
		

		
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
		);
		panelCenter.setLayout(gl_panelCenter);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(60,60,60));
		
		find = new SearchStudent();
		find.setBackground(new Color(60,60,60));
		find.setForeground(new Color(200,200,200));
		find.setCaretColor(new Color(200,200,200));
		
		
		JLabel lblIconFind = new JLabel(img.iconSearch());
		lblIconFind.setBorder(null);
		lblIconFind.setBackground(Color.WHITE);
		
		
	
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
				.addComponent(panelNorth, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
		);
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addComponent(lblIconFind, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(84))
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGap(38)
					.addComponent(find, GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
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
				indexSelectedTopic = index;
			}
		});
	}
	
	public void setSelectedRowTopic(int index) {
		table.setRowSelectionInterval(index, index);
	}
	
	public void addCaretListener(CaretListener event) {
		find.addCaretListener(event);
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
