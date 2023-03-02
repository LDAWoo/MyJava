package componentCustomers;

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
import javax.swing.event.CaretListener;

import componentProduct.PanelCustomers;
import javax.swing.SwingConstants;
import animation.TextField;
import color.ColorBackground;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class PanelCustomerHeader extends JPanel {
	private Color colorOverview = new Color(26, 29, 31);
	private Color color = new Color(252,252,252);
	private Color color1 = new Color(150,150,150);

	private Color color2 = new Color(39, 43, 48);
	private Color color3 = new Color(0, 0, 0);
	
	private TextField txtSearch;
	private JLabel lblCustomer;
	private PanelCustomers panelFind;
	

	
	public PanelCustomerHeader() {
		setOpaque(false);

		lblCustomer = new JLabel("Khách hàng");
		lblCustomer.setForeground(color);
		lblCustomer.setFont(new Font("Roboto", Font.BOLD, 18));
		
		panelFind = new PanelCustomers();
		panelFind.setOpaque(false);
		panelFind.setColorCustomers(new Color(39, 43, 48));
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(PanelCustomerHeader.class.getResource("/icon/search.png")));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtSearch = new TextField();
		txtSearch.setHint("Tìm kiếm tên hoặc email");
		txtSearch.setForeground(new Color(191, 191, 191));
		txtSearch.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtSearch.setCaretColor(new Color(252, 252, 252));
		txtSearch.setBorder(null);
		txtSearch.setBackground(new Color(39, 43, 48));
		
		GroupLayout gl_panelFind = new GroupLayout(panelFind);
		gl_panelFind.setHorizontalGroup(
			gl_panelFind.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 416, Short.MAX_VALUE)
				.addGroup(gl_panelFind.createSequentialGroup()
					.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelFind.setVerticalGroup(
			gl_panelFind.createParallelGroup(Alignment.LEADING)
				.addGap(0, 45, Short.MAX_VALUE)
				.addGroup(gl_panelFind.createSequentialGroup()
					.addGroup(gl_panelFind.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelFind.setLayout(gl_panelFind);
		
		JLabel lblNewLabel = new JLabel("Tên");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel.setForeground(color1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(color1);
		lblEmail.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setForeground(color1);
		lblSinThoi.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblMua = new JLabel("Mua");
		lblMua.setForeground(color1);
		lblMua.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblTngTin = new JLabel("Tổng tiền");
		lblTngTin.setForeground(color1);
		lblTngTin.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblLtThch = new JLabel("Lượt thích");
		lblLtThch.setForeground(color1);
		lblLtThch.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblBnhLun = new JLabel("Bình luận");
		lblBnhLun.setForeground(color1);
		lblBnhLun.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("____________________________________________________________________________________________________________________________________________________________________");
		lblNewLabel_1.setForeground(color1);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMua, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTngTin, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBnhLun, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLtThch, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCustomer)
							.addGap(18)
							.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLtThch, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBnhLun, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTngTin, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMua, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(23)
									.addComponent(lblCustomer))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
							.addComponent(lblNewLabel)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1))
		);
		
		
		setLayout(groupLayout);
		
		if(MainForm.mode == "Light") {
			setColorModeLight();
		}else {
			setColorModeDark();
		}
		
		action();
	}
	
	
	public void action() {
		PanelMode.actionButonModeLight(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeLight();
			}
		});
		
		PanelMode.actionButonModeDark(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeDark();
			}
		});
	}
	
	private void setColorModeLight() {
		lblCustomer.setForeground(ColorBackground.colorDark);
		txtSearch.setColor(ColorBackground.colorGRB147147147);
		txtSearch.setCaretColor(ColorBackground.colorGRB707070);
		panelFind.setColorCustomers(ColorBackground.colorGRB239239239);
	}
	
	private void setColorModeDark() {
		lblCustomer.setForeground(ColorBackground.colorLight);
		txtSearch.setColor(ColorBackground.colorLight);
		txtSearch.setCaretColor(ColorBackground.colorLight);
		panelFind.setColorCustomers(ColorBackground.colorGRB394348);
	}
	
	public void addCaretListenerTextField(CaretListener event) {
		txtSearch.addCaretListener(event);
	}

	public TextField getTxtSearch() {
		return txtSearch;
	}

	public void setTxtSearch(TextField txtSearch) {
		this.txtSearch = txtSearch;
	}
	
	
}
