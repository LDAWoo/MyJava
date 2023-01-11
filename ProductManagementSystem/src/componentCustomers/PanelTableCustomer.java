package componentCustomers;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import componentButton.ButtonNotification;
import componentHeader.DialogNotification;
import componentScrollPane.ScrollBarMenu;
import componentsCurve.DatabaseConnection;
import dao.DAOCustomers;
import model.ModelCustomerList;
import model.ModelMessage;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import view.PanelHeader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.lang.Math;

public class PanelTableCustomer extends JPanel {

	private MigLayout layout;
	private PanelCustomerHeader panelHeader;
	private JPanel body;
	private JPanel bottom;
	private JPanel panel;
	private JPanel panelBody;
	private Color color = new Color(252,252,232);
	private int countCustomers = -1;
	private ArrayList<ModelCustomerList> datas = new ArrayList<ModelCustomerList>();
	private DAOCustomers dao = new DAOCustomers();
	
	ImageIcon image = new ImageIcon(new ImageIcon(PanelTableCustomer.class.getResource("/icon/logo-shop.png"))
			.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
	private JLabel lblCustomerList;


	public PanelTableCustomer() {
		setOpaque(false);
		setLayout(new MigLayout("fill"));
		panel = new JPanel();
		
		panel.setOpaque(false);
		
		layout = new MigLayout("fill,wrap,inset 1", "[fill]", "[120!,fill][fill,100%][::60%,shrink 0]");
		panel.setLayout(layout);
		
		panelHeader = new PanelCustomerHeader();
		
		body = createPanelBody();
		JScrollPane scrollPane = new JScrollPane(body);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setVerticalScrollBar(new ScrollBarMenu());
		
		
		bottom = createPanelBottom();
		
		
		
		panel.add(panelHeader);
		panel.add(scrollPane);
		panel.add(bottom, "");
		

		add(panel, "push,grow");
	}
	
	public JPanel createPanelBody() {
		panelBody = new JPanel();
		panelBody.setOpaque(false);
		panelBody.setLayout(new MigLayout("wrap,fillx"));
		panelBody.setBorder(null);
		initData();
		
		return panelBody ;
		
	}
	
	public JPanel createPanelBottom() {
		JPanel panelBottom = new JPanel();
		panelBottom.setOpaque(false);
		lblCustomerList = new JLabel();
		lblCustomerList.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCustomerList.setFont(new Font("Roboto", Font.BOLD, 14));
		lblCustomerList.setForeground(color);
		lblCustomerList.setText("Có tất cả là "+countCustomers+" khách hàng trong danh sách");
		GroupLayout gl_panelBottom = new GroupLayout(panelBottom);
		gl_panelBottom.setHorizontalGroup(
			gl_panelBottom.createParallelGroup(Alignment.LEADING)
				.addComponent(lblCustomerList, GroupLayout.DEFAULT_SIZE, 1114, Short.MAX_VALUE)
		);
		gl_panelBottom.setVerticalGroup(
			gl_panelBottom.createParallelGroup(Alignment.LEADING)
				.addComponent(lblCustomerList, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
		);
		panelBottom.setLayout(gl_panelBottom);
		
		return panelBottom;
	}
	
	public void initData() {
		datas = dao.SelectAll();
		countCustomers = datas.size();
		fillPanelBody();
		searchCustomers();
	}

	public void fillPanelBody() {
		panelBody.removeAll();
		panelBody.repaint();
		panelBody.revalidate();
		
		for (ModelCustomerList data : datas) {
			double total =data.getTotalMonney();
			long roundValue = Math.round(total);
			ButtonCustomerList button1 = new ButtonCustomerList(image,
			data.getName(),data.getEmail(),data.getPhone(),data.getBuys(),roundValue+"",data.getComment()+"",data.getLikes()+"");
			button1.setBorder(null);
			button1.setFont(new Font("Roboto", Font.BOLD, 17));
			button1.setHorizontalAlignment(SwingConstants.LEFT); // 33
			panelBody.add(button1, "wrap");
			
		}
		
	}
	
	
	public void searchCustomers() {
		panelHeader.addCaretListenerTextField(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				String result = panelHeader.getTxtSearch().getText();
				if(result.equals("")) {
					datas = dao.SelectAll();
					fillPanelBody();
				}else {
					datas = dao.SelectByName(result);
					fillPanelBody();
				}
				
			}
		});
	}
}
