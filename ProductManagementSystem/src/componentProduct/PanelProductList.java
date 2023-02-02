package componentProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import color.ColorBackground;
import componentScrollPane.ScrollBarMenu;
import dao.DAOProducts;
import model.ModelProductList;
import net.miginfocom.swing.MigLayout;

public class PanelProductList extends JPanel {
	private Color color = ColorBackground.colorDark;
	private JPanel panel;
	private MigLayout layout;
	private JPanel header;
	private JPanel body;
	private JPanel bottom;
	private static JPanel panelBody;

	private static ArrayList<ModelProductList> datas = new ArrayList<ModelProductList>();
	private static DAOProducts dao = new DAOProducts();
	private static ButtonProductList btnProduct;

	public PanelProductList() {
		setOpaque(false);
		setLayout(new MigLayout("fill"));
		panel = new JPanel();
		layout = new MigLayout("fill,wrap, inset 2", "[fill]", "[150!,fill][fill,100%][::60%,shrink 0]");
		panel.setLayout(layout);
		panel.setOpaque(false);

		header = new PanelCustomerHeader();

		body = createPanelBody();

		panel.add(header);
		panel.add(body);
//		panel.add(bottom);

		add(panel, "push,grow");
	}

	public JPanel createPanelBody() {
		panelBody = new JPanel();
		panelBody.setOpaque(false);
		panelBody.setLayout(new MigLayout("wrap,fillx"));
		panelBody.setBorder(null);
		initData();

		return panelBody;

	}

	public static void initData() {
		datas = dao.SelectAll();
		fillPanelBody();

	}

	public static void fillPanelBody() {
		panelBody.removeAll();
		panelBody.repaint();
		panelBody.revalidate();

		for (ModelProductList data : datas) {
			String active = "";
			boolean status = data.isStatus();
			if (status) {
				active = "Hoạt động";
			} else {
				active = "Không hoạt động";

			}

			btnProduct = new ButtonProductList(data.getProductCode(), data.getImage(), data.getProductName(),
					data.getManufacturer(), active, data.getPrice(), data.getAmount(), data.getLikes());
			if (active == "Không hoạt động") {
				btnProduct.lblStatus.setForeground(ColorBackground.colorGRB25510685);
				btnProduct.lblStatus.setColor(ColorBackground.colorGRB1662921);

			}
			panelBody.add(btnProduct, "wrap, h 120!");
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

		super.paintComponent(g);
	}
}
