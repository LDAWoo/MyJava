package componentStore;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import color.ColorBackground;
import componentProduct.ButtonProductList;
import componentProduct.IconEditProduct;
import java.awt.Font;

public class PanelStoreFooter extends JPanel {

	private Icon iconPrev = new ImageIcon(ButtonProductList.class.getResource("/icon/arrow-right.png"));
	private Icon iconNext = new ImageIcon(ButtonProductList.class.getResource("/icon/arrow-right.png"));

	private Icon iconPrevBlue = new ImageIcon(ButtonProductList.class.getResource("/icon/arrow-right-blue.png"));
	private Icon iconNextBlue = new ImageIcon(ButtonProductList.class.getResource("/icon/arrow-right-blue.png"));
	public static IconEditProduct btnPrev;
	public static IconEditProduct btnNext;
	public static JLabel lblIndex;

	public PanelStoreFooter() {
		setOpaque(false);

		btnPrev = new IconEditProduct(iconPrev);
		btnPrev.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPrev.setIcon(iconPrevBlue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnPrev.setIcon(iconPrev);
			}
		});

		btnNext = new IconEditProduct(iconNext);
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNext.setIcon(iconNextBlue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnNext.setIcon(iconNext);
			}
		});

		lblIndex = new JLabel("1");
		lblIndex.setForeground(ColorBackground.colorLight);
		lblIndex.setFont(new Font("Segoe UI", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(436)
						.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblIndex, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(57, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(15, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIndex, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		setLayout(groupLayout);
	}
	
	
}
