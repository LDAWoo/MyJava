package componentTableShedule;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class PanelTableSheduleStudent extends JPanel {
	private TableSheduleStudent table;
	private JComboBox cbbTime;
	
	private DefaultComboBoxModel cbbModel;

	public PanelTableSheduleStudent() {
		setOpaque(false);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCenter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
						.addComponent(panelNorth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblShedule2 = new JLabel("Lịch học");
		lblShedule2.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblShedule2.setForeground(new Color(191,191,191));
		
		table = new TableSheduleStudent();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		table.addTableStyle(scrollPane);
		
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblShedule2)
					.addContainerGap(1019, Short.MAX_VALUE))
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblShedule2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
		);
		panelCenter.setLayout(gl_panelCenter);
		
		JLabel lblShedule = new JLabel("Lịch học");
		lblShedule.setHorizontalAlignment(SwingConstants.CENTER);
		lblShedule.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblShedule.setForeground(new Color(200,200,200));
		
		
		JLabel lblTime = new JLabel("Thời gian");
		lblTime.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblTime.setForeground(new Color(191,191,191));
		
		cbbTime = new JComboBox();
		cbbTime.setOpaque(false);
		cbbTime.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cbbTime.setForeground(new Color(60,60,60));
		cbbTime.setFocusable(false);
		cbbTime.setMaximumRowCount(10);
		
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
						.addComponent(lblShedule, GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
						.addGroup(gl_panelNorth.createSequentialGroup()
							.addComponent(lblTime)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbbTime, 0, 992, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblShedule, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTime)
						.addComponent(cbbTime, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		panelNorth.setLayout(gl_panelNorth);
		setLayout(groupLayout);
		
		initCombobox();
	}
	
	public void initCombobox() {
		cbbModel = new DefaultComboBoxModel();
		
		String[] dataTime = new String[] {"7 ngày tới","14 ngày tới","30 ngày tới","60 ngày tới","90 ngày tới","7 ngày sau","14 ngày sau","30 ngày sau","60 ngày sau","90 ngày sau"};
		
		for (String string : dataTime) {
			cbbModel.addElement(string);
		}
		cbbTime.setModel(cbbModel);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(60,60,60));
		g2.fillRect(0, 0, getWidth(), getHeight());		
		super.paintComponent(g);
	}
}
