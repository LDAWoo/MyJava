package componentProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;

import componentsCurve.CurveLineChart;
import componentsCurve.DatabaseConnection;
import componentsCurve.ModelChart;
import model.ModelData;
import view.MainForm;
import view.PanelMode;

import javax.swing.border.EmptyBorder;

import color.ColorBackground;

public class PanelOverview extends JPanel {
	private Color colorOverview = new Color(26, 29, 31);
	private Color color1 = new Color(252, 252, 252);

	private Color color2 = new Color(39, 43, 48);
	private Color color3 = new Color(0, 0, 0);
	private Color color4 = new Color(191, 191, 191);

	private ButtonCustomers btnCustomers;
	private ButtonIncome btnIncome;
	private CurveLineChart chart;
	private JPanel panelBody;
	private PanelCustomers panelCustomers;
	private JLabel lblOverview;

	int index = 1;


	public PanelOverview() {
		setOpaque(false);
		lblOverview = new JLabel("Tổng Quan");
		lblOverview.setForeground(color1);
		lblOverview.setFont(new Font("Roboto", Font.BOLD, 18));

		panelCustomers = new PanelCustomers();
		panelBody = new JPanel();
		panelBody.setBorder(null);
		panelBody.setOpaque(false);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(41).addComponent(lblOverview))
								.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(panelCustomers,
										GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(26, Short.MAX_VALUE))
				.addComponent(panelBody, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(23).addComponent(lblOverview).addGap(34)
						.addComponent(panelCustomers, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelBody, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)));

		setLayout(groupLayout);

		btnCustomers = new ButtonCustomers();
		btnCustomers.setColorCustomers(color2);

		btnIncome = new ButtonIncome();
		btnIncome.setColorIncome(color3);
		GroupLayout gl_panelCustomers = new GroupLayout(panelCustomers);
		gl_panelCustomers.setHorizontalGroup(gl_panelCustomers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCustomers.createSequentialGroup().addContainerGap()
						.addComponent(btnCustomers, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnIncome, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(14, Short.MAX_VALUE)));
		gl_panelCustomers.setVerticalGroup(gl_panelCustomers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCustomers.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelCustomers.createParallelGroup(Alignment.LEADING)
								.addComponent(btnIncome, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCustomers, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
						.addContainerGap()));
		panelCustomers.setLayout(gl_panelCustomers);
		
		if (MainForm.mode == "Dark") {
			lblOverview.setForeground(ColorBackground.colorLight);
			colorOverview = new Color(26, 29, 31);
			panelCustomers.setColorCustomers(ColorBackground.colorGRB000);
			
			btnCustomers.setColorCustomers(color2);
			btnIncome.setColorIncome(color3);
			repaint();

		} else {
			lblOverview.setForeground(ColorBackground.colorDark);
			colorOverview = ColorBackground.colorLight;
			panelCustomers.setColorCustomers(ColorBackground.colorGRB240242245);

			btnCustomers.setColorCustomers(ColorBackground.colorLight);
			btnIncome.setColorIncome(ColorBackground.colorGRB240242245);
			repaint();
		}
		
		showFormBody(new PanelViewAllCustomer());
		actionButton();

	}

	public void init() {
		chart.setTitle("Doanh Thu");
		chart.addLegend("Số Lượng", Color.decode("#93291E"), Color.decode("#780206"));
		chart.addLegend("Giá Cả", Color.decode("#e65c00"), Color.decode("#F9D423"));
		chart.addLegend("Lợi Nhuận", Color.decode("#0099F7"), Color.decode("#4286f4"));
		setData();
	}

	public void setData() {
		try {
			List<ModelData> lists = new ArrayList<>();
			DatabaseConnection.getInstance().connectToDatabase();
			String sql = "SELECT DATENAME(MONTH,Date) month, SUM(TotalAmount) as Amount, SUM(TotalCost) as Cost, SUM(TotalProfit) as Profit from orders group by DATENAME(MONTH,Date)";
			PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
			ResultSet r = p.executeQuery();
			while (r.next()) {
				String month = r.getString("Month");
				double amount = r.getDouble("Amount");
				double cost = r.getDouble("Cost");
				double profit = r.getDouble("Profit");

				lists.add(new ModelData(month, amount, cost, profit));
			}
			r.close();
			p.close();
			// Add Data to chart
			for (int i = lists.size() - 1; i >= 0; i--) {
				ModelData d = lists.get(i);
				chart.addData(new ModelChart(d.getMonth(), new double[] { d.getAmount(), d.getCost(), d.getProfit() }));
			}
			// Start to show data with animation
			chart.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionButton() {
		btnCustomers.addMouseListener(new MouseAdapter() {
			private PanelViewAllCustomer panel;

			@Override
			public void mousePressed(MouseEvent e) {
				index = 1;

				if (MainForm.mode == "Dark") {
					if (e.getClickCount() == 1) {
						btnCustomers.setColorCustomers(color2);
						btnIncome.setColorIncome(color3);
					}

				} else {
					if (e.getClickCount() == 1) {
						btnCustomers.setColorCustomers(ColorBackground.colorLight);
						btnIncome.setColorIncome(ColorBackground.colorGRB240242245);
					}
				}

				
				showFormBody(new PanelViewAllCustomer());
			}
		});

		btnIncome.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				index = 2;

				if (MainForm.mode == "Dark") {

					if (e.getClickCount() == 1) {
						btnIncome.setColorIncome(color2);
						btnCustomers.setColorCustomers(color3);
					}
				} else {
					if (e.getClickCount() == 1) {
						btnCustomers.setColorCustomers(ColorBackground.colorGRB240242245);
						btnIncome.setColorIncome(ColorBackground.colorLight);
					}
				}

				chart = new CurveLineChart();
				chart.setForeground(new Color(191, 191, 191));
				chart.setFillColor(true);
				chart.setBorder(null);
				chart.setBackground(new Color(26, 29, 31));
				init();
				showFormBody(chart);
			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblOverview.setForeground(ColorBackground.colorDark);
				colorOverview = ColorBackground.colorLight;
				panelCustomers.setColorCustomers(ColorBackground.colorGRB240242245);

				if (index == 1) {
					btnCustomers.setColorCustomers(ColorBackground.colorLight);
					btnIncome.setColorIncome(ColorBackground.colorGRB240242245);
				} else {
					btnCustomers.setColorCustomers(ColorBackground.colorGRB240242245);
					btnIncome.setColorIncome(ColorBackground.colorLight);
				}

				repaint();
			}
		});

		PanelMode.actionButonModeDark(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblOverview.setForeground(ColorBackground.colorLight);
				colorOverview = new Color(26, 29, 31);
				panelCustomers.setColorCustomers(ColorBackground.colorGRB000);

				if (index == 1) {
					btnCustomers.setColorCustomers(color2);
					btnIncome.setColorIncome(color3);
				} else {
					btnCustomers.setColorCustomers(color3);
					btnIncome.setColorIncome(color2);
				}

				repaint();

			}
		});

	}

	public void showFormBody(JComponent com) {
		panelBody.removeAll();
		GroupLayout gl_panelBody = new GroupLayout(panelBody);
		gl_panelBody.setHorizontalGroup(gl_panelBody.createParallelGroup(Alignment.LEADING).addComponent(com,
				GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE));
		gl_panelBody.setVerticalGroup(gl_panelBody.createParallelGroup(Alignment.LEADING).addComponent(com,
				GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE));
		panelBody.setLayout(gl_panelBody);
		panelBody.repaint();
		panelBody.revalidate();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorOverview);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintComponent(g);
	}
}
