package componentHeader;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class PanelOption extends JPanel {

	private Color color = new Color(17, 19, 21);
	private Color color1 = new Color(39, 43, 49);
	private ButtonOption btnCheckReading;
	private ButtonOption btnDelete;

	public PanelOption() {
		setOpaque(false);
		btnCheckReading = new ButtonOption();
		btnCheckReading.setIcon(new ImageIcon(PanelOption.class.getResource("/icon/check-white.png")));
		btnCheckReading.setFont(new Font("Roboto", Font.BOLD, 16));
		btnCheckReading.setText("   Đánh dấu đã đọc");

		btnDelete = new ButtonOption();
		btnDelete.setIcon(new ImageIcon(PanelOption.class.getResource("/icon/delete-white.png")));
		btnDelete.setFont(new Font("Roboto", Font.BOLD, 16));
		btnDelete.setText("   Xóa thông báo");

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
								.addComponent(btnCheckReading, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(29)
						.addComponent(btnCheckReading, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 62, GroupLayout.PREFERRED_SIZE).addGap(15)));
		setLayout(groupLayout);
	}

	public void addActionButtonCheck(ActionListener event) {
		btnCheckReading.addActionButton(event);
	}
	
	public void addActionButtonDelete(ActionListener event) {
		btnDelete.addActionButton(event);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(color1);
		int[] x = { 240, 250, 260 };
		int[] y = { 8, 0, 8 };
		g2.fillPolygon(x, y, 3);

		g2.setColor(color);
		g2.fillRoundRect(1, 8, getWidth(), getHeight() - 8, 25, 25);

		g2.setColor(color1);
		g2.drawRoundRect(0, 8, getWidth() - 1, getHeight() - 9, 25, 25);
		super.paintComponent(g);
	}
}
