package componentStatistical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.StaticalRevenueDAO;
import model.ModelStaticalRevenue;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class PanelStaticaRevenue extends JPanel {

	private JComboBox cbbYear;
	private TableStaticalRevenue table;
	private DefaultComboBoxModel cbbModel;
	
	private ArrayList<ModelStaticalRevenue> datas = new ArrayList<ModelStaticalRevenue>();
	private StaticalRevenueDAO dao = new StaticalRevenueDAO();
	
	public PanelStaticaRevenue() {
		setOpaque(false);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		
		JLabel lblRevenue = new JLabel("DOANH THU");
		lblRevenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblRevenue.setForeground(SystemColor.scrollbar);
		lblRevenue.setFont(new Font("SansSerif", Font.BOLD, 20));
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1268, Short.MAX_VALUE)
				.addComponent(lblRevenue, GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGap(0, 49, Short.MAX_VALUE)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRevenue, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelNorth.setLayout(gl_panelNorth);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCenter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE)
						.addComponent(panelNorth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblYear = new JLabel("Năm");
		lblYear.setFont(new Font("SansSerif",Font.PLAIN, 15));
		lblYear.setForeground(new Color(191,191,191));
		
		cbbYear = new JComboBox();
		cbbYear.setOpaque(false);
		cbbYear.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cbbYear.setForeground(new Color(60,60,60));
		cbbYear.setFocusable(false);
		cbbYear.setMaximumRowCount(10);
		
		table = new TableStaticalRevenue();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		table.addTableStyle(scrollPane);
		
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1252, Short.MAX_VALUE)
						.addGroup(gl_panelCenter.createSequentialGroup()
							.addComponent(lblYear)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbbYear, 0, 1211, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYear)
						.addComponent(cbbYear, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelCenter.setLayout(gl_panelCenter);
		setLayout(groupLayout);
		
		initCombobox();
		action();
	}

	public void initCombobox() {
		cbbModel = new DefaultComboBoxModel();
		String[] year = {"","2025","2024","2023","2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"};
	
		for (String string : year) {
			cbbModel.addElement(string);
		}
		cbbYear.setModel(cbbModel);
		
	}
	
	public void action(){
		cbbYear.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				int atIndex = Integer.parseInt(cbbYear.getSelectedItem().toString());
				datas = dao.SelectAll(atIndex);
				
				table.tableModel.setRowCount(0);
				for (ModelStaticalRevenue data : datas) {
					Object[] rows = new Object[7];
					rows[0] = data.getNameTopic();
					rows[1] = data.getNumberOfCourse();
					rows[2] = data.getCountLearner();
					
					double value1 = data.getRevenue();
					long roundedValue1 = Math.round(value1);
				    rows[3] = Long.toString(roundedValue1);	
					
							
					double value2 = data.getHighestRevenue();
					long roundedValue2 = Math.round(value2);
					rows[4] = Long.toString(roundedValue2);
					
			
					double value3 = data.getLowestRevenue();
					long roundedValue3 = Math.round(value3);
					rows[5] = Long.toString(roundedValue3);
					
					double value4 = data.getMediumRevenue();
					long roundedValue4 = Math.round(value4);
					rows[6] = Long.toString(roundedValue4);
					table.tableModel.addRow(rows);
				}
				
			}
		});
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
